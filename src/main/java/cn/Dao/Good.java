package cn.Dao;

import java.io.Serializable;

/**
 * 防疫物质库存实体类
 */
public class Good implements Serializable {
    //对应名称和库存信息
    String g_name,total;
    /**
     * 无参构造函数
     */
    public Good(){}
    /**
     * 有参构造函数
     * @param g_name
     * @param total
     */
    public Good(String g_name, String total) {
        this.g_name = g_name;
        this.total = total;
    }

    public String getG_name() {
        return g_name;
    }

    public void setG_name(String g_name) {
        this.g_name = g_name;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
