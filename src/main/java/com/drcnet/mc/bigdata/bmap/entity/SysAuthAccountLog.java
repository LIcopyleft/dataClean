package com.drcnet.mc.bigdata.bmap.entity;

import lombok.Data;

import java.util.Date;

/**
 * 
 * @date 2019-09-10
 */
@Data
public class SysAuthAccountLog {
    /**
     * 主键id
     */
    private Integer logId;

    /**
     * 用户主键id
     */
    private Integer userId;

    /**
     * 日志名称 登录/登出
     */
    private String logName;

    /**
     * 用户名
     */
    private String loginId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 是否执行成功
     */
    private Integer success;

    /**
     * 信息
     */
    private String message;

    /**
     * ip
     */
    private String ip;
    private Date startTime;
    private Date endTime;


}