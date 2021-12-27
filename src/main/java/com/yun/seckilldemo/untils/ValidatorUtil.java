package com.yun.seckilldemo.untils;

import org.thymeleaf.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author wanglufei
 * 手机号码校验
 * @title: ValidatorUtil
 * @projectName seckill-demo
 * @description: TODO
 * @date 2021/10/31/3:33 下午
 */
public class ValidatorUtil {
    private static final Pattern mobile_phone = Pattern.compile("[1]([3-9])[0-9]{9}$");

    public static boolean isMobile(String mobile) {
        if (StringUtils.isEmpty(mobile)) {
            return false;
        }
        Matcher matcher = mobile_phone.matcher(mobile);
        return matcher.matches();
    }
}
