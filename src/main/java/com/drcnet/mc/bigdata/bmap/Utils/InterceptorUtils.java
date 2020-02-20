package com.drcnet.mc.bigdata.bmap.Utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

/**
 * 拦截器工具
 * 
 * @author qi.sun
 * @time 2018年11月26日 下午5:04:47
 */
public class InterceptorUtils {

    /**
     * 返回结果
     */
    public static void result(HttpServletResponse response, int code,
        Object data) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter writer = response.getWriter();
        Result result = Result.instance(code, data);
        String json = JSON.toJSONString(result);
        writer.write(json);
        writer.flush();
        writer.close();
    }

    /**
     * 获取token
     */
    public static String getAuthorization(HttpServletRequest request) {
        String authorization = request.getHeader("authorization");
        if (authorization == null || authorization.isEmpty()
            || "undefined".equalsIgnoreCase(authorization)
            || "null".equalsIgnoreCase(authorization)) {
            authorization = request.getParameter("authorization");
        }
        return authorization;
    }

}
