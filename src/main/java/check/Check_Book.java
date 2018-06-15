package check;

import config.mysql.CloseMysql;
import entity.Book;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Check_Book {

    public List<Book> getOneBook(PreparedStatement preparedStatement) {
        List<Book> list = new ArrayList<Book>();
        list.clear();
        ResultSet resultSet = null;
        try {
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Book book = new Book();
                //将获取的值存进book中
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
                list.add(book);
                if (list.size() > 7) {
                    break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                CloseMysql.close(null, preparedStatement, resultSet);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return list;
    }

    public List<Book> getResultSetBook(ResultSet resultSet) {
        List<Book> list_book = new ArrayList<Book>();
        return list_book;
    }
}
