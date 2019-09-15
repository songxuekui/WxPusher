package com.sxk.wxpusher;

import com.sxk.wxpusher.dao.WxUserDao;
import com.sxk.wxpusher.pojo.WxUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WxpusherApplicationTests {


    @Autowired
    private WxUserDao dao;

    @Test
    public void contextLoads() {
//        WxUser pojo=new WxUser();
//        pojo.setName("sxk");
//        pojo.setOppenid("orPQ803epDzOEyVGs1-ngRbSbM5oQLBAP_EMtb");
//        dao.save(pojo);
        for (WxUser wxUser : dao.findAll()) {
            System.out.println(wxUser.getOppenid());
        }
        ;
    }

}
