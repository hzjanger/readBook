package layout;

import check.Check_Book;
import config.mysql.CloseMysql;
import config.mysql.ConnectionMysql;
import entity.Book;

import java.sql.*;
import java.util.Iterator;
import java.util.List;

public class PopularBook extends ShowBook{

    public PopularBook() {
        super();
    }

    public void getPopularBook() {
        ConnectionMysql connectionMysql = new ConnectionMysql();
        Connection connection = connectionMysql.getConnection();
        String select_max = "select * from book_information order by review_grade desc";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(select_max);
            List<Book> list_book = new Check_Book().getOneBook(preparedStatement);

            Iterator<Book> iterator_book = list_book.iterator();
            while (iterator_book.hasNext()) {
                Book book = iterator_book.next();
                this.getList().add(book);
            }
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
}
