package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("PageController")
public class PageController {

    /*跳转展示首页*/
    @RequestMapping("PageOrderShow")
    public   String  PageOrderShow(){
        return  "carshow2";
    }
    /*跳转我要卖车*/
    @RequestMapping("jumpsellcar")
    public   String  jumpsellcar(){
        return  "sellcar2";
    }
    /*引入登录页面*/
    @RequestMapping("jumplogin")
    public   String  jumplogin(){
        return  "login";
    }
    /*跳转汽车list页面*/
    @RequestMapping("jumpcarlist")
    public   String  jumpcarlist(Integer  dqid, Model model){
        model.addAttribute("dqid",dqid);
        System.out.println(dqid);
        return  "carlist";
    }

    /*跳转汽车详情*/
    @RequestMapping("jumpcarxq")
    public   String  jumpcarxq(Integer  carId){
        return  "carxiangqing";
    }
}
