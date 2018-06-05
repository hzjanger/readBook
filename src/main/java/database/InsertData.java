package database;


import config.mysql.ConnectionMysql;
import entity.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertData {
//    public void insert(Book book[]) {
//        System.out.println(book[0]);
//        ConnectionMysql connectionMysql = new ConnectionMysql();
//        Connection connection = connectionMysql.getConnection();
//        PreparedStatement preparedStatement = null;
//        String sql = "insert into book_information (ISBN, publish_time, author, publiseer, translators, book_name, directory, is_popular, content_Introduction, book_img, price, binding, review_grade, page_amount)"+"value (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//        try {
//            connection.setAutoCommit(false);
//            preparedStatement = connection.prepareStatement(sql);
//            System.out.println(book.length);
//            for (int i = 0; i < 1; i++) {
//                preparedStatement.setString(1, book[i].getISBN());
//                preparedStatement.setString(2, book[i].getPutlish_time());
//                preparedStatement.setString(3, book[i].getAuthor());
//                preparedStatement.setString(4, book[i].getPubliseer());
//                preparedStatement.setString(5, book[i].getTranslators());
//                preparedStatement.setString(6, book[i].getBook_name());
//                preparedStatement.setString(7, book[i].getDirectory());
//                preparedStatement.setString(8, book[i].getIs_popular());
//                preparedStatement.setString(9, book[i].getContent_Introduction());
//                preparedStatement.setString(10, book[i].getBook_img());
//                preparedStatement.setString(11, book[i].getPrice());
//                preparedStatement.setString(12, book[i].getBinding());
//                preparedStatement.setString(13, book[i].getReview_grade());
//                preparedStatement.setString(14, book[i].getPage_amount());
//                preparedStatement.addBatch();
//            }
//            preparedStatement.executeBatch();
//            connection.commit();
//            connection.setAutoCommit(true);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//
//        }
//    }
public void insert(Book book) {
    System.out.println(book);
    ConnectionMysql connectionMysql = new ConnectionMysql();
    Connection connection = connectionMysql.getConnection();
    PreparedStatement preparedStatement = null;
    String sql = "insert into book_information (ISBN, publish_time, author, publiseer, translators, book_name, directory, is_popular, content_Introduction, book_img, price, binding, review_grade, page_amount)"+"value (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    try {
        connection.setAutoCommit(false);
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, book.getISBN());
        preparedStatement.setString(2, book.getPutlish_time());
        preparedStatement.setString(3, book.getAuthor());
        preparedStatement.setString(4, book.getPubliseer());
        preparedStatement.setString(5, book.getTranslators());
        preparedStatement.setString(6, book.getBook_name());
        preparedStatement.setString(7, book.getDirectory());
        preparedStatement.setString(8, book.getIs_popular());
        preparedStatement.setString(9, book.getContent_Introduction());
        preparedStatement.setString(10, book.getBook_img());
        preparedStatement.setString(11, book.getPrice());
        preparedStatement.setString(12, book.getBinding());
        preparedStatement.setString(13, book.getReview_grade());
        preparedStatement.setString(14, book.getPage_amount());
        preparedStatement.addBatch();
        preparedStatement.executeBatch();
        connection.commit();
        connection.setAutoCommit(true);

    } catch (SQLException e) {
        e.printStackTrace();
    } finally {

    }
}
}
