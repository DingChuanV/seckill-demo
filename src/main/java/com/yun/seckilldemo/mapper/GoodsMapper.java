package com.yun.seckilldemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yun.seckilldemo.pojo.Goods;
import com.yun.seckilldemo.vo.GoodsVo;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author wanglufei
 * @since 2021-11-01
 */
public interface GoodsMapper extends BaseMapper<Goods> {
    /**
     * @desc 获取商品列表
     * @author: wanglufei
     * @date: 2021/11/1 8:40 下午
     * @Version V1.1.0
     */
    List<GoodsVo> findGoodsVo();

    GoodsVo findGoodsVoByGoodsId(Long goodsId);
}
