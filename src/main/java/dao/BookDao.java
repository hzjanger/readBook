package dao;

import config.mysql.CloseMysql;
import config.mysql.ConnectionMysql;
import entity.Book;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao {

    public Book selectOneBook(String ISBN) {
        Connection connection = ConnectionMysql.getConnection();
        String sql = "select * from book_information where ISBN=?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, ISBN);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Book book = new Book();
                //将获取的值存进book中
                this.getResultSetBook(resultSet, book);
                return book;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                CloseMysql.close(connection, preparedStatement, resultSet);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public List<Book> selectListBook(PreparedStatement preparedStatement) {
        List<Book> list = new ArrayList<Book>();
        ResultSet resultSet = null;
        try {
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Book book = new Book();
                this.getResultSetBook(resultSet, book);
                list.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void DeleteBook(String ISBN) {
        Connection connection = ConnectionMysql.getConnection();
        String sql = "delete from book_information where ISBN=?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, ISBN);
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

    public boolean addBook(Book book) {
        Connection connection = ConnectionMysql.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "select * from book_information where ISBN=?";
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, book.getISBN());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sql = "insert into book_information (ISBN, publish_time, author, publiseer, translators, book_name, directory, is_popular, content_Introduction, book_img, price, binding, review_grade, page_amount)" + "value (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
            try {
                CloseMysql.close(connection, preparedStatement, resultSet);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public void upDataBook(Book book) {
        Connection connection = ConnectionMysql.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "update book_information set publish_time=?,author=?,publiseer=?,translators=?,book_name=?,directory=?,is_popular=?,content_Introduction=?,book_img=?,price=?,binding=?,review_grade=?,page_amount=?,type=? where ISBN=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, book.getISBN());
            preparedStatement.setString(1, book.getPutlish_time());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setString(3, book.getPubliseer());
            preparedStatement.setString(4, book.getTranslators());
            preparedStatement.setString(5, book.getBook_name());
            preparedStatement.setString(6, book.getDirectory());
            preparedStatement.setString(7, book.getIs_popular());
            preparedStatement.setString(8, book.getContent_Introduction());
            preparedStatement.setString(9, book.getBook_img());
            preparedStatement.setString(10, book.getPrice());
            preparedStatement.setString(11, book.getBinding());
            preparedStatement.setString(12, book.getReview_grade());
            preparedStatement.setString(13, book.getPage_amount());
            preparedStatement.setString(14, book.getType());
            preparedStatement.setString(15, book.getISBN());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getResultSetBook(ResultSet resultSet, Book book) {
        try {
            book.setISBN(resultSet.getString(1));
            book.setPutlish_time(resultSet.getString(2));
            book.setAuthor(resultSet.getString(3));
            book.setPubliseer(resultSet.getString(4));
            book.setTranslators(resultSet.getString(5));
            book.setBook_name(resultSet.getString(6));
            book.setDirectory(resultSet.getString(7));
            book.setIs_popular(resultSet.getString(8));
            book.setContent_Introduction(resultSet.getString(9));
            book.setBook_img(resultSet.getString(10));
            book.setPrice(resultSet.getString(11));
            book.setBinding(resultSet.getString(12));
            book.setReview_grade(resultSet.getString(13));
            book.setPage_amount(resultSet.getString(14));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
