package com.drcnet.mc.bigdata.bmap.entity.theme;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.drcnet.mc.bigdata.bmap.entity.BaseEntity;

@Data
@EqualsAndHashCode(callSuper=true)
public class Screen extends BaseEntity{
	private Integer screenId;
	private Integer appId;
	private Integer userId;
	private String name;
	private String imgUrl;
	private String icon;
	private Integer isShow;
	private String frequency;
	private Integer orderNumber;
	private String left;
	private String top;
	private String width;
	private String height;

}
