package com.sxk.wxpusher.dao;

import com.sxk.wxpusher.pojo.WxUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WxUserDao extends JpaRepository<WxUser,Long> {
}
