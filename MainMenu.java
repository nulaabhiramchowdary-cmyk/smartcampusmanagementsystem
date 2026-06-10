package com.smartcampus;

import java.util.*;

public class MainMenu {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== SMART CAMPUS MANAGEMENT SYSTEM =====");

        boolean status = Login.login(sc);

        if (!status) {

            System.out.println("Invalid Login");
            return;
        }

        while (true) {

            System.out.println("\n1. Student Management");
            System.out.println("2. Faculty Management");
            System.out.println("3. Exit");

            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    StudentManagement.menu(sc);
                    break;

                case 2:
                    FacultyManagement.menu(sc);
                    break;

                case 3:
                    System.out.println("Thank You");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
