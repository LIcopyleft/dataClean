package com.drcnet.mc.bigdata.bmap.entity;

import lombok.Data;

/**
 *
 * @date 2019-09-16
 */

@Data
public class Indicator {
    private Integer indicatorId;

    private String name;

    private String displayName;

    private String code;

    private Integer orderNumber;

    private Integer parentId;

    private Integer recordstatus;

    private String unit;

}
