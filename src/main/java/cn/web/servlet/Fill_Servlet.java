package cn.web.servlet;

import cn.Dao.*;
import cn.service.FIllservice;
import cn.service.impl.Fillserviceimpl;
import com.google.gson.Gson;
import org.apache.commons.beanutils.BeanUtils;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet("/fill/*")
public class Fill_Servlet extends BaseServlet {

    private Health hy = new Health();
    private leave_S le = new leave_S();
    private ResultInfo info = new ResultInfo();
    private Gson gson = new Gson();
    private E_shcool es = new E_shcool();
    private FIllservice stu=new Fillserviceimpl();
    private String id=null;
    private G_Fa gf=new G_Fa();


    /**
     * 每日健康申报表
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void health(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {

                    System.out.println("/fill/health");



        Finduser_infor fu=new Finduser_infor();
        id= fu.findid(request,response);

        Map<String, String[]> map = request.getParameterMap();

        System.out.println(map.get("location"));

            try {
                BeanUtils.populate(hy, map);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            hy.setUid( id);
            System.out.println(request.getParameter("day_14")+" "+request.getParameter("location")+request.getParameter("provice"));
            int n = stu.insert_hearth(hy);
            if (n == 1) {
                //申报成功
                info.setFlag(1);

            } else {
                info.setFlag(0);
                info.setErrorMsg("申报失败");
            }

        //json格式返回数据
        response.setContentType("application/x-json;charset=utf-8");
        response.getWriter().write(gson.toJson(info));


            }


            /**
             * 进校申请表
             * @param request
             * @param response
             * @throws ServletException
             * @throws IOException
             */
            public void e_school (HttpServletRequest request, HttpServletResponse response) throws
                    ServletException, IOException, InvocationTargetException, IllegalAccessException {
                request.setCharacterEncoding("UTF-8");
                Finduser_infor fu=new Finduser_infor();
                id= fu.findid(request,response); //获取id
                Map<String, String[]> map = request.getParameterMap();
                System.out.println(map.get("reason"));    //测试

                try {
                    BeanUtils.populate(es, map);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                es.setUid( id);
                int n = stu.insert_e_school(es);
                if (n == 1) {
                    //申报成功
                    info.setFlag(1);

                } else {
                    info.setFlag(0);
                    info.setErrorMsg("申报失败");
                }
                //json格式返回数据
                response.setContentType("application/json;charset=utf-8");
                response.getWriter().write(gson.toJson(info));



            }

            /**
             * 外出申请
             * @param request
             * @param response
             * @throws ServletException
             * @throws IOException
             */
            public void l_school (HttpServletRequest request, HttpServletResponse response) throws
                    ServletException, IOException, InvocationTargetException, IllegalAccessException {
                System.out.println("/student/l_school");
                Finduser_infor fu=new Finduser_infor();
                id= fu.findid(request,response);
                Map<String, String[]> map = request.getParameterMap();

                try {
                    BeanUtils.populate(le, map);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                le.setUid( id);
                int n = stu.insert_l_school(le);
                if (n == 1) {
                    //填报成功
                    info.setFlag(1);

                } else {
                    info.setFlag(0);
                    info.setErrorMsg("申请失败");
                }

                //json格式返回数据
                response.setContentType("application/json;charset=utf-8");
                response.getWriter().write(gson.toJson(info));



            }


    /**
     * 查看对应id返校申请进度
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void fanxiao_apply (HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException, InvocationTargetException, IllegalAccessException {
        System.out.println("/fill/fanxiao_apply");
        Finduser_infor fu=new Finduser_infor();
        id= fu.findid(request,response);
        String mesg;
        List<E_shcool>  list=stu.e_findall( id);

        writeValue(list,response);
    }

    /**
     * 查看对应id离校申请进度
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void leave_apply (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        System.out.println("/fill/leave_apply");

        Finduser_infor fu=new Finduser_infor();
        id= fu.findid(request,response);
        List<leave_S> list=stu.l_findall(id);
        for(leave_S le:list){
            System.out.println(le.getUid()+" "+le.getReason()+" "+le.getD_secr());
        }

        writeValue(list,response);


    }

    /**
     * 添加物资申请记录
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public void wuzi_apply (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        System.out.println("/fill/wuzi_apply");
        ResultInfo info1=new ResultInfo();
        Map<String, String[]> map = request.getParameterMap();
        try {
            BeanUtils.populate(gf, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        Finduser_infor fu=new Finduser_infor();

        id= fu.findid(request,response);

        gf.setUid(id);
        int n= stu.f_inster(gf);
        if(n==1){
            //填写成功
            info1.setFlag(1);

        }
        else {
            info1.setFlag(0);
            info1.setErrorMsg("申请失败，请重新申请");
        }

        //json格式返回数据
        response.setContentType("application/x-json;charset=utf-8");
        response.getWriter().write(gson.toJson(info1));


    }

    /**
     * 查询物资库存信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public void good_findall (HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException, InvocationTargetException, IllegalAccessException {
        System.out.println("fill/good_findall");

         List<Good> list=stu.good_findall();

         writeValue(list,response);

    }

    /**
     * 查询地点信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public void address_findall (HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException, InvocationTargetException, IllegalAccessException {
        System.out.println("fill/address_findall");
        List<Address> list=stu.address_findall();
        writeValue(list,response);

    }

    /**
     * 插入消毒记录
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public void dis_insert (HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException, InvocationTargetException, IllegalAccessException {
        System.out.println("/fill/dis_insert");
        Disinfect dis=new Disinfect();
        Map<String, String[]> map = request.getParameterMap();
        try {
            BeanUtils.populate(dis, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        Finduser_infor fu=new Finduser_infor();

        id= fu.findid(request,response);

        dis.setHid(id);
        System.out.println(dis.getBlock()+" "+dis.getRoom()+" "+dis.getTime());
        int n= stu.inster_dis(dis);
        if(n==1){
            //填写成功
            info.setFlag(1);

        }
        else {
            info.setFlag(0);
            info.setErrorMsg("添加失败！");
        }

        //json格式返回数据
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(gson.toJson(info));

    }

    /**
     * 插入每日健康数据
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */

    public void d_insert (HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException, InvocationTargetException, IllegalAccessException {
        System.out.println("/fill/d_insert");
        ResultInfo info1=new ResultInfo();
        Health_day hd=new Health_day();
        Map<String, String[]> map = request.getParameterMap();
        try {
            BeanUtils.populate(hd, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        Finduser_infor fu=new Finduser_infor();
        id= fu.findid(request,response);
        hd.setHid(id);

        int n= Integer.parseInt(request.getParameter("num"));
        //1==学生 2==老师
     int y=stu.inster_hday(hd,n);
     if(y==1) {
         info1.setFlag(1);
     }else
         info1.setFlag(0);


        //json格式返回数据
        response.setContentType("application/x-json;charset=utf-8");
        String msg=gson.toJson(info1);
        System.out.println(msg);
        response.getWriter().write(msg);

    }

        }
