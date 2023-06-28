package wangwei.entity;

public class Admin {
    private int id;
    private String name;
    private String realname;
    private String pwd;
    private String sex;

    public Admin() {
    }

    public Admin(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }

    public Admin(String name, String realname, String pwd, String sex) {
        this.name = name;
        this.realname = realname;
        this.pwd = pwd;
        this.sex = sex;
    }

    public Admin(int id, String name, String realname, String pwd, String sex) {
        this.id = id;
        this.name = name;
        this.realname = realname;
        this.pwd = pwd;
        this.sex = sex;
    }

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

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", realname='" + realname + '\'' +
                ", pwd='" + pwd + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
