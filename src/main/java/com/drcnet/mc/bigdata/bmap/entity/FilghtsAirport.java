package com.drcnet.mc.bigdata.bmap.entity;

import lombok.Data;

@Data
public class FilghtsAirport {
	private Integer airportId;
	
	private Integer communityId;
	private Integer nationCode;
	private String nationName;
	private String name;
	private String displayName;
	private String nameEn;
	private String iata;
	private String icao;
	private String lat;
	private String lng;
	private Integer provinceCode;
	private String provinceName;
	private Integer cityCode;
	private String cityName;
	private Integer districtCode;
	private String districtName;
	private String timezone;
	private String unit;
	private Integer parentId;
	
	private String countryEname;
	private String countryShortName;
	private String countrySecondShortName;
	
	public Integer getAirportId(){
		if(this.communityId!=null){
			this.airportId = this.communityId;
		}
		return this.airportId;
	}
}
