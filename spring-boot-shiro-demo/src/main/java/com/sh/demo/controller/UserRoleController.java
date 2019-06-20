package com.sh.demo.controller;

import com.sh.demo.common.util.ShiroUtils;
import com.sh.demo.core.service.SysMenuService;
import com.sh.demo.core.service.SysRoleMenuService;
import com.sh.demo.core.service.SysRoleService;
import com.sh.demo.core.service.SysUserService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description 角色测试
 * @Author Sans
 * @CreateTime 2019/6/19 11:38
 */
@RestController
@RequestMapping("/role")
public class UserRoleController {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysMenuService sysMenuService;
    @Autowired
    private SysRoleMenuService sysRoleMenuService;

    /**
     * 管理员角色测试接口
     * @Author Sans
     * @CreateTime 2019/6/19 10:38
     * @Return Map<String,Object> 返回结果
     */
    @RequestMapping("/getAdminInfo")
    @RequiresRoles("ADMIN")
    public Map<String,Object> getAdminInfo(){
        Map<String,Object> map = new HashMap<>();
        map.put("code",200);
        map.put("msg","这里是只有管理员角色能访问的接口");
        return map;
    }

    /**
     * 用户角色测试接口
     * @Author Sans
     * @CreateTime 2019/6/19 10:38
     * @Return Map<String,Object> 返回结果
     */
    @RequestMapping("/getUserInfo")
    @RequiresRoles("USER")
    public Map<String,Object> getUserInfo(){
        Map<String,Object> map = new HashMap<>();
        map.put("code",200);
        map.put("msg","这里是只有用户角色能访问的接口");
        return map;
    }

    /**
     * 角色测试接口
     * @Author Sans
     * @CreateTime 2019/6/19 10:38
     * @Return Map<String,Object> 返回结果
     */
    @RequestMapping("/getRoleInfo")
    @RequiresRoles(value={"ADMIN","USER"},logical = Logical.OR)
    @RequiresUser
    public Map<String,Object> getRoleInfo(){
        Map<String,Object> map = new HashMap<>();
        map.put("code",200);
        map.put("msg","这里是只要有ADMIN或者USER角色能访问的接口");
        return map;
    }

    /**
     * 登出
     * @Author Sans
     * @CreateTime 2019/6/19 10:38
     * @Return Map<String,Object> 返回结果
     */
    @RequestMapping("/getLogout")
    @RequiresUser
    public Map<String,Object> getLogout(){
        //登出Shiro会帮我们清理掉Session和Cache
        ShiroUtils.logout();
        Map<String,Object> map = new HashMap<>();
        map.put("code",200);
        map.put("msg","登出");
        return map;
    }
}
