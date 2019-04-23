package com.jk.controller;

import com.jk.dao.IsseuDao;
import com.jk.pojo.CarBean;
import com.jk.pojo.IssueBean;
import com.jk.utils.Easyuipage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("isseu")
public class IsseuController {

    @Autowired
    private IsseuDao isseuDao;

    /**
     * 问答查询
     * @param page
     * @param rows
     * @return
     */
        @RequestMapping("findIsseu")
        @ResponseBody
        public List<IssueBean>   findIsseu(){

            return  isseuDao.findIsseu();
        }

}
