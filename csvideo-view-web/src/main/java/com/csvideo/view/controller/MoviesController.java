package com.csvideo.view.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.csvideo.entity.PageResult;
import com.csvideo.entity.Result;
import com.csvideo.pojo.Movies;
import com.csvideo.pojo.Videos;
import com.csvideo.util.FFmpegUtils;
import com.csvideo.util.FastDFSClient;
import com.csvideo.view.service.MoviesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/movies")
public class MoviesController {
    @Reference
    private MoviesService moviesService;
    @Value("${FILE_SERVER_URL}")
    private String FILE_SERVER_URL; //文件服务器地址

    public static final String FFMPEG_EXE = "F:\\ffmpeg\\bin\\ffmpeg.exe";

    /**
     * 上传电影
     */
    @RequestMapping("/add")

    public Result add(@RequestBody Movies movies, String userId, MultipartFile file) {
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
            movies.setMoviesPath(moviesUrl);
            String photoUrl = FILE_SERVER_URL + photoPath;
            movies.setMoviesPhotoPath(photoUrl);
            movies.setUserId(userId);
            moviesService.add(movies);
            return new Result(true, "上传成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "上传失败");
        }

    }

    /**
     * 根据状态查询电影
     * @param page
     * @param rows
     * @param
     * @return
     */
    @RequestMapping("/getAll")
    public PageResult getAll(int page, int rows, String moviesStatu){
        return moviesService.findPage(page,rows,moviesStatu);
    }
    /**
     * 根据视频id查询视频
     */
    @RequestMapping("/getByMoviesId")
    public List<Movies> getById(String moviesId){
        return moviesService.findOne(moviesId);
    }
    /**
     * 根据状态，类别，用户id等
     */
    @RequestMapping("/getByStatu")
    public PageResult getByStatu(@RequestBody Movies movies, int page, int rows){
        return moviesService.findPage(movies, page, rows);
    }
    /**
     * 删除视频
     */
    @RequestMapping("/deleteById")
    public Result delete(String moviesId){
        try {
            moviesService.delete(moviesId);
            return new Result(true,"删除成功");
        }catch (Exception e){
            return new Result(false,"删除失败");
        }
    }
}
