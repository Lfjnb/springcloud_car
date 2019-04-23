package com.jk.repostory;

import com.jk.model.CarBean2;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * 类描述：
 * 创建人：孙长江
 * 创建时间：2019/4/2214:39
 * 修改人：孙长江
 * 修改时间：2019/4/2214:39
 * 修改备注：
 */
public interface CarRepostory extends ElasticsearchRepository<CarBean2,Integer> {

}
