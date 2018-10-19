package com.server.auth.jwt;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * serviice层调用接口生成token
 */
@Slf4j
@Component
public class JsonTokenUtils {
    @Value("${jwt.expire}") //fixme 获取application.properties中的token过期时间14400
    private int expire;
    @Autowired
    private KeyConfiguration keyConfiguration;


    public String generateToken(IJWTInfo jwtInfo) throws Exception {
        if (null == keyConfiguration) {//测试验证当前的keyConfiguration 为null
            log.error("genarate token ocuury exception.keyConfiguration is null");
        }
        return JWTHelper.generateToken(jwtInfo, "pri", expire);//keyConfiguration出现空指针异常
    }

    public IJWTInfo getInfoFromToken(String token) throws Exception {//fixme 刷新token


        return JWTHelper.getInfoFromToken(token, keyConfiguration.getUserPubKey());
    }


    public static JsonTokenUtils getInstance() {
        return SingleTon.INSTANCE.getInstance();
    }

    /***
     * 适用于服务端的高并发
     */

    public static enum SingleTon {
        INSTANCE;
        private JsonTokenUtils singleton;

        private SingleTon() {
            this.singleton = new JsonTokenUtils();
        }

        public JsonTokenUtils getInstance() {
            return singleton;
        }
    }

}
