package com.ruanjian.springcloud.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruanjian.springcloud.entity.TbUser;

/**
 * 类 名 称：TbUserService
 * 类 描 述：TODO
 * 创建时间：2020-03-09 14:18
 * 创 建 人：renhao
 */
public interface TbUserService {


    int deleteByPrimaryKey(Long userId);

    int insert(TbUser record);

    int insertOrUpdate(TbUser record);

    int insertOrUpdateSelective(TbUser record);

    int insertSelective(TbUser record);

    TbUser selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(TbUser record);

    int updateByPrimaryKey(TbUser record);

    int updateBatch(List<TbUser> list);

    int batchInsert(List<TbUser> list);


}
