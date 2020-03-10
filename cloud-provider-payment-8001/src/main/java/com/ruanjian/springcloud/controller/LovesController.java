package com.ruanjian.springcloud.controller;

import com.ruanjian.springcloud.entity.Lovers;
import com.ruanjian.springcloud.service.LoversService;
import com.ruanjian.springcloud.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 类 名 称：a
 * 类 描 述：TODO
 * 创建时间：2020-03-07 19:40
 * 创 建 人：renhao
 */
@RestController
public class LovesController {
    @Autowired
    private LoversService loversService;

    @ResponseBody
    @PostMapping(value = "/insert")
    public R insert(@RequestBody Lovers lovers) {
        loversService.insert(lovers);
        return R.ok();
    }

    @GetMapping(value = "/select/{id}")
    public R select(@PathVariable("id") Long id) {
        System.out.println("id ==== " + id);
        Lovers lovers = loversService.selectByPrimaryKey(id);
        return R.ok().put("result", lovers);
    }
}
