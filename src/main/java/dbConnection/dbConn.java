/*
#Database connectivity class
 */

package dbConnection;

import java.sql.*;

import static Config.configProperties.*;

public class dbConn {
    //DB Credentials
    static String url = dbUrl;
    static String username = dbUsername;
    static String password = dbPassword;

    static Connection connection = null;
    static Statement statement = null;

    public static void connectDb(String url, String username, String password) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(url, username, password); //DB connection
    }

    public static String getActiveSurveyId() throws SQLException {

        String activeSurveyID = "";
        String query = "SELECT * FROM droobi.surveys where status = 1";

        try {

            connectDb(url, username, password);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                activeSurveyID = resultSet.getString("id");
            }

            resultSet.close();

        } catch (SQLException e) {
            System.out.println("Connection Failed!");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Connection Failed!");

            e.printStackTrace();
        } finally {
            statement.close();
            connection.close();
        }

        return activeSurveyID;
    }

}

