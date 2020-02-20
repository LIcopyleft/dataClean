package com.drcnet.mc.bigdata.bmap.entity.dynamic;

import java.util.Date;

import lombok.Data;

@Data
public class ShipInfo {
	
	private Integer id;
	private String mmsi;
	private String shipName;
	private String shipCnname;
	private String shipType;
	private String imo;
	private String callCode;
	private String flag;
	private String aisShipType;
	private Double shipTonnage;
	private Double shipLoadWeight;
	private Double shipLength;
	private Double shipWidth;
	private Integer shipConstructionYear;
	private String shipImgs;
	private Double maxDrainage;
	private Double shipHeight;
	private Integer source;
	private String shipid;
	private Integer tradetype;
	private Integer shipTypeId;
	private Double shipLeft;
	private Integer trail;
	private Date createTime;

	
	
}
