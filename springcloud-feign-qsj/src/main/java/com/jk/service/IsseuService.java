package com.jk.service;

import com.jk.pojo.IssueBean;
import com.jk.utils.Easyuipage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("springcloud-car-reg")
public interface IsseuService {
    @RequestMapping("isseu/findIsseu")
    List<IssueBean> findIsseu();


}
