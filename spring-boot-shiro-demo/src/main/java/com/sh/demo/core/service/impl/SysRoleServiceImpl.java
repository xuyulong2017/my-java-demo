package com.sh.demo.core.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sh.demo.core.dao.SysRoleDao;
import com.sh.demo.core.entity.SysRoleEntity;
import com.sh.demo.core.service.SysRoleService;
import java.util.List;

/**
 * @Description 角色业务实现
 * @Author Sans
 * @CreateTime 2019/6/14 15:57
 */
@Service("sysRoleService")
public class SysRoleServiceImpl extends ServiceImpl<SysRoleDao, SysRoleEntity> implements SysRoleService {

    /**
     * 通过用户ID查询角色集合
     * @Author Sans
     * @CreateTime 2019/6/18 18:01
     * @Param  userId 用户ID
     * @Return List<SysRoleEntity> 角色名集合
     */
    @Override
    public List<SysRoleEntity> selectSysRoleByUserId(Long userId) {
        return this.baseMapper.selectSysRoleByUserId(userId);
    }
}