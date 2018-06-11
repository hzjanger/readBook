package config.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CloseMysql {
    public static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) throws SQLException {
        try {
            if(connection != null){
                connection.close();
            }
        } finally{
            try{
                if(preparedStatement != null){
                    preparedStatement.close();
                }
            }finally{
                if(resultSet != null){
                    resultSet.close();
                }
            }
        }

    }
}
