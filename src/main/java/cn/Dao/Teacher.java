package cn.Dao;

import java.io.Serializable;

/**
 * 教师实体类
 */
public class Teacher implements Serializable {
    //对应教师工号，姓名，性别，年龄，学院，职称，是否在校，密码信息
    private  String id,name,sex,age,dept,title,Y_school,password;
    /**
     * 无参构造函数
     */
    public Teacher(){}
    /**
     * 有参构造函数
     * @param id
     * @param name
     * @param sex
     * @param age
     * @param dept
     * @param title
     * @param Y_school
     * @param password
     */
    public Teacher(String id,String name,String sex,String age,String dept,String title,String Y_school,String password){
        this.id=id;
        this.name=name;
        this.sex=sex;
        this.age=age;
        this.dept=dept;
        this.title=title;

        this.Y_school=Y_school;
        this.password=password;

    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setY_school(String y_school) {
        Y_school = y_school;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getY_school() {
        return Y_school;
    }

    public String getSex() {
        return sex;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getDept() {
        return dept;
    }

    public String getAge() {
        return age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void seId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
