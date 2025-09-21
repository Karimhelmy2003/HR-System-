package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Dbconnection {
    String url = "jdbc:sqlite:company.db";


    public void cretaetable() {
        String url = "jdbc:sqlite:company.db";
        String query ="""
    CREATE TABLE IF NOT EXISTS employees (
      id INTEGER PRIMARY KEY AUTOINCREMENT,
      name TEXT NOT NULL,
      title TEXT,
      salary REAL
   );
    """ ;




        // Establish connection
        Connection con = null;
        try {
            con = DriverManager.getConnection(url);

            System.out.println("Connection Established successfully");

            // Create a statement
            Statement st = con.createStatement();

            // Execute the query
            st.executeUpdate(query);

            // Close the statement and connection
            st.close();
            con.close();
            System.out.println("Connection Closed....");
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Emolyee>retermployes(){

        ArrayList<Emolyee>employees=new ArrayList<>();


        String url = "jdbc:sqlite:company.db";
        String query ="""
    Select * from employees
    
    """ ;

        Connection con = null;
        try {
            con = DriverManager.getConnection(url);

            System.out.println("Connection Established successfully");

            // Create a statement
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

        while (rs.next()) {
            Emolyee employee=new Emolyee();
            int id = rs.getInt("id");
            employee.setId(id);

            String name = rs.getString("name");
            employee.setName(name);

            String title=rs.getString("title");
            employee.setTitle(title);

            double salary=rs.getDouble("salary");
            employee.setSalary(salary);

            employees.add(employee);

            System.out.println(employees);



            // Retrieve name from db

        }

            st.close();
            con.close();
            System.out.println("Connection Closed....");

    }catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return employees;
}
    public Emolyee addemployeedb(Emolyee empolyee){
        String url = "jdbc:sqlite:company.db";
        String query ="""
    INSERT INTO employees (name, title, salary) VALUES (?, ?, ?)
   
    
    """ ;
        try (Connection con = DriverManager.getConnection(url);
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setString(1, empolyee.getName());
            pstmt.setString(2, empolyee.getTitle());
            pstmt.setDouble(3, empolyee.getSalary());

            pstmt.executeUpdate();

            System.out.println("Employee inserted successfully!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return empolyee;



} //udate ha5od emloyeee object w id , delete a5od id a delete


    public void updateemployee(int id , Emolyee updateemolyee){
        String url = "jdbc:sqlite:company.db";    // hwa deh lazem a3mlhaa fe kol function ?
        String sql = "UPDATE employees SET name = ?, title = ?, salary = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Set the values from the Employee object
            pstmt.setString(1, updateemolyee.getName());
            pstmt.setString(2, updateemolyee.getTitle());
            pstmt.setDouble(3, updateemolyee.getSalary());
            pstmt.setInt(4, id);

            pstmt.executeUpdate();
            System.out.println("The employee updated succefully");


        }catch (SQLException e) {
            throw new RuntimeException(e);
        }




    }
    public void deleteemployee(int id ){
        String sql = "DELETE FROM employees WHERE id=?";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate(); // هنفذ وخلاص
            System.out.println("Delete operation executed.");

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }
    public void resetEmployeesTable() {
        try (Connection con = DriverManager.getConnection(url);
             Statement st = con.createStatement()) {

            st.executeUpdate("DELETE FROM employees");

            st.executeUpdate("DELETE FROM sqlite_sequence WHERE name='employees'");

            System.out.println("Employees table reset to start from 1");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




}


