package com.drcnet.mc.bigdata.bmap.entity.report;

import lombok.Data;
/**
 * @author tengchao.li
 * @description 报告控制点
 * @date 2019/10/24
 */
@Data
public class ReportControl {
	private Integer reportTemplateId;
	private Integer controlId;
	private String controlName;
	private String controlCode;
	private String defaultId;
	private Integer orderNumber;
	private Integer showType;
}
