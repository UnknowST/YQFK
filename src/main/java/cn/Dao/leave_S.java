package cn.Dao;

import java.io.Serializable;


/**
 * 离校申请实体类
 */
public class leave_S implements Serializable {
    /**
     * 对应信息
     * 表单号
     * 用户账号
     * 外出目的
     * 所属学院
     * 辅导员姓名
     * 辅导员工号
     * 辅导员意见
     * 副书记意见
     * 书记意见
     * 离校时间
     * 申请时间
     */
    String formid,uid,reason,couns,D_secr,secr,dept,tname,tid;
    String l_time,r_time,a_time;
    /**
     * 无参构造函数
     */
    public leave_S(){}



    /**
     * 有参构造函数
     * @param formid
     * @param uid
     * @param reason
     * @param couns
     * @param dept
     * @param tname
     * @param tid
     * @param D_secr
     * @param secr
     * @param l_time
     * @param r_time
     * @param a_time
     */
    public leave_S(String formid, String uid, String reason, String couns, String D_secr, String secr,
                   String dept, String tname, String tid, String l_time, String r_time, String a_time) {
        this.formid = formid;
        this.uid = uid;
        this.reason = reason;
        this.couns = couns;
        this.D_secr = D_secr;
        this.secr = secr;
        this.dept = dept;
        this.tname = tname;
        this.tid = tid;
        this.l_time = l_time;
        this.r_time = r_time;
        this.a_time = a_time;
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

    public String getCouns() {
        return couns;
    }

    public void setCouns(String couns) {
        this.couns = couns;
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

    public String getL_time() {
        return l_time;
    }

    public void setL_time(String l_time) {
        this.l_time = l_time;
    }

    public String getR_time() {
        return r_time;
    }

    public void setR_time(String r_time) {
        this.r_time = r_time;
    }

    public String getA_time() {
        return a_time;
    }

    public void setA_time(String a_time) {
        this.a_time = a_time;
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
