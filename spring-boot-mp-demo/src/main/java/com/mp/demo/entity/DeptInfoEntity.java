package com.mp.demo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.util.Date;

/**
 * 部门信息实体类
 * @Author Sans
 * @CreateTime 2020/8/15 20:03
 */
@Data
@TableName("dept_info")
public class DeptInfoEntity {

    /**
     * ID主键
     */
    @TableId(type = IdType.AUTO)
    private Long deptId;
    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 自动填充属性
     * FieldFill.INSERT 为插入时填充
     * FieldFill.INSERT_UPDATE 插入和更新填充字段
     * FieldFill.UPDATE 更新填充字段
     * FieldFill.DEFAULT 默认不处理
     */
    /**
     * 创建者ID
     */
    @TableField(fill = FieldFill.INSERT)
    private String createId;
    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    /**
     * 更新者ID
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateId;
    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    /**
     * 逻辑删除
     * TableLogic为逻辑删除注解,如果在yml配置了全局逻辑删除字段,这个注解可以不加
     * 注意: insert 官方推荐字段在数据库定义默认值
     */
    @TableLogic
    private Integer deleted;
}