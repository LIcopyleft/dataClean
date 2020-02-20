package com.drcnet.mc.bigdata.bmap.entity.report;

import java.util.List;

import lombok.Data;

@Data
public class ReportVariable {
	
	private Integer variableId;
	private String code;
	private String name;
	private Integer parentId;
	private List<ReportVariable> variableList;
}
