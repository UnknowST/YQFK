package cn.Dao;

import java.io.Serializable;


/**
 * 健康申报信息实体类
 */
public class Health implements Serializable {
    /**
     * 对应信息
     * 表单号
     * 申报人账号
     * 所在地
     * 电话
     * 14天所在地
     * 温度
     * 申报时间
     */
    String formid,uid,location,tel,day_14;
    float temp;
    String  re_time;
    /**
     * 无参构造函数
     */
    public Health(){}
    /**
     * 有参构造函数
     * @param formid
     * @param uid
     * @param location
     * @param tel
     * @param day_14
     * @param temp
     * @param re_time
     */
    public Health(String formid, String uid, String location, String tel, String day_14, float temp, String re_time) {
        this.formid = formid;
        this.uid = uid;
        this.location = location;
        this.tel = tel;
        this.day_14 = day_14;
        this.temp = temp;
        this.re_time = re_time;
    }

    public String getFormid() {
        return formid;
    }

    public void setFormid(String formid) {
        this.formid = formid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDay_14() {
        return day_14;
    }

    public void setDay_14(String day_14) {
        this.day_14 = day_14;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public String getRe_time() {
        return re_time;
    }

    public void setRe_time(String re_time) {
        this.re_time = re_time;
    }
}
