package wangwei.dao;

import wangwei.controller.EmployeeAction;
import wangwei.entity.Employee;
import wangwei.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public List<Employee> selectAll() {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Employee employee = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "select * from employee";
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();
            List<Employee> list = new ArrayList<>();
            while (rs.next()) {
                employee = new Employee();
                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                employee.setAge(rs.getInt("age"));
                employee.setSalary(rs.getString("salary"));
                list.add(employee);
            }
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.close(rs, stm, null);
        }
    }

    @Override
    public void insertAll(Employee employee) {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn=JDBCUtil.getConnection();
            String sql="insert into employee (name,age,salary) values (?,?,?)";
            stm=conn.prepareStatement(sql);
            stm.setString(1,employee.getName());
            stm.setInt(2,employee.getAge());
            stm.setString(3, employee.getSalary());
            stm.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtil.close(stm,null);
        }
    }

    @Override
    public void deleteAll(int id) {
        Connection conn=null;
        PreparedStatement stm=null;
        try {
            conn=JDBCUtil.getConnection();
            String sql="delete from employee where id=?";
            stm=conn.prepareStatement(sql);
            stm.setInt(1,id);
            stm.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtil.close(stm,null);
        }
    }

    @Override
    public void updateAll(Employee employee) {
        Connection conn=null;
        PreparedStatement stm=null;
        try {
            conn=JDBCUtil.getConnection();
            String sql="update employee set name = ? ,age=?,salary=? where id = ?";
            stm=conn.prepareStatement(sql);
            stm.setString(1,employee.getName());
            stm.setInt(2,employee.getAge());
            stm.setString(3, employee.getSalary());
            stm.setInt(4,employee.getId());
            stm.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtil.close(stm,null);
        }
    }

    @Override
    public List<Employee> selectByPage(int beginCount, int pageSize) {
        Connection conn=null;
        PreparedStatement stm=null;
        ResultSet rs=null;
        ArrayList<Employee> ListEmp=new ArrayList<>();
        try {
            conn=JDBCUtil.getConnection();
            String sql="select * from employee limit ?,?;";
            stm=conn.prepareStatement(sql);
            stm.setInt(1,beginCount);
            stm.setInt(2,pageSize);
            rs=stm.executeQuery();
            while (rs.next()){
                Employee employee=new Employee();
                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                employee.setSalary(rs.getString("salary"));
                employee.setAge(rs.getInt("age"));
                ListEmp.add(employee);
            }
            return ListEmp;
        } catch (Exception e) {
            throw new RuntimeException("分页查询异常");
        }finally {
            JDBCUtil.close(rs,stm,conn);
        }
    }

    @Override
    public int selectTotalCount() {
        Connection conn=null;
        PreparedStatement stm=null;
        ResultSet rs=null;
        int totalCount=0;
        try {
            conn=JDBCUtil.getConnection();
            String sql="select count(*) from employee";
            stm=conn.prepareStatement(sql);
            rs=stm.executeQuery();
            if (rs.next()){
                totalCount=rs.getInt(1);
            }
            return totalCount;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("查询总条数异常");
        }finally {
            JDBCUtil.close(rs,stm,conn);
        }
    }
}
