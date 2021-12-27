package com.yun.seckilldemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yun.seckilldemo.pojo.Order;
import com.yun.seckilldemo.pojo.User;
import com.yun.seckilldemo.vo.GoodsVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wanglufei
 * @since 2021-11-01
 */
public interface IOrderService extends IService<Order> {

    Order seckill(User user, GoodsVo goods);
}
