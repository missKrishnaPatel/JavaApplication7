
package javaapplication7;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateEmployee extends JFrame implements ActionListener{
    
    JTextField tfeducation,tffname,tfmname,tfaddress,tfphone,tfemail,tfsalary,tfdesignation;
    
    JLabel lblempid,lblaadhar,lblname;
    JButton add,back;
    String empId;
    
    UpdateEmployee(String empId){
        this.empId=empId;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading=new JLabel("Update Employee Detail");
        heading.setBounds(320,20,500,50);
        heading.setFont(new Font("san_serif",Font.BOLD,25));
        add(heading);
        
        JLabel labelname=new JLabel("Name");
        labelname.setBounds(50,150,150,30);
        labelname.setFont(new Font("serif",Font.PLAIN,15));
        add(labelname);
        
         JLabel lblname=new JLabel();
        lblname.setBounds(200,150,150,30);
        add(lblname);
        
        JLabel labelfname=new JLabel("Father's Name");
        labelfname.setBounds(400,150,150,30);
        labelfname.setFont(new Font("serif",Font.PLAIN,15));
        add(labelfname);
        
         tffname=new JTextField();
        tffname.setBounds(600,150,150,30);
        add(tffname);
        
        JLabel labelmname=new JLabel("Name");
        labelmname.setBounds(50,200,150,30);
        labelmname.setFont(new Font("serif",Font.PLAIN,15));
        add(labelmname);
        
        tfmname=new JTextField();
        tfmname.setBounds(200,200,150,30);
        add(tfmname);
        
        JLabel labelsalary=new JLabel("Salary");
        labelsalary.setBounds(400,200,150,30);
        labelsalary.setFont(new Font("serif",Font.PLAIN,15));
        add(labelsalary);
        
         tfsalary=new JTextField();
        tfsalary.setBounds(600,200,150,30);
        add(tfsalary);
        
        JLabel labeladdress=new JLabel("Adress");
        labeladdress.setBounds(50,250,150,30);
        labeladdress.setFont(new Font("serif",Font.PLAIN,15));
        add(labeladdress);
        
         tfaddress=new JTextField();
        tfaddress.setBounds(200,250,150,30);
        add(tfaddress);
        
         JLabel labelphone=new JLabel("Phone No.");
        labelphone.setBounds(400,250,150,30);
        labelphone.setFont(new Font("serif",Font.PLAIN,15));
        add(labelphone);
        
         tfphone=new JTextField();
        tfphone.setBounds(600,250,150,30);
        add(tfphone);
        
        JLabel labelemail=new JLabel("Email Address");
        labelemail.setBounds(50,300,150,30);
        labelemail.setFont(new Font("serif",Font.PLAIN,15));
        add(labelemail);
        
         tfemail=new JTextField();
        tfemail.setBounds(200,300,150,30);
        add(tfemail);
        
        JLabel labeleducation=new JLabel("Highest Education");
        labeleducation.setBounds(400,300,150,30);
        labeleducation.setFont(new Font("serif",Font.PLAIN,15));
        add(labeleducation);
        
        //String course[] ={"BBA","BCA","BA","BSc","B.COM","BTech","MCA","MBA","MSC"};
        
         tfeducation=new JTextField();
        //tfeducation.setBackground(Color.white);
        tfeducation.setBounds(600,300,150,30);
        add(tfeducation);
        
        JLabel labeldesignation = new JLabel("Designation");
        labeldesignation.setBounds(50,350,150,30);
        labeldesignation.setFont(new Font("serif",Font.PLAIN,15));
        add(labeldesignation);
        
        tfdesignation=new JTextField();
        tfdesignation.setBounds(200,350,150,30);
        add(tfdesignation);
        
         JLabel labelaadhar=new JLabel("Adhar No.");
        labelaadhar.setBounds(400,350,150,30);
        labelaadhar.setFont(new Font("serif",Font.PLAIN,15));
        add(labelaadhar);
        
           lblaadhar=new JLabel();
        lblaadhar.setBounds(600,350,150,30);
        add(lblaadhar);
        
        JLabel labelempId=new JLabel("Employee ID");
        labelempId.setBounds(50,400,150,30);
        labelempId.setFont(new Font("serif",Font.PLAIN,15));
        add(labelempId);
        
        lblempid=new JLabel();
        lblempid.setBounds(200,400,150,30);
        lblempid.setFont(new Font("serif",Font.PLAIN,15));
        add(lblempid);
        
        try{
            Conn c=new Conn();
            String query="select * from employee where empId='"+empId+"'";
            ResultSet rs =c.st.executeQuery(query);
            while(rs.next()){
                lblname.setText(rs.getString("name"));
                tffname.setText(rs.getString("fname"));
                 tfmname.setText(rs.getString("mname"));
                  tfsalary.setText(rs.getString("salary"));
                  tfphone.setText(rs.getString("phone"));
                   tfaddress.setText(rs.getString("address"));
                    tfemail.setText(rs.getString("email"));
                     tfdesignation.setText(rs.getString("designation"));
                      tfeducation.setText(rs.getString("education"));
                       lblaadhar.setText(rs.getString("aadhar"));
                        lblempid.setText(rs.getString("empId"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
          add= new JButton("Update Details");
        add.setBounds(250,500,150,40);
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        add.addActionListener(this);
       add(add);
       
         back= new JButton("Back");
        back.setBounds(450,500,150,40);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
       back.addActionListener(this);
       add(back);
       
        
        
        setSize(900,700);
        setLocation(300,50);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){
            //String name=lblname.getText();
            String fname=tffname.getText();
            String mname=tfmname.getText();
            String salary=tfsalary.getText();
            String phone=tfphone.getText();
            String address=tfaddress.getText();
            String email=tfemail.getText();
            String education= tfeducation.getText();
            String designation=tfdesignation.getText();
            //String aadhar=lblaadhar.getText();
            //String empId=lblempid.getText();
            
            try{
                Conn conn =new Conn();
                String query = "update  employee set fname = '"+fname+"',mname = '"+mname+"',salary = '"+salary+"',address = '"+address+"',phone = '"+phone+"', email = '"+email+"',education = '"+education+"',designation = '"+designation+"' where empId ='"+empId+"'";
            conn.st.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Details Updated  successfully");
            setVisible(false);
            new Home();
            
            }catch (Exception e){
                e.printStackTrace();
            }
            
        }else{
            setVisible(false);
            new Home();
        }
    }
    
    public static void main(String[] args){
       new UpdateEmployee("");
    }
    
}
