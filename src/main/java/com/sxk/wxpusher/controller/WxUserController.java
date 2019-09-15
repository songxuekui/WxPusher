package com.sxk.wxpusher.controller;

import com.sxk.wxpusher.dao.WxUserDao;
import com.sxk.wxpusher.pojo.WxUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("user")  //  加/与不加/好像没有区别
public class WxUserController {

    @Resource(name ="wxUserDao" )
    private WxUserDao WxUserdao;

    @RequestMapping("all_user")
    public List<WxUser> all(){
        return WxUserdao.findAll();
    }

    @RequestMapping("/add_user")
    public String create(WxUser user){
        try {
             WxUserdao.save(user);
            return "创建成功";
        }catch(Exception e){
            return "创建失败";
        }
    }
}
