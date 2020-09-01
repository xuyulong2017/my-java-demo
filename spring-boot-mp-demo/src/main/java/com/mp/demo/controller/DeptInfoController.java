package com.mp.demo.controller;

import com.mp.demo.entity.DeptInfoEntity;
import com.mp.demo.serivce.DeptInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 自动填充和逻辑删除示例
 * @Author Sans
 * @CreateTime 2020/8/15
 */
@RestController
@RequestMapping("/deptInfo")
public class DeptInfoController {

    @Autowired
    private DeptInfoService deptInfoService;

    /**
     * 新增
     * @Author Sans
     * @CreateTime 2020/8/31
     * @Param  deptInfoEntity 部门信息实体类
     * @Return void
     */
    @PostMapping("/save")
    public void save(@RequestBody DeptInfoEntity deptInfoEntity){
        deptInfoService.save(deptInfoEntity);
    }
    /**
     * 更新
     * @Author Sans
     * @CreateTime 2020/8/31
     * @Param  deptInfoEntity 部门信息实体类
     * @Return void
     */
    @PostMapping("/update")
    public void update(@RequestBody DeptInfoEntity deptInfoEntity){
        deptInfoService.updateById(deptInfoEntity);
    }
    /**
     * 查询
     * @Author Sans
     * @CreateTime 2020/8/31
     * @Return Map<String,Object> 数据
     */
    @RequestMapping("/list")
    public Map<String,Object> list(){
        //初始化返回类
        Map<String,Object> result = new HashMap<>();
        List<DeptInfoEntity> deptInfoEntityList = deptInfoService.list();
        result.put("list",deptInfoEntityList);
        return result;
    }
    /**
     * 逻辑删除
     * @Author Sans
     * @CreateTime 2020/8/31
     * @Return void
     */
    @RequestMapping("/delete")
    public void delete(String deptId){
        deptInfoService.removeById(deptId);
    }
}