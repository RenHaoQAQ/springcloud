package com.ruanjian;

import cn.hutool.http.HttpUtil;
import com.ruanjian.springcloud.PaymentMain8001;
import com.ruanjian.springcloud.dao.LoversDao;
import com.ruanjian.springcloud.entity.Video;
import com.ruanjian.springcloud.service.TbUserService;
import com.ruanjian.springcloud.service.VideoService;
import com.ruanjian.springcloud.utils.ImgDownLoad;
import com.ruanjian.springcloud.utils.m3u8Util;
import org.apache.http.protocol.HTTP;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.*;

/**
 * 类 名 称：PaymentTest
 * 类 描 述：TODO
 * 创建时间：2020-03-09 14:38
 * 创 建 人：renhao
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = PaymentMain8001.class)
public class PaymentTest {
    @Autowired
    private TbUserService tbUserService;
    @Autowired
    private VideoService videoService;

    @Test
    public void test01() throws IOException {
        for (int j = 1; j <= 125; j++) {
            String html = HttpUtil.get("http://www.23bbe.com/mlvideolist.x?tagid=3&page="+j);
            Document doc = Jsoup.parse(html);
            Elements select = doc.select("ul#content");
//        class222
            Elements href = select.select("a.video-pic.loading");
            ArrayList<Video> hrefs = new ArrayList<Video>();
            for (int i = 0; i < href.size(); i++) {
                Video video = new Video();
                video.setVideoUrl("http://www.23bbe.com" + href.attr("href"));
                video.setVideoTitle(href.attr("title"));
                video.setImgUrl(href.attr("data-original"));
                video.setCreateDate(new Date());
                String videoHtml = HttpUtil.get(video.getVideoUrl());
                Document videoDoc = Jsoup.parse(videoHtml);
                String m3u8 = videoDoc.select("#vpath").html();
                video.setM3u8Url(m3u8);
                //视屏写入本地磁盘返回的是本地存放地址
                StringBuilder videoPath = m3u8Util.tsToMP4(m3u8);
                video.setVideoPath(videoPath.toString());
                //图片写入本地，返回的是图片本地地址
                String imgPath = ImgDownLoad.down(video.getImgUrl());
                video.setImgPath(imgPath);
                hrefs.add(video);
                videoService.insert(video);
            }
        }

    }

    @Test
    public void teso02() {
        String down = ImgDownLoad.down("https://fm.ssz91.com/我的视频_pic/国产精选/[00118]好多淫水哦宝贝我高潮喷东西你帮我舔干净对白超淫荡桑拿会所玩小姐碰到个外表清纯超会调情的漂亮妹子.jpg");
        System.out.println("down = " + down);
    }
}
