package com.ruanjian.springcloud.service.impl;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruanjian.springcloud.entity.TbUser;
import com.ruanjian.springcloud.dao.TbUserDao;
import com.ruanjian.springcloud.service.TbUserService;

/**
 * 类 名 称：TbUserServiceImpl
 * 类 描 述：TODO
 * 创建时间：2020-03-09 14:18
 * 创 建 人：renhao
 */
@Service
public class TbUserServiceImpl implements TbUserService {

    @Resource
    private TbUserDao tbUserDao;

    @Override
    public int deleteByPrimaryKey(Long userId) {
        return tbUserDao.deleteByPrimaryKey(userId);
    }

    @Override
    public int insert(TbUser record) {
        return tbUserDao.insert(record);
    }

    @Override
    public int insertOrUpdate(TbUser record) {
        return tbUserDao.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(TbUser record) {
        return tbUserDao.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(TbUser record) {
        return tbUserDao.insertSelective(record);
    }

    @Override
    public TbUser selectByPrimaryKey(Long userId) {
        return tbUserDao.selectByPrimaryKey(userId);
    }

    @Override
    public int updateByPrimaryKeySelective(TbUser record) {
        return tbUserDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TbUser record) {
        return tbUserDao.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<TbUser> list) {
        return tbUserDao.updateBatch(list);
    }

    @Override
    public int batchInsert(List<TbUser> list) {
        return tbUserDao.batchInsert(list);
    }




}
