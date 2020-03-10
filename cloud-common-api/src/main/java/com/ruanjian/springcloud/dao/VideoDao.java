package com.ruanjian.springcloud.dao;

import com.ruanjian.springcloud.entity.Video;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 类 名 称：VideoDao
 * 类 描 述：TODO
 * 创建时间：2020-03-10 13:43
 * 创 建 人：renhao
 */
@Mapper
public interface VideoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Video record);

    int insertOrUpdate(Video record);

    int insertOrUpdateSelective(Video record);

    int insertSelective(Video record);

    Video selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Video record);

    int updateByPrimaryKey(Video record);

    int updateBatch(List<Video> list);

    int batchInsert(@Param("list") List<Video> list);
}