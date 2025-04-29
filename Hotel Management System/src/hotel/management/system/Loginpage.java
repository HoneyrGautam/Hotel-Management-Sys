/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
/**
 *
 * @author Honey
 */
public class Loginpage extends JFrame implements ActionListener{
    JTextField username;
    JPasswordField password;
    JButton login, cancel;
    Loginpage(){
        getContentPane().setBackground(Color.WHITE);
        //above function is use to give the background color of the page
        //and for using the function we import the awt package
        
        setLayout(null);  // this is for removing the default layout
        
        JLabel user = new JLabel("User Name");  // for instruction of username to enter
        user.setBounds(40, 20, 100, 30);
        add(user);
        //for entering the data we have to create the text field
        username = new JTextField();
        username.setBounds(150, 20, 150, 30);
        add(username);
        
        JLabel pass = new JLabel("Password");
        pass.setBounds(40, 70, 100, 30);
        add(pass);
        password = new JPasswordField();
        password.setBounds(150, 70, 150, 30);
        add(password);
        
        login = new JButton("LOG-IN"); //this is for creating a button
        login.setBounds(40, 150, 120, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        cancel = new JButton("CANCEL"); //this is for creating a button
        cancel.setBounds(180, 150, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
        //now for logo of login page
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        // now we cannot place the image directly to the JLabel
        //so we have to convert image class to imageIcon
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3); // then we can place the image
        image.setBounds(350,10,200,200);
        add(image); // to crop/scale the image we use an image class
        
        setBounds(500,200,600,300);
        setVisible(true);
    }
    //for accessing the textfield in actionEvent we have to defined it globally
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==login){
            String user = username.getText();
            String pass = password.getText();
            try{
                Conn c = new Conn();
                String query = "select*from login where username = '" +user+ "'and password ='"+ pass+"'";
                ResultSet rs = c.s.executeQuery(query);//to get data from the database, data need
                //-to store in the object of ResultSet
                //ResultSet class is used under the SQL package
                //now we have to check that data is present in database or not
                if(rs.next()){
                    setVisible(false);
                    new Dashboard();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                    setVisible(false);
                    new Loginpage();
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==cancel){
            setVisible(false);
        }
    }
    public static void main(String args[]){
        new Loginpage();
    }
}
