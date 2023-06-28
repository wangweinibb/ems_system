package wangwei.service;

import wangwei.dao.EmployeeDAOImpl;
import wangwei.entity.Employee;

import java.util.List;

public class EmployeeServiceDAOImpl implements EmployeeServiceDAO {
    EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();

    //查询所有
    @Override
    public List<Employee> findAll() {
        List<Employee> employees = employeeDAO.selectAll();
        return employees;
    }

    @Override
    public void addAll(Employee employee) {
        employeeDAO.insertAll(employee);
    }

    @Override
    public void del(int id) {
        employeeDAO.deleteAll(id);
    }

    @Override
    public void change(Employee employee) {
        employeeDAO.updateAll(employee);
    }
    //分页查询
    @Override
    public List<Employee> findByPageAll(int beginCount,int pageSize) {
        List<Employee> employee = employeeDAO.selectByPage(beginCount, pageSize);
        return employee;
    }
    //获取总条数
    @Override
    public int findCount() {
        return employeeDAO.selectTotalCount();
    }
}
