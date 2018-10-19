package com.dylan.gate.servergate.fallback;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/****
 * Auth服务模块异常处理
 */
@Slf4j
@Component
public class AllServerFallback implements FallbackProvider {

    public String SERVER_NO_RESPONSE = "current server not response";//fixme 服务降级--当前服务无响应

    @Override
    public String getRoute() {
        return "*";//fixme api服务id，如需所有都支持回退，可设置为return null,或return"*"
    }

    //fixme 请求服务失败，返回信息给客户端
    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {

        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                log.error("AuthServerFallback getStatusCode excute");

                return HttpStatus.SERVICE_UNAVAILABLE;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                log.error("AuthServerFallback getRawStatusCode excute");
                return HttpStatus.SERVICE_UNAVAILABLE.value();
            }

            @Override
            public String getStatusText() throws IOException {
                log.error("AuthServerFallback getStatusText excute");

                return HttpStatus.SERVICE_UNAVAILABLE.getReasonPhrase();
            }

            @Override
            public void close() {
                log.error("AuthServerFallback close excute");

            }

            @Override
            public InputStream getBody() throws IOException {//fixme 服务不可用返回客户端信息
                log.error("AuthServerFallback getBody excute,route:" + route);
                if (cause != null && cause.getMessage() != null) {
                    log.error("invoke:{} exception：{}", route, cause.getMessage());
                    return new ByteArrayInputStream(cause.getMessage().getBytes());
                } else {
                    log.error("invoke:{} exception：{}", route, SERVER_NO_RESPONSE.getBytes());
                    return new ByteArrayInputStream(SERVER_NO_RESPONSE.getBytes());
                }

            }

            @Override
            public HttpHeaders getHeaders() {
                log.error("AuthServerFallback getHeaders excute");
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);//fixme 设置返回数据格式，以免乱码
                return headers;

            }
        };

    }


}
