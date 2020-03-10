package com.ruanjian.springcloud.service;

import com.ruanjian.springcloud.entity.Lovers;

import java.util.List;

/**
* 类 名 称：LoversService
* 类 描 述：TODO
* 创建时间：2020-03-07 19:43
* 创 建 人：renhao
*/
public interface LoversService {


int deleteByPrimaryKey(Long id);

int insert(Lovers record);

int insertOrUpdate(Lovers record);

int insertOrUpdateSelective(Lovers record);

int insertSelective(Lovers record);

Lovers selectByPrimaryKey(Long id);

int updateByPrimaryKeySelective(Lovers record);

int updateByPrimaryKey(Lovers record);

int updateBatch(List<Lovers> list);

int batchInsert(List<Lovers> list);

}
