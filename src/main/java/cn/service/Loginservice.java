package cn.service;

import cn.Dao.Fangkong;
import cn.Dao.Houqin;
import cn.Dao.Student;
import cn.Dao.Teacher;

import javax.xml.stream.FactoryConfigurationError;

public interface Loginservice {

    Student login(Student st);
    Teacher login(Teacher te);
    Houqin  login(Houqin hq);
    Fangkong login(Fangkong fk);
}
