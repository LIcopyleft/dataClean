package com.drcnet.mc.bigdata.bmap.entity.theme;

import lombok.Data;

@Data
public class ThemeSelectDimension {
	private Integer selectId;
//	private String tableName;
//	private Integer orderNumber;
	private Integer id;
	private String aliasName;
	private Integer parentId;
	private String name;
	private String displayName;
	private Integer graphId;
}
