package com.sxk.wxpusher.scheduled;

import com.alibaba.fastjson.JSON;
import com.sxk.wxpusher.WxpusherApplication;
import com.sxk.wxpusher.dao.WxUserDao;
import com.sxk.wxpusher.pojo.WxUser;
import com.zjiecode.wxpusher.client.WxPusher;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class ScheduledService {
    private static Logger logger = LoggerFactory.getLogger(WxpusherApplication.class);
    @Resource(name = "wxUserDao")
    private WxUserDao WxUserdao;

    @Scheduled(cron = "0 0/6 20-21 ? * 1,2,3,4,5")
    public void sendMessage() {
        logger.info("当前时间：" + new Date().toString() + "开始执行定时任务");
        List<String> oppenids = new ArrayList<>();
        List<String> userName = new ArrayList<>();
        userName.add("null");
        OkHttpClient client = new OkHttpClient();
        FormBody body = new FormBody.Builder().add("stoptype", "0").add("stopid", "9.").add("sid", "e69ffe783e99801d84b89d5c886182bf").build();
        Request request = new Request.Builder()
                .url("https://shanghaicity.openservice.kankanews.com/public/bus/Getstop")
                .post(body)
                .addHeader("content-type", "multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW")
                .addHeader("Cookie", "aliyungf_tc=AQAAAFp6j3/feAQA6mRzG5cQeWrtbfMK; acw_tc=707c9fd315676045885515229e22ad7c04b0ccdb30cfd4fd89261a5de77185; _ga=GA1.2.647946584.1567604588; souid=eSgsNF1zR4SaVQdEZST4Ag==; Hm_p1vt_6f69830ae7173059e935b61372431b35=eSgsNF1zR5ma6AdFZz1xAg==; last_search_records=eyJpdiI6InRCRFdVemp1cmRaWjd5V2N6TnNsWEE9PSIsInZhbHVlIjoiMXpLMHFsNHRqSHIzckRwV1NGOHlYTGNPYVJXM1d1Q2M2dVJpZ1VmS0lpRT0iLCJtYWMiOiJjNGEwYmFkODY1OWQ2ODUwODgyZWQzNDU3YWQwZTgyNWViYjE1ZmMwNTNjMjJkOGVhN2Y5MjRhM2FjYmMyYjEzIn0%3D; _gat=1; XSRF-TOKEN=eyJpdiI6ImRUQ05USndlTkRwdGNuZTlFQWRYUUE9PSIsInZhbHVlIjoiT3JQaFJNK05NYzNlemVsTnNjYmFyenp0RGNYZlJsMHlGeE5YY3hFQ3JVTnFsY3dZTkRBVnB4bkxvaG5zOG4zcGIwUnNwemtuVkJxTWsxb2lBRUk1OUE9PSIsIm1hYyI6ImRkZTlmMTBkNGZhMjAxMmY1Y2RmNTg0NTY3ODQzYWJjOWU1NDc1MmRmN2YxZGI0MTA4MWI2ZTBlNTIxOWI3NTcifQ%3D%3D; _session=eyJpdiI6Ik1OMkFEdXJDSERpSUZpRGxiRjNMVHc9PSIsInZhbHVlIjoiRkUzT1psZXd1N0cyMDFMT2wyQXk4Z0hZT2daczZhRmtmZDJ2WGFpOGJvQ21HOFh6ZFUzdzBRd2RMTG9ETVdkRHFWZXFnT1pwbWROXC9UaGFBZzZCVU9nPT0iLCJtYWMiOiJiYzI4Nzg3ZmVlNGRiZTQxMGIxOTNiNDkxYWIwZTY5YTg5YzAyYzVjMmIzZGM5ZTMzOTFlNDY3NzYxODQ1M2MyIn0%3D; SERVERID=4f5f69a3e569b9cd359e6a82e64e12fb|1567838013|1567837782,aliyungf_tc=AQAAAFp6j3/feAQA6mRzG5cQeWrtbfMK; acw_tc=707c9fd315676045885515229e22ad7c04b0ccdb30cfd4fd89261a5de77185; _ga=GA1.2.647946584.1567604588; souid=eSgsNF1zR4SaVQdEZST4Ag==; Hm_p1vt_6f69830ae7173059e935b61372431b35=eSgsNF1zR5ma6AdFZz1xAg==; last_search_records=eyJpdiI6InRCRFdVemp1cmRaWjd5V2N6TnNsWEE9PSIsInZhbHVlIjoiMXpLMHFsNHRqSHIzckRwV1NGOHlYTGNPYVJXM1d1Q2M2dVJpZ1VmS0lpRT0iLCJtYWMiOiJjNGEwYmFkODY1OWQ2ODUwODgyZWQzNDU3YWQwZTgyNWViYjE1ZmMwNTNjMjJkOGVhN2Y5MjRhM2FjYmMyYjEzIn0%3D; _gat=1; XSRF-TOKEN=eyJpdiI6ImRUQ05USndlTkRwdGNuZTlFQWRYUUE9PSIsInZhbHVlIjoiT3JQaFJNK05NYzNlemVsTnNjYmFyenp0RGNYZlJsMHlGeE5YY3hFQ3JVTnFsY3dZTkRBVnB4bkxvaG5zOG4zcGIwUnNwemtuVkJxTWsxb2lBRUk1OUE9PSIsIm1hYyI6ImRkZTlmMTBkNGZhMjAxMmY1Y2RmNTg0NTY3ODQzYWJjOWU1NDc1MmRmN2YxZGI0MTA4MWI2ZTBlNTIxOWI3NTcifQ%3D%3D; _session=eyJpdiI6Ik1OMkFEdXJDSERpSUZpRGxiRjNMVHc9PSIsInZhbHVlIjoiRkUzT1psZXd1N0cyMDFMT2wyQXk4Z0hZT2daczZhRmtmZDJ2WGFpOGJvQ21HOFh6ZFUzdzBRd2RMTG9ETVdkRHFWZXFnT1pwbWROXC9UaGFBZzZCVU9nPT0iLCJtYWMiOiJiYzI4Nzg3ZmVlNGRiZTQxMGIxOTNiNDkxYWIwZTY5YTg5YzAyYzVjMmIzZGM5ZTMzOTFlNDY3NzYxODQ1M2MyIn0%3D; SERVERID=4f5f69a3e569b9cd359e6a82e64e12fb|1567838013|1567837782; SERVERID=4f5f69a3e569b9cd359e6a82e64e12fb|1567949805|1567949805")
                .addHeader("User-Agent", "Mozilla/5.0 (Linux; Android 9; SM-G9730 Build/PPR1.180610.011; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/67.0.3396.87 XWEB/986 MMWEBSDK/190506 Mobile Safari/537.36 MMWEBID/238 MicroMessenger/7.0.6.1460(0x27000634) Process/tools NetType/WIFI Language/zh_CN")
                .addHeader("Accept", "*/*")
                .addHeader("Host", "shanghaicity.openservice.kankanews.com")
                .addHeader("Content-Type", "multipart/form-data; boundary=--------------------------106459198467121470271063")
                .addHeader("Accept-Encoding", "gzip, deflate")
                .addHeader("Content-Length", "405")
                .addHeader("Connection", "keep-alive")
                .build();
        try {
            for (WxUser wxUser : WxUserdao.findAll()) {
                oppenids.add(wxUser.getOppenid());
                userName.add(wxUser.getName());
            }
        } catch (Exception e) {
            logger.error("找不到相关用户，请查看数据库");
        }
        try {
            Response response = client.newCall(request).execute();
            String str = JSON.parse(new String(response.body().bytes())).toString();
            String time = str.split(",")[3].split(":")[1];
            int total_seconds = Integer.parseInt(time.replaceAll("\"", ""));
            logger.info(total_seconds / 60 + "分" + total_seconds % 60 + "秒车辆进站");
            WxPusher.post("标题", total_seconds / 60 + "分" + total_seconds % 60 + "秒", "", oppenids);
            logger.info(new Date().toString() + "发送消息给" + userName.toString());
        } catch (Exception e) {
            logger.error("当前时间：" + new Date().toString() + "发送消息失败,再次尝试");
            try {
                Response response = client.newCall(request).execute();
                String str = JSON.parse(new String(response.body().bytes())).toString();
                String time = str.split(",")[3].split(":")[1];
                int total_seconds = Integer.parseInt(time.replaceAll("\"", ""));
                logger.info(total_seconds / 60 + "分" + total_seconds % 60 + "秒车辆进站");
                WxPusher.post("标题", total_seconds / 60 + "分" + total_seconds % 60 + "秒", "", oppenids);
                logger.info(new Date().toString() + "发送消息给" + userName.toString());
            } catch (Exception e1) {
                logger.error("当前时间：" + new Date().toString() + "发送消息失败");
            }
        }
    }

    public static void main(String[] args) {
    }
}
