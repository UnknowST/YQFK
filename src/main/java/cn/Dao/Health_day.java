package cn.Dao;

import java.io.Serializable;


/**
 * 在校人员每日体温申报实体类
 */
public class Health_day implements Serializable {
    /**
     * 对应信息
     * 被测温人账号
     * 测温人账号
     * 温度
     * 时间
     */
    String uid,hid;
    float temp;
    String time;
    /**
     * 无参构造函数
     */
    public  Health_day(){}
    /**
     * 有参构造函数
     * @param uid
     * @param hid
     * @param temp
     * @param time
     */
    public Health_day(String uid, String hid, float temp, String time) {
        this.uid = uid;
        this.hid = hid;
        this.temp = temp;
        this.time = time;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getHid() {
        return hid;
    }

    public void setHid(String hid) {
        this.hid = hid;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
