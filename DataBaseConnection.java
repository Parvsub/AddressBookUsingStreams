package AddressBookUsingStreams;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DataBaseConnection {
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    DataBaseConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbookservices", "root", "password");
            System.out.println("connection established........");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void display() throws Exception {
        preparedStatement = connection.prepareStatement("SELECT * FROM addressbooks;");
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3)
                    + " " + resultSet.getString(4) + "  " + resultSet.getString(5)
                    + "  " + resultSet.getString(6) + "  " + resultSet.getString(7)
                    + "  " + resultSet.getString(8) + "  " + resultSet.getString(9)
                    + "  " + resultSet.getString(10));
        }

    }

    public void close() throws Exception {
        connection.close();
    }

    public static void main(String[] args) throws Exception {
        DataBaseConnection dataObj = new DataBaseConnection();
        dataObj.display();
    }
}
