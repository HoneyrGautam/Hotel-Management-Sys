/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Dashboard extends JFrame implements ActionListener{
    Dashboard(){
        setBounds(0, 0, 1550, 1000);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/vihasta123.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1550, 1000);
        add(image);
        
        JLabel text = new JLabel("THE VIHASTA GROUP WELCOMES YOU");
        text.setBounds(300, 80, 1000, 50);
        text.setFont(new Font("Tahoma", Font.BOLD, 50));
        text.setForeground(Color.WHITE);
        image.add(text);
        
        JMenuBar mb = new JMenuBar(); //JMenuBar is use to create menux
        mb.setBounds(0, 0, 1550, 30);
        image.add(mb);
        
        JMenu admin = new JMenu("ADMIN");//JMenu is use to give the menu in MenuBar
        admin.setForeground(Color.RED);
        mb.add(admin);
        
        JMenu hotel = new JMenu("Hotel Management");//JMenu is use to give the menu in MenuBar
        hotel.setForeground(Color.BLUE);
        mb.add(hotel);
        
        JMenuItem reception = new JMenuItem("RECEPTION");//JMenuItem is use to give the menu items
        reception.addActionListener(this);
        hotel.add(reception);
        
        JMenuItem addemployee = new JMenuItem("ADD EMPLOYEE");
        addemployee.addActionListener(this);
        admin.add(addemployee);
        
        JMenuItem addrooms = new JMenuItem("ADD ROOMS");
        addrooms.addActionListener(this);
        admin.add(addrooms);
        
        JMenuItem adddrivers = new JMenuItem("ADD DRIVERS");
        adddrivers.addActionListener(this);
        admin.add(adddrivers);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("ADD EMPLOYEE")){
            new AddEmployee();
        }
        else if(ae.getActionCommand().equals("ADD ROOMS")){
            new AddRooms();
        }
        else if(ae.getActionCommand().equals("ADD DRIVERS")){
            new AddDriver();
        }
        else if(ae.getActionCommand().equals("RECEPTION")){
            new Reception();
        }
    }
    public static void main(String args[]){
        new Dashboard();
    }
}
