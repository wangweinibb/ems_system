package wangwei.util;


import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

//JDBC工具类效率版本
public class JDBCUtil {
    //将数据存储到程序的集合中Properties
    private static Properties p= new Properties();
    private static  ThreadLocal<Connection> tl = new ThreadLocal<>();

    static {

        //动态搭建输入流 将被指文件中的数据读取到IO流中
        InputStream is =JDBCUtil.class.getResourceAsStream("/jdbc.properties");
        //加载数据
        try{p.load(is);}catch (IOException e){e.printStackTrace();}

    }

    //获取连接
    public static Connection getConnection() throws Exception {
        //使用集合中加载的配置参数

        Class.forName(p.getProperty("driver"));
        if (tl.get() == null){
            Connection conn = DriverManager.getConnection(p.getProperty("url"),p.getProperty("user"),p.getProperty("password"));
            tl.set(conn);

        }

        return tl.get();
    }


    public static void close( Connection con) {
        //表示关闭连接后，将连接对象从线程绑定对象中移除出去
        try{ if (con != null)con.close();tl.remove();}catch (Exception e){}
    }


    public static void close(PreparedStatement ps , Connection con) {
        try{ if (ps != null)ps.close();}catch (Exception e){}
        try{ if (con != null)con.close();tl.remove();}catch (Exception e){}


    }
    public static void close(ResultSet rs, PreparedStatement ps, Connection con) {
        try{if (rs != null)rs.close();}catch (Exception e){}
        try{ if (ps != null)ps.close();}catch (Exception e){}
        try{ if (con != null)con.close();tl.remove();}catch (Exception e){}

    }

}










