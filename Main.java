package org.example.classByAmolMateSir.sqlDemo;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        int ch;
        while (true) {
            //main choice
            System.out.println("Enter choice 0 exit , 1 - show data , 2 - insert datta , 3- update , 4 - delete data");
            ch = sc.nextInt();
            MyConnection.connection();
            int id = 0;
            String name = " ";
            if (ch == 1) {
                //show data
                DataBase.showData();
            } else if (ch == 2) {
                //instert data
                DataBase.insertData();
            } else if (ch == 3) {
                System.out.println("enter name");
                name = sc.nextLine();
                System.out.println("enter id");
                id = sc.nextInt();
                DataBase.updateData(id, name);
            } else if (ch == 4) {
                //delete
                System.out.println("enter id");
                id = sc.nextInt();
                DataBase.deleteData(id);
            } else {
                //invalid input handle
                System.out.println("not valid........");
            }
                if (ch == 0) {
                    //break loop
                    break;
                }
            }
            System.out.println("Thanking you to used Our system ...........");
        }
    }