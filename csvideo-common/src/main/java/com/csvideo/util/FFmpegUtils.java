package com.csvideo.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus on 2019/3/21.
 */
public class FFmpegUtils {
    public boolean executeCodecs(String ffmpegPath,String upFilePath,String codcFilePath,String coverPath) throws Exception{
        //创建一个List集合来保存转换视频文件未fiv格式的命令
        List<String> convert = new ArrayList<String>();
        convert.add(ffmpegPath); //添加转换工具路径
        convert.add("-i"); //添加参数“-i”，该参数指定要转换的文件
        convert.add(upFilePath); //添加要转换格式的视频文件的路径
        convert.add("-qscale"); //指定转换的质量
        convert.add("6");
        convert.add("-ab"); //设置音频码率
        convert.add("64");
        convert.add("-ac"); //设置声道数
        convert.add("2");
        convert.add("-ar"); //设置声音的采样频率
        convert.add("22050");
        convert.add("-r"); //设置帧频
        convert.add("24");
        convert.add("-y"); // 添加参数“-y”，该参数指定将覆盖已存在的文件
        convert.add(codcFilePath);

        //创建一个List集合来保存从视频中截取图片的命令
        List<String> cutpic = new ArrayList<String >();
        cutpic.add(ffmpegPath);
        cutpic.add("-i");
        cutpic.add(upFilePath);
        cutpic.add("-y");
        cutpic.add("-f");
        cutpic.add("image2");
        cutpic.add("-ss"); //添加参数"-ss",该参数指定街区的起始时间
        cutpic.add("17");
        cutpic.add("-t"); //该参数指定持续时间
        cutpic.add("0.001");
        cutpic.add("-s"); //截取图片大小
        cutpic.add("800*280"); // 添加街区的图片大小为350*240
        cutpic.add(coverPath);

        boolean mark = true;
        ProcessBuilder builder = new ProcessBuilder();
        try {
            builder.command(convert);
            builder.redirectErrorStream(true);
            builder.start();

            builder.command(cutpic);
            builder.redirectErrorStream(true);

            //如果此属性为true，则任何由通过此对象的start（）方法启动的后续子进程生成的错误输出都将与标准输出合并
            //因此两者均可使用Process.getInputStream()方法读取。这使得关联错误信息和相应的输出变得更加容易
            builder.start();
        }catch (Exception e){
            mark = false;
            System.out.println(e);
            e.printStackTrace();
        }
        return mark;
    }
}
