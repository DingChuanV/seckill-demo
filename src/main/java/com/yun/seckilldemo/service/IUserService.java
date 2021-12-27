package com.yun.seckilldemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yun.seckilldemo.pojo.User;
import com.yun.seckilldemo.vo.Loginvo;
import com.yun.seckilldemo.vo.RespBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author wanglufei
 * @since 2021-10-31
 */
public interface IUserService extends IService<User> {
    /**
     * @param loginvo
     * @param request
     * @param response
     * @desc 登陆
     * @Return: com.yun.seckilldemo.vo.RespBean
     * @author: wanglufei
     * @date: 2021/10/31 3:04 下午
     * @Version V1.1.0
     */
    RespBean doLogin(Loginvo loginvo, HttpServletRequest request, HttpServletResponse response);

    /**
     * @param userTicket
     * @desc 根据cookie获取用户
     * @Return: com.yun.seckilldemo.pojo.User
     * @author: wanglufei
     * @date: 2021/11/1 3:15 下午
     * @Version V1.1.0
     */
    User getUserByCookie(String userTicket, HttpServletRequest request, HttpServletResponse response);

    /**
     * @desc 更新密码
     * @Return:
     * @author: wanglufei
     * @date: 2021/11/7 3:45 下午
     * @Version V1.1.0
     */
    RespBean updatePassword(String userTicket, String password, HttpServletRequest request,
                            HttpServletResponse response);
}
