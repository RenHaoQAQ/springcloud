package com.ruanjian.springcloud.service;

import java.util.List;
import com.ruanjian.springcloud.entity.Video;

/**
 * 类 名 称：VideoService
 * 类 描 述：TODO
 * 创建时间：2020-03-10 13:30
 * 创 建 人：renhao
 */
public interface VideoService {


    int deleteByPrimaryKey(Integer id);

    int insert(Video record);

    int insertOrUpdate(Video record);

    int insertOrUpdateSelective(Video record);

    int insertSelective(Video record);

    Video selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Video record);

    int updateByPrimaryKey(Video record);

    int updateBatch(List<Video> list);

    int batchInsert(List<Video> list);

}


