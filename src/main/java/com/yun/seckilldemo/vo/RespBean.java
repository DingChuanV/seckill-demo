package com.yun.seckilldemo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wanglufei
 * @desc 设置公共返回对象
 * @title: RespBean
 * @projectName seckill-demo
 * @description: TODO
 * @date 2021/10/31/2:27 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespBean {

    private long code;
    private String message;
    private Object obj;

    /**
     * @desc 成功返回
     * @Return: com.yun.seckilldemo.vo.RespBean
     * @author: wanglufei
     * @date: 2021/10/31 2:40 下午
     * @Version V1.1.0
     */
    public static RespBean success() {
        return new RespBean(RespBeanEnum.SUCCESS.getCode(), RespBeanEnum.SUCCESS.getMessage(), null);
    }

    /**
     * @param obj
     * @desc 成功返回
     * @Return: com.yun.seckilldemo.vo.RespBean
     * @author: wanglufei
     * @date: 2021/10/31 2:41 下午
     * @Version V1.1.0
     */
    public static RespBean success(Object obj) {
        return new RespBean(RespBeanEnum.SUCCESS.getCode(), RespBeanEnum.SUCCESS.getMessage(), obj);
    }

    /**
     * @param
     * @desc 失败返回
     * @Return: com.yun.seckilldemo.vo.RespBean
     * @author: wanglufei
     * @date: 2021/10/31 2:42 下午
     * @Version V1.1.0
     */
    public static RespBean error() {
        return new RespBean(RespBeanEnum.ERROR.getCode(), RespBeanEnum.ERROR.getMessage(), null);
    }

    /**
     * @param obj
     * @desc 失败返回
     * @Return: com.yun.seckilldemo.vo.RespBean
     * @author: wanglufei
     * @date: 2021/10/31 2:43 下午
     * @Version V1.1.0
     */
    public static RespBean error(Object obj) {
        return new RespBean(RespBeanEnum.ERROR.getCode(), RespBeanEnum.ERROR.getMessage(), null);
    }
}
