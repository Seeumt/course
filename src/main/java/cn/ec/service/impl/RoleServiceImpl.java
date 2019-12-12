package cn.ec.service.impl;

import cn.ec.dao.RoleMapper;
import cn.ec.model.Role;
import cn.ec.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Override
    @Transactional
    public int insert() {
        Role role1 = new Role();
        role1.setId(666);
        role1.setRoleSn("111");
        role1.setRoleName("hhhhh");
        role1.setDeleted(false);

        Role role2 = new Role();
        role2.setId(888);
        role2.setRoleSn("112");
        role2.setRoleName("xxxxx");
        role2.setDeleted(false);

        roleMapper.insert(role1);
        int i = 10 / 0;
        roleMapper.insert(role2);
        return 1;

    }
}
