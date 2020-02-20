package com.drcnet.mc.bigdata.bmap.entity;

import java.util.List;

import lombok.Data;

@Data
public class DataDimensionTable {
	
	private Integer id;
	private String name;
	private String frequency;
	private String dimensioncode;
	private String displayName;
	private Integer level;
	private Integer parentId;
	private String nameEn;
	private String initial;
	
	private List<DataDimensionTable> childs;
}
