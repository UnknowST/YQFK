package cn.Dao;

import java.io.Serializable;


/**
 * 物资发放信息等级类
 */
public class G_Fa implements Serializable {
    /**
     * 对应信息
     * 编号
     * 领取人账号
     * 物资名称
     * 领取时间
     * 领取数量
     * 审核状态
     */
    String formid,uid,g_name,status;
    Integer amount;

    String time;
    /**
     * 无参构造函数
     */
    public G_Fa(){}



    /**
     * 有参构造函数
     * @param formid
     * @param uid
     * @param g_name
     * @param amount
     * @param time
     * @param status
     */
    public G_Fa(String formid, String uid, String g_name, String status, Integer amount, String time) {
        this.formid = formid;
        this.uid = uid;
        this.g_name = g_name;
        this.status = status;
        this.amount = amount;
        this.time = time;
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

    public String getG_name() {
        return g_name;
    }

    public void setG_name(String g_name) {
        this.g_name = g_name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
