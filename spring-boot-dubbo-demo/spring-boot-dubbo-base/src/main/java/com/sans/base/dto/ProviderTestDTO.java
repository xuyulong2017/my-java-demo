package com.sans.base.dto;

import lombok.Data;
import java.io.Serializable;

/**
 * RPC接口DTO
 * 注意这里要实现序列化接口
 * @Author Sans
 * @CreateTime 2019/11/6 23:04
 */
@Data
public class ProviderTestDTO implements Serializable {
    // ID
    private int id;
    // 名字
    private String name;
    // 序号
    private Integer number;
}