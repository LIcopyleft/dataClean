package com.drcnet.mc.bigdata.bmap.entity.theme;

import com.drcnet.mc.bigdata.bmap.entity.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class ScreenGraph extends BaseEntity {
	private Integer screenId;
	private Integer themeId;
	private Integer graphId;
	private String name;
	private String top;
	private String left;
	private String width;
	private String height;
	private Integer isControl;
	

}
