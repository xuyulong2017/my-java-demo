package com.sh.demo.core.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sh.demo.core.dao.SysUserRoleDao;
import com.sh.demo.core.entity.SysUserRoleEntity;
import com.sh.demo.core.service.SysUserRoleService;

/**
 * @Description 用户与角色业务实现
 * @Author Sans
 * @CreateTime 2019/6/14 15:57
 */
@Service("sysUserRoleService")
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleDao, SysUserRoleEntity> implements SysUserRoleService {

}