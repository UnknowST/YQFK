package cn.service;

import cn.Dao.*;

import java.security.PublicKey;
import java.util.List;

public interface FIllservice {
    /**
     * 教师，学生基本功能
     * @param he
     * @return
     */
    public int insert_hearth(Health he);
    public int insert_e_school(E_shcool ws);
    public int insert_l_school(leave_S ls);
    public List<E_shcool>  e_findall(String id);
    public List<leave_S> l_findall(String id);
 /*   public List<E_shcool> E_findall();
    public */
    public int  f_inster(G_Fa fa);


    /**
     * 防控组基本功能
     */
    public  int insert_br(Breach br);
    public  List<Breach> br_find(String sid,String fid);
    public  List<Breach> br_findall();
    public List<Disinfect> dis_findall();
    public List<G_Fa> g_findall();
    public List<G_Fa> g_find(String id);
    public int insert_gd (Good gd);


    /**
     * 后勤人员基本功能
     * @param dis
     * @return
     */

    public int inster_dis(Disinfect dis);
    public int inster_hday(Health_day hd,int n);
    public List<Disinfect> dis_find(String hid) ;

    public List<Good> good_findall();

    public List<Address> address_findall();






}
