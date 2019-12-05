package cn.ec.service.impl;

import cn.ec.dao.ClassMapper;
import cn.ec.model.Class;
import cn.ec.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    private ClassMapper classMapper;
    @Override
    public Class findClassesWithTeacher(Integer cid){
        return classMapper.findClassesWithTeacher(cid);
    }
}
