package com.drcnet.mc.bigdata.bmap.entity.compare;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.drcnet.mc.bigdata.bmap.entity.BaseEntity;

@Data
@EqualsAndHashCode(callSuper=true)
public class CompareSort  extends BaseEntity{
	
	private Integer compareId;
	private String name;
	private String fileName;
	private Integer userId;
	private Integer appId;
	private Integer timeId;
	private String imgUrl;
	private String frequency;
	private Integer isShow;
	
}
