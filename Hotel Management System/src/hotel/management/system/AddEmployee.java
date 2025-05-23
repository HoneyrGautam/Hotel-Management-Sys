/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class AddEmployee extends JFrame implements ActionListener{
    boolean check = true;
    JTextField tfname, tfemail, tfphone, tfage, tfsalary, tfadhaar;
    JRadioButton rbmale, rbfemale;
    JButton submit;
    JComboBox cbjob;
    AddEmployee(){
        setLayout(null);
        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(60, 30, 120, 30);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblname);
        
        tfname = new JTextField(20);
        tfname.setBounds(200, 30, 150, 30);
        add(tfname);
        
        JLabel lblage = new JLabel("AGE");
        lblage.setBounds(60, 80, 120, 30);
        lblage.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblage);
        
        tfage = new JTextField();
        tfage.setBounds(200, 80, 150, 30);
        add(tfage);
        
        JLabel lblgender = new JLabel("GENDER");
        lblgender.setBounds(60, 130, 120, 30);
        lblgender.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblgender);
        
        rbmale = new JRadioButton("Male");//class used for radio buttons
        rbmale.setBounds(200, 130, 70, 30);
        rbmale.setFont(new Font("Tahoma",Font.PLAIN,14));
        rbmale.setBackground(Color.WHITE);
        add(rbmale);
        
        rbfemale = new JRadioButton("Female");//class used for radio buttons
        rbfemale.setBounds(280, 130, 70, 30);
        rbfemale.setFont(new Font("Tahoma",Font.PLAIN,14));
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);
        
        ButtonGroup bg = new ButtonGroup(); //this class is use to choose single option in radio buttons
        bg.add(rbmale);
        bg.add(rbfemale);
        
        JLabel lbljob = new JLabel("JOB");
        lbljob.setBounds(60, 180, 120, 30);
        lbljob.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lbljob);
        
        String str[]={"Manager","Accountant","Waiter/Waitress","Chefs","Room Service","Kitchen Staff","House Keeping","Porters","Front Desk Clerk"};
        cbjob = new JComboBox(str);
        cbjob.setBounds(200, 180, 150, 30);
        cbjob.setBackground(Color.WHITE);
        add(cbjob);
        
        JLabel lblsalary = new JLabel("SALARY");
        lblsalary.setBounds(60, 230, 120, 30);
        lblsalary.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblsalary);
        
        tfsalary = new JTextField();
        tfsalary.setBounds(200, 230, 150, 30);
        add(tfsalary);
        
        JLabel lblphone = new JLabel("PHONE NO.");
        lblphone.setBounds(60, 280, 120, 30);
        lblphone.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblphone);
        
        tfphone = new JTextField(10);
        tfphone.setBounds(200, 280, 150, 30);
        add(tfphone);
        
        JLabel lblemail = new JLabel("EMAIL ID");
        lblemail.setBounds(60, 330, 120, 30);
        lblemail.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblemail);
        
        tfemail = new JTextField(50);
        tfemail.setBounds(200, 330, 150, 30);
        add(tfemail);
        
        JLabel lbladhaar = new JLabel("ADHAAR ID");
        lbladhaar.setBounds(60, 380, 120, 30);
        lbladhaar.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lbladhaar);
        
        tfadhaar = new JTextField(12);
        tfadhaar.setBounds(200, 380, 150, 30);
        add(tfadhaar);
        
        submit = new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(200, 430, 150, 30);
        submit.addActionListener(this);
        add(submit);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380, 60, 450, 370);
        add(image);
        
        getContentPane().setBackground(Color.WHITE);
        setBounds(350, 200, 850, 540);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String name = tfname.getText();
        String age = tfage.getText();
        String phone = tfphone.getText();
        String salary = tfsalary.getText();
        String email = tfemail.getText();
        String adhaar = tfadhaar.getText();
        
        String gender = null;
        
        if(name.equals("")){
            JOptionPane.showMessageDialog(null, "Name should not be empty");
            check = false;
            return;
        }
        if(age.equals("")){
            JOptionPane.showMessageDialog(null, "Age should not be empty");
            check = false;
            return;
        }
        if(salary.equals("")){
            JOptionPane.showMessageDialog(null, "Salary should not be empty");
            check = false;
            return;
        }
        if(phone.equals("")){
            JOptionPane.showMessageDialog(null, "Phone no. should not be empty");
            check = false;
            return;
        }
        if(adhaar.equals("")){
            JOptionPane.showMessageDialog(null, "Adhaar should not be empty");
            check = false;
            return;
        }
        if(email.equals("") && email.contains("@gmail.com")){
            JOptionPane.showMessageDialog(null, "Name should not be empty");
            check = false;
            return;
        }
        if(rbmale.isSelected()){
            gender = "MALE";
        }
        else if(rbfemale.isSelected()){
            gender = "FEMALE";
        }
        String job = (String) cbjob.getSelectedItem();
        if(check==true){
            try{
                Conn conn = new Conn();
                String query = "insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"','"+adhaar+"')";
                //String query = "insert into employee (name,age,gender,job,salary,phone,email,adhaar) select '"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"','"+adhaar+"' where '"+email+"' like '%gmail.com'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee added successfully");
                setVisible(false);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String args[]){
        new AddEmployee();
    }
}
