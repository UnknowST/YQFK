package cn.service.impl;

import cn.Dao.*;
import cn.daomain.GetDataDao;
import cn.daomain.impl.GetDatadaoimpl;
import cn.service.GetData;

import java.util.List;

public class GetDataimpl implements GetData {
    GetDataDao dao=new GetDatadaoimpl();
    @Override
    public List<E_shcool> findall_R_C(String tid) {
        return dao.findall_R_C(tid);
    }

    @Override
    public List<leave_S> findall_l(String id) {
        return dao.findall_l(id);
    }

    @Override
    public List<Teacher> findall_T() {
        return dao.fidall_T();
    }

    @Override
    public int update_f(String fromid, String couns) {
        return dao.update_f(fromid,couns);
    }

    @Override
    public int update_l(String formid, String couns) {
        return dao.updatel(formid,couns);
    }

    @Override
    public List<E_shcool> findall_R_S(String dept) {
        return dao.findall_R_S(dept);
    }

    @Override
    public int update_gf(String g_name,String amount, String formid, String status) {
        return dao.update_gf(g_name,amount,formid,status);
    }

    @Override
    public List<Health_extend> findall_He() {
        return dao.findall_He();
    }

    @Override
    public List<Health_extend> findall_he_t() {
        return dao.findall_he_t();
    }

    @Override
    public List<Health_extend> findall_he_h() {
        return dao.findall_he_h();
    }

    @Override
    public List<E_shcool> findall_R_t(String dept) {
        return dao.findall_R_t(dept);
    }

    @Override
    public int update_r_d(String formid, String couns) {
        return dao.update_R_d(formid,couns);
    }

    @Override
    public List<leave_S> findall_l_d(String dept) {
        return dao.findall_l_d(dept);
    }

    @Override
    public int update_l_d(String formid, String couns) {
        return dao.update_l_d(formid,couns);
    }

    @Override
    public int update_r_ds(String formid, String couns) {
        return dao.update_r_ds(formid,couns);
    }

    @Override
    public int update_r(String formid, String couns) {
        return dao.update_r(formid,couns);
    }

    @Override
    public int update_l_s(String formid, String couns) {
        return dao.update_l_s(formid,couns);
    }

    @Override
    public int update_r_t(String formid, String couns) {
        return dao.update_r_t(formid,couns);
    }
}
