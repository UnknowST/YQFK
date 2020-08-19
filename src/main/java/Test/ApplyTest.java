package Test;

import cn.Dao.Health;
import cn.Dao.ResultInfo;
import cn.service.FIllservice;
import cn.service.impl.Fillserviceimpl;

import java.awt.image.RescaleOp;

public class ApplyTest {
    public static void main(String []args){
        FIllservice stu=new Fillserviceimpl();
        Health he=new Health();
        he.setDay_14("上海市");
        he.setLocation("北京市");
        he.setTel("1818181818");
        he.setTemp(34.3f);
        he.setUid("T1000");
        ResultInfo.num=2;
        System.out.println(stu.insert_hearth(he));

    }
}
