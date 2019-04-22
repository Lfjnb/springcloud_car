package com.jk.dao;

import com.jk.pojo.IssueBean;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;

public interface IsseuDao {

    @Select("select * from t_issue")
    List<IssueBean> findIsseu();

}
