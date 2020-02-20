package com.drcnet.mc.bigdata.bmap.Utils;

import com.alibaba.fastjson.JSON;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class WriteFile {

	/**
	 * 将List类型，写入文件
	 * @param content
	 * @param fileName 写入文件的路径
	 */
	public static void write(List<String> content,String fileName){
		try {
			FileWriter wr = new FileWriter(fileName);
			for(String str :content){
				wr.write(str+"\n");
			}
			wr.close();
		} catch (Exception e) {
			//MyLog.logError("can not wirte file");
		}
	}

	public static void write(String str,String fileName){
		try {
			FileWriter wr = new FileWriter(fileName);

			wr.write(str+"\n");

			wr.close();
		} catch (Exception e) {
			System.err.println("失败==================");
			//MyLog.logError("can not wirte file");
		}
	}
	/**
	 * 将HashMap<String, Integer>类型，写入文件
	 * @param map
	 * @param fileName 写入文件的路径
	 */
	public static void write2(Map<String, List<double[]>> map,String fileName){
		try {
			FileWriter wr = new FileWriter(fileName);
//			Iterator<Entry<String,Integer>> iter = map.entrySet().iterator();
			Iterator<Entry<String, List<double[]>>> iter = map.entrySet().iterator();
			Entry<String, List<double[]>> entry = null;
			while(iter.hasNext()){
				entry = iter.next();
				String s = JSON.toJSONString(entry);
				wr.write(s+"\n");
			}
			wr.close();
		} catch (Exception e) {
			//MyLog.logError("can not wirte file");
		}
	}
	/**
	 * 将HashMap<String, Integer>类型，写入文件
	 * @param map
	 * @param fileName 写入文件的路径
	 */
	public static void write(HashMap<String, Integer> map,String fileName){
		try {
			FileWriter wr = new FileWriter(fileName);
			Iterator<Entry<String,Integer>> iter = map.entrySet().iterator();
			Entry<String,Integer> entry = null;
			while(iter.hasNext()){
				entry = iter.next();
				wr.write(entry.getKey()+"	"+entry.getValue()+"\n");
			}
			wr.close();
		} catch (Exception e) {
			//MyLog.logError("can not wirte file");
		}
	}

	/**
	 * 写入词典
	 * @param key
	 * @param value
	 * @param outputName
	 */
	public static void addWord(String key,Integer value,String outputName){
		try {
			FileWriter writer = new FileWriter(outputName, true);
			writer.write(key + " " + value + "\n");
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
