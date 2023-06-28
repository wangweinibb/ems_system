package wangwei.dao;

import wangwei.entity.Admin;

public interface AdminDAO {
    //根据账号密码查询
    Admin SelectByUsernameAndPassword(String name, String pwd);

    //新增所有属性
    void insertAll(Admin admin);
}
