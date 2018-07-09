package ch10JDBC;

import java.sql.*;

public class JDBCStatements {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:derby:zoo";
        try (Connection conn = DriverManager.getConnection(url);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT name FROM animal")){

            while(rs.next()){
                System.out.println(rs.getString(1));
            }

        }


    }

}
