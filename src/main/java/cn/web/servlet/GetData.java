package cn.web.servlet;

import cn.Dao.*;
import cn.service.FIllservice;
import cn.service.impl.Fillserviceimpl;
import cn.service.impl.GetDataimpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import org.apache.commons.beanutils.BeanUtils;

import org.springframework.transaction.support.SimpleTransactionStatus;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;


@WebServlet("/get/*")
public class GetData  extends BaseServlet{
    cn.service.GetData dao=new GetDataimpl();
    FIllservice fill=new Fillserviceimpl();
    String id=null;
   Gson gson=new Gson();
   ResultInfo info=new ResultInfo();
    /**
     * 查看辅导员审核的返校申请记录
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public void findall_R_C(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException, InvocationTargetException, IllegalAccessException {
        Finduser_infor fu=new Finduser_infor();
        id= fu.findid(request,response);
        List<E_shcool> list=dao.findall_R_C(id);
        for (E_shcool es:list){
            System.out.println(es.getTid()+es.getD_secr()+es.getDept()+es.getReason()+" "+es.getD_secr());
        }

        writeValue(list,response);

}

    /**
     * 查找教师职称信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public void find_t(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException, InvocationTargetException, IllegalAccessException {
        List<Teacher> list=dao.findall_T();

        writeValue(list,response);
    }

    /**
     * 更新辅导员审核的返校申请记录
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public void update_f(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException, InvocationTargetException, IllegalAccessException {
         String formid=request.getParameter("formid");
         String couns=request.getParameter("couns");
         int n=dao.update_f(formid,couns);
         if(n==1) info.setFlag(1);
         else info.setFlag(0);
        //json格式返回数据
        response.setContentType("application/x-json;charset=utf-8");
        response.getWriter().write(gson.toJson(info));
    }

    /**
     * 查看辅导员审核的离校申请
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public void findall_L(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException, InvocationTargetException, IllegalAccessException {
        Finduser_infor fu=new Finduser_infor();
        id= fu.findid(request,response);
        List<leave_S> list=dao.findall_l(id);
        writeValue(list,response);

    }

    /**
     * 辅导员更新离校申请信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public void update_l(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException, InvocationTargetException, IllegalAccessException {
        String formid=request.getParameter("formid");
        String couns=request.getParameter("couns");

        int n=dao.update_l(formid,couns);
        if(n==1) info.setFlag(1);
        else info.setFlag(0);
        //json格式返回数据
        response.setContentType("application/x-json;charset=utf-8");
        response.getWriter().write(gson.toJson(info));
    }

    /**
     * 查询副书记要审核的生返校记录 --根据学院信息查询
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public void findall_R_S(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException, InvocationTargetException, IllegalAccessException {
        System.out.println("get/findall_R_S");
            Finduser_infor fu=new Finduser_infor();
            String dept=fu.f_title(request,response);
        System.out.println(dept);
        List<E_shcool> list=dao.findall_R_S(dept);
        writeValue(list,response);

    }

    /**
     * 查找防疫物资申请记录
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public void findall_gf(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException, InvocationTargetException, IllegalAccessException {
          List<G_Fa> list=fill.g_findall();
          writeValue(list,response);


    }

    /**
     * 后勤人员更新物资申请记录
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public void update_gf(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException, InvocationTargetException, IllegalAccessException {
          String g_name=request.getParameter("g_name");
          String amount=request.getParameter("amount");
           String formid=request.getParameter("formid");
           String status=request.getParameter("status");

           int n=dao.update_gf(g_name,amount,formid,status);
           if(n==1) info.setFlag(1);
           else info.setFlag(0);
        //json格式返回数据
        response.setContentType("application/x-json;charset=utf-8");
        response.getWriter().write(gson.toJson(info));


    }

    /**
     * 通过id查找物资申请记录
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public void find_byid_gf(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException, InvocationTargetException, IllegalAccessException {
        Finduser_infor fu=new Finduser_infor();
        id= fu.findid(request,response);
        List<G_Fa> list=fill.g_find(id);
        writeValue(list,response);

    }

    /**
     * 插入违纪学生信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public void insert_break(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException, InvocationTargetException, IllegalAccessException {
        Breach br=new Breach();
        Map<String, String[]> map = request.getParameterMap();
        try {
            BeanUtils.populate(br, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        Finduser_infor fu=new Finduser_infor();
        id= fu.findid(request,response);
        br.setFid(id);
        System.out.println(br.getFid()+" "+br.getSid());
       int n= fill.insert_br(br);
        if(n==1) info.setFlag(1);
        else info.setFlag(0);
        //json格式返回数据
        response.setContentType("application/x-json;charset=utf-8");
        response.getWriter().write(gson.toJson(info));

    }

    /**
     * 查找所有的违纪信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public void findall_br(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException, InvocationTargetException, IllegalAccessException {
         List<Breach>list= fill.br_findall();
         writeValue(list,response);

    }

    /**
     * 查找消毒信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public void findall_Dis(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException, InvocationTargetException, IllegalAccessException {
            List<Disinfect> list=fill.dis_findall();
            writeValue(list,response);

    }

    /**
     * 查找学生的健康上报信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public void findall_He(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException, InvocationTargetException, IllegalAccessException {
        List<Health_extend> list=dao.findall_He();
        writeValue(list,response);

    }

    /**
     * 查找老师健康上报信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public void findall_He_t(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException, InvocationTargetException, IllegalAccessException {
        List<Health_extend> list=dao.findall_he_t();
        writeValue(list,response);
    }

    /**
     * 查找后勤健康上报信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public void findall_He_h(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException, InvocationTargetException, IllegalAccessException {
        List<Health_extend> list=dao.findall_he_h();
        writeValue(list,response);
    }

    /**
     * 查询教师进校申请---根据学院信息查询
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */

