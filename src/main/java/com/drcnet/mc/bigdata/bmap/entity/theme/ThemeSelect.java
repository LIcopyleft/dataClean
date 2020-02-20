package com.drcnet.mc.bigdata.bmap.entity.theme;

import java.util.List;

import lombok.Data;

@Data
public class ThemeSelect {
	private Integer selectId;
	private Integer themeId;
	private String dimensionCode;
//	private Integer orderNumber;
	private String dimensionId;
	private String dimensionTable;
	
	private List<ThemeSelectDimension> dimensionList;
}
