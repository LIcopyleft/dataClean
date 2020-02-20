package com.drcnet.mc.bigdata.bmap.entity.report;

import lombok.Data;

/**

 * @author DRC
 * @date 2019-10-23
 */
@Data
public class ReportCategory {
    private Integer categoryId;

    private String name;

    private Integer parentId;

    private Integer userId;

    private Integer appId;


}
