package com.jk.controller;


import com.jk.pojo.UserBean;
import com.jk.service.ShiroService;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.security.PublicKey;

@Controller
public class HouLoginController {

    /**
     * 后台管理员登陆
     * shiro权限
     * 查寻账号是否存在
     * @param userName
     * @return
     */
    @Autowired
    private ShiroService shiroService;
    /**
     * 当用户名密码不正确时
     * 跳转到此方法
     * 认证失败之后会进入此方法 提示用户失败原因
     * @return
     */
    @RequestMapping("login")
    public String login(HttpServletRequest request, ModelMap map){
        //认证器会根据对应的错误 返回对应的异常 根据异常判断对应错误
        String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");

        if(UnknownAccountException.class.getName().equals(exceptionClassName)
                || AuthenticationException.class.getName().equals(exceptionClassName)){
            System.out.println("request = [ 用户名异常]");
            map.put("message","用户名错误");
        }else{
            System.out.println("request = [密码异常]");
            map.put("message","密码错误");
        }
        return "login";
    }

    /**
     * 跳转到登录页面
     * @return
     */
     @RequestMapping("toLogin")
     public   String  toLogin (){
        return  "login";
    }
    /**
     * 新增后台管理员账号
     * @param userBean
     * @return
     */
    @RequestMapping("addUser")
    @ResponseBody
    public   Boolean  addUser(UserBean userBean){
        try {
            shiroService.addUser(userBean);
            return  true;
        }catch (Exception e){
            e.printStackTrace();
            return  false;
        }
    }

}
