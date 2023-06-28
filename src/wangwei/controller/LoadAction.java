package wangwei.controller;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import wangwei.entity.Admin;
import wangwei.service.AdminServiceDAOImpl;
import wangwei.service.EmployeeServiceDAOImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoadAction extends ActionSupport {
    private String code;
    private String name;
    private String realname;
    private String pwd;
    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    AdminServiceDAOImpl adminServiceDAO = new AdminServiceDAOImpl();
    EmployeeServiceDAOImpl employeeServiceDAO=new EmployeeServiceDAOImpl();
    HttpServletRequest request = ServletActionContext.getRequest();
    HttpSession session = request.getSession();
    String storeCode = (String) session.getAttribute("code");
    //登陆
    public String Login() {
        if (code.equals(storeCode)) {
            if (adminServiceDAO.findByUsernameAndPassword(name, pwd) == null) {
                session.removeAttribute("code");
                return "error";
            } else {
                session.removeAttribute("code");
                session.setAttribute("Name",name);
                return "success";
            }
        }else {
            return "error2";
        }
    }

    //注册
    public String Regist() {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();
        String storeCode= (String) session.getAttribute("code");
        if (code.equals(storeCode)){
            if (name != null && realname != null) {
                adminServiceDAO.addAll(new Admin(name, realname, pwd, sex));
                session.removeAttribute("code");
                return "success";
            } else {
                session.removeAttribute("code");
                return "error";
            }
        }else {
            return "error2";
        }
    }
    //退出登陆
    public String Logout(){
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session=request.getSession();
        session.removeAttribute("name");
        return "success";
    }
}
