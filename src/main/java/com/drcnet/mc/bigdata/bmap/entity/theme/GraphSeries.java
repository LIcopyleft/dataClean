package com.drcnet.mc.bigdata.bmap.entity.theme;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.drcnet.mc.bigdata.bmap.entity.BaseDimension;

@Data
@EqualsAndHashCode(callSuper=false)
public class GraphSeries extends BaseDimension{
	
	private Integer graphId;
	private String graphType;
	private String code;
	private String name;
	
	private String aliasName;
	private String unit;
	private String nameDimension;
	private Integer databaseId;
	
	private String reactDimension;
	private Integer hasReactChildrenDimension;
	private Integer hasIncludeSelf;
	private String linestyle;
	private String itemstyle;
	private String areastyle;
	private String frequency;
	private Boolean isRightYAxis;
	private String color;
	private String seriesTemplate;
	private Boolean isTopXAxis; 
	private Integer movePeriod;
	private Integer isHome;
	
	
	
	private Integer orderNumber;
	private Integer recordstatus;
	private String ystyle;
	private String xstyle;
	private String execSql;
	private String builttimes;
	/**
	 * 是否展示地区标签
	 */
	private Boolean isShowRegionLabel;


	
}
