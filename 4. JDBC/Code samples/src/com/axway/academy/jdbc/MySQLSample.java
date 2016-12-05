package com.axway.academy.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class MySQLSample {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = /*"com.mysql.jdbc.Driver"; */("oracle.jdbc.driver.OracleDriver");
    static final String DB_URL = /*"jdbc:mysql://10.232.15.140/academy"; */"jdbc:oracle:thin:@10.232.14.253:1521:ORCL";

    // Database credentials
    static final String USER = "academy";
    static final String PASS = "123";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        PreparedStatement preparedStatement = null;
        try {
            // STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT id, value FROM sample";
            ResultSet rs = stmt.executeQuery(sql);
            
            // STEP 5: Extract data from result set
            while (rs.next()) {
                // Retrieve by column name
                int id = rs.getInt("id");
                String value = rs.getString("value");

                // Display values
                System.out.print("ID: " + id);
                System.out.println(", value: " + value);
            }


            // STEP 4: Execute a query
            System.out.println("Creating insert preapared statement...");
            String insertQyery = "insert into sample (value) values (?)";
            preparedStatement = conn.prepareStatement(insertQyery, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, "value2");
            preparedStatement.executeUpdate(); 
            ResultSet rsGenKey = preparedStatement.getGeneratedKeys();
            if(rsGenKey.next())
            {
                int last_inserted_id = rsGenKey.getInt(1);
                System.out.println("lastly inserted ID = " + last_inserted_id);
            }            
            
            // STEP 4: Execute a query
            System.out.println("Creating preapared statement...");
            preparedStatement = conn.prepareStatement("select * from sample where value like ?");
            preparedStatement.setString(1, "val%");
            rs = preparedStatement.executeQuery(sql);

            // STEP 5: Extract data from result set
            while (rs.next()) {
                // Retrieve by column name
                int id = rs.getInt("id");
                String value = rs.getString("value");

                // Display values
                System.out.print("ID: " + id);
                System.out.print(", value: " + value);
            }
            // STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            } // nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            } // end finally try
        } // end try
    }// end main
}
