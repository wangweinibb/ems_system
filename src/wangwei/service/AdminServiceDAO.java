package wangwei.service;

import wangwei.entity.Admin;

public interface AdminServiceDAO {
    //根据username和password查询
    public Admin findByUsernameAndPassword(String name, String pwd);
    //新增所有属性
    public void addAll(Admin admin);
}
