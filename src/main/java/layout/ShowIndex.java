package layout;

import check.Check_Book;
import config.mysql.CloseMysql;
import config.mysql.ConnectionMysql;
import entity.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShowIndex extends ShowBook{

    public ShowIndex() {
        super();
    }
    public void getBook(String value) {

        if (value == null || "".equals(value)) {
            value = "root";
        }

        ConnectionMysql connectionMysql = new ConnectionMysql();
        Connection connection = connectionMysql.getConnection();
        String select_user = "select * from recommend where user=?";
        PreparedStatement preparedStatement = null;
        List<String> ISBN = new ArrayList<String>();
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(select_user);
            preparedStatement.setString(1, value);
            //得到一个查找ISBN的结果集
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String str = resultSet.getString(1);
                //将得到的书的ISBN放到一个List数组中
                ISBN.add(str);
            }

            Iterator<String> iterator = ISBN.iterator();
            while (iterator.hasNext()) {
//                通过迭代遍历这个数组，然后得到书的信息
                String select_ISBN = "select * from book_information where ISBN=?";
                preparedStatement = connection.prepareStatement(select_ISBN);
                preparedStatement.setString(1, iterator.next());
                //这里是得到书的信息
                List<Book> list_book = new Check_Book().getOneBook(preparedStatement);
                Iterator<Book> iterator_book = list_book.iterator();
                while (iterator_book.hasNext()) {
                    Book book = iterator_book.next();
                    this.getList().add(book);
                }

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
    }
}
