package com.drcnet.mc.bigdata.bmap.entity.report;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 *
 * 
 * @date 2019-10-23
 */
@Data
public class ReportTemplate {
    private Integer reportTemplateId;

    private String name;

    private Integer categoryId;

    private String frequency;

    private Integer appId;

    private Integer userId;
    /**
     * 0不展示 1展示
     */
    private Integer isShow;
    private Integer recordstatus;

    private String content;

    private Date createDate;

    private Date updateDate;

    private List<ReportControl> controlList;

}
