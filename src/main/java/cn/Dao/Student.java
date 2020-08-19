package cn.Dao;

import java.io.Serializable;

/**
 * 学生实体类
 */
public class Student implements Serializable {
    //分别对应学生 学号，姓名，性别，年龄，学院，专业，所在地，是否在学校，密码信息
    private String id, name, sex, age, dept, major, born, Y_school, password;

    /**
     * 无参构造函数
     */
    public Student() {
    }
    /**
     * 有参构造函数
     * @param id
     * @param name
     * @param sex
     * @param age
     * @param dept
     * @param major
     * @param born
     * @param Y_school
     * @param password
     */
    public Student(String id,String name,String sex,String age,String dept,String major,String born,String Y_school,String password){
        this.id=id;
        this.name=name;
        this.sex=sex;
        this.age=age;
        this.dept=dept;
        this.major=major;
        this.born=born;
        this.Y_school=Y_school;
        this.password=password;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAge() {
        return age;
    }

    public String getBorn() {
        return born;
    }

    public String getDept() {
        return dept;
    }

    public String getMajor() {
        return major;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getSex() {
        return sex;
    }

    public String getY_school() {
        return Y_school;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setBorn(String born) {
        this.born = born;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setY_school(String y_school) {
        Y_school = y_school;
    }

}
