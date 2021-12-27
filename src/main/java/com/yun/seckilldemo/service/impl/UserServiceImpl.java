package com.yun.seckilldemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yun.seckilldemo.exception.GlobalException;
import com.yun.seckilldemo.mapper.UserMapper;
import com.yun.seckilldemo.pojo.User;
import com.yun.seckilldemo.service.IUserService;
import com.yun.seckilldemo.untils.CookieUtil;
import com.yun.seckilldemo.untils.MD5Utils;
import com.yun.seckilldemo.untils.UUIDUtil;
import com.yun.seckilldemo.vo.Loginvo;
import com.yun.seckilldemo.vo.RespBean;
import com.yun.seckilldemo.vo.RespBeanEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wanglufei
 * @since 2021-10-31
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * @param loginvo
     * @param request
     * @param response
     * @desc 登陆逻辑 登陆就传了一个手机号和密码
     * @Return: com.yun.seckilldemo.vo.RespBean
     * @author: wanglufei
     * @date: 2021/10/31 3:05 下午
     * @Version V1.1.0
     */
    @Override
    public RespBean doLogin(Loginvo loginvo, HttpServletRequest request, HttpServletResponse response) {
        String mobile = loginvo.getMobile();
        String password = loginvo.getPassword();
        //使用validator自定义组件对mobile校验
//        if (StringUtils.isEmpty(mobile)||StringUtils.isEmpty(password)){
//            return RespBean.error(RespBeanEnum.LOGIN_ERROR);
//        }
//
//        if (!ValidatorUtil.isMobile(mobile)){
//            return RespBean.error(RespBeanEnum.MOBILE_ERROr);
//        }
        User user = userMapper.selectById(mobile);
        if (user == null) {
            throw new GlobalException(RespBeanEnum.LOGIN_ERROR);
        }
        if (!MD5Utils.formPassToDBPass(password, user.getSlat()).equals(user.getPassword())) {
            throw new GlobalException(RespBeanEnum.LOGIN_ERROR);
        }
        /**
         * @desc 在秒杀的时候，为了实现对用户登录（状态校验）的状态的判断，采用在登录
         * @param loginvo
         * @param request
         * @param response
         * @Return: com.yun.seckilldemo.vo.RespBean
         * @author: wanglufei
         * @date: 2021/10/31 7:51 下午
         * @Version V1.1.0
         */
        //生成cookie
        String ticket = UUIDUtil.uuid();
        //将cookie放在session中
        //request.getSession().setAttribute(ticket,user);
        //将用户信息存入redis
        redisTemplate.opsForValue().set("user" + ticket, user);
        CookieUtil.setCookie(request, response, "userTicket", ticket);
        return RespBean.success(ticket);
    }

    @Override
    public User getUserByCookie(String userTicket, HttpServletRequest request, HttpServletResponse response) {
        if (StringUtils.isEmpty(userTicket)) {
            return null;
        }
        User o = (User) redisTemplate.opsForValue().get("user" + userTicket);
        if (o != null) {
            CookieUtil.setCookie(request, response, "userTicket", userTicket);
        }
        return o;
    }

    /**
     * @desc 更新密码
     * 当更新数据库的数据的时候一定要更新redis中的东西
     * 缓存和数据库的双写一致性的问题
     * @Return: com.yun.seckilldemo.vo.RespBean
     * @author: wanglufei
     * @date: 2021/11/7 3:46 下午
     * @Version V1.1.0
     */
    @Override
    public RespBean updatePassword(String userTicket,
                                   String password, HttpServletRequest request,
                                   HttpServletResponse response) {
        User user = getUserByCookie(userTicket, request, response);
        if (user==null){
            new GlobalException(RespBeanEnum.MOBILE_NOT_EXIST);
        }
        user.setPassword(MD5Utils.inputPassToDbPass(password,user.getSlat()));
        int result =userMapper.updateById(user);
        if (result==1){
            //删除redis的缓存
            redisTemplate.delete("user"+userTicket);
            return RespBean.success();
        }

        return RespBean.error(RespBeanEnum.PASSWORD_UPDATE_FAIL);
    }

}
