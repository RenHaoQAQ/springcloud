package com.ruanjian.springcloud.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.ruanjian.springcloud.dao.VideoDao;
import com.ruanjian.springcloud.entity.Video;
import com.ruanjian.springcloud.service.VideoService;

/**
 * 类 名 称：VideoServiceImpl
 * 类 描 述：TODO
 * 创建时间：2020-03-10 13:30
 * 创 建 人：renhao
 */
@Service
public class VideoServiceImpl implements VideoService {

    @Resource
    private VideoDao videoDao;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return videoDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Video record) {
        return videoDao.insert(record);
    }

    @Override
    public int insertOrUpdate(Video record) {
        return videoDao.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(Video record) {
        return videoDao.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(Video record) {
        return videoDao.insertSelective(record);
    }

    @Override
    public Video selectByPrimaryKey(Integer id) {
        return videoDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Video record) {
        return videoDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Video record) {
        return videoDao.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<Video> list) {
        return videoDao.updateBatch(list);
    }

    @Override
    public int batchInsert(List<Video> list) {
        return videoDao.batchInsert(list);
    }

}


