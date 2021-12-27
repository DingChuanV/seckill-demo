package com.yun.seckilldemo.exception;

import com.yun.seckilldemo.vo.RespBean;
import com.yun.seckilldemo.vo.RespBeanEnum;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * @author wanglufei
 * 全局异常处理类
 * @title: GlobalExceptionHandler
 * @projectName seckill-demo
 * @description: TODO
 * @date 2021/10/31/5:55 下午
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public RespBean ExceptionHandler(Exception e) {
        if (e instanceof GlobalException) {
            GlobalException globalException = (GlobalException) e;
            return RespBean.error(globalException.getRespBeanEnum());
        }else if (e instanceof BindException){
            BindException bindException=(BindException) e;
            RespBean error = RespBean.error(RespBeanEnum.BIND_ERROR);
            error.setMessage("参数校验异常"+ bindException.getBindingResult().getAllErrors().get(0).getDefaultMessage());
            return error;
        }
        return RespBean.error(RespBeanEnum.BIND_ERROR);
    }
}
