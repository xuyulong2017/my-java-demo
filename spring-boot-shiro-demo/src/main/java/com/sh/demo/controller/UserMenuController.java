package com.sh.demo.controller;

import com.sh.demo.common.util.ShiroUtils;
import com.sh.demo.core.entity.SysMenuEntity;
import com.sh.demo.core.entity.SysRoleEntity;
import com.sh.demo.core.entity.SysRoleMenuEntity;
import com.sh.demo.core.entity.SysUserEntity;
import com.sh.demo.core.service.SysMenuService;
import com.sh.demo.core.service.SysRoleMenuService;
import com.sh.demo.core.service.SysRoleService;
import com.sh.demo.core.service.SysUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 权限测试
 * @Author Sans
 * @CreateTime 2019/6/19 11:38
 */
@RestController
@RequestMapping("/menu")
public class UserMenuController {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysMenuService sysMenuService;
    @Autowired
    private SysRoleMenuService sysRoleMenuService;

    /**
     * 获取用户信息集合
     * @Author Sans
     * @CreateTime 2019/6/19 10:36
     * @Return Map<String,Object> 返回结果
     */
    @RequestMapping("/getUserInfoList")
    @RequiresPermissions("sys:user:info")
    public Map<String,Object> getUserInfoList(){
        Map<String,Object> map = new HashMap<>();
        List<SysUserEntity> sysUserEntityList = sysUserService.list();
        map.put("sysUserEntityList",sysUserEntityList);
        return map;
    }

    /**
     * 获取角色信息集合
     * @Author Sans
     * @CreateTime 2019/6/19 10:37
     * @Return Map<String,Object> 返回结果
     */
    @RequestMapping("/getRoleInfoList")
    @RequiresPermissions("sys:role:info")
    public Map<String,Object> getRoleInfoList(){
        Map<String,Object> map = new HashMap<>();
        List<SysRoleEntity> sysRoleEntityList = sysRoleService.list();
        map.put("sysRoleEntityList",sysRoleEntityList);
        return map;
    }

    /**
     * 获取权限信息集合
     * @Author Sans
     * @CreateTime 2019/6/19 10:38
     * @Return Map<String,Object>
     */
    @RequestMapping("/getMenuInfoList")
    @RequiresPermissions("sys:menu:info")
    public Map<String,Object> getMenuInfoList(){
        Map<String,Object> map = new HashMap<>();
        List<SysMenuEntity> sysMenuEntityList = sysMenuService.list();
        map.put("sysMenuEntityList",sysMenuEntityList);
        return map;
    }

    /**
     * 获取所有数据
     * @Author Sans
     * @CreateTime 2019/6/19 10:38
     * @Return Map<String,Object>
     */
    @RequestMapping("/getInfoAll")
    @RequiresPermissions("sys:info:all")
    public Map<String,Object> getInfoAll(){
        Map<String,Object> map = new HashMap<>();
        List<SysUserEntity> sysUserEntityList = sysUserService.list();
        map.put("sysUserEntityList",sysUserEntityList);
        List<SysRoleEntity> sysRoleEntityList = sysRoleService.list();
        map.put("sysRoleEntityList",sysRoleEntityList);
        List<SysMenuEntity> sysMenuEntityList = sysMenuService.list();
        map.put("sysMenuEntityList",sysMenuEntityList);
        return map;
    }

    /**
     * 添加管理员角色权限(测试动态权限更新)
     * @Author Sans
     * @CreateTime 2019/6/19 10:39
     * @Param  username 用户ID
     * @Return Map<String,Object>
     */
    @RequestMapping("/addMenu")
    public Map<String,Object> addMenu(){
        //添加管理员角色权限
        SysRoleMenuEntity sysRoleMenuEntity = new SysRoleMenuEntity();
        sysRoleMenuEntity.setMenuId(4L);
        sysRoleMenuEntity.setRoleId(1L);
        sysRoleMenuService.save(sysRoleMenuEntity);
        //清除缓存
        String username = "admin";
        ShiroUtils.deleteCache(username,false);
        Map<String,Object> map = new HashMap<>();
        map.put("code",200);
        map.put("msg","权限添加成功");
        return map;
    }
}