package com.ruanjian.springcloud.utils;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.UUID;
import cn.hutool.http.HttpUtil;

/**
 * 类 名 称：ImgDownLoad
 * 类 描 述：TODO
 * 创建时间：2020-03-10 13:48
 * 创 建 人：renhao
 */
public class ImgDownLoad {
    /**
     * 下载图片
     * 返回图片本地地址
     */
    public static String down(String url) {
        StringBuilder path = new StringBuilder();
        path.append("/Users/renhao/Downloads/xuechengzaixian/img/");
        path.append(DateUtil.today() + "/");
        path.append(UUID.fastUUID() + ".jpg");
        HttpUtil.downloadFile(url, FileUtil.file(path.toString()));
        return path.toString();
    }

}
