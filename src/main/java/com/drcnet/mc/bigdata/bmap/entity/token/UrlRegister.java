package com.drcnet.mc.bigdata.bmap.entity.token;

import lombok.Data;

/**
 * url_register
 */
@Data
public class UrlRegister {

    private Integer urlId;
    private String name;
    private String controllerAction;
    private Boolean isLogin;
    private Boolean isAuth;
    private String remark;

}
