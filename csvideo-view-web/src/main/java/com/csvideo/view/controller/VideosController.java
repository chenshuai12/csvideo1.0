package com.csvideo.view.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.csvideo.entity.PageResult;
import com.csvideo.entity.Result;
import com.csvideo.pojo.Movies;
import com.csvideo.pojo.Videos;
import com.csvideo.util.FFmpegUtils;
import com.csvideo.util.FastDFSClient;
import com.csvideo.view.service.VideosService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

/**
 * Created by asus on 2019/3/19.
 */
@RestController
@RequestMapping("/videos")

public class VideosController {
    @Reference
    private VideosService videosService;
    @Value("${FILE_SERVER_URL}")
    private String FILE_SERVER_URL; //文件服务器地址

    public static final String FFMPEG_EXE = "F:\\ffmpeg\\bin\\ffmpeg.exe";
    /**
     * 上传短视频
     */
    @RequestMapping("/add")
    public Result add(@RequestBody Videos videos, String userId, MultipartFile file) {
        //文件保存的命名空间
        String fileSpace = "D:/csvideo";
        //保存到临时文件中的相对路径
        String uploadPath = "/" + userId + "/video";
        String coverPath = "/" + userId + "/video";
        //临时视频地址
        String finalVideoPath = "";
        //截图临时视频地址
        String finalCoverPath = "";
        //转码临时视频地址
        String newVideoPath = "";
        FileOutputStream fileOutputStream = null;
        InputStream inputStream = null;
        try {
            if (file != null) {
                String fileName = file.getOriginalFilename();
                String arrayFilenameItem[] = fileName.split("\\.");
                String fileNamePrefix = "";
                for (int i = 0; i < arrayFilenameItem.length - 1; i++) {
                    fileNamePrefix += arrayFilenameItem[i];
                }
                // fix bug: 解决小程序端OK，PC端不OK的bug，原因：PC端和小程序端对临时视频的命名不同
//				String fileNamePrefix = fileName.split("\\.")[0];
                if (StringUtils.isNotBlank(fileName)) {
                    finalVideoPath = fileSpace + uploadPath + "/" + fileName;
                    coverPath = fileSpace + coverPath + "/" + fileNamePrefix + UUID.randomUUID().toString() + ".jpg";
                    newVideoPath = fileSpace + uploadPath + "/" + UUID.randomUUID().toString() + fileName + ".flv";
                    File outFile = new File(finalVideoPath);
                    if (outFile.getParentFile() != null || !outFile.getParentFile().isDirectory()) {
                        //创建父文件夹
                        outFile.getParentFile().mkdirs();
                    }
                    fileOutputStream = new FileOutputStream(outFile);
                    inputStream = file.getInputStream();
                    IOUtils.copy(inputStream, fileOutputStream);
                }
            } else {
                return new Result(false, "上传出错.....");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "上传出错......");
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        FFmpegUtils fFmpegUtils = new FFmpegUtils();
        try {
            fFmpegUtils.executeCodecs(FFMPEG_EXE, finalVideoPath, newVideoPath, coverPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            //2、创建一个fastDFS客户端
            FastDFSClient fastDFSClient = new FastDFSClient("classpath:config/fafs_client.conf");
            //3、执行上传处理
            String moviesPath = fastDFSClient.uploadFile(newVideoPath);
            String photoPath = fastDFSClient.uploadFile(coverPath);
            //4、拼接返回的url和ip地址，拼装成完整的url
            String moviesUrl = FILE_SERVER_URL + moviesPath;
            videos.setVideosPath(moviesUrl);
            String photoUrl = FILE_SERVER_URL + photoPath;
            videos.setVideosPhotoPath(photoUrl);
            videos.setUserId(userId);
            videosService.add(videos);
            return new Result(true, "上传成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "上传失败");
        }

    }
    /**
     * 根据状态查询短视频
     * @param page
     * @param rows
     * @param videosStatu
     * @return
     */
    @RequestMapping("/getAll")

    public PageResult getAll(int page, int rows, String videosStatu){
        return videosService.findPage(page,rows,videosStatu);
    }
    /**
     * 根据视频id查询视频
     */
    @RequestMapping("/getByVideosId")

    public List<Videos> getById(String videosId){
        return videosService.findOne(videosId);
    }
    /**
     * 根据id，状态，发布，禁播
     */
    @RequestMapping("/getByStatu")
    public PageResult getByStatu(String userId, int page, int rows,String videosStatu){
        return videosService.findPage(userId, page, rows, videosStatu);
    }

    /**
     * 删除视频
     */
    @RequestMapping("/deleteById")
    public Result delete(String videosId){
        try {
            videosService.delete(videosId);
            return new Result(true,"删除成功");
        }catch (Exception e){
            return new Result(false,"删除失败");
        }
    }
}
