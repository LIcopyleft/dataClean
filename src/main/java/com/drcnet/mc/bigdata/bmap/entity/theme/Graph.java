package com.drcnet.mc.bigdata.bmap.entity.theme;


import java.util.Date;

import lombok.Data;


@Data
public class Graph {
	private Integer graphId;
	private Integer chartId;
	private Integer themeId;
	private String name;
//	private String graphType;
	private String jstag;
	private String divContrainer;
	private String api;
	private String itemApi;
	private String code;
	private Integer isPrimary;
	private Integer isPrimaryControl;
	private Integer isControl;
	private String frequency;
	private Integer period;
	private String size;
	private Integer factValuePrecision;
	private String controlAttribute;
	private Boolean isLeftAlign;
	private Boolean isRightAlign;
	private String categoryDimension;
	private String settingJson;
	private String enlargeControl;
	private String lengendDimension;
	private String lengendGraphStyle;
	private Integer top;
	private Integer timeRange;
	private String imgPath;
	private Integer recordstatus;
	private Integer orderNumber;
	/**
	 * 是否展示  0 展示 , 1 不展示
	 */
	private Integer isShow;
	private Integer descId;
	
	private Integer userId;
	private Integer appId;
	
	private Date createDate;
	private Date updateDate;
	
	private Integer chartFrom;
	private String paramsJson;
	
}
