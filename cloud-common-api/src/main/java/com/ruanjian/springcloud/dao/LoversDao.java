package com.ruanjian.springcloud.dao;

import com.ruanjian.springcloud.entity.Lovers;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 类 名 称：LoversDao
 * 类 描 述：TODO
 * 创建时间：2020-03-07 19:43
 * 创 建 人：renhao
 */
@Mapper
public interface LoversDao {
    int deleteByPrimaryKey(Long id);

    int insert(Lovers record);

    int insertOrUpdate(Lovers record);

    int insertOrUpdateSelective(Lovers record);

    int insertSelective(Lovers record);

    Lovers selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Lovers record);

    int updateByPrimaryKey(Lovers record);

    int updateBatch(List<Lovers> list);

    int batchInsert(@Param("list") List<Lovers> list);
}