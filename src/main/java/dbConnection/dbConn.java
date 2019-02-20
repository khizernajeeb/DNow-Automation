package dbConnection;

import java.sql.*;

import static Config.configProperties.Password;
import static Config.configProperties.Url;
import static Config.configProperties.UserName;

public class dbConn {
    //DB Credentials
    static String url = Url;
    static String username = UserName;
    static String password = Password;

    static Connection connection = null;
    static Statement statement = null;

    public static void connectDb(String url, String username, String password) throws ClassNotFoundException, SQLException {

        Class.forName("oracle.jdbc.driver.OracleDriver"); // load sql driver
        connection = DriverManager.getConnection(url, username, password); //DB connection
    }

    public static String getVerificationCode() throws SQLException {

        String Verif_Code = "";
        String query =
                "select * from VJ_EXTERNAL_APP_CONFIG " +
                        "where key = 'DUMMY_VERIFICATION_CODE' ";

        try {

            connectDb(url, username, password);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Verif_Code = resultSet.getString("VALUE");
                //System.out.println(Verif_Code);
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

        return Verif_Code;
    }

}

