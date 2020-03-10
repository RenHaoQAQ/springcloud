package com.ruanjian.springcloud.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 类 名 称：User
 * 类 描 述：TODO
 * 创建时间：2020-03-09 14:17
 * 创 建 人：renhao
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    /**
     * id
     */
    private Long id;

    /**
     * name
     */
    private String name;

    /**
     * address
     */
    private String address;

    /**
     * age
     */
    private Integer age;

    /**
     * 生日
     */
    private Date birthday;
}