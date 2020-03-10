package com.ruanjian.springcloud.controller;

import cn.hutool.http.HttpUtil;
import com.ruanjian.springcloud.entity.Video;
import com.ruanjian.springcloud.service.VideoService;
import com.ruanjian.springcloud.utils.ImgDownLoad;
import com.ruanjian.springcloud.utils.m3u8Util;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * 类 名 称：DownLoadFileController
 * 类 描 述：TODO
 * 创建时间：2020-03-10 18:24
 * 创 建 人：renhao
 */
@RestController
public class DownLoadFileController {
    @Autowired
    private VideoService videoService;

    @GetMapping(value = "/down/{page}")
    public void down(@PathVariable("page") int page) throws IOException {
        for (int j = page; j <= 125; j++) {
            String html = HttpUtil.get("http://www.23bbe.com/mlvideolist.x?tagid=3&page=" + j);
            Document doc = Jsoup.parse(html);
            Elements select = doc.select("ul#content");
//        class222
            Elements href = select.select("a.video-pic.loading");
            ArrayList<Video> hrefs = new ArrayList<Video>();
            for (int i = 0; i < href.size(); i++) {
                Video video = new Video();

                video.setVideoUrl("http://www.23bbe.com" + href.get(i).attr("href"));
                video.setVideoTitle(href.get(i).attr("title"));
                video.setImgUrl(href.get(i).attr("data-original"));
                video.setCreateDate(new Date());
                String videoHtml = HttpUtil.get(video.getVideoUrl());
                Document videoDoc = Jsoup.parse(videoHtml);
                String m3u8 = videoDoc.select("#vpath").html();
                video.setM3u8Url(m3u8);

                //图片写入本地，返回的是图片本地地址
                String imgPath = ImgDownLoad.down(video.getImgUrl());
                video.setImgPath(imgPath);
                //视屏写入本地磁盘返回的是本地存放地址
                StringBuilder videoPath = m3u8Util.tsToMP4(m3u8);
                video.setVideoPath(videoPath.toString());
                hrefs.add(video);
                videoService.insert(video);
                System.out.println("第" + j + "页" + "第" + (i + 1) + "条视屏");
            }
        }

    }
}
