package com.ruanjian.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 类 名 称：Lovers
 * 类 描 述：TODO
 * 创建时间：2020-03-07 19:43
 * 创 建 人：renhao
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lovers implements Serializable {
    /**
    * id
    */
    private Long id;

    /**
    * 男孩姓名
    */
    private String boyName;

    /**
    * 女孩姓名
    */
    private String girlName;

    /**
    * 男孩出生日期
    */
    private Date boyBirthDate;

    /**
    * 女孩姓名
    */
    private Date girlBirthDate;

    /**
    * 记录日期
    */
    private Date createTime;

    /**
    * 消息
    */
    private String message;

    /**
    * 表白类型
    */
    private Integer type;

    /**
    * 修改日期
    */
    private Date updateTime;

    /**
    * 表白日期
    */
    private Date confessionDate;
}