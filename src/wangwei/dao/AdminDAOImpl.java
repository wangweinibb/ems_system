package wangwei.dao;

import wangwei.entity.Admin;
import wangwei.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminDAOImpl implements AdminDAO {
    //根据username跟password查询
    @Override
    public Admin SelectByUsernameAndPassword(String name, String pwd) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Admin admin=null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "select * from admin where name=? and pwd=?";
            stm = conn.prepareStatement(sql);
            stm.setString(1,name);
            stm.setString(2,pwd);
            rs=stm.executeQuery();
            while (rs.next()){
                admin=new Admin();
                admin.setId(rs.getInt("id"));
                admin.setName(rs.getString("name"));
                admin.setRealname(rs.getString("realname"));
                admin.setPwd(rs.getString("pwd"));
                admin.setSex(rs.getString("sex"));
            }
            return admin;
        } catch (Exception e) {
            throw new RuntimeException("查询账号密码异常");
        }finally {
            JDBCUtil.close(rs,stm,null);
        }
    }

    //新增所有属性
    @Override
    public void insertAll(Admin admin) {
        Connection conn=null;
        PreparedStatement stm=null;
        try {
            conn=JDBCUtil.getConnection();
            String sql="insert into admin (name,realname,pwd,sex) values (?,?,?,?)";
            stm=conn.prepareStatement(sql);
            stm.setString(1,admin.getName());
            stm.setString(2,admin.getRealname());
            stm.setString(3,admin.getPwd());
            stm.setString(4,admin.getSex());
            stm.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("添加异常");
        }finally {
            JDBCUtil.close(stm,null);
        }
    }
}
