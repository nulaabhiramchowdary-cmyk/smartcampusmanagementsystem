package com.smartcampus;

import java.sql.*;
import java.util.Scanner;

public class Login {

    public static boolean login(Scanner sc) {

        try {

            Connection con = DBConnection.getConnection();

            System.out.print("Username: ");
            String username = sc.next();

            System.out.print("Password: ");
            String password = sc.next();

            String query =
                    "SELECT * FROM users WHERE username=? AND password=?";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (Exception e) {

            System.out.println(e);
        }

        return false;
    }
}
