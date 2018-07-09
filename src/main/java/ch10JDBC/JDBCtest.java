package main.java.ch10JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCtest {

    public static void main(String[] args) throws Exception {
        String url = "jdbc:derby:demo;create=true";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate("CREATE TABLE species ("
                    + "id INTEGER PRIMARY KEY,"
                    + "name VARCHAR(255), "
                    + "num_acres DECIMAL)");
            stmt.executeUpdate("CREATE TABLE animal ("
                    + "id INTEGER PRIMARY KEY, "
                    + "Species_id integer, "
                    + "name VARCHAR(255), "
                    + "date_born TIMESTAMP");
            stmt.executeUpdate("INSERT INTO species VALUES (1,'Honey Badger', 7.7)");
            stmt.executeUpdate("INSERT INTO species VALUES (2, 'Zebra',1.2)");
            stmt.executeUpdate("INSERT INTO animal VALUES (1, 1, 'Elsa', '2001−05−06 02:15')");
            stmt.executeUpdate("INSERT INTO animal VALUES (2, 2, 'Zelda', '2002−08−15 09:12')");
            stmt.executeUpdate("INSERT INTO animal VALUES (3, 1, 'Ester', '2002−09−09 10:36')");
            stmt.executeUpdate("INSERT INTO animal VALUES (4, 1, 'Eddie', '2010−06−08 01:24')");
            stmt.executeUpdate("INSERT INTO animal VALUES (5, 2, 'Zoe', '2005−11−12 03:44')");
        }
    }

    // There are four Key interfaces for JDBC
    // The below are provided in the jdk
    // Driver, Connection, Statement, and ResultSet

    // 1. Driver gets a connection to the database

    // 2. Connection knows how to communicate with the DB

    // 3. statement Knows how to run the SQL

    // 4. Knows what is returned by the SELECT query

    // each one is linked to a vendor specific implementation
    // i.e. MySQLDriver, MySQLConnection, MySQLStatement, etc.


}