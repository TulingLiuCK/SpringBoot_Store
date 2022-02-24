package com.lck.springboot_store.interceptor;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Invocation;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Properties;

/***
 #Create by LCK on 2022/1/30
 # 用法: 登录拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {


    /**
     * 检测全局session对象中是否有uid数据，如果有放行，如果没有重定向到登录页面
     *
     * @param request  请求对象
     * @param response 响应对象
     * @param handler  处理器（url+controller：映射)
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        HttpSession session = request.getSession();
//        Object uid = session.getAttribute("uid");
        Object uid = request.getSession().getAttribute("uid");
        if (uid == null) {
            response.sendRedirect("/web/login.html");
            return false;
        }
        return true;
    }


}
