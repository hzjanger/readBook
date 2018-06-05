package config.mysql;

import config.mysql.MysqlInfor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMysql {
    public Connection getConnection() {
        Connection connection = null;
        MysqlInfor mysqlInfor = new MysqlInfor();
        try {
            Class.forName(mysqlInfor.getDriver());
            connection = DriverManager.getConnection(mysqlInfor.getUrl(), mysqlInfor.getUser(), mysqlInfor.getPassword());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
