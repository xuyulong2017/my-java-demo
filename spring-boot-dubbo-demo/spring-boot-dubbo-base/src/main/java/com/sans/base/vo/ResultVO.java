package com.sans.base.vo;

import lombok.Getter;
import java.io.Serializable;

/**
 * 返回结果类
 * 这里采用构建者模式构建
 * 优点：1.私有化构造器访问范围小 2.参数可灵活设置便于管理
 * @Author Sans
 * @CreateTime 2019/11/7 18:59
 */
@Getter
public class ResultVO<T> implements Serializable {

    /**
     * 返回码
     */
    private int code;
    /**
     * 返回信息
     */
    private String message;
    /**
     * 返回数据
     */
    private T data;

    /** 私有化构造器  **/
    private ResultVO() {}
    private ResultVO(ResultVO<T> resultVO) {
        this.code = resultVO.code;
        this.message = resultVO.message;
        this.data = resultVO.data;
    }

    /**
     * Build
     */
    public static class Builder<T>{
        private ResultVO<T> resultVO;
        public Builder() {
            resultVO = new ResultVO<>();
        }
        public Builder code(int code){
            resultVO.code = code;
            return this;
        }
        public Builder message(String message){
            resultVO.message = message;
            return this;
        }
        public Builder data(T data){
            resultVO.data = data;
            return this;
        }
        public ResultVO<T> build(){
            return new ResultVO<>(resultVO);
        }
    }
}