/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hotel.management.system;
/**
 * @author Honey
 */
//we are using here swings concept
//all the concept of swings are stored in a seperate class i.e., JFrames
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class HotelManagementSystem extends JFrame implements ActionListener{
    //implement ActionListener help to catch the actions applied on any button
    //actions like : clicking or draging on the button etc.
    //and for this we imported awt package of event of java
    //and for the error occoured in class name we use to override the class
    HotelManagementSystem(){
        setSize(1366,565);
        setLocation(100,100);// with respect to screen
        //this will fix the border location from left and top respectively
        //"ImageIcon" is a datatype according to the syntax
        setBounds(100,100,1366,565);
        setLayout(null); //this removes the default border layout
        //we can make layout by using setBounds() function
        
        //to opt any icon from file directory we use a class "ImageIcon"
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        //classLoader is a class to load the image
        //getSystemResources is use to take the image from system
        //in the string of braces their is url of the image
        //we cannot use icon directly into the frame it need a class called "JLable"
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,1366,565);//with respect to frame
        // it takes 4 properties
        //location from X&Y, length and breadth
        //to apply/add anything on the frame we have to use add() function
        add(image);
        //border layout applies bydefault
        //for writing over the frame we use JLabel
        //main use of JLabel is to write the text over the frame
        JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
        //now we use setBound to set over the frame
        text.setBounds(20,430,1500,50);
        text.setForeground(Color.WHITE);//Color and all editing of fonts are in awt package
        text.setFont(new Font("serif",Font.PLAIN,50));
        image.add(text);
        
        JButton next = new JButton("Next");//this is use to give the button
        next.setBounds(1150,450,150,50);
        next.setBackground(Color.WHITE);
        next.setForeground(Color.BLACK);
        next.addActionListener(this);
        next.setFont(new Font("serif",Font.PLAIN,32));
        image.add(next);
        
        setVisible(true);// this is use to apply the image size
        //in the frame, text over the poster is blinking in every mili second
        //for displaying in style blinking we need to extend the blinking time
        //for blinking we use the concept of error handling
        while(true){
            text.setVisible(false);
            try{                      // to hit the data in MySql we use try-catch method
                Thread.sleep(500);    // try-catch method also known as exception handling
            }
            catch(Exception e){
                e.printStackTrace();
            }
            text.setVisible(true);
            try{
                Thread.sleep(500);
            }
            catch(Exception e){
                e.printStackTrace();
            }
            text.setVisible(true);
            try{
                Thread.sleep(500);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public void actionPerformed(ActionEvent ae){
        //in this section we have to describe that what to perform
        setVisible(false);// this is use to close the current frame
        new Loginpage();
    }
    public static void main(String[] args){
        new HotelManagementSystem();
    }
}
