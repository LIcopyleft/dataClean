package com.drcnet.mc.bigdata.bmap.entity;

import lombok.Data;

@Data
public class DataSet {
	
	private Integer databaseId;
	private String name;
	private String factTableName;
	private String frequency;
	private String comment;
}
