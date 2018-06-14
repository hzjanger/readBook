package dao;

import check.Check_Book;
import entity.Book;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SelectData {
    public List<Book> exact(PreparedStatement preparedStatement) {
        List<Book> list = new ArrayList<Book>();
        ResultSet resultSet = null;
        try {
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                List<Book> list_book = new Check_Book().getOneBook(preparedStatement);
                Iterator<Book> iterator = list_book.iterator();
                while (iterator.hasNext()) {
                    list.add(iterator.next());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

    }
}
