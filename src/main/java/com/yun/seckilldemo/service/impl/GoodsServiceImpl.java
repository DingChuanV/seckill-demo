package com.yun.seckilldemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yun.seckilldemo.mapper.GoodsMapper;
import com.yun.seckilldemo.pojo.Goods;
import com.yun.seckilldemo.service.IGoodsService;
import com.yun.seckilldemo.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wanglufei
 * @since 2021-11-01
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements IGoodsService {
    @Autowired
    private GoodsMapper goodsMapper;
    /**
     * @param
     * @desc 获取goods列表
     * @Return: java.util.List<com.yun.seckilldemo.vo.GoodsVo>
     * @author: wanglufei
     * @date: 2021/11/1 8:39 下午
     * @Version V1.1.0
     */
    @Override
    public List<GoodsVo> findGoodsVo() {
        return goodsMapper.findGoodsVo();
    }

    @Override
    public GoodsVo findGoodsVoByGoodsId(Long goodsId) {
        return goodsMapper.findGoodsVoByGoodsId(goodsId);
    }
}
