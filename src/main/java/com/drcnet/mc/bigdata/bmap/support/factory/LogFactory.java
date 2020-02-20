package com.drcnet.mc.bigdata.bmap.support.factory;

import com.drcnet.mc.bigdata.bmap.entity.SysAuthAccountLog;
import com.drcnet.mc.bigdata.bmap.entity.SysUserOprationLog;

import java.util.Date;

/**
 *   日志对象工厂
 * @author tomsun28
 * @date 9:50 2018/4/22
 */
public class LogFactory {

    private LogFactory() {
       
    }

    public static SysAuthAccountLog createAccountLog(Integer userId,String name ,String loginId, String logName, String ip, Integer success, String message) {
        SysAuthAccountLog accountLog = new SysAuthAccountLog();
        accountLog.setUserId(userId);
        accountLog.setName(name);
        accountLog.setLoginId(loginId);
        accountLog.setLogName(logName);
        accountLog.setIp(ip);
        accountLog.setSuccess(success);
        accountLog.setMessage(message);
        accountLog.setCreateTime(new Date());
        return accountLog;
    }

    public static SysUserOprationLog createOperationLog(Integer userId,String name, String loginId ,String logName, String api, String method, Integer succeed, String message) {
        SysUserOprationLog operationLog = new SysUserOprationLog();
        operationLog.setUserId(userId);
        operationLog.setName(name);
        operationLog.setLoginId(loginId);
        operationLog.setLogName(logName);
        operationLog.setApi(api);
        operationLog.setMethod(method);
        operationLog.setSuccess(succeed);
        operationLog.setMessage(message);
        operationLog.setCreateTime(new Date());
        return operationLog;
    }
}
