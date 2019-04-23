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

    /*跳转展示首页*/
    @RequestMapping("PageOrderShow2")
    public   String  PageOrderShow2(Long phone,Model model){
        System.out.println(phone);
        model.addAttribute("phone",phone);
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
    @RequestMapping("jumpcarlist2")
    public   String  jumpcarlist2(String carName, Model model){
        System.out.println(carName);
        model.addAttribute("carName",carName);
        return  "carlist";
    }
    /*跳转汽车详情*/
    @RequestMapping("jumpcarxq")
    public   String  jumpcarxq(Integer  carId, Model model){
        model.addAttribute("carId",carId);
        System.out.println(carId);
        return  "carxiangqing";
    }
    /*跳转我要卖车*/
    @RequestMapping("wymc")
    public   String  wymc(Long phone,Model  model){
        model.addAttribute("phone",phone);
        return  "wymc";
    }

}
