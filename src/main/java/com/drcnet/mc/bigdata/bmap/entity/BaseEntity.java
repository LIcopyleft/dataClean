package com.drcnet.mc.bigdata.bmap.entity;

import java.util.Date;

import lombok.Data;


@Data
public class BaseEntity {
	
	private Integer recordstatus=0;
	private Date createDate;
	private Date updateDate;
	private Integer createUser;
	private Integer updateUser;
}
