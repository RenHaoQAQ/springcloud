package com.ruanjian.springcloud.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 类 名 称：Video
 * 类 描 述：TODO
 * 创建时间：2020-03-10 13:43
 * 创 建 人：renhao
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Video {
    private Integer id;

    /**
     * 图片在本地地址
     */
    private String imgPath;

    /**
     * 图片网络地址
     */
    private String imgUrl;

    /**
     * 视频本地地址
     */
    private String videoPath;

    /**
     * 视屏网络地址
     */
    private String videoUrl;

    /**
     * 视屏标题
     */
    private String videoTitle;

    /**
     * 爬取时间
     */
    private Date createDate;

    /**
     * m3u8地址
     */
    private String m3u8Url;
}