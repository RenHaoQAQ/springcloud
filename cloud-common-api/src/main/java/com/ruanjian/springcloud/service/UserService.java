package com.ruanjian.springcloud.service;

import java.util.List;
import com.ruanjian.springcloud.entity.User;
    /**
 * 类 名 称：UserService
 * 类 描 述：TODO
 * 创建时间：2020-03-09 14:17
 * 创 建 人：renhao
 */
public interface UserService{


    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertOrUpdate(User record);

    int insertOrUpdateSelective(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int updateBatch(List<User> list);

    int batchInsert(List<User> list);

}
