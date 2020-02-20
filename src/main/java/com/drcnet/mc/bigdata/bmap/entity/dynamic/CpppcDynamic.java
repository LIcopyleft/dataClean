package com.drcnet.mc.bigdata.bmap.entity.dynamic;

import java.util.Date;

import lombok.Data;

@Data
public class CpppcDynamic {
	
	private Integer id;
	private String projName;
	private String projNo;
	private Double investAmount;
	private Integer estimateCoper;
	private Date startTime;
	private Integer provinceCode;
	private Integer cityCode;
	private Integer districtCode;
	
	private String provinceName;
	private String cityName;
	private String districtName;
}
