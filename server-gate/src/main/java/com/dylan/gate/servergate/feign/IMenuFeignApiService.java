package com.dylan.gate.servergate.feign;

import com.dylan.common.vo.gateserver.MenuVo;
import com.dylan.gate.servergate.feign.fallback.MenuFeignApiServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Set;

/***
 * 此类用于跨服务获取角色--菜单信息:从其他微服务获取(menu-moudle模块获取)
 */
@FeignClient(name = "menu-moudle", fallback = MenuFeignApiServiceFallBack.class)
public interface IMenuFeignApiService {
    /**
     * @param role 传入角色名称
     * @return 返回角色可操作的菜单信息
     */
    @GetMapping(value = "/menu/findMenuByRole/{roleName}")
    Set<MenuVo> findMenuByRole(@PathVariable("roleName") String role);
}
