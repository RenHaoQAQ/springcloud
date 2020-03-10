package com.ruanjian.springcloud.service.impl;

import com.ruanjian.springcloud.dao.LoversDao;
import com.ruanjian.springcloud.entity.Lovers;
import com.ruanjian.springcloud.service.LoversService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类 名 称：LoversServiceImpl
 * 类 描 述：TODO
 * 创建时间：2020-03-07 19:43
 * 创 建 人：renhao
 */
@Service
public class LoversServiceImpl implements LoversService {

    @Autowired
    private LoversDao loversDao;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return loversDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Lovers record) {
        return loversDao.insert(record);
    }

    @Override
    public int insertOrUpdate(Lovers record) {
        return loversDao.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(Lovers record) {
        return loversDao.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(Lovers record) {
        return loversDao.insertSelective(record);
    }

    @Override
    public Lovers selectByPrimaryKey(Long id) {
        return loversDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Lovers record) {
        return loversDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Lovers record) {
        return loversDao.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<Lovers> list) {
        return loversDao.updateBatch(list);
    }

    @Override
    public int batchInsert(List<Lovers> list) {
        return loversDao.batchInsert(list);
    }

}
