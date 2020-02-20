package com.drcnet.mc.bigdata.bmap.entity.theme;

import lombok.Data;

@Data
public class Theme {
	private Integer themeId;
	private String name;
//	private Integer orderNumber;
	private String imagePath;
	private String defaultTimeSql;
	private String frequency;
}
