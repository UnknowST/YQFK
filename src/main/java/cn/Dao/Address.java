package cn.Dao;

import java.io.Serializable;

/**
 * 教室地点实体类
 */
public class Address implements Serializable {
    //对应地点的楼号和房间号
    private String block,room;
    /**
     * 无参构造函数
     */
    public Address(){}
    /**
     * 有参构造函数
     * @param block
     * @param room
     */
    public Address(String block,String room){
       this.block=block;
       this.room=room;
    }

    public String getBlock() {
        return block;
    }

    public String getRoom() {
        return room;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}
