package com.sxk.wxpusher.pojo;

import javax.persistence.*;

@Entity
public class WxUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //设置主键自增默认由程序控制，identity 主键由数据库生成
    private long id;
    @Column
    private String name;
    @Column
    private String oppenid;

    public WxUser() {
    }

    public WxUser(long id, String name, String oppenid) {
        this.id = id;
        this.name = name;
        this.oppenid = oppenid;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOppenid() {
        return oppenid;
    }

    public void setOppenid(String oppenid) {
        this.oppenid = oppenid;
    }

    @Override
    public String toString() {
        return "WxUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", oppenid='" + oppenid + '\'' +
                '}';
    }
}
