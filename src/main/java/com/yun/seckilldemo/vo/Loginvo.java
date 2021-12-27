package com.yun.seckilldemo.vo;

import com.yun.seckilldemo.validator.IsMobile;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @author wanglufei
 * 登陆参数
 * @title: Loginvo
 * @projectName seckill-demo
 * @description: TODO
 * @date 2021/10/31/2:53 下午
 */
@Data
public class Loginvo {
    @NotNull
    //自定义@IsMobile组件
    @IsMobile
    private String mobile;
    @NotNull
    @Length(min = 32)
    private String password;

}
