package wangwei.service;

import wangwei.dao.AdminDAOImpl;
import wangwei.entity.Admin;

public class AdminServiceDAOImpl implements AdminServiceDAO{
    AdminDAOImpl adminDAO=new AdminDAOImpl();
    @Override
    public Admin findByUsernameAndPassword(String name, String pwd) {
        Admin admin=adminDAO.SelectByUsernameAndPassword(name,pwd);
        return admin;
    }

    @Override
    public void addAll(Admin admin) {
        adminDAO.insertAll(admin);
    }
}
