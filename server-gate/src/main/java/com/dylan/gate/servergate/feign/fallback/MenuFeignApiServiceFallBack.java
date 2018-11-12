package com.dylan.gate.servergate.feign.fallback;

import com.dylan.common.vo.gateserver.MenuVo;
import com.dylan.gate.servergate.feign.IMenuFeignApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Set;

/***
 * 用于获取角色--菜单失败会的回退
 */
@Slf4j
@Component
public class MenuFeignApiServiceFallBack implements IMenuFeignApiService {
    @Override
    public Set<MenuVo> findMenuByRole(String roleName) {
        log.error("MenuServiceFallBack findMenuByRole error,roleName:" + roleName);
        return null;
    }
}
