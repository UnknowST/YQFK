package cn.daomain.impl;

import cn.Dao.*;
import cn.daomain.FillDao;
import cn.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class FIllDaoimpl implements FillDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public int h_insert(Health he) {
        System.out.println(ResultInfo.num);
        String sql=null;
        if(ResultInfo.num==1){
            sql = "insert into HEALTH_REPORT_S (Sid,TEMP,LOCATION,14_DAYS_TRACK,PHONENUMBER) values(?,?,?,?,?)";
               }

        if(ResultInfo.num==2){
            sql="insert into HEALTH_REPORT_T(Tid,TEMP,LOCATION,14_DAYS_TRACK,PHONENUMBER) values(?,?,?,?,?)";}

        if(ResultInfo.num==3){
            sql="insert into HEALTH_REPORT_H(Hid,TEMP,LOCATION,14_DAYS_TRACK,PHONENUMBER) values(?,?,?,?,?)";}

        System.out.println(sql);
        return template.update(sql,he.getUid(),he.getTemp(),he.getLocation(),he.getDay_14(),he.getTel());

    }

    @Override
    public int e_insert(E_shcool es) {

        String sql=null;
        if(ResultInfo.num==1){
            sql = "insert into ENTER_APPLY_S (Sid,REASON,dept,tid,tname,PREDICTED_RETURN_TIME) values(?,?,?,?,?,?)";
        return template.update(sql,es.getUid(),es.getReason(),es.getDept(),es.getTid(),es.getTname(),es.getE_time());
        }
         if(ResultInfo.num==2) {
             sql = "insert into ENTER_APPLY_T (Tid,REASON,dept,PREDICTED_RETURN_TIME) values(?,?,?,?)";
             return template.update(sql,es.getUid(),es.getReason(),es.getDept(),es.getE_time());
         }

     /*    if(ResultInfo.num==3)
            sql="insert into ENTER_APPLY_H (Hid,REASON,PREDICTED_RETURN_TIME) values(?,?,?)";*/
       /* System.out.println(sql);*/
        return 0;


    }

    @Override
    public int l_insert(leave_S ls) {
        String sql=null;
           sql = "insert into LEAVE_APPLY (Sid,REASON,PREDICTED_LEAVE_TIME,dept,tname,tid,PREDICTED_RETURN_TIME) values(?,?,?,?,?,?,?)";

       return template.update(sql,ls.getUid(),ls.getReason(),ls.getL_time(),ls.getDept(),ls.getTname(),ls.getTid(),ls.getR_time());

    }

    @Override
    public List<E_shcool> e_findall(String id) {
        String sql=null;
        if(ResultInfo.num==1)
            sql = "SELECT FORMid formid,Sid uid,REASON,PREDICTED_RETURN_TIME e_time,COUNSELLORE,DEPUTY_SECRETARY d_secr,SECRETARY secr,APPLY_TIME from ENTER_APPLY_S where Sid='"+id+" ' ORDER BY APPLY_TIME DESC";
        else if(ResultInfo.num==2)
            sql = "SELECT FORMid formid,Tid uid,REASON,PREDICTED_RETURN_TIME e_time,dept,DEPUTY_SECRETARY d_secr,SECRETARY secr,APPLY_TIME from ENTER_APPLY_T where Tid='"+id+"' ORDER BY APPLY_TIME DESC";
        else if(ResultInfo.num==3)
            sql = "SELECT FORMid formid,Hid uid,REASON,PREDICTED_RETURN_TIME e_time,COUNSELLORE,DEPUTY_SECRETARY d_secr,SECRETARY secr,APPLY_TIME from ENTER_APPLY_H where Hid='"+id+"' ORDER BY APPLY_TIME DESC";
        System.out.println(sql);
        return template.query(sql,new BeanPropertyRowMapper<E_shcool>(E_shcool.class));
    }

    @Override
    public List<leave_S> l_findall(String id) {
        String sql=null;
        sql = "SELECT FORMid formid,Sid uid,REASON reason,PREDICTED_LEAVE_TIME l_time,PREDICTED_RETURN_TIME r_time,COUNSELLORE couns,DEPUTY_SECRETARY D_secr,SECRETARY secr,APPLY_TIME a_time from LEAVE_APPLY where Sid=? ORDER BY APPLY_TIME DESC";
        return template.query(sql,new BeanPropertyRowMapper<leave_S>(leave_S.class),id);
    }

    @Override
    public List<Health> h_findall(String id) {
        return null;
    }

    @Override
    public List<E_shcool> E_findall() {
        return null;
    }

    @Override
    public List<leave_S> L_findall() {
        return null;
    }


    @Override
    public int insert_br(Breach br) {
        String sql="insert into BREAK_SITUATION (Sid,Fid,TYPE,PUNISH) values(?,?,?,?) ";
        return template.update(sql,br.getSid(),br.getFid(),br.getType(),br.getPunish());
    }

    @Override
    public List<Breach> br_find(String sid, String fid) {
        String sql="";
        if(sid.equals("")==true){
            sql="";
            return template.query(sql,new BeanPropertyRowMapper<Breach>(Breach.class),fid);
        }
        if(sid.equals("")!=true)
        {
            sql="";
            return template.query(sql,new BeanPropertyRowMapper<Breach>(Breach.class),sid);}
        if(sid.equals("")!=true&&fid.equals("")!=true){
            sql="";
            return template.query(sql,new BeanPropertyRowMapper<Breach>(Breach.class),sid,fid);

        }
        return null;
    }

    @Override
    public List<Breach> br_findall() {
        String sql="select Sid sid,Fid,fid,TYPE type,PUNISH punish,TIME date from BREAK_SITUATION";
        return template.query(sql,new BeanPropertyRowMapper<Breach>(Breach.class));
    }

    @Override
    public List<Disinfect> dis_findall() {
        String sql="select FORMid formid,ROOMid room,BLOCKid block,Hid hid,Time time from STERILIZE_CONDITION";
        return template.query(sql,new BeanPropertyRowMapper<Disinfect>(Disinfect.class));
    }

    @Override
    public List<Disinfect> dis_find(String hid) {
        String sql="";
        return template.query(sql,new BeanPropertyRowMapper<Disinfect>(Disinfect.class),hid);
    }

    @Override
    public int inster_dis(Disinfect dis) {
        String sql=null;
        sql = "insert into STERILIZE_CONDITION  (ROOMid,BLOCKid,Hid,TIME) values(?,?,?,?)";

        return template.update(sql,dis.getRoom(),dis.getBlock(),dis.getHid(),dis.getTime());
    }

    @Override
    public int inster_hday(Health_day hd,int n) {
        String sql=null;
        if(n==1){
            sql="insert into TEMP_MEASURE_S (Sid,Hid,TEMP) values (?,?,?)";
        }
        if(n==2)
            sql="insert into TEMP_MEASURE_T (Tid,Hid,TEMP) values (?,?,?)";

        return  template.update(sql,hd.getUid(),hd.getHid(),hd.getTemp());

    }

    @Override
    public List<G_Fa> g_findall() {
        String sql="select FORMid formid,Tid uid,GOOD_NAME g_name,TIME time,AMOUNT amount,status from GOOD_APPLY ";
        return template.query(sql,new BeanPropertyRowMapper<G_Fa>(G_Fa.class));
    }

    @Override
    public List<G_Fa> g_find(String id) {

        String sql="select FORMid formid,Tid uid,GOOD_NAME g_name,TIME time,AMOUNT amount,status from GOOD_APPLY where Tid=?";
        return template.query(sql,new BeanPropertyRowMapper<G_Fa>(G_Fa.class),id);
    }

    @Override
    public int insert_gd(Good gd) {
        return 0;
    }


    /**
     * 插入防疫物资申请记录
     * @param fa
     * @return
     */
    @Override
    public int  f_insert(G_Fa fa) {
        String sql="insert into GOOD_APPLY(Tid,GOOD_NAME,AMOUNT) values(?,?,?)";
        return template.update(sql,fa.getUid(),fa.getG_name(),fa.getAmount());
    }

    @Override
    public List<Good> good_findall() {
        String sql="select GOOD_NAME g_name,TOTAL total from GOOD";
        return template.query(sql,new BeanPropertyRowMapper<Good>(Good.class));
    }

    @Override
    public List<Address> address_findall() {
        String sql="select ROOMid room,BLOCKid block from ADDRESS";
        return template.query(sql,new BeanPropertyRowMapper<Address>(Address.class));
    }


}
