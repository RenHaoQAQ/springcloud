package com.ruanjian.springcloud.utils;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.UUID;
import cn.hutool.http.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 类 名 称：ImgDownLoad
 * 类 描 述：TODO
 * 创建时间：2020-03-10 13:48
 * 创 建 人：renhao
 */
@Configuration
public class ImgDownLoad {
    public static String UPLOADImgPath;

    //注入
    @Autowired(required = false)
    public void setUPLOADED_FOLDER(@Value("${cbs.uploadImgPath}") String UPLOADImgPath) {
        ImgDownLoad.UPLOADImgPath = UPLOADImgPath;
    }

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
