package cn.daomain;

import cn.Dao.*;

import java.util.List;

public interface FillDao {
    /**
     * 插入健康申报表
     * @param he
     * @return
     */
    public int h_insert(Health he);

    /**
     * 插入入校申请表
     * @param es
     * @return
     */

    public int e_insert(E_shcool es);

    /**
     * 插入离校申请表
     * @param ls
     * @return
     */

    public int l_insert(leave_S ls);

    /**
     * 根据学号查找所有填报的入校申请
     * @param id
     * @return
     */
    public List<E_shcool> e_findall(String id);

    /**
     * 根据学号查找所有填报的离校申请
     * @param id
     * @return
     */
    public List<leave_S> l_findall(String id);



    /**
     * 查看某一个人的健康申报信息
     * @param id
     * @return
     */
    public List<Health> h_findall(String id);

    /**
     * 查看所有人的入校申请
     * @return
     */
    public List<E_shcool> E_findall();

    /**
     * 查看所有人的离校申请
     * @return
     */
    public List<leave_S> L_findall();

    /**
     * 插入处罚记录
     * @param br
     * @return
     */
    public  int insert_br(Breach br);

    /**
     * 查找处罚记录
     * @param sid
     * @param fid
     * @return
     */
    public  List<Breach> br_find(String sid,String fid);

    /**
     * 查找所有的处罚记录
     * @return
     */
    public  List<Breach> br_findall();

    /**
     * 查看消毒记录
     * @return
     */
    public List<Disinfect> dis_findall();

    /**
     * 查找消毒记录
     * @param hid
     * @return
     */
    public List<Disinfect> dis_find(String hid) ;

    /**
     * 插入消毒记录
     * @param dis
     * @return
     */

    public int inster_dis(Disinfect dis);

    /**
     * 插入每日温度
     * @param hd
     * @return
     */
    public int inster_hday(Health_day hd,int n);

    /**
     * 查看防疫物资申请记录
     * @return
     */

    public List<G_Fa> g_findall();

    /**
     * 查找防疫物资申请记录
     * @param id

     * @return
     */
    public List<G_Fa> g_find(String id);

    /**
     * 物资添加
     * @param gd
     * @return
     */
    public int insert_gd (Good gd);


    /**
     * 物资发放登记
     * @param fa
     * @return
     */
    int  f_insert(G_Fa fa);

    List<Good> good_findall();

    List<Address> address_findall();
}
