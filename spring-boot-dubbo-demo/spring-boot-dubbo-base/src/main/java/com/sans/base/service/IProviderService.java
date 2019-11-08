package com.sans.base.service;

import com.sans.base.dto.ProviderTestDTO;
import java.util.List;

/**
 * RPC接口
 * @Author Sans
 * @CreateTime 2019/11/6 23:03
 */
public interface IProviderService {
    List<ProviderTestDTO> queryList();
}