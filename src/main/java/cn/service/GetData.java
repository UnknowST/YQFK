package cn.service;

import cn.Dao.*;

import java.util.List;

public interface GetData {
    /**
     * 查看对应权限的老师待审核的返校申请记录
     * @param tid
     * @return
     */
    public List<E_shcool> findall_R_C(String tid);

    /**
     * 查看对应权限老师已经盛和的离校记录
     * @param id
     * @return
     */

    public List<leave_S> findall_l(String id);

    /**
     * 查找教师职称信息
     * @return
     */

    public List<Teacher> findall_T();

    /**
     * 辅导员更新返校申请信息
     * @param fromid
     * @param couns
     * @return
     */
    public int update_f(String fromid,String couns);

    /**
     * 辅导员更新离校申请记录
     * @param formid
     * @param couns
     * @return
     */
    public int update_l(String formid, String couns);

    /**
     * 查看副书记待审核学生返校申请

     * @param dept
     * @return
     */
    public List<E_shcool> findall_R_S(String dept);

    /**
     * 更新物资申请记录和仓库管理
     * @param g_name
     * @param amount
     * @param formid
     * @param status
     * @return
     */
    public int update_gf(String g_name,String amount,String formid,String status);

    /**
     * 查找所有的学生每日健康上报信息
     * @return
     */
    public List<Health_extend> findall_He();

    /**
     * 查找教师每日健康上报信息
     * @return
     */
    public List<Health_extend> findall_he_t();

    /**
     * 查找后勤每日健康上报信息
     * @return
     */
    public List<Health_extend> findall_he_h();

    /**
     * 查根据学院信息查询教师返校申请；
     * @return
     */
    public List<E_shcool> findall_R_t(String dept);

    /**
     * 副书记跟新学生进校申请状态
     * @param formid
     * @param couns
     * @return
     */
    public int update_r_d(String formid ,String couns);

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
    public int update_l_d(String formid,String couns);

    /**
     * 副书记更新老师进校申请状态
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
