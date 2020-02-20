package com.drcnet.mc.bigdata.bmap.entity.token;

import java.util.Date;

import com.drcnet.mc.bigdata.bmap.Utils.DateUtils;
import com.drcnet.mc.bigdata.bmap.Utils.StringUtils;

import lombok.Data;

/**
 * 用户token
 * 
 * @author qi.sun
 *
 */
@Data
public class UserToken {

    /** 登录的失效周期 */
    public static final int LOGIN_EXPIRED_IN_MILLISECOND = 60 * 1000 * 20; // 20分钟
    /** token的失效周期 */
    public static final int TOKEN_EXPIRED_IN_MILLISECOND = 60 * 1000 * 10; // 10分钟
    /** token的编号 */
    private String id;
    /** 旧token的编号 */
    private String oldId;
    /** token的创建时间 */
    private Date createTime;
    /** token的过期时间 */
    private Date expired;
    /** 用户的基本信息 */
    private User user;
    /** 用户权限的基本信息 */
    private String permissions;
    /** token的加密信息 */
    private String tokenString;

    /**
     * 自动生成ID，创建时间，过期时间的构造方法
     */
    public UserToken() {
        refresh();
    }

    public void refresh() {
        Date now = new Date();
        this.oldId = this.id;
        this.id = StringUtils.get32UUID();
        this.createTime = now;
        this.expired = DateUtils.addDate(now, TOKEN_EXPIRED_IN_MILLISECOND);
    }

}
