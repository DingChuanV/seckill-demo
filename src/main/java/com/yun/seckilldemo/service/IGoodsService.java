package com.yun.seckilldemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yun.seckilldemo.pojo.Goods;
import com.yun.seckilldemo.vo.GoodsVo;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author wanglufei
 * @since 2021-11-01
 */
public interface IGoodsService extends IService<Goods> {
    /**
     * @param
     * @desc 获取goods列表
     * @Return: java.util.List<com.yun.seckilldemo.vo.GoodsVo>
     * @author: wanglufei
     * @date: 2021/11/1 8:38 下午
     * @Version V1.1.0
     */
    List<GoodsVo> findGoodsVo();

    GoodsVo findGoodsVoByGoodsId(Long goodsId);
}
