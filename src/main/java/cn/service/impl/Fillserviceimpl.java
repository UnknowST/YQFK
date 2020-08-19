package cn.service.impl;

import cn.Dao.*;
import cn.daomain.FillDao;
import cn.daomain.impl.FIllDaoimpl;
import cn.service.FIllservice;

import java.util.List;

public class Fillserviceimpl implements FIllservice {
    private FillDao sd=new FIllDaoimpl();
    @Override
    public int insert_hearth(Health he) {
        return sd.h_insert(he);
    }

    @Override
    public int insert_e_school(E_shcool ws) {
        return sd.e_insert(ws);
    }

    @Override
    public int insert_l_school(leave_S ls) {
        return sd.l_insert(ls);
    }

    @Override
    public List<E_shcool> e_findall(String id) {

        return sd.e_findall(id);
    }

    @Override
    public List<leave_S> l_findall(String id) {
        return sd.l_findall(id);
    }

 /*   @Override
    public List<Health> h_findall(String id) {
        return sd.h_findall(id);
    }

    @Override
    public List<E_shcool> E_findall() {
        return sd.E_findall();
    }

    @Override
    public List<leave_S> L_findall() {
        return sd.L_findall();
    }
*/
    @Override
    public int f_inster(G_Fa fa) {
        return sd.f_insert(fa);
    }

    @Override
    public int insert_br(Breach br) {
        return sd.insert_br(br);
    }

    @Override
    public List<Breach> br_find(String sid, String fid) {
        return sd.br_find(sid,fid);
    }

    @Override
    public List<Breach> br_findall() {
        return sd.br_findall();
    }

    @Override
    public List<Disinfect> dis_findall() {
        return sd.dis_findall();
    }

    @Override
    public List<G_Fa> g_findall() {
        return sd.g_findall();
    }

    @Override
    public List<G_Fa> g_find(String id) {
        return sd.g_find(id);
    }

    @Override
    public int insert_gd(Good gd) {
        return sd.insert_gd(gd);
    }

    @Override
    public int inster_dis(Disinfect dis) {
        return sd.inster_dis(dis);
    }

    @Override
    public int inster_hday(Health_day hd,int n) {
        return sd.inster_hday(hd, n);
    }

    @Override
    public List<Disinfect> dis_find(String hid) {
        return sd.dis_find(hid);
    }

    @Override
    public List<Good> good_findall() {
        return sd.good_findall();
    }

    @Override
    public List<Address> address_findall() {
        return sd.address_findall();
    }


}
