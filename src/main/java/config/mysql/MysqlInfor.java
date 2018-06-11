package config.mysql;

public class MysqlInfor {
    private final String driver = "com.mysql.jdbc.Driver";
    private final String url = "jdbc:mysql://127.0.0.1:3306/BookRead?useUnicode=true&characterEncoding=utf-8&useSSL=false";
    private final String user = "root";
    private final String password = "123456";

    public String getDriver() {
        return driver;
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
