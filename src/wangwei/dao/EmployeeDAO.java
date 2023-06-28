package wangwei.dao;

import wangwei.controller.EmployeeAction;
import wangwei.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    //查询所有
    public List<Employee> selectAll();
    //新增员工
    public void insertAll(Employee employee);
    //删除员工
    public void deleteAll(int id);
    //修改员工
    public void updateAll(Employee employee);
    //获取条数
    public List<Employee> selectByPage(int beginCount,int pageSize);
    //查询条数
    public int selectTotalCount();
}
