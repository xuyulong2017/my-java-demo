package com.sans.consumer;

import com.sans.base.dto.ProviderTestDTO;
import com.sans.base.service.IProviderService;
import com.sans.base.vo.ResultVO;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * 消费测试接口
 * @Author Sans
 * @CreateTime 2019/11/6 23:09
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerController {
    // Dubbo远程调用注解
    @Reference
    private IProviderService providerService;
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResultVO getList(){
        // 远程调用
        List<ProviderTestDTO> providerTestDTOList = providerService.queryList();
        return new ResultVO.Builder<>().code(200).message("success").data(providerTestDTOList).build();
    }
}