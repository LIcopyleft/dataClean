package com.drcnet.mc.bigdata.bmap.entity.dynamic;

import java.util.Date;

import lombok.Data;

@Data
public class ShipVoyage {
	private Integer id;
	private String voyageCode;
	private String codeStr;
	private String mmsi;
	private String imo;
	private String state;
	private String depTime;
	private String depDate;
	private String depCountryCode;
	private String depPortNameEn;
	private String depPortNameCn;
	private String arrTime;
	private String arrDate;
	private String arrCountryCode;
	private String arrPortNameEn;
	private String arrPortNameCn;
	private String dest;
	private String eta;
	private Double sogAvg;
	private Date createTime;

}
