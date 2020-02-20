package com.drcnet.mc.bigdata.bmap.Utils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * IO工具类
 * 
 * @author qi.sun
 * @time 2018年12月7日 上午11:28:31
 */
public class IOUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(IOUtils.class);

    /**
     * 输入流转为字符串
     */
    public static String InputStream2String(InputStream in) {
        try (InputStreamReader reader = new InputStreamReader(in, "UTF-8");
            BufferedReader br = new BufferedReader(reader);) {
            StringBuilder sb = new StringBuilder();
            String line = "";
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
            return null;
        }
    }

    /**
     * 字符串转为输入流
     */
    public static InputStream String2InputStream(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            ByteArrayInputStream stream = new ByteArrayInputStream(bytes);
            return stream;
        } catch (UnsupportedEncodingException e) {
            LOGGER.error(e.getMessage());
            return null;
        }
    }

    /**
     * 将byte[]写入本地文件
     */
    public static void writeToLocal(String destination, byte[] bytes) {
        File file = new File(destination);
        isExistDir(destination);
        try (FileOutputStream downloadFile = new FileOutputStream(file);) {
            downloadFile.write(bytes);
            downloadFile.flush();
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }

    /**
     * 将InputStream写入本地文件
     */
    public static void writeToLocal(String destination,
        InputStream inputStream) {
        int index;
        byte[] bytes = new byte[1024];
        File file = new File(destination);
        isExistDir(destination);
        try (FileOutputStream downloadFile = new FileOutputStream(file);) {
            while ((index = inputStream.read(bytes)) != -1) {
                downloadFile.write(bytes, 0, index);
                downloadFile.flush();
            }
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }

    /**
     * 文件夹是否存在，不存在则创建。
     */
    public static void isExistDir(String destination) {
        String paths[] = { "" };
        // 切割路径
        try {
            String tempPath = new File(destination).getCanonicalPath();// File对象转换为标准路径并进行切割，有两种windows和linux
            paths = tempPath.split("\\\\");// windows
            if (paths.length == 1) {
                paths = tempPath.split("/");
            } // linux
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
        // 判断是否有后缀
        boolean hasType = false;
        if (paths.length > 0) {
            String tempPath = paths[paths.length - 1];
            if (tempPath.length() > 0) {
                if (tempPath.indexOf(".") > 0) {
                    hasType = true;
                }
            }
        }
        // 创建文件夹
        String dir = paths[0];
        for (int i = 0; i < paths.length - (hasType ? 2 : 1); i++) {// 注意此处循环的长度，有后缀的就是文件路径，没有则文件夹路径
            try {
                dir = dir + "/" + paths[i + 1];// 采用linux下的标准写法进行拼接，由于windows可以识别这样的路径，所以这里采用警容的写法
                File dirFile = new File(dir);
                if (!dirFile.exists()) {
                    dirFile.mkdir();
                }
            } catch (Exception e) {
                LOGGER.error(e.getMessage());
            }
        }
    }

    public static void clear(String path) {
        File file = new File(path);
        if (file.exists()) {
            if (file.isDirectory()) {
                String[] filelist = file.list();
                for (int i = 0; i < filelist.length; i++) {
                    String deletePath = path + "/" + filelist[i];
                    clear(deletePath);
                }
            }
            file.delete();
            file = null;
        }
    }

}
