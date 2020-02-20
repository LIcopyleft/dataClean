package com.drcnet.mc.bigdata.bmap.entity.dynamic;

import java.util.Date;

import lombok.Data;

@Data
public class ShipVoyageDynamic {
	
	private Integer id;
	private String voyageCode;
	private String voyageDynamicCode;
	private String mmsi;
	private String imo;
	private String locationTime;
	private String locationDate;
	private String state;
	private Double draught;
	private String lng;
	private String lat;
	private Double sog;
	private Double cog;
	private Double hdg;
	private Double naviDistance;
	private Double rot;
	private Double sogAvg;
	private Double naviTime;
	private String position;
	private String naviStat;
	private Date createTime;

}
