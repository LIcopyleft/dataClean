package com.drcnet.mc.bigdata.bmap.Utils;

import java.text.ParseException;
import java.util.Map;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.Payload;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;

import net.minidev.json.JSONObject;

/**
 * token jwt
 * 
 * @author qi.sun
 *
 */
public class JwtUtils {

    /**
     * 32位byte[]密匙
     */
    private static final byte[] SECRET = "thesecretlengthmustbeatleast256bits".getBytes();

    /**
     * 生成token
     */
    public static String generate(Map<String, Object> payloadMap)
        throws JOSEException {
        /**
         * JWSHeader参数：
         * 
         * 1.加密算法法则
         * 
         * 2.类型
         * 
         * 3.一般只需要传入加密算法法则就可以，这里则采用HS256。
         *
         * 注：JWSAlgorithm类里面有所有的加密算法法则，直接调用。
         */
        // 先建立一个头部Header
        JWSHeader jwsHeader = new JWSHeader(JWSAlgorithm.HS256);
        // 建立一个载荷Payload
        Payload payload = new Payload(new JSONObject(payloadMap));
        // 将头部和载荷结合在一起
        JWSObject jwsObject = new JWSObject(jwsHeader, payload);
        // 建立一个密匙
        JWSSigner jwsSigner = new MACSigner(SECRET);
        // 签名
        jwsObject.sign(jwsSigner);
        // 生成token
        return jwsObject.serialize();
    }

    /**
     * 解析token
     */
    public static Map<String, Object> analysis(String token)
        throws ParseException, JOSEException {
        // 解析token
        JWSObject jwsObject = JWSObject.parse(token);
        // 获取到载荷
        Payload payload = jwsObject.getPayload();
        // 建立一个解锁密匙
        JWSVerifier jwsVerifier = new MACVerifier(SECRET);
        // 判断token
        if (jwsObject.verify(jwsVerifier)) {
            // 载荷的数据解析成Json对象并转为Map。
            return (Map<String, Object>) payload.toJSONObject();
        } else {
            return null;
        }
    }

}
