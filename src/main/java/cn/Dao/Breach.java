package cn.Dao;

import java.io.Serializable;
import java.util.Date;

/**
 * 违纪信息类
 */
public class Breach implements Serializable {
    //对应学生学号，防控小组人员编号，处罚类型，处罚方式，时间
    String sid,fid,type,punish,date;

    /**
     * 无参构造函数
     */
    public Breach(){}
    /**
     * 有参构造函数
     * @param sid
     * @param fid
     * @param type
     * @param punish
     * @param date
     */
    public Breach(String sid, String fid, String type, String punish, String date) {
        this.sid = sid;
        this.fid = fid;
        this.type = type;
        this.punish = punish;
        this.date = date;
    }

    public String getSid() {
        return sid;
    }

    public String getFid() {
        return fid;
    }

    public String getType() {
        return type;
    }

    public String getPunish() {
        return punish;
    }

    public String getDate() {
        return date;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPunish(String punish) {
        this.punish = punish;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
