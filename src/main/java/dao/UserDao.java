package dao;

import config.mysql.CloseMysql;
import config.mysql.ConnectionMysql;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    public User selectOngUser(int user_id) {
        User user = new User();
        user.setUser_id(user_id);
        Connection connection = ConnectionMysql.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from user where user_id=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, user_id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user.setUser_name(resultSet.getString(2));
                user.setUser_pass(resultSet.getString(3));
                user.setUser_img(resultSet.getString(4));
                user.setSex(resultSet.getString(5));
                user.setBirth(resultSet.getString(6));
                user.setUser_email(resultSet.getString(7));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                CloseMysql.close(connection, preparedStatement,resultSet);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void deleteUser(int user_id) {
        Connection connection = ConnectionMysql.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "delete from user where user_id=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,user_id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                CloseMysql.close(connection, preparedStatement, null);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean addUser(User user) {
        Connection connection = ConnectionMysql.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from user where user_id=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, user.getUser_id());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sql = "insert into user (user_name, user_pass, user_img, sex, birth, user_email) value (?,?,?,?,?,?)";
        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUser_name());
            preparedStatement.setString(2, user.getUser_pass());
            preparedStatement.setString(3, user.getUser_img());
            preparedStatement.setString(4, user.getSex());
            preparedStatement.setString(5, user.getBirth());
            preparedStatement.setString(6, user.getUser_email());
            preparedStatement.addBatch();
            preparedStatement.executeBatch();
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                CloseMysql.close(connection, preparedStatement, null);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public void updateUser(User user) {
        System.out.println(user);
        Connection connection = ConnectionMysql.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "update user set user_name=?,user_pass=?,user_img=?,sex=?,birth=?,user_email=? where user_id=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUser_name());
            preparedStatement.setString(2, user.getUser_pass());
            preparedStatement.setString(3, user.getUser_img());
            preparedStatement.setString(4, user.getSex());
            preparedStatement.setString(5, user.getBirth());
            preparedStatement.setString(6, user.getUser_email());
            preparedStatement.setInt(7, user.getUser_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                CloseMysql.close(connection, preparedStatement, null);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public int selectUserId(String user_name) {
        Connection connection = ConnectionMysql.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from user where user_name=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user_name);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


}
