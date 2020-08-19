package cn.daomain;

import cn.Dao.Fangkong;
import cn.Dao.Houqin;
import cn.Dao.Student;
import cn.Dao.Teacher;

public interface LoginDao {
    /**
     * 登录检查学生账号
     * @param id
     * @param password
     * @return
     */
    public Student checkstudent(String id,String password);

    /**
     * 登录检查教师账号
     * @param id
     * @param password
     * @return
     */
    public Teacher checkteacher(String id,String password);

    /**后勤人员账号
     * 登录检查
     * @param id
     * @param password
     * @return
     */
    public Houqin checkhouqin(String id,String password);

    /**
     * 登录检查防控组员
     * @param id
     * @param password
     * @return
     */

    public Fangkong chengfang(String id,String password);




}
