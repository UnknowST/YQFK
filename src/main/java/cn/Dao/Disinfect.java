package cn.Dao;

import java.io.Serializable;
import java.util.Date;

/**
 * 消毒记录实体类
 */
public class Disinfect implements Serializable {
    /**
     * 对应信息
     * 表单号
     * 教室号
     * 楼号
     * 消毒人员编号
     * 消毒时间
     */
    String formid,room,block,hid,time;

    /**
     * 无参构造函数
     */
    public Disinfect(){}



    /**
     * 有参构造函数
     * @param formid
     * @param room
     * @param block
     * @param hid
     * @param time
     */
    public Disinfect(String formid, String room, String block, String hid, String time) {
        this.formid = formid;
        this.room = room;
        this.block = block;
        this.hid = hid;
        this.time = time;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getHid() {
        return hid;
    }

    public void setHid(String hid) {
        this.hid = hid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getFormid() {
        return formid;
    }

    public void setFormid(String formid) {
        this.formid = formid;
    }
}
