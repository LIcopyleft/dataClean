package com.drcnet.mc.bigdata.bmap.entity.token;

import java.util.List;

import lombok.Data;

import com.drcnet.mc.bigdata.bmap.entity.theme.Screen;
import com.drcnet.mc.bigdata.bmap.entity.theme.Theme;

/**
 * user
 */
@Data
public class User {

    private Integer userId; // 用户编号
    private Integer appId;
    private Integer regionId;// 默认地区
    private String name;// 用户名称
    private String loginId;// 登录编号
    private String password;// 登录密码
    private String remark;// 备注
    private Integer role;//角色  0：普通用户    1：管理员

    private List<Screen> screens;

}
