package org.example.classByAmolMateSir.sqlDemo;

import java.sql.*;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {

        int ch;
        while (true) {
            //main choice
            System.out.println("Enter choice 0 exit , 1 - show data , 2 - insert datta");
            ch = sc.nextInt();
             MyConnection.connection();
            if (ch == 1) {
                //show data
                DataBase.showData();
            } else if (ch == 2) {
                //instert data
                DataBase.insertData();
            }else {
                //invalid input handle
                System.out.println("not valid........");
            }
            if(ch == 0){
                //break loop
                break;
            }
        }
        System.out.println("Thanking you to used Our system ...........");
    }
}