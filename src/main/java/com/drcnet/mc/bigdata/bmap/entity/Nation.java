package com.drcnet.mc.bigdata.bmap.entity;

import lombok.Data;

/**
 * 
 * @date 2019-09-16
 */
@Data
public class Nation {
    private Integer regionId;

    private String name;

    private Integer parentId;

    private Integer level;

    private String lat;

    private String lng;

    private String displayName;

    private Integer recordstatus;

    private Integer orderNumber;

}
