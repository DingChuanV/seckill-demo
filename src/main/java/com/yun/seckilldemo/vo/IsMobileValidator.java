package com.yun.seckilldemo.vo;

import com.yun.seckilldemo.untils.ValidatorUtil;
import com.yun.seckilldemo.validator.IsMobile;
import org.thymeleaf.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author wanglufei
 * 自定义@IsMobile组件的校验规则
 * @title: isMobilevalidator
 * @projectName seckill-demo
 * @description: TODO
 * @date 2021/10/31/4:06 下午
 */
public class IsMobileValidator implements ConstraintValidator<IsMobile, String> {
    private boolean required = false;

    @Override
    public void initialize(IsMobile constraintAnnotation) {
        required = constraintAnnotation.required();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (required){
            return ValidatorUtil.isMobile(value);
        }else {
            if (StringUtils.isEmpty(value)){
                return true;
            }else{
                return ValidatorUtil.isMobile(value);
            }
        }
    }
}
