package com.ruanjian.springcloud.dao;

import com.ruanjian.springcloud.entity.User;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 类 名 称：UserDao
 * 类 描 述：TODO
 * 创建时间：2020-03-09 14:17
 * 创 建 人：renhao
 */
@Mapper
public interface UserDao {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertOrUpdate(User record);

    int insertOrUpdateSelective(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int updateBatch(List<User> list);

    int batchInsert(@Param("list") List<User> list);
}