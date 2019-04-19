package com.jk.controller;


import com.jk.dao.ShiroDao;
import com.jk.pojo.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HouLoginController {
    @Autowired
    private ShiroDao shiroDao;

    /**
     * 后台管理员登陆
     * shiro权限
     * 查寻账号是否存在
     * @param userName
     * @return
     */
    @RequestMapping("queryPhone")
    @ResponseBody
   public UserBean findIntoByAccount(@RequestParam String userName){
           return shiroDao.findIntoByAccount(userName);
    }

    /**
     * 新增后台管理员账号
     * @param userBean
     * @return
     */
    @RequestMapping("addUser")
    @ResponseBody
    public   Boolean  addUser(@RequestBody UserBean userBean){
        try {
              shiroDao.addUser(userBean);
              return  true;
        }catch (Exception e){
            e.printStackTrace();
            return  false;
        }
    }
}
