package cn.ec.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
public class Department implements Serializable {
    private Integer id;
    private String departmentSn;
    private String departmentName;
    private String parentDepartmentSn;
    private List<User> users;
}
