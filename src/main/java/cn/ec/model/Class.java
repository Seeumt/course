package cn.ec.model;

import lombok.Data;

import java.util.List;

@Data
public class Class {
    private Integer cid;
    private String cname;
    private List<Teacher> teachers;
}
