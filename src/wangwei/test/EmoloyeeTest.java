package wangwei.test;

import org.junit.Test;
import wangwei.dao.EmployeeDAOImpl;
import wangwei.entity.Employee;
import wangwei.service.EmployeeServiceDAOImpl;

public class EmoloyeeTest {
    EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
    EmployeeServiceDAOImpl employeeServiceDAO=new EmployeeServiceDAOImpl();
    //查询所有
    @Test
    public void selectAll() {
        //System.out.println(employeeDAO.selectAll());
        System.out.println(employeeServiceDAO.findAll());
    }

    //新增员工
    @Test
    public void addAll() {
        //employeeDAO.insertAll(new Employee("王维", 19, "20000"));
        employeeServiceDAO.addAll(new Employee("123",12,"212"));
    }

    @Test
    //删除员工
    public void delAll() {
        //employeeDAO.deleteAll(6);
        employeeServiceDAO.del(9);
    }

    @Test
    //修改员工
    public void changeAll() {
        //employeeDAO.updateAll(new Employee(1,"sb",12,"20000"));
        employeeServiceDAO.change(new Employee(1,"2b",19,"100"));
    }
    //获取分页条数信息
    @Test
    public void getPage(){
        System.out.println(employeeServiceDAO.findByPageAll(0,5));
    }
    //获取总条数
    @Test
    public void getCount(){
        System.out.println( employeeServiceDAO.findCount());
    }
}
