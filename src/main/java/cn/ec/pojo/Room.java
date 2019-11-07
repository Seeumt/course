package cn.ec.pojo;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.List;
import java.util.Map;

public class Room {

    private Integer id;

    private String name;

    private Integer doorNum;

    private Integer windowNum;

    private Integer area;

    private Map keyOwner;

    private List openDay;

    private Builder builder;


//    public Room(String name) {
//        this.name = name;
//    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", doorNum=" + doorNum +
                ", windowNum=" + windowNum +
                ", area=" + area +
                ", keyOwner=" + keyOwner +
                ", openDay=" + openDay +
                ", builder=" + builder +
                '}';
    }

    public Builder getBuilder() {
        return builder;
    }

    public void setBuilder(Builder builder) {
        this.builder = builder;
    }

    public Map getKeyOwner() {
        return keyOwner;
    }

    public void setKeyOwner(Map keyOwner) {
        this.keyOwner = keyOwner;
    }

    public List getOpenDay() {
        return openDay;
    }

    public void setOpenDay(List openDay) {
        this.openDay = openDay;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDoorNum() {
        return doorNum;
    }

    public void setDoorNum(Integer doorNum) {
        this.doorNum = doorNum;
    }

    public Integer getWindowNum() {
        return windowNum;
    }

    public void setWindowNum(Integer windowNum) {
        this.windowNum = windowNum;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }
}
