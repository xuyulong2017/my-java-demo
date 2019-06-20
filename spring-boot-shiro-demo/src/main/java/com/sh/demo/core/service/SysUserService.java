package com.sh.demo.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sh.demo.core.entity.SysUserEntity;

/**
 * @Description 系统用户业务接口
 * @Author Sans
 * @CreateTime 2019/6/14 15:57
 */
public interface SysUserService extends IService<SysUserEntity> {

    /**
     * 根据用户名查询实体
     * @Author Sans
     * @CreateTime 2019/6/14 16:30
     * @Param  username 用户名
     * @Return SysUserEntity 用户实体
     */
    SysUserEntity selectUserByName(String username);

}

