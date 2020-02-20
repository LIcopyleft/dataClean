package com.drcnet.mc.bigdata.bmap.entity;

import lombok.Data;

/**
 *
 * @date 2019-09-16
 */
@Data
public class Equipment {
    private Integer equipmentId;

    private String name;

    private String displayName;

    private String code;

    /**
     * 0
     */
    private Integer orderNumber;

    /**
     * 0
     */
    private Integer parentId;

    private Integer recordstatus;

    private String unit;

}
