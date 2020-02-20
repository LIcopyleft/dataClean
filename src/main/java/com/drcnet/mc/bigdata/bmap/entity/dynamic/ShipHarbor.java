package com.drcnet.mc.bigdata.bmap.entity.dynamic;

import lombok.Data;

@Data
public class ShipHarbor {
	
	private Integer harborId;
	private String displayName;
	private String name;
	private String lat;
	private String lng;
	private Integer countryId;
	private String countryName;
	private String countryEname;
	private String countryShortName;
	private String countrySecondShortName;
	private Integer provinceCode;
	private String provinceName;
	private Integer cityCode;
	private String cityName;
	private Integer districtCode;
	private String districtName;
	private String unit;
	private Integer orderNumber;
	private Integer parentId;
	
 
}
