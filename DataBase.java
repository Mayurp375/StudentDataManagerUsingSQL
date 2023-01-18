package org.example.classByAmolMateSir.sqlDemo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class DataBase {
    static Scanner sc = new Scanner(System.in);

    public static void showData() throws SQLException {
        MyConnection con = new MyConnection();
        String query = "select * from student";
        Connection root = MyConnection.connection(); //method called
        Statement statement = root.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
//list
        List<Bridglab> employeeList = new ArrayList<Bridglab>();

        while (resultSet.next()) {
            Bridglab employee = new Bridglab();
            employee.setId(resultSet.getInt(1));
            employee.setName(resultSet.getString(2));
            employee.setRollNo(resultSet.getInt(4));
            employee.setMarks(resultSet.getDouble(5));
            employee.setAge(resultSet.getInt(3));
            employeeList.add(employee);
        }
        //Iterator
        Iterator<Bridglab> iterator = employeeList.iterator();
        while (iterator.hasNext()) {
            System.out.println("++++++++++++++++++++++");
            Bridglab next = iterator.next();
            System.out.println(next);
            System.out.println("++++++++++++++++++++++");
        }
    }

    //insert value
    public static void insertData() throws SQLException {
        System.out.println("Enter name :");
        String name = sc.nextLine();
        System.out.println("Enter age :");
        int age = sc.nextInt();
        System.out.println("Enter roll :");
        int roll = sc.nextInt();
        System.out.println("Enter mark :");
        double mark = sc.nextDouble();
//query
        String q = "insert into student(name,age,rollNo,marks)values('" + name + "'," + age + "," + roll + "," + mark + ");";
        Connection root = MyConnection.connection();
        Statement statement = root.createStatement();
        //if added
        int resultSet = statement.executeUpdate(q);
        if (resultSet == 1) {
            System.out.println("added Successfully...........");
        } else {
            System.out.println("Something went wrong........");
        }
        root.close(); //closed connection
    }

    public static void updateData(int id,String  name) throws SQLException {
        String q = "update student set name ="+ name+ " where id " + "=" + id;
        Connection root = MyConnection.connection();
        Statement statement = root.createStatement();
        int resultSet = statement.executeUpdate(q);
        if (resultSet == 1) {
            System.out.println("update Successfully...........");
        } else {
            System.out.println("Something went wrong........");
        }
        root.close(); //closed connection
    }

    public static void deleteData(int id) throws SQLException {

        String q = "delete from student where id " + "=" + id;
        Connection root = MyConnection.connection();
        Statement statement = root.createStatement();
        int resultSet = statement.executeUpdate(q);
        if (resultSet == 1) {
            System.out.println("update Successfully...........");
        } else {
            System.out.println("Something went wrong........");
        }
        root.close(); //closed connection
    }
}
