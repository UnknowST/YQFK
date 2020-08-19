package cn.Dao;

import java.io.Serializable;

/**
 * 防控组实体类
 */
public class Fangkong implements Serializable {
    /**
     * 对应信息
     * 编号
     * 姓名
     * 所属学院
     * 职位
     * 密码
     */
    String id,fanme,dept,title,password;
    /**
     * 无参构造函数
     */
    public Fangkong(){}
    /**
     * 有参构造函数
     * @param id
     * @param fname
     * @param dept
     * @param title
     * @param password
     */
    public Fangkong(String id, String fname, String dept, String title, String password) {
        this.id = id;
        this.fanme = fname;
        this.dept = dept;
        this.title = title;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFname() {
        return fanme;
    }

    public void setFanme(String fname) {
        this.fanme = fanme;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
