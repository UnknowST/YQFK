package cn.Dao;

import java.io.Serializable;

public class Health_extend implements Serializable {
    /**
     * 健康信息扩展类
     * 把健康上报表跟学生表，教师表，后勤表结合起来
     */

    String formid,uid,name,temp,location,day_14,re_time,dept,major,age,born,at_school_or_not,title,tel;

    /**
     * 无参构造函数
     */
    public Health_extend(){}
    /**
     * 有参构造函数
     */
    public Health_extend(String formid, String uid, String name, String temp, String location, String day_14, String re_time,
                         String dept, String major, String age, String born, String at_school_or_not, String title,String tel) {
        this.formid = formid;
        this.uid = uid;
        this.name = name;
        this.temp = temp;
        this.location = location;
        this.day_14 = day_14;
        this.re_time = re_time;
        this.dept = dept;
        this.major = major;
        this.age = age;
        this.born = born;
        this.at_school_or_not = at_school_or_not;
        this.title = title;
        this.tel=tel;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDay_14() {
        return day_14;
    }

    public void setDay_14(String day_14) {
        this.day_14 = day_14;
    }

    public String getRe_time() {
        return re_time;
    }

    public void setRe_time(String re_time) {
        this.re_time = re_time;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBorn() {
        return born;
    }

    public void setBorn(String born) {
        this.born = born;
    }

    public String getAt_school_or_not() {
        return at_school_or_not;
    }

    public void setAt_school_or_not(String at_school_or_not) {
        this.at_school_or_not = at_school_or_not;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
