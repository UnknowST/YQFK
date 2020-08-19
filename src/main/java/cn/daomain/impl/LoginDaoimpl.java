package cn.daomain.impl;

import cn.Dao.Fangkong;
import cn.Dao.Houqin;
import cn.Dao.Student;
import cn.Dao.Teacher;
import cn.daomain.LoginDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import cn.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
public class LoginDaoimpl implements LoginDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource()); //连接池模板
    /**
     * 根据账号和密码进行学生登录检查
     * @param id
     * @param password
     * @return
     */
    @Override
    public Student checkstudent(String id, String password) {

        Student Student = null;
        try {
            //1.定义sql
            String sql = "select Sid id,SNAME name,SEX sex,AGE age,DEPT dept,MAJOR major,BORN born,AT_SCHOOL_OR_NOT Y_school,password password from STUDENT where Sid = ? and password = ?";
            //2.执行sql
            Student = template.queryForObject(sql, new BeanPropertyRowMapper<cn.Dao.Student>(cn.Dao.Student.class), id,password);
        } catch (Exception e) {

        }

        return Student;
    }

    /**
     *根据账号和密码进行老师登录检查
     * @param id
     * @param password
     * @return
     */
    
    @Override
    public Teacher checkteacher(String id, String password) {
        Teacher te=null;
        try {
            //1.定义sql
            String sql = "select Tid id,TNAME name,SEX sex,AGE age,DEPT dept,TITLE title,AT_SCHOOL_OR_NOT Y_school,password password  from TEACHER where Tid = ? and password = ?";
            //2.执行sql
            te = template.queryForObject(sql, new BeanPropertyRowMapper<cn.Dao.Teacher>(cn.Dao.Teacher.class), id,password);
        } catch (Exception e) {

        }

        return te;
    }

    /**
     *根据账号和密码进行后勤登录检查
     * @param id
     * @param password
     * @return
     */
    @Override
    public Houqin checkhouqin(String id, String password) {
        Houqin hq=null;
        try {
            //1.定义sql
            String sql = "select Hid id,HNAME name,SEX sex,AGE age,TITLE title,AT_SCHOOL_OR_NOT Y_school,password password from HOUQIN where Hid = ? and password = ?";
            //2.执行sql
            hq= template.queryForObject(sql, new BeanPropertyRowMapper<cn.Dao.Houqin>(cn.Dao.Houqin.class), id,password);
        } catch (Exception e) {

        }

        return hq;
    }

    /**
     *根据账号和密码进行防控组登录检查
     * @param id
     * @param password
     * @return
     */
    @Override
    public Fangkong chengfang(String id, String password) {
        Fangkong fk=null;
        try {
            //1.定义sql
            String sql = "SELECT Fid id,FNAME fname,DEPT dept,TITLE title,PASSWORD PASSWORD FROM FANGKONG_GROUP WHERE Fid =? AND PASSWORD = ?";
            //2.执行sql
            fk= template.queryForObject(sql, new BeanPropertyRowMapper<cn.Dao.Fangkong>(cn.Dao.Fangkong.class), id,password);
        } catch (Exception e) {

        }

        return fk;
    }
}
