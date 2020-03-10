package com.ruanjian.springcloud.utils;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 类 名 称：m3u8Util
 * 类 描 述：TODO
 * 创建时间：2020-03-10 09:22
 * 创 建 人：renhao
 */
@Configuration
public class m3u8Util {
    public static String UPLOADEDVIDEOPATH;

    //注入
    @Autowired(required = false)
    public void setUPLOADED_FOLDER(@Value("${cbs.uploadVideoPath}") String UPLOADEDVIDEOPATH) {
        m3u8Util.UPLOADEDVIDEOPATH = UPLOADEDVIDEOPATH;
    }

    /**
     * ts文件转mp4
     */
    public static StringBuilder tsToMP4(String url) throws IOException {
        String str = HttpUtil.get(url);
        // 索引出现负数，说明在源字符串指定位置之后已经没有 '{' 或者 '}'
        int start = str.indexOf(",", 0);
        String substring = str.substring(start - 2, str.length());
        List<String> result = subStr(substring, ",", "#");
        //最后出现"/"的位置
        int i = url.lastIndexOf("/");
        String prefix = url.substring(0, i + 1);
        //请输入视频地址
        HttpURLConnection con;
        InputStream is;
        BufferedInputStream bs = null;
        StringBuilder path = new StringBuilder();
//        path.append("/Users/renhao/Downloads/xuechengzaixian/video/");
        path.append(UPLOADEDVIDEOPATH);
        path.append(DateUtil.today() + "/");
        //文件名
        String fileName = UUID.fastUUID().toString();
        path.append(fileName + ".ts");

        File file = FileUtil.touch(path.toString());
        FileOutputStream fs = new FileOutputStream(file, true);
        for (int j = 0; j < result.size(); j++) {
            try {
                con = (HttpURLConnection) new URL(prefix + result.get(j)).openConnection();
                con.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.143 Safari/537.36");
                //网络输入流
                is = con.getInputStream();
                //网络流写为文件流
                bs = new BufferedInputStream(is);
                byte[] bytes = new byte[6000000];
                int line;
                while ((line = bs.read(bytes)) != -1) {
                    fs.write(bytes, 0, line);
                    fs.flush();
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                //close
                if (fs == null) {
                    try {
                        fs.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (bs == null) {
                    try {
                        bs.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        //返回下载的地址
        return path;
    }

    /**
     * 截取两个特定字符之间的值组合成为集合
     * origin :需要分割的字符
     * fast :开始的字符
     * last :结束的字符
     */
    public static List<String> subStr(String origin, String fast, String Last) {
        if (origin == null) {
            return null;
        }
        List<String> ret = new ArrayList<String>();
        int ch = 0, start, end;
        while (ch < origin.length()) {

            start = origin.indexOf(fast, ch);
            end = origin.indexOf(Last, ch);
            // substring 内部索引禁止出现负数
            if (start == -1 || end == -1) {
                break;
            }
            String tmp = origin.substring(start + 1, end);
            //保存上一次截取时的索引
            ch = end + 1;
            String tem = StrUtil.removeAll(tmp, "\r\n");
            ret.add(tem);
        }
        return ret;
    }

}
