package cn.Dao;

import java.io.Serializable;

/**
 * 后勤人员实体类
 */
public class Houqin implements Serializable {
    /**
     * 对应信息
     * 账号
     * 姓名
     * 性别
     * 年龄
     * 职务
     * 是否在校
     * 密码
     */
    String id,name,sex,age,title,y_school,password;
    /**
     * 无参构造函数
     */
    public  Houqin(){}
    /**
     * 有参构造函数
     * @param id
     * @param name
     * @param sex
     * @param age
     * @param title
     * @param y_school
     * @param password
     */
    public Houqin(String id, String name, String sex, String age, String title, String y_school, String password) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.title = title;
        y_school = y_school;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getY_school() {
        return y_school;
    }

    public void setY_school(String y_school) {
        y_school = y_school;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
