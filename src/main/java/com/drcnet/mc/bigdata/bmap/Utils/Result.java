package com.drcnet.mc.bigdata.bmap.Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回结果
 * 
 * @author qi.sun
 */
public class Result {

    // 系统
    public static final int CODE_SUCCESS = 0; // 成功
    public static final int CODE_FAIL = 1; // 失败
    public static final int CODE_SERVER_ERROR = -1; // 系统错误
    public static final int CODE_CLIENT_ERROR = -2; // 参数错误

    // TOKEN 10-19
    public static final int CODE_TOKEN_EXPIRED = 10; // TOKEN 过期
    public static final int CODE_TOKEN_INVALID = 11; // TOKEN 无效
    public static final int CODE_TOKEN_REFRESH_FAILURE = 12; // TOKEN 刷新失败
    public static final int CODE_TOKEN_AUTH_FAILURE = 13; // 无操作权限
    public static final int CODE_TOKEN_URL_FAILURE = 14; // URL未记录

    // LOGIN 20-29
    public static final int CODE_CODE_INVALID = 20; // 验证码无效
    public static final int CODE_CODE_FAILURE = 21; // 验证码错误
    public static final int CODE_LOGIN_FAILURE = 22; // 登录名或密码错误
    public static final int CODE_USER_INVALID = 23; // 用户不存在

    // REGISTER 30-39
    public static final int CODE_REGISTER_INVALID = 30; // 用户名已存在

    // DATA 40-49
    public static final int CODE_DATA_QUERY_ERROR = 40; // 数据记录不存在
    public static final int CODE_DATA_MODIFY_ERROR = 41; // 数据记录修改失败


    // label 50-59
    public static final int CODE_LABEL_NAME_ERROR = 50; // 标签名称已存在


    // 映射
    public static final Map<Integer, String> CODEMESSAGEMAP = new HashMap<>();
    static {
        CODEMESSAGEMAP.put(CODE_SUCCESS, "成功");
        CODEMESSAGEMAP.put(CODE_FAIL, "失败");
        CODEMESSAGEMAP.put(CODE_SERVER_ERROR, "系统错误");
        CODEMESSAGEMAP.put(CODE_CLIENT_ERROR, "参数错误");

        CODEMESSAGEMAP.put(CODE_TOKEN_EXPIRED, "TOKEN 过期");
        CODEMESSAGEMAP.put(CODE_TOKEN_INVALID, "TOKEN 无效");
        CODEMESSAGEMAP.put(CODE_TOKEN_REFRESH_FAILURE, "TOKEN 刷新失败");
        CODEMESSAGEMAP.put(CODE_TOKEN_AUTH_FAILURE, "无操作权限");
        CODEMESSAGEMAP.put(CODE_TOKEN_URL_FAILURE, "URL未记录");
        
        CODEMESSAGEMAP.put(CODE_CODE_INVALID, "验证码无效");
        CODEMESSAGEMAP.put(CODE_CODE_FAILURE, "验证码错误");
        CODEMESSAGEMAP.put(CODE_LOGIN_FAILURE, "登录名或密码错误");
        CODEMESSAGEMAP.put(CODE_REGISTER_INVALID, "用户名已存在");
        CODEMESSAGEMAP.put(CODE_USER_INVALID, "用户不存在");


        CODEMESSAGEMAP.put(CODE_DATA_QUERY_ERROR, "数据记录不存在");
        CODEMESSAGEMAP.put(CODE_DATA_MODIFY_ERROR, "数据记录修改失败");


        CODEMESSAGEMAP.put(CODE_LABEL_NAME_ERROR, "标签名称已存在");
    }

    /**
     * 编码
     */
    private int code;
    /**
     * 信息
     */
    private String message;
    /**
     * 业务数据
     */
    private Object data;

    private Result() {
    }

    public static Result instance(int code, Object data) {
        Result result = new Result();
        result.setCode(code);
        result.setData(data);
        return result;
    }

    public static Result error(int code) {
        return instance(code, null);
    }

    public static Result success(Object data) {
        return instance(CODE_SUCCESS, data);
    }
    public static Result fail(Object data) {
        return instance(CODE_FAIL, data);
    }

    public int getCode() {
        return code;
    }

    private void setCode(int code) {
        this.code = code;
        this.setMessage(CODEMESSAGEMAP.get(code));
    }

    public String getMessage() {
        return message;
    }

    private void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    private void setData(Object data) {
        this.data = data;
    }

}
