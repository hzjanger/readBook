package dao;


import config.mysql.CloseMysql;
import config.mysql.ConnectionMysql;
import entity.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddBook {
    public boolean insert(Book book) {
        System.out.println("AddBook " + book);
        Connection connection = ConnectionMysql.getConnection();
        System.out.println(connection);
        PreparedStatement preparedStatement = null;
//        String sql = "select * from book_information where ISBN=?";
//        ResultSet resultSet = null;
//        try {
//            preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, book.getISBN());
//            resultSet = preparedStatement.executeQuery();
//            if (resultSet.next()) {
//                System.out.println("AddBook book存在");
//                return false;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        sql = "insert into book_information (ISBN, publish_time, author, publiseer, translators, book_name, directory, is_popular, content_Introduction, book_img, price, binding, review_grade, page_amount)" + "value (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//        try {
//            connection.setAutoCommit(false);
//            preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, book.getISBN());
//            preparedStatement.setString(2, book.getPutlish_time());
//            preparedStatement.setString(3, book.getAuthor());
//            preparedStatement.setString(4, book.getPubliseer());
//            preparedStatement.setString(5, book.getTranslators());
//            preparedStatement.setString(6, book.getBook_name());
//            preparedStatement.setString(7, book.getDirectory());
//            preparedStatement.setString(8, book.getIs_popular());
//            preparedStatement.setString(9, book.getContent_Introduction());
//            preparedStatement.setString(10, book.getBook_img());
//            preparedStatement.setString(11, book.getPrice());
//            preparedStatement.setString(12, book.getBinding());
//            preparedStatement.setString(13, book.getReview_grade());
//            preparedStatement.setString(14, book.getPage_amount());
//            preparedStatement.addBatch();
//            preparedStatement.executeBatch();
//            connection.commit();
//            connection.setAutoCommit(true);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                CloseMysql.close(connection, preparedStatement, resultSet);
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
        return true;
    }
}
