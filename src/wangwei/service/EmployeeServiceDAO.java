package wangwei.service;

import wangwei.entity.Employee;

import java.util.List;

public interface EmployeeServiceDAO {
    //查询所有
    public List<Employee> findAll();
    //新增员工
    public void addAll(Employee employee);
    //删除员工
    public void del(int id);
    //修改员工
    public void change(Employee employee);
    //分页查询
    public List<Employee> findByPageAll(int beginCount,int pageSize);
    //查询总条数
    public int findCount();
}
