package com.jk.shiro;

import com.jk.pojo.UserBean;
import com.jk.service.ShiroService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;


public class MyRealm extends AuthorizingRealm {

    @Autowired
    private ShiroService shiroService;
    //认证方法
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取到输入框输入的用户名
        String userName = (String)token.getPrincipal();
        UserBean user =shiroService.findIntoByAccount(userName);
        System.out.println(user);
        if(user == null){
            //如果用户对象为空 抛出用户名错误异常
            throw new UnknownAccountException();
        }
        //认证器 第一个参数为用户名或用户对象 第二个参数为密码 第三个参数为当前real名称
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user,user.getPassword(),this.getName());
        return simpleAuthenticationInfo;
    }

    //授权方法
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
       return null;
    }


}
