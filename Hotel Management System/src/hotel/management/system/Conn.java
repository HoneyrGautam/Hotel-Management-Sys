/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;
/**
 *
 * @author Honey
 */
//We have five steps in JDBC Connectivity
//1. Register the driver class(MySQL driver class)
//2. Creating the connection
import java.sql.*;
public class Conn {
    //we have to create object of connection interface
    Connection c; //Connection class is used under the sql package
    //now we have to create connection string & for that we have to use another class named as DriverManager
    Statement s;
    Conn(){
        // we have some static method
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");//in the string we entered an argument i.e., driver name
            c = DriverManager.getConnection("jdbc:mysql://localhost:3307/hotelmanagementsystem","root","glad@12Honey");
            s = c.createStatement();// with this statement we can execute the querry
        }
        catch(Exception e){
            e.printStackTrace();
        }    
    }
}
