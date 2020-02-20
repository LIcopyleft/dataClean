package com.drcnet.mc.bigdata.bmap.Utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.alibaba.fastjson.JSON;

@SuppressWarnings({ "unused", "unchecked" })
public class ReadFileUtils {

    public static Map<String, List<List<Double>>> readJson() throws Exception {
        Properties pps = new Properties();
        InputStream stream = ReadFileUtils.class.getClassLoader()
            .getResourceAsStream("json/coordinates.json");
        // 将字节流向字符流的转换。
        InputStreamReader isr = new InputStreamReader(stream);// 读取
        // 创建字符流缓冲区
        BufferedReader bufr = new BufferedReader(isr);// 从字符输入流中读取文本，缓冲各个字符，从而实现字符、数组和行的
        // 高效读取。 可以指定缓冲区的大小，或者可使用默认的大小。大多数情况下，默认值足够大。类似于BufferInputStream
        // 只是两者缓冲的对象不一样。
        // BufferedReader bufr = new BufferedReader(
        // new InputStreamReader(new FileInputStream("D:\\demo.txt")));可以综合到一句。

//	      int ch =0;
//	    ch = bufr.read();
//	    System.out.println((char)ch);

        StringBuffer jsonString = new StringBuffer("");
        String line;
        while ((line = bufr.readLine()) != null) {
            jsonString.append(line);
        }
        isr.close();

//		 InputStream stream = ReadFileUtils.class.getClassLoader().getResourceAsStream("json/coordinates.json");
//     .getClassLoader()
//     .getResourceAsStream("defult.properties"); 
//		BufferedReader br = new BufferedReader(resource.getInputStream());

        Map<String, List<List<Double>>> map = new HashMap<String, List<List<Double>>>();
        map = JSON.parseObject(jsonString.toString(), map.getClass());

//        pps.load(br);
//        Map<String, List<List<Integer>>> map = new HashMap<String, List<List<Integer>>>();
//        map = JSON.parseObject(resource.getInputStream(),
//            StandardCharsets.UTF_8, map.getClass().getGenericSuperclass(),
//            // 自动关闭流
//            Feature.AutoCloseSource,
//            // 允许注释
//            Feature.AllowComment,
//            // 允许单引号
//            Feature.AllowSingleQuotes,
//            // 使用 Big decimal
//            Feature.UseBigDecimal);

        return map;
    }

    public static Map<String, List<Double>> worldJson() throws Exception {
        Properties pps = new Properties();
        InputStream stream = ReadFileUtils.class.getClassLoader()
            .getResourceAsStream("json/world.json");
        // 将字节流向字符流的转换。
        InputStreamReader isr = new InputStreamReader(stream);// 读取
        // 创建字符流缓冲区
        BufferedReader bufr = new BufferedReader(isr);// 从字符输入流中读取文本，缓冲各个字符，从而实现字符、数组和行的
        // 高效读取。 可以指定缓冲区的大小，或者可使用默认的大小。大多数情况下，默认值足够大。类似于BufferInputStream
        // 只是两者缓冲的对象不一样。
        // BufferedReader bufr = new BufferedReader(
        // new InputStreamReader(new FileInputStream("D:\\demo.txt")));可以综合到一句。

//	      int ch =0;
//	    ch = bufr.read();
//	    System.out.println((char)ch);

        StringBuffer jsonString = new StringBuffer("");
        String line;
        while ((line = bufr.readLine()) != null) {
            jsonString.append(line);
        }
        isr.close();

//		 InputStream stream = ReadFileUtils.class.getClassLoader().getResourceAsStream("json/coordinates.json");
//     .getClassLoader()
//     .getResourceAsStream("defult.properties"); 
//		BufferedReader br = new BufferedReader(resource.getInputStream());

        Map<String, List<Double>> map = new HashMap<String, List<Double>>();
        map = JSON.parseObject(jsonString.toString(), map.getClass());

//        pps.load(br);
//        Map<String, List<List<Integer>>> map = new HashMap<String, List<List<Integer>>>();
//        map = JSON.parseObject(resource.getInputStream(),
//            StandardCharsets.UTF_8, map.getClass().getGenericSuperclass(),
//            // 自动关闭流
//            Feature.AutoCloseSource,
//            // 允许注释
//            Feature.AllowComment,
//            // 允许单引号
//            Feature.AllowSingleQuotes,
//            // 使用 Big decimal
//            Feature.UseBigDecimal);

        return map;
    }

    public static void main(String[] args) throws Exception {
        Map<String, List<List<Double>>> map = readJson();
        System.out.println(map.get("110106"));

//        Map<String, List<Double>> map = worldJson();
//        System.out.println(map.get("乌克兰"));
    }
}
