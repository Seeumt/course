package cn.ec.pojo;

import io.swagger.models.auth.In;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Builder {

    private Integer id;

    private String name;



    @Override
    public String toString() {
        return "Builder{" +
                "id=" + id +
                ", name='" + name + '\'' +
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

    public Builder() {
    }

    public Builder(Integer id,String name) {
        this.id = id;
        this.name = name;
    }
}
