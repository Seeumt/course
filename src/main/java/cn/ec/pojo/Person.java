package cn.ec.pojo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
@JacksonXmlRootElement(localName = "school")
public class Person {
    @JacksonXmlProperty(localName = "id")
    private Integer id;
    @JacksonXmlProperty(localName = "name")
    private String name;
    @JacksonXmlProperty(localName = "shortname")
    private String shortName;
    //……
}
