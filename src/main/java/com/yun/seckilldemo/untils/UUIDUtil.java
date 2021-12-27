package com.yun.seckilldemo.untils;

import java.util.UUID;

/**
 * @author wanglufei
 * @title: UUIDUtil
 * @projectName seckill-demo
 * @description: TODO
 * @date 2021/10/31/7:40 下午
 */
public class UUIDUtil {
    public static String uuid(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
