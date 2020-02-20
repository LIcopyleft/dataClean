package com.drcnet.mc.bigdata.bmap.entity.theme;

import lombok.Data;

/**
 * @author tengchao.li
 * @date 2019-10-18
 */
@Data
public class Chart {
    /**
     * 图表类型主键id
     */
    private Integer chartId;

    /**
     * 名称(db_graph jstag)
     */
    private String name;

    /**
     * 图表路径
     */
    private String imgPath;

    /**
     * 编码
     */
    private String code;
    
    private Integer parentId;
    private Integer special;
    private String api;
}
