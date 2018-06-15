package entity;

public class User {
    private int user_id; //用户id
    private String user_name;   //用户名
    private  String user_pass;  //密码
    private String user_img;    //用户头像
    private String sex; //性别
    private String birth;   //生日
    private String user_email;  //用户邮箱

    public User() {}

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getUser_id() {
        return user_id;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_pass() {
        return user_pass;
    }

    public void setUser_pass(String user_pass) {
        this.user_pass = user_pass;
    }

    public String getUser_img() {
        return user_img;
    }

    public void setUser_img(String user_img) {
        this.user_img = user_img;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public void init() {
        this.sex = "男";
        this.birth = "出生日期(格式为： 年-月-日)";
        this.user_email = "邮箱";
        this.user_img = "//img.mukewang.com/533e4d5b0001d57502200203-200-200.jpg";

    }
    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_pass='" + user_pass + '\'' +
                ", user_img='" + user_img + '\'' +
                ", sex='" + sex + '\'' +
                ", birth='" + birth + '\'' +
                ", user_email='" + user_email + '\'' +
                '}';
    }
}
