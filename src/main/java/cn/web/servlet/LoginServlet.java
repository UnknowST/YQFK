package cn.web.servlet;

import cn.Dao.*;
import cn.service.Loginservice;
import cn.service.impl.Loginserviceimpl;
import com.google.gson.Gson;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private Loginservice service = new Loginserviceimpl();
    private ResultInfo info = new ResultInfo();
    private int i;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Gson gson=new Gson();
        //验证校验
        //信息记录
        String check = request.getParameter("check");
        //从sesion中获取验证码
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");//为了保证验证码只能使用一次
        //比较
        if(checkcode_server == null || !checkcode_server.equalsIgnoreCase(check)){
            //验证码错误
           //登陆失败
            info.setFlag(0);
            info.setErrorMsg("验证码错误");

        }
        else {
            //1.获取用户名和密码数据
            Map<String, String[]> map = request.getParameterMap();
            //获取身份信息 i=1为学生 2为教师 3为后勤人员 3为防控小组
            i = Integer.parseInt(request.getParameter("shenfen"));


            if(i==1){

            System.out.println(i);
            if (i == 1) {
                //2.封装学生对象
                Student st = new Student();
                try {
                    BeanUtils.populate(st, map);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }

                Student st2 = service.login(st);
                //4.判断学生对象是否为null
                if (st2 == null) {
                    //用户名密码或错误
                    info.setFlag(0);
                    info.setErrorMsg("用户名或密码错误");
                } else {
                    info.num=i;
                    info.setData(i);
                    info.setFlag(1);//登录成功标记
                    request.getSession().setAttribute("user", st2);//对象放进缓存
                }
            }}
            if (i == 2) {
                //2.封装教师对象
                Teacher te = new Teacher();
                try {
                    BeanUtils.populate(te, map);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }

                Teacher st2 = service.login(te);
                //4.判断教师对象是否为null
                if (st2 == null) {
                    //用户名密码或错误
                    info.setFlag(0);
                    info.setErrorMsg("用户名或密码错误");
                } else {
                    info.num=i;
                    info.setData(i);
                    info.setFlag(1);//登录成功标记
                    request.getSession().setAttribute("user", st2);//对象放进缓存
                }
            }
            if (i == 3) {
                //2.封装后勤对象
                Houqin hq = new Houqin();

                try {
                    BeanUtils.populate(hq, map);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }


                Houqin st2 = service.login(hq);
                
                //4.判断后勤对象是否为null
                if (st2 == null) {
                    //用户名密码或错误
                    info.setFlag(0);
                    info.setErrorMsg("用户名或密码错误");
                } else {
                    info.num=i;
                    info.setData(i);
                    info.setFlag(1);//登录成功标记
                    request.getSession().setAttribute("user", st2);//对象放进缓存
                }
            }
            if (i == 4) {
                //2.封装防控组对象
                Fangkong fk = new Fangkong();
                try {
                    BeanUtils.populate(fk, map);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }

                Fangkong st2 = service.login(fk);
                //4.判断防控组对象是否为null
                if (st2 == null) {
                    //用户名密码或错误
                    info.setFlag(0);
                    info.setErrorMsg("用户名或密码错误");
                }
                //6.判断登录成功
                else {
                    info.num=i;
                    info.setData(i);
                    info.setFlag(1);//登录成功标记
                    request.getSession().setAttribute("user", st2);//对象放进缓存
                }
            }
        }
            //json格式返回数据
            response.setContentType("application/x-json;charset=utf-8");
            response.getWriter().write(gson.toJson(info));
            System.out.println(gson.toJson(info));
            System.out.println("re"+" "+ResultInfo.num);
            System.out.println("info"+" "+info.num);

        }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
