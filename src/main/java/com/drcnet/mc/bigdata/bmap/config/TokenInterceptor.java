package com.drcnet.mc.bigdata.bmap.config;/*
package com.drcnet.mc.bigdata.bmap.config;

import com.drcnet.mc.bigdata.bmap.Utils.InterceptorUtils;
import com.drcnet.mc.bigdata.bmap.entity.token.User;
import com.drcnet.mc.bigdata.bmap.service.token.TokenService;
import com.drcnet.mc.bigdata.bmap.support.manager.LogExeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

*/
/**
 * token拦截器
 *
 * @author qi.sun
 *//*

@Component
public class TokenInterceptor implements HandlerInterceptor {

    @Autowired
    private TokenService tokenService;

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object obj, Exception exc)
            throws Exception {
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object obj, ModelAndView mav)
            throws Exception {
    }

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object obj) throws Exception {

        // if("/token/login".indexOf(request.getRequestURI()) == -1 ||"/token/logout".indexOf(request.getRequestURI()) == -1){
        //校验为登录状态后,排除 登录 注册接口地址
        String token = InterceptorUtils.getAuthorization(request);
        User user = tokenService.convertToken(token).getUser();
       // LogExeManager.getInstance().executeLogTask(LogTaskFactory.bussinssLog(user.getUserId(), user.getName(), user.getLoginId(), request.getRequestURI(), request.getMethod(), 1, "success"));

        //}

        return true;
    }
       */
/* String uri = request.getRequestURI().toLowerCase();
        UrlRegister urlregister = tokenService.getUrlRegister(uri);
        if (urlregister == null) {
            InterceptorUtils.result(response, Result.CODE_TOKEN_URL_FAILURE,
                null);
            return false;
        }
        if (urlregister.getIsLogin()) {
            String authorization = InterceptorUtils.getAuthorization(request);
            UserToken userToken = tokenService.convertToken(authorization);
            Integer checkToken = tokenService.checkToken(userToken);
            if (checkToken != Result.CODE_SUCCESS) {
                InterceptorUtils.result(response, checkToken, null);
                return false;
            }
            // 校验是否有权限
            if (urlregister.getIsAuth()) {
                if (userToken.getPermissions() == null
                    || userToken.getPermissions()
                        .indexOf("," + urlregister.getUrlId() + ",") == -1) {
                    InterceptorUtils.result(response,
                        Result.CODE_TOKEN_AUTH_FAILURE, null);
                    return false;
                }
            }
            // 校验token日期
            Date now = new Date();
            Date expired = userToken.getExpired(); // 过期时间
            if (expired.before(now)) {
                InterceptorUtils.result(response, Result.CODE_TOKEN_EXPIRED,
                    null);
                return false;
            }
        }
        return true;
    }*//*


}
*/
