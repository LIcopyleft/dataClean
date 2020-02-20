package com.drcnet.mc.bigdata.bmap.entity;

import lombok.Data;

@Data
public class DataDimension {
	private Integer databaseId;
	private String dimensioncode;
	private String dimensionname;
	private String dimensionTablename;
	private String dimensionFieldname;
}
