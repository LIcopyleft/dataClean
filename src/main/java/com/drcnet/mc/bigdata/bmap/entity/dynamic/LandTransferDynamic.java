package com.drcnet.mc.bigdata.bmap.entity.dynamic;

import java.util.Date;

import lombok.Data;

@Data
public class LandTransferDynamic {
	
	private Integer id;
	
	private String region;
	private String projectName;
	private Double area;
	private Double price;
	
	private Date contractDate;
	private Integer provinceCode;
	private Integer cityCode;
	private Integer districtCode;

	
	private String provinceName;
	private String cityName;
	private String districtName;

}
