package cn.service.impl;

import cn.Dao.Fangkong;
import cn.Dao.Houqin;
import cn.Dao.Student;
import cn.Dao.Teacher;
import cn.daomain.LoginDao;
import cn.daomain.impl.LoginDaoimpl;
import cn.service.Loginservice;

public class Loginserviceimpl implements Loginservice {

    private LoginDao logindao=new LoginDaoimpl();

    /**
     * 学生登录检查
     * @param st
     * @return
     */
    @Override
    public Student login(Student st) {
        return logindao.checkstudent(st.getId(),st.getPassword());
    }

    /**
     * 教师登录检查
     * @param te
     * @return
     */
    @Override
    public Teacher login(Teacher te) {
        return logindao.checkteacher(te.getId(),te.getPassword());
    }

    /**
     * 后勤登录检查
     * @param hq
     * @return
     */
    @Override
    public Houqin login(Houqin hq) {
        return logindao.checkhouqin(hq.getId(),hq.getPassword());
    }

    /**
     * 防控组成员登录检查
     * @param fk
     * @return
     */
    @Override
    public Fangkong login(Fangkong fk) {
        return logindao.chengfang(fk.getId(),fk.getPassword());
    }
}
