package com.server.auth.runner;

import com.server.auth.jwt.KeyConfiguration;
import com.server.auth.jwt.RsaKeyHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 此类用于系统启动时进行赋值：KeyConfiguration中的秘钥和公钥--redis中进行赋值保存
 */
@Slf4j
@Component
@Order(value = 1)//优先级别
public class AuthCommandRunner implements CommandLineRunner {

    @Autowired
    public KeyConfiguration keyConfiguration;
    @Autowired
    public RedisTemplate<String, String> redisTemplate;
    //确定redis中的键值

    private String REDIS_USER_PRI_KEY = "SC:AUTH:JWT:PRI";
    private String REDIS_USER_PUB_KEY = "SC:AUTH:JWT:PUB";

    private String REDIS_SERVICE_PRI_KEY = "SC:AUTH:CLIENT:PRI";
    private String REDIS_SERVICE_PUB_KEY = "SC:AUTH:CLIENT:PUB";

    @Override
    public void run(String... args) throws Exception {//fixme 当前服务启动阶段便会执行当前run方法内部逻辑
        log.info("auth server is start");
        //fixme redis中保存有数据
        if (redisTemplate.hasKey(REDIS_USER_PRI_KEY) && redisTemplate.hasKey(REDIS_USER_PUB_KEY) && redisTemplate.hasKey(REDIS_SERVICE_PRI_KEY) && redisTemplate.hasKey(REDIS_SERVICE_PUB_KEY)) {
            log.info("redis has key of keyconfiguration");
            keyConfiguration.setUserPriKey(RsaKeyHelper.toBytes(redisTemplate.opsForValue().get(REDIS_USER_PRI_KEY).toString()));
            keyConfiguration.setUserPubKey(RsaKeyHelper.toBytes(redisTemplate.opsForValue().get(REDIS_USER_PUB_KEY).toString()));
            keyConfiguration.setServicePriKey(RsaKeyHelper.toBytes(redisTemplate.opsForValue().get(REDIS_SERVICE_PRI_KEY).toString()));
            keyConfiguration.setServicePubKey(RsaKeyHelper.toBytes(redisTemplate.opsForValue().get(REDIS_SERVICE_PUB_KEY).toString()));
        } else {
            //fixme redis中未保存有数据，进行设置
            log.info("redis not has key of keyconfiguration,parse generatekey");
            Map<String, byte[]> keyMap = RsaKeyHelper.generateKey(keyConfiguration.getUserSecret());
            keyConfiguration.setUserPriKey(keyMap.get("pri"));//获取对应generateKey方法中加入到map中的key值为pri
            keyConfiguration.setUserPubKey(keyMap.get("pub"));
            //保存到redis
            redisTemplate.opsForValue().set(REDIS_USER_PRI_KEY, RsaKeyHelper.toHexString(keyMap.get("pri")));
            redisTemplate.opsForValue().set(REDIS_USER_PUB_KEY, RsaKeyHelper.toHexString(keyMap.get("pub")));
            keyMap = RsaKeyHelper.generateKey(keyConfiguration.getServiceSecret());
            keyConfiguration.setServicePriKey(keyMap.get("pri"));
            keyConfiguration.setServicePubKey(keyMap.get("pub"));
            //保存到redis中
            redisTemplate.opsForValue().set(REDIS_SERVICE_PRI_KEY, RsaKeyHelper.toHexString(keyMap.get("pri")));
            redisTemplate.opsForValue().set(REDIS_SERVICE_PUB_KEY, RsaKeyHelper.toHexString(keyMap.get("pub")));

        }

    }
}
