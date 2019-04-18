package com.jk.controller;

import com.jk.pojo.TreeBean;
import com.jk.service.NavServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("feignNav")
public class NavController {

    @Autowired
    private NavServiceFeign navServiceFeign;

    @RequestMapping("findNav")
    @ResponseBody
    public List<TreeBean> findNav(){
        return navServiceFeign.findNav();
    }

    @RequestMapping("toindex")
    public String toindex(){
        return "jsp/index";
    }

    @RequestMapping("tocarlist")
    public String tocarlist(){
        return "jsp/carlist";
    }

    @RequestMapping("toaddCar")
    public String toaddCar(){
        return "jsp/addCar";
    }

    @RequestMapping("touserlist")
    public String touserlist(){
        return "jsp/userlist";
    }
}
