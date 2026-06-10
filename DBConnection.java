package com.smartcampus;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    static Connection con;

    public static Connection getConnection() {

        try {

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/smart_campus",
                    "root",
                    "Rama@123"
            );

            System.out.println("Connected Successfully");

        } catch (Exception e) {

            e.printStackTrace();
        }

        return con;
    }
}
