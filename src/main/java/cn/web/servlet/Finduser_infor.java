package cn.web.servlet;

import cn.Dao.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.StyleSheet;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet("/findUser/*")
public class Finduser_infor extends BaseServlet{
    public String findid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
            Object user=request.getSession().getAttribute("user");
            Student st=new Student();
            Teacher te=new Teacher();
            Houqin hq=new Houqin();
            Fangkong fk=new Fangkong();
            String id=null;
            if(ResultInfo.num==1) {
                st=(Student)user;
                id=st.getId();

            }
            else if(ResultInfo.num==2) {
                te=(Teacher) user;
                id=te.getId();
            }
            else if(ResultInfo.num==3) {
                hq=(Houqin) user;
                id=hq.getId();

            }
           else  if(ResultInfo.num==4) {
                fk=(Fangkong) user;
                id=fk.getId();

            }
            return id;
        }

    public void infor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        Object user=request.getSession().getAttribute("user");
        System.out.println("user"+user);
        writeValue(user,response);  //将用户信息序列化

    }
    public String f_title(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException, InvocationTargetException, IllegalAccessException {

        Object user=request.getSession().getAttribute("user");


        Teacher te=new Teacher();
       String dept=null;

         if(ResultInfo.num==2) {
            te=(Teacher) user;
             dept=te.getDept();
         }
         return dept;

    }




}
