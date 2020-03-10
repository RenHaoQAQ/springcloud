package com.ruanjian.springcloud.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.ruanjian.springcloud.dao.UserDao;
import com.ruanjian.springcloud.entity.User;
import com.ruanjian.springcloud.service.UserService;

/**
 * 类 名 称：UserServiceImpl
 * 类 描 述：TODO
 * 创建时间：2020-03-09 14:16
 * 创 建 人：renhao
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return userDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(User record) {
        return userDao.insert(record);
    }

    @Override
    public int insertOrUpdate(User record) {
        return userDao.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(User record) {
        return userDao.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(User record) {
        return userDao.insertSelective(record);
    }

    @Override
    public User selectByPrimaryKey(Long id) {
        return userDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userDao.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<User> list) {
        return userDao.updateBatch(list);
    }

    @Override
    public int batchInsert(List<User> list) {
        return userDao.batchInsert(list);
    }

}

