package cn.ec.pojo;

import org.omg.PortableInterceptor.INACTIVE;

public class Room {

    private Integer id;

    private String name;

    private Integer doorNum;

    private Integer windowNum;

    private Integer area;

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", doorNum=" + doorNum +
                ", windowNum=" + windowNum +
                ", area=" + area +
                '}';
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
