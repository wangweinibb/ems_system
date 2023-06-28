package wangwei.controller;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import wangwei.entity.Employee;
import wangwei.service.EmployeeServiceDAOImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class EmployeeAction extends ActionSupport {
    private int id;
    private String name;
    private int age;
    private String salary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    EmployeeServiceDAOImpl employeeServiceDAO = new EmployeeServiceDAOImpl();
    //查询所有员工信息
    public String findAll(){
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("list",employeeServiceDAO.findAll());
        return "success";
    }
    //新增员工信息
    public String addAll() {
        HttpServletRequest request = ServletActionContext.getRequest();
        employeeServiceDAO.addAll(new Employee(name,age,salary));
        return "success";
    }
    //删除员工信息
    public String delAll(){
        employeeServiceDAO.del(id);
        return "success";
    }
    //修改员工信息
    public String changeAll(){
        Employee employee=new Employee(id,name,age,salary);
        employeeServiceDAO.change(employee);
        return "success";
    }
    //分页查询员工信息
    public String findByPageAll(){
        HttpServletRequest request=ServletActionContext.getRequest();
        HttpSession session=request.getSession();
        request.setAttribute("list",employeeServiceDAO.findByPageAll(0,5));
        session.setAttribute("count",employeeServiceDAO.findCount());
        session.setAttribute("id",1);
        return "success";
    }
    public String findByPage(){
        HttpServletRequest request=ServletActionContext.getRequest();
        HttpSession session=request.getSession();
        request.setAttribute("list",employeeServiceDAO.findByPageAll((id-1)*5,5));
        session.setAttribute("page",id);
        System.out.println(id);
        return "success";
    }
}
