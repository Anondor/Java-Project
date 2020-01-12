package edu.juniv.cse;


import edu.juniv.cse.auth.Auth;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

class User_information implements ActionListener{
    JFrame f;
    JLabel id8,id,aid,id1,aid1,id2,aid2,id3,aid3,id4,aid4,id5,aid5,id6,aid6,id7,aid7,id9,id10,id11,id12,id13,id14,id15,id16,id17,lab;
    String f_name,l_name,address,phone,age,dob,user_id;
    JButton b1,b2;
    ImageIcon icon;

    User_information(){
        try{
            Auth auth =new Auth();
            Conn con = new Conn();
            String str = "select * from user where user_id = '"+auth.loggedIn+"'";
            ResultSet rs= con.s.executeQuery(str);

            while(rs.next()){


                user_id = rs.getString("user_id");
               f_name = rs.getString("fname");
                l_name = rs.getString("Lname");
                dob = rs.getString("Birth_date");
                phone = rs.getString("phone");
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        f=new JFrame("Print Data");
        f.setVisible(true);
        f.setSize(595,642);
        f.setLocation(450,200);
        f.setBackground(Color.white);
        f.setLayout(null);


        id9=new JLabel();
        id9.setBounds(0,0,595,642);
        id9.setLayout(null);
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("edu/juniv/cse/icons/print.jpg"));
        id9.setIcon(img);

        id8 = new JLabel("User Details");
        id8.setBounds(50,10,250,30);
        f.add(id8);
        id8.setFont(new Font("serif",Font.BOLD,25));
        id9.add(id8);
        f.add(id9);

        id = new JLabel("User Id:");
        id.setBounds(50,70,120,30);
        id.setFont(new Font("serif",Font.BOLD,20));
        id9.add(id);

        aid = new JLabel(user_id);
        aid.setBounds(200,70,200,30);
        aid.setFont(new Font("serif",Font.BOLD,20));
        id9.add(aid);

        id1 = new JLabel("First Name:");
        id1.setBounds(50,120,100,30);
        id1.setFont(new Font("serif",Font.BOLD,20));
        id9.add(id1);

        aid1 = new JLabel(f_name);
        aid1.setBounds(200,120,300,30);
        aid1.setFont(new Font("serif",Font.BOLD,20));
        id9.add(aid1);


        id2 = new JLabel("Last Name:");
        id2.setBounds(50,170,200,30);
        id2.setFont(new Font("serif",Font.BOLD,20));
        id9.add(id2);

        aid2 = new JLabel(l_name);
        aid2.setBounds(200,170,300,30);
        aid2.setFont(new Font("serif",Font.BOLD,20));
        id9.add(aid2);
        id1 = new JLabel("Birth Date:");
        id1.setBounds(50,220,100,30);
        id1.setFont(new Font("serif",Font.BOLD,20));
        id9.add(id1);

        aid1 = new JLabel(dob);
        aid1.setBounds(200,220,300,30);
        aid1.setFont(new Font("serif",Font.BOLD,20));
        id9.add(aid1);



        id3= new JLabel("Phone");
        id3.setBounds(50,270,100,30);
        id3.setFont(new Font("serif",Font.BOLD,20));
        id9.add(id3);

        aid3= new JLabel(phone);
        aid3.setBounds(200,270,300,30);
        aid3.setFont(new Font("serif",Font.BOLD,20));
        id9.add(aid3);


        b2=new JButton("cancel");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(250,420,100,30);
        b2.addActionListener(this);
        id9.add(b2);


    }

    public void actionPerformed(ActionEvent ae){


        if(ae.getSource()==b2){
            f.setVisible(false);
            new Details();
        }
    }
    public static void main(String[] args){
        new User_information();
    }

}

