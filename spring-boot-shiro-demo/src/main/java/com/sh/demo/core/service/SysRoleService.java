package com.sh.demo.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sh.demo.core.entity.SysRoleEntity;
import java.util.List;

/**
 * @Description 角色业务接口
 * @Author Sans
 * @CreateTime 2019/6/14 15:57
 */
public interface SysRoleService extends IService<SysRoleEntity> {

    /**
     * 通过用户ID查询角色集合
     * @Author Sans
     * @CreateTime 2019/6/18 18:01
     * @Param  userId 用户ID
     * @Return List<SysRoleEntity> 角色名集合
     */
    List<SysRoleEntity> selectSysRoleByUserId(Long userId);
}

