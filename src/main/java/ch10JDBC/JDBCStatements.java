package ch10JDBC;

import java.sql.*;

public class JDBCStatements {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String url = "jdbc:derby:demo";
        // in older code you might see the below line, simply it loads the class associated
        // with the database vendor driver class. This is now usually placed in the
        // META-INF/service/java.sql.Driver file so is unnecessary in newer code (JDBC-4.0)
        Class.forName("org.apache.derby.jdbc.AutoloadedDriver");
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();

             ResultSet rs = stmt.executeQuery("SELECT id,name FROM animal")) {

            while (rs.next()) {
                // getInt starts with the first column. in this case ID. It is not
                // Zero based!
                System.out.println(rs.getInt(1));
                System.out.println(rs.getString(1));
                System.out.println(rs.getString("name"));
                // there are various other get Methods, for primitive types, Objects,
                // And Timestamps / times
                // e.g. getDouble, getObject, getTime, getTimestamp etc.
            }
        }


        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();) {

            // some common errors with ResultSet and types

            // this gives invalid cursor state. The result set needs to call
            // rsTSS.next() to work
//            ResultSet rsTSS = stmt.executeQuery("SELECT id,name FROM animal");
//            rsTSS.getInt(1);

            // column value pointing to invalid cursor location
//            ResultSet rsTSX = stmt.executeQuery("SELECT id,name FROM animal");
//            rsTSX.next();
//            rsTSX.getInt(0);


        } finally {
            // close all the result sets!
        }





        try (Connection conn = DriverManager.getConnection(url);
             // Inside the statment, you can specify the type of the ResultSet
             // TYPE_SCROLL_INSENSITIVE means that it is insensitive to changes in the Result
             // Set after calling the query.
             // CONCUR_READ_ONLY means you cannot update the ResultSet.
             Statement stmt = conn.createStatement(
                     ResultSet.TYPE_SCROLL_INSENSITIVE,
                     ResultSet.CONCUR_READ_ONLY);
             ResultSet rs = stmt.executeQuery("SELECT id FROM species ORDER BY id")
             ) {
            // puts cursor to end of result set
            rs.afterLast();
            System.out.println(rs.previous());
            System.out.println(rs.getInt(1));
            System.out.println(rs.previous());
            System.out.println(rs.getInt(1));
            System.out.println(rs.last());
            System.out.println(rs.getInt(1));
            System.out.println(rs.first());
            System.out.println(rs.getInt(1));
            // Absolute gets the absolute 2nd row of the ResultSet
            System.out.println(rs.absolute(2));
            System.out.println(rs.absolute(3));
            // Relative moves forward of backward x rows from the current location
            System.out.println(rs.relative(2));

            rs.beforeFirst();
            // throws Exception - since the cursor is at an invalid location
            //System.out.println(rs.getInt(1));


            // closing DB - easier with try catch block
            // closing a Connection also closes the Statement and ResultSet
            // Close a Statement also closes the ResultSet





        } finally {

        }

    }

}
