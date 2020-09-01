package com.mp.demo.serivce.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mp.demo.dao.DeptInfoDao;
import com.mp.demo.entity.DeptInfoEntity;
import com.mp.demo.serivce.DeptInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 部门业务实现
 * @Author Sans
 * @CreateTime 2020/8/29
 */
@Service
@Transactional
public class DeptInfoServiceImpl extends ServiceImpl<DeptInfoDao, DeptInfoEntity> implements DeptInfoService {

}