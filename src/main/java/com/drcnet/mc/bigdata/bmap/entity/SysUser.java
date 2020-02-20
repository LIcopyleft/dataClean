package com.drcnet.mc.bigdata.bmap.entity;

import com.drcnet.mc.bigdata.bmap.entity.theme.Theme;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class SysUser {
    private Integer userId;

    private String name;

    private String loginId;

    private String password;

    private String remark;

    private Integer appId;

    private Integer regionId;

    private Date validBeginDate;

    private Date validEndDate;

    private Integer sex;

    private String post;

    private String address;

    private String email;

    private String mobile;

    private String company;

    private Integer recordstatus;

    private Date createDate;

    private Date updateDate;

    private Integer createUser;

    private Integer updateUser;
    //角色标识
    private Integer role;

    private List<Theme> themeList;
}