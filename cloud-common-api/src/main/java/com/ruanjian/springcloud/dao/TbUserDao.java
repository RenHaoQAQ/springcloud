package com.ruanjian.springcloud.dao;

import com.ruanjian.springcloud.entity.TbUser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 类 名 称：TbUserDao
 * 类 描 述：TODO
 * 创建时间：2020-03-09 14:18
 * 创 建 人：renhao
 */
@Mapper
public interface TbUserDao {
    int deleteByPrimaryKey(Long userId);

    int insert(TbUser record);

    int insertOrUpdate(TbUser record);

    int insertOrUpdateSelective(TbUser record);

    int insertSelective(TbUser record);

    TbUser selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(TbUser record);

    int updateByPrimaryKey(TbUser record);

    int updateBatch(List<TbUser> list);

    int batchInsert(@Param("list") List<TbUser> list);

}