package wangwei.test;

import org.junit.Test;
import wangwei.dao.AdminDAOImpl;
import wangwei.service.AdminServiceDAO;
import wangwei.service.AdminServiceDAOImpl;

public class AdminTest {
    AdminDAOImpl adminDAO=new AdminDAOImpl();
    @Test
    public void selectByUsernameAndPassword(){
        System.out.println(adminDAO.SelectByUsernameAndPassword("wangwei","wangwei"));
        System.out.println(adminDAO.SelectByUsernameAndPassword("sb","sb"));
    }
    @Test
    public void insertAll(){
        adminDAO.insertAll(new wangwei.entity.Admin("admin","王维","admin","男"));
    }
    AdminServiceDAO adminServiceDAO=new AdminServiceDAOImpl();
    @Test
    public void findByUsernameAndPassword(){
        System.out.println( adminServiceDAO.findByUsernameAndPassword("sb","sb"));
    }
    @Test
    public void addAll(){
        adminServiceDAO.addAll(new wangwei.entity.Admin("sb","whxh","sb","人妖"));
    }
}
