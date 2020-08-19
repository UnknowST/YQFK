package Test;

import cn.Dao.G_Fa;
import cn.Dao.Student;
import cn.Dao.Teacher;
import cn.daomain.FillDao;
import cn.daomain.LoginDao;
import cn.daomain.impl.FIllDaoimpl;
import cn.daomain.impl.LoginDaoimpl;
import cn.service.FIllservice;


public class StudentLoginTest {
    public static void main(String []args){
        Student st=new Student();
        st.setId("S1853130");
        st.setPassword("123456");
        Teacher te=new Teacher();
        te.setId("T1000");
        te.setPassword("1234");
        LoginDao lg=new LoginDaoimpl();
        te=lg.checkteacher(te.getId(),te.getPassword());
        if(te!=null)
        System.out.println(te.getId()+" "+te.getPassword()+" "+te.getDept()+" "+te.getTitle());
        if(te==null) System.out.println("没有找到");

   /*     st=lg.checkstudent(st.getId(),st.getPassword());
        System.out.println(st.getId()+" "+st.getMajor());*/
/*        FillDao fl=new FIllDaoimpl();
        G_Fa gf=new G_Fa();
        gf.setUid("T1000");
        gf.setG_name("体温计");
        gf.setAmount(2);
        System.out.println(fl.f_insert(gf));*/

    }
}
