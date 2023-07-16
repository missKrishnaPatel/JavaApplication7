/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication7;
import java.sql.*;

public class Conn{
     Connection con;
      Statement st;
 Conn(){
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        
        String path="jdbc:mysql://localhost:3306/employeemanagementsystem";
        String username="root";
        String password="123456";
      
        con=DriverManager.getConnection(path, username, password);
        
         st=con.createStatement();
        
        
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }
   
}  

