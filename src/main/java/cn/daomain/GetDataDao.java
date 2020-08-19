package cn.daomain;

import cn.Dao.*;

import java.util.List;

public interface GetDataDao {

    /**
     * 找辅导员待审核的返校申请
     * @param tid
     * @return
     */
    public List<E_shcool> findall_R_C(String tid);

    /**
     * 找辅导员审核的返校申请
     * @param tid
     * @return
     */
    public List<leave_S> findall_l(String tid);

    /**
     * 找教师职称信息
     */
    public List<Teacher> fidall_T();

    /**
     * 辅导员更新进校申请记录
     * @param fromid
     * @param couns
     * @return
     */
   public int update_f(String fromid,String couns);
    /**
     * 查询待副书记审核得学生返校申请
     * @param dept
     * @return
     */
    public List<E_shcool> findall_R_S(String dept);

    /**
     * 跟新物资申请记录状态
     * @param g_name
     * @param amount
     * @param formid
     * @param status
     * @return
     */

    public int update_gf(String g_name,String amount,String formid,String status);

    /**
     * 辅导员更新出校申请状态
     * @param formid1
     * @param counsid1
     * @return
     */
    public int updatel(String formid1,String counsid1);

    /**
     * 查找所有的学生及健康上报信息
     * @return
     */
    public List<Health_extend> findall_He();

    /**
     * 查找所有的教师健康上报信息
     * @return
     */
    public List<Health_extend> findall_he_t();

    /**
     * 查找所有的后勤人员健康上报信息
     * @return
     */
    public List<Health_extend> findall_he_h();

    /**
     * 查询教师返校申请记录
     * @return
     */
    public List<E_shcool> findall_R_t(String dept);

    /**
     * 副书记更新学生进校申请状态
     * @param formid
     * @param couns
     * @return
     */
    public int update_R_d(String formid,String couns);

    /**
     * 根据学院信息查询学生离校申请
     * @param dept
     * @return
     */
    public List<leave_S> findall_l_d(String dept);

    /**
     * 副书记更新学生离校申请状态
     * @param formid
     * @param couns
     * @return
     */
    public int update_l_d(String formid, String couns);

    /**
     * 副书记更新老师进校申请意见
     * @param formid
     * @param couns
     * @return
     */
    public int update_r_ds(String formid,String couns);
    /**
     * 书记更新学生进校申请状态
     * @param formid
     * @param couns
     * @return
     */
    public int update_r(String formid,String couns);

    /**
     * 书记更新学生离校申请状态
     * @param formid
     * @param couns
     * @return
     */
    public int update_l_s(String formid,String couns);

    /**
     * 书记审核老师返校申请意见
     * @param formid
     * @param couns
     * @return
     */
    public int update_r_t(String formid,String couns);
}
