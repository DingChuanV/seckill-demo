package com.yun.seckilldemo.exception;

import com.yun.seckilldemo.vo.RespBeanEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author wanglufei
 * 全局异常
 * @title: GlobalException
 * @projectName seckill-demo
 * @description: TODO
 * @date 2021/10/31/5:54 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GlobalException extends RuntimeException{

    private RespBeanEnum respBeanEnum;
}
