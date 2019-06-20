package com.mp.demo.serivce;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mp.demo.entity.UserInfoEntity;


/**
 * @Description 用户业务接口
 * @Author Sans
 * @CreateTime 2019/6/8 16:26
 */
public interface UserInfoService extends IService<UserInfoEntity> {

    /**
     * 查询大于该分数的学生
     * @Author Sans
     * @CreateTime 2019/6/9 14:27
     * @Param  page  分页参数
     * @Param  fraction  分数
     * @Return IPage<UserInfoEntity> 分页数据
     */
    IPage<UserInfoEntity> selectUserInfoByGtFraction(IPage<UserInfoEntity> page,Long fraction);
}
