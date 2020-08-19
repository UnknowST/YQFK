package cn.Dao;

import java.io.Serializable;
import java.util.Date;

/**
 * 进校申请表
 */
public class E_shcool implements Serializable {
    /**
     * 对应信息
     * 表单号
     * 提交人账号
     * 入校原因
     * 辅导员意见
     * 副书记意见
     * 书记意见
     * 入校时间
     * 申请时间
     */
    String formid,uid,reason,counsellore,D_secr,secr;
    String e_time,apply_time,dept,tname,tid;

    /**
     * 无参构造函数
     */
    public E_shcool(){}



    /**
     * 有参构造函数
     * @param formid
     * @param uid
     * @param reason
     * @param counsellore
     * @param d_secr
     * @param secr
     * @param e_time
     * @param apply_time
     * @param dept
     * @param tname
     * @param tid
     */

    public E_shcool(String formid, String uid, String reason, String counsellore, String d_secr, String secr, String e_time,
                    String apply_time, String dept, String tname, String tid) {
        this.formid = formid;
        this.uid = uid;
        this.reason = reason;
        this.counsellore = counsellore;
        D_secr = d_secr;
        this.secr = secr;
        this.e_time = e_time;
        this.apply_time = apply_time;
        this.dept = dept;
        this.tname = tname;
        this.tid = tid;
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getCounsellore() {
        return counsellore;
    }

    public void setCounsellore(String counsellore) {
        this.counsellore = counsellore;
    }

    public String getD_secr() {
        return D_secr;
    }

    public void setD_secr(String d_secr) {
        D_secr = d_secr;
    }

    public String getSecr() {
        return secr;
    }

    public void setSecr(String secr) {
        this.secr = secr;
    }

    public String getE_time() {
        return e_time;
    }

    public void setE_time(String e_time) {
        this.e_time = e_time;
    }

    public String getApply_time() {
        return apply_time;
    }

    public void setApply_time(String apply_time) {
        this.apply_time = apply_time;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }
}
