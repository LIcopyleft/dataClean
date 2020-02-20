package com.drcnet.mc.bigdata.bmap.entity;

import lombok.Data;

/**
 * 
 * @date 2019-09-16
 */
@Data
public class Company {
    private Integer companyId;

    private String name;

    private String displayName;

    private Integer orderNumber;

    private Integer parentId;

    private String code;

    private Integer recordstatus;

    private String unit;

}
