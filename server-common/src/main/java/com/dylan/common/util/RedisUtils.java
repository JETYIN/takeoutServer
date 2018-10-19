package com.dylan.common.util;

import com.google.common.base.Preconditions;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

/***
 * 设置操作Redis
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)//fixme Lombok生成一个无参的构造方法
public final class RedisUtils {

    private static final String ACCESS_TOKEN = "takeout:token:accessToken";

    /***
     * token存储在redis中时将会设置为此
     * @param token
     * @return
     */
    public static String getAccessTokenKey(String token) {
        Preconditions.checkArgument(StringUtils.isNotEmpty(token), "非法请求token参数不存在");

        return ACCESS_TOKEN + ":" + token;
    }

}
