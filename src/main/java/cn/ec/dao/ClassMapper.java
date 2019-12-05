package cn.ec.dao;

import cn.ec.model.Class;

public interface ClassMapper {
    Class findClassesWithTeacher(Integer cid);
}
