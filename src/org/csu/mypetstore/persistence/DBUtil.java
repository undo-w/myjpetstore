package org.csu.mypetstore.persistence;

import java.sql.*;

public class DBUtil {
    private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
    private static final String URL="jdbc:mysql://localhost:3306/mypetstore?useSSL=false&useUnicode=true&characterEncoding=utf-8&autoReconnect=true&serverTimezone=Asia/Shanghai";
    private static final String USERNAME ="root";
    private static final String PASSWORD = "20021101";

    public static Connection getConnection()throws Exception{
        Class.forName(DRIVER_CLASS);
        Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        return connection;
    }

    public static void closeConnection(Connection connection)throws Exception{
        if(connection!=null)
            connection.close();
    }
    public static void closeStatement(Statement statement) throws SQLException {
        if(statement!=null){
            statement.close();
        }
    }

    public static void closePreparedStatement(PreparedStatement preparedStatement) throws SQLException {
        if(preparedStatement!=null){
            preparedStatement.close();
        }
    }

    public static void closeResultSet(ResultSet resultSet) throws SQLException {
        if(resultSet!=null){
            resultSet.close();
        }
    }
}
