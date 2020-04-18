/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utama;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Satya
 */
public class ViewContact extends JFrame {
    JTable tabel; //= new JTable();
    Container c;
    Object[] kolom = {"Nama","NoHP","umur","e-mail"};
    DefaultTableModel model; //= new DefaultTableModel();
    
    JLabel lnamanya = new JLabel("Nama : ");
    JTextField tfnama = new JTextField();
    
    JLabel lnohp = new JLabel("No.HP : ");
    JTextField tfnohp = new JTextField();
    
    JLabel lumur = new JLabel("Umur : ");
    JTextField tfumur = new JTextField();
    
    JLabel lemail = new JLabel("email : ");
    JTextField tfemail = new JTextField();
    
    JButton btn_tambah = new JButton("tambah");
    JButton btn_edit = new JButton("edit");
    JButton btn_hapus = new JButton("hapus");
    JButton btn_cancel = new JButton("cancel");
    
    JScrollPane pane;
    public ViewContact() {
        model = new DefaultTableModel(kolom,0);
        tabel = new JTable(model);
        pane = new JScrollPane(tabel);
//        model.setColumnIdentifiers(kolom);
        tabel.setModel(model);
        tabel.setBackground(Color.PINK);
        tabel.setForeground(Color.black);
        Font font = new Font("",1,16);
        tabel.setFont(font);
        tabel.setRowHeight(30);
        
        lnamanya.setBounds(20, 220, 50, 25);
        lnohp.setBounds(20, 250, 50, 25);
        lumur.setBounds(20, 280, 50, 25);
        lemail.setBounds(20, 310, 50, 25);
        
        tfnama.setBounds(80, 220, 180, 25);
        tfnohp.setBounds(80, 250, 180, 25);
        tfumur.setBounds(80, 280, 180, 25);
        tfemail.setBounds(80, 310, 180, 25);
        
        btn_tambah.setBounds(400,265,90,20);
        btn_edit.setBounds(510,265,90,20);
        btn_hapus.setBounds(620,265,90,20);
        btn_cancel.setBounds(730,265,90,20);
        
        setLayout(null);
        setTitle("Contact List MVC");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(900,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pane.setBounds(0, 0, 880, 200);
        pane.setBackground(Color.PINK);
        add(pane);
        
        add(lnamanya);
        add(lnohp);
        add(lumur);
        add(lemail);
        
        add(tfnama);
        add(tfnohp);
        add(tfumur);
        add(tfemail);
        
        add(btn_tambah);
        add(btn_edit);
        btn_edit.setEnabled(false);
        add(btn_hapus);
        btn_hapus.setEnabled(false);
        add(btn_cancel);
    }
//    public static void main(String[] args) {
//        new ViewContact();
//    }
     public String getTfnama() {
        return tfnama.getText();
    }

    public String getTfnohp() {
        return tfnohp.getText();
    }

    public String getTfumur() {
        return tfumur.getText();
    }

    public String getTfemail() {
        return tfemail.getText();
    }
    
}