    public void findall_R_t(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException, InvocationTargetException, IllegalAccessException {
        Finduser_infor fu=new Finduser_infor();
        String dept=fu.f_title(request,response);
        System.out.println(dept);
        List<E_shcool> list=dao.findall_R_t(dept);
        writeValue(list,response);
    }

    /**
     * 副书记更新学生进校申请状态
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public void update_r_d(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException, InvocationTargetException, IllegalAccessException {
        String formid=request.getParameter("formid");
        String couns=request.getParameter("couns");
        int n=dao.update_r_d(formid,couns);
        if(n==1) info.setFlag(1);
        else info.setFlag(0);

        //json格式返回数据
        response.setContentType("application/x-json;charset=utf-8");
        response.getWriter().write(gson.toJson(info));
    }

    /**
     * 查询学生离校申请---根据学院信息查询
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public void findall_l_d(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException, InvocationTargetException, IllegalAccessException {
        Finduser_infor fu=new Finduser_infor();
        String dept=fu.f_title(request,response);
        List<leave_S> list=dao.findall_l_d(dept);
        writeValue(list,response);
    }

    /**
     * 副书记更新学生出校申请状态
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public void update_l_d(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException, InvocationTargetException, IllegalAccessException {
        String formid=request.getParameter("formid");
        String couns=request.getParameter("couns");
        int n=dao.update_l_d(formid,couns);
        if(n==1) info.setFlag(1);
        else info.setFlag(0);
        //json格式返回数据
        response.setContentType("application/x-json;charset=utf-8");
        response.getWriter().write(gson.toJson(info));
    }

    /**
     * 副书记更新老师进校申请
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public void update_r_ds(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException, InvocationTargetException, IllegalAccessException {
        String formid=request.getParameter("formid");
        String couns=request.getParameter("couns");
        int n=dao.update_r_ds(formid,couns);
        if(n==1) info.setFlag(1);
        else info.setFlag(0);
        //json格式返回数据
        response.setContentType("application/x-json;charset=utf-8");
        response.getWriter().write(gson.toJson(info));
    }
    /**
     * 书记更新学生进校申请
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public void update_r(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException, InvocationTargetException, IllegalAccessException {
        String formid=request.getParameter("formid");
        String couns=request.getParameter("couns");
        System.out.println(formid+" "+couns);
        int n=dao.update_r(formid,couns);
        if(n==1) info.setFlag(1);
        else info.setFlag(0);
        //json格式返回数据
        response.setContentType("application/x-json;charset=utf-8");
        response.getWriter().write(gson.toJson(info));
    }
    /**
     * 书记更新学生离校申请状态
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public void update_l_s(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException, InvocationTargetException, IllegalAccessException {
        String formid=request.getParameter("formid");
        String couns=request.getParameter("couns");
        int n=dao.update_l_s(formid,couns);
        if(n==1) info.setFlag(1);
        else info.setFlag(0);
        //json格式返回数据
        response.setContentType("application/x-json;charset=utf-8");
        response.getWriter().write(gson.toJson(info));
    }

    /**
     * 书记审核老师返校申请状态
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public void update_r_t(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException, InvocationTargetException, IllegalAccessException {
        String formid=request.getParameter("formid");
        String couns=request.getParameter("couns");
        int n=dao.update_r_t(formid,couns);
        if(n==1) info.setFlag(1);
        else info.setFlag(0);
        //json格式返回数据
        response.setContentType("application/x-json;charset=utf-8");
        response.getWriter().write(gson.toJson(info));
    }


}
