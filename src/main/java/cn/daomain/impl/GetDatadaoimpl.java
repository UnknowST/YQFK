package cn.daomain.impl;

import cn.Dao.*;
import cn.daomain.GetDataDao;
import cn.service.GetData;
import cn.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class GetDatadaoimpl implements GetDataDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource()); //连接池模板
    @Override
    public List<E_shcool> findall_R_C(String tid) {
        String sql="select FORMid formid,Sid uid,REASON reason,dept,tid,tname,PREDICTED_RETURN_TIME e_time,COUNSELLORE " +
                ",DEPUTY_SECRETARY d_secr,SECRETARY secr,APPLY_TIME apply_time from ENTER_APPLY_S where tid=? ORDER BY apply_time desc ";
        return template.query(sql,new BeanPropertyRowMapper<E_shcool>(E_shcool.class),tid);
    }

    @Override
    public List<leave_S> findall_l(String tid) {
        String sql="select FORMid formid,Sid uid,REASON reason,dept,tid,tname,PREDICTED_LEAVE_TIME l_time,PREDICTED_RETURN_TIME r_time,COUNSELLORE  couns" +
                ",DEPUTY_SECRETARY D_secr,SECRETARY secr,APPLY_TIME a_time from LEAVE_APPLY where tid=? ORDER BY apply_time desc ";
        return template.query(sql,new BeanPropertyRowMapper<leave_S>(leave_S.class),tid);
    }

    @Override
    public List<Teacher> fidall_T() {    //无用
        String sql="select Tid id,TNAME name,SEX sex,AGE age,DEPT dept,TITLE title from TEACHER";
         return template.query(sql,new BeanPropertyRowMapper<Teacher>(Teacher.class));
    }

    @Override
    public int update_f(String fromid, String couns) {
        String sql="update ENTER_APPLY_S set COUNSELLORE=? where FORMid=?";
        return template.update(sql,couns,fromid);
    }

    @Override
    public List<E_shcool> findall_R_S( String dept) {

        String sql="select FORMid formid,Sid uid,REASON reason,dept,tid,tname,PREDICTED_RETURN_TIME e_time,COUNSELLORE,DEPUTY_SECRETARY D_secr,SECRETARY secr," +
                "APPLY_TIME apply_time from ENTER_APPLY_S where  dept=?   ";
        System.out.println(sql);
        return template.query(sql,new BeanPropertyRowMapper<E_shcool>(E_shcool.class),dept);
    }

    @Override
    public int update_gf(String g_name, String amount, String formid, String status) {
        String sql=" ",sql1="";
        int n,m;
       if(status.equals("已发放")==true){
           sql="UPDATE GOOD SET TOTAL=TOTAL-? WHERE GOOD_NAME=?";
           n=template.update(sql,amount,g_name);
           sql1="update GOOD_APPLY set status=? where FORMid=?";
           m=template.update(sql1,status,formid);
           if(n+m==2)
           return 1;
           else return 0;

       }else{

           sql1="update GOOD_APPLY set status=? where FORMid=?";
           m=template.update(sql1,status,formid);
           return m;
       }

    }

    @Override
    public int updatel(String formid1, String couns1) {
        String sql="update LEAVE_APPLY set COUNSELLORE='"+couns1+" ' where FORMid='"+formid1+" '";
        return template.update(sql);
    }

    @Override
    public List<Health_extend> findall_He() {

        String sql="SELECT FORMid formid,a.Sid uid,SNAME name,temp,location,14_DAYS_TRACK day_14,REPORT_TIME re_time," +
                "PHONENUMBER tel,dept,major,age,born,at_school_or_not FROM HEALTH_REPORT_S a ,STUDENT b WHERE a.Sid=b.Sid ORDER BY a.REPORT_TIME DESC";
        return template.query(sql,new BeanPropertyRowMapper<Health_extend>(Health_extend.class));
    }

    @Override
    public List<Health_extend> findall_he_t() {
        String sql="SELECT FORMid formid,a.Tid uid,temp,location,14_DAYS_TRACK day_14,REPORT_TIME re_time,TNAME name,PHONENUMBER tel," +
                "dept,age,at_school_or_not,title FROM HEALTH_REPORT_T a ,TEACHER b WHERE a.Tid=b.Tid ORDER BY a.REPORT_TIME DESC";
        return template.query(sql,new BeanPropertyRowMapper<Health_extend>(Health_extend.class));
    }

    @Override
    public List<Health_extend> findall_he_h() {
        String sql="SELECT FORMid formid,a.Hid uid,temp,location,14_DAYS_TRACK day_14,REPORT_TIME re_time,HNAME name,PHONENUMBER tel," +
                "age,at_school_or_not,title FROM HEALTH_REPORT_H a ,HOUQIN b WHERE a.Hid=b.Hid ORDER BY a.REPORT_TIME DESC";
        return template.query(sql,new BeanPropertyRowMapper<Health_extend>(Health_extend.class));
    }

    @Override
    public List<E_shcool> findall_R_t(String dept) {
        String sql="SELECT FORMid formid,Tid uid,REASON reason,dept,PREDICTED_RETURN_TIME e_time,DEPUTY_SECRETARY D_secr,SECRETARY secr," +
                " APPLY_TIME apply_time FROM ENTER_APPLY_T WHERE  dept=? ";
        System.out.println(sql);
        return template.query(sql,new BeanPropertyRowMapper<E_shcool>(E_shcool.class),dept);
    }

    @Override
    public int update_R_d(String formid, String couns) {
        String sql="update ENTER_APPLY_S set DEPUTY_SECRETARY=? where FORMid=?";
        return template.update(sql,couns,formid);
    }

    @Override
    public List<leave_S> findall_l_d(String dept) {
        String sql="select FORMid formid,Sid uid,REASON reason,dept,tid,tname,PREDICTED_LEAVE_TIME l_time,PREDICTED_RETURN_TIME r_time,COUNSELLORE  couns" +
                ",DEPUTY_SECRETARY D_secr,SECRETARY secr,APPLY_TIME a_time from LEAVE_APPLY where dept=? ORDER BY apply_time desc ";
        return template.query(sql,new BeanPropertyRowMapper<leave_S>(leave_S.class),dept);
    }

    @Override
    public int update_l_d(String formid, String couns) {
        String sql="update LEAVE_APPLY set DEPUTY_SECRETARY=? where FORMid=?";
        return template.update(sql,couns,formid);
    }

    @Override
    public int update_r_ds(String formid, String couns) {
        String sql="update ENTER_APPLY_T set DEPUTY_SECRETARY=? where FORMid=?";
        return template.update(sql,couns,formid);
    }

    @Override
    public int update_r(String formid, String couns) {
        String sql="update ENTER_APPLY_S set SECRETARY=? where FORMid=?";
        return template.update(sql,couns,formid);
    }

    @Override
    public int update_l_s(String formid, String couns) {
        String sql="update LEAVE_APPLY set SECRETARY=? where FORMid=?";
        return template.update(sql,couns,formid);
    }

    @Override
    public int update_r_t(String formid, String couns) {
        String sql="update ENTER_APPLY_T set SECRETARY=? where FORMid=?";
        return template.update(sql,couns,formid);
    }
}
