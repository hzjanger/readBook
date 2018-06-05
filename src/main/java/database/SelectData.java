package database;

import entity.Book;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelectData {
    public List<Book> exact(PreparedStatement preparedStatement) {
        List<Book> list = new ArrayList<Book>();
        ResultSet resultSet = null;
        try {
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Book book = new Book();
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
                System.out.println(book);
                list.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

    }
}
