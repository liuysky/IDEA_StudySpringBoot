package com.lys.test;

import com.lys.JpaStart;
import com.lys.dao.RolesRepository;
import com.lys.pojo.Menus;
import com.lys.pojo.Roles;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JpaStart.class)
public class ManytoManyTest {
    @Resource
    private RolesRepository rolesRepository;

    /**
     * 添加测试
     */
    @Test
    public void testSave(){
        //创建角色对象
        Roles roles=new Roles();
        roles.setRolename("项目经理");
        //创建菜单对象
        Menus menus=new Menus();
        menus.setMenusname("xxxxx管理系统");
        menus.setFatherid(0);

        Menus menus2=new Menus();
        menus2.setFatherid(1);
        menus2.setMenusname("项目管理");

        //关联
        roles.getMenus().add(menus);
        roles.getMenus().add(menus2);

        menus.getRoles().add(roles);
        menus2.getRoles().add(roles);

        //保存
        this.rolesRepository.save(roles);
    }

    /**
     * 查询操作
     */
    @Test
    public void testFind(){
        Roles roles = this.rolesRepository.findOne(2);
        System.out.println(roles.getRolename());
        Set<Menus> menus=roles.getMenus();
        for(Menus m:menus){
            System.out.println(m);
        }
    }
}
