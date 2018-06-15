package dao;

import config.mysql.CloseMysql;
import config.mysql.ConnectionMysql;
import entity.Author;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorDao {

    public Author selectOneAuthor(int author_id) {
        Author author = new Author();
        author.setAuthor_id(author_id);
        Connection connection = ConnectionMysql.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from author_information where author_id=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, author_id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                author.setAuthor_name(resultSet.getString(2));
                author.setAuthor_introduction(resultSet.getString(3));
                return author;
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


    public boolean addAuthor(Author author) {
        Connection connection = ConnectionMysql.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from author_information where author_name=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, author.getAuthor_name());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("到这了");
        sql = "insert into author_information (author_name, author_introduction) value (?,?)";
        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, author.getAuthor_name());
            preparedStatement.setString(2, author.getAuthor_introduction());
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

    public void updateAuthor(Author author) {
        Connection connection = ConnectionMysql.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "update author_information set author_name=?,author_introduction=? where author_id=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, author.getAuthor_name());
            preparedStatement.setString(2, author.getAuthor_introduction());
            preparedStatement.setInt(3, author.getAuthor_id());
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

    public int selectAuthor(String author_name) {
        Connection connection = ConnectionMysql.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from author_information where author_name=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, author_name);
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
