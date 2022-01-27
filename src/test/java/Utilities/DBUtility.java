package Utilities;

import batchTests.Scope_Run;

import java.sql.*;

public class DBUtility {
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(ConfigurationReader.getProperty("ssmsDB_url")+Scope_Run.scopeOfWork,
                ConfigurationReader.getProperty("ssmsDB_UserName"),
                ConfigurationReader.getProperty("ssmsDB_Password"));
    }

    private static Connection connection;
    private static PreparedStatement statement;
    private static ResultSet resultSet;

    public static void establishConnection(){
        System.out.println("Database URL: "+ ConfigurationReader.getProperty("ssmsDB_url")+Scope_Run.database);
        try{
            connection = DriverManager.getConnection(ConfigurationReader.getProperty("ssmsDB_url")+Scope_Run.database,
                    ConfigurationReader.getProperty("ssmsDB_UserName"),
                    ConfigurationReader.getProperty("ssmsDB_Password"));
           System.out.println("Database URL: "+ ConfigurationReader.getProperty("ssmsDB_url")+Scope_Run.database);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        System.out.println("Connection Successful");
    }

    public static void runSQLQuery(String sql){
        try{
            statement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            statement.execute();
            System.out.println("SQL Query executed successfully");
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static void closeConnections() {
        try {
            if (resultSet != null && !resultSet.isClosed()) {
                resultSet.close();
            }
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
            System.out.println("Run has been completed !!! Database connection has been disconnected");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

