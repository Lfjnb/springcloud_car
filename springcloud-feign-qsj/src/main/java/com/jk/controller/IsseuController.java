package com.jk.controller;

import com.jk.pojo.IssueBean;
import com.jk.service.IsseuService;
import com.jk.utils.Easyuipage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("isseu")
public class IsseuController {

      @Autowired
      private IsseuService isseuService;

    /**
     * 问答查询
     * @return
     */
    @RequestMapping("findIsseu")
    @ResponseBody
    public List<IssueBean> findIsseu() {
        return  isseuService.findIsseu();
    }

}
