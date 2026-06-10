package com.smartcampus;

import java.sql.*;
import java.util.Scanner;

public class StudentManagement {

    public static void menu(Scanner sc) {

        while (true) {

            System.out.println("\n--- Student Management ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Delete Student");
            System.out.println("4. Back");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addStudent(sc);
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    deleteStudent(sc);
                    break;

                case 4:
                    return;
            }
        }
    }

    static void addStudent(Scanner sc) {

        try {

            Connection con = DBConnection.getConnection();

            System.out.print("ID: ");
            int id = sc.nextInt();

            System.out.print("Name: ");
            String name = sc.next();

            System.out.print("Course: ");
            String course = sc.next();

            System.out.print("Year: ");
            int year = sc.nextInt();

            System.out.print("Email: ");
            String email = sc.next();

            String query =
                    "INSERT INTO students VALUES(?,?,?,?,?)";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, course);
            ps.setInt(4, year);
            ps.setString(5, email);

            ps.executeUpdate();

            System.out.println("Student Added");

        } catch (Exception e) {

            System.out.println(e);
        }
    }

    static void viewStudents() {

        try {

            Connection con = DBConnection.getConnection();

            Statement st = con.createStatement();

            ResultSet rs =
                    st.executeQuery("SELECT * FROM students");

            while (rs.next()) {

                System.out.println(
                        rs.getInt(1) + " " +
                                rs.getString(2) + " " +
                                rs.getString(3)
                );
            }

        } catch (Exception e) {

            System.out.println(e);
        }
    }

    static void deleteStudent(Scanner sc) {

        try {

            Connection con = DBConnection.getConnection();

            System.out.print("Enter Student ID: ");

            int id = sc.nextInt();

            PreparedStatement ps =
                    con.prepareStatement(
                            "DELETE FROM students WHERE student_id=?"
                    );

            ps.setInt(1, id);

            ps.executeUpdate();

            System.out.println("Student Deleted");

        } catch (Exception e) {

            System.out.println(e);
        }
    }
}
