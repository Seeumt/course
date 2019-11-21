package cn.ec.pojo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
@JacksonXmlRootElement(localName = "person")//随便写都行？
public class Person {
    @JacksonXmlProperty(localName = "id")
    private Integer id;
    @JacksonXmlProperty(localName = "name")
    private String name;
    @JacksonXmlProperty(localName = "shortname")
    private String shortName;
    //……


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shortName='" + shortName + '\'' +
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

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
}
