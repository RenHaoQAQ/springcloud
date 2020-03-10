package com.ruanjian.springcloud.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 类 名 称：TbUser
 * 类 描 述：TODO
 * 创建时间：2020-03-09 14:18
 * 创 建 人：renhao
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbUser {
    private Long userId;

    /**
    * 用户名
    */
    private String username;

    /**
    * 手机号
    */
    private String mobile;

    /**
    * 密码
    */
    private String password;

    /**
    * 创建时间
    */
    private Date createTime;
}