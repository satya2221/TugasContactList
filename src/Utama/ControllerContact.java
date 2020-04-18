/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utama;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Satya
 */
public class ControllerContact {
    ModelContact modelnya;
    ViewContact viewnya;
    String dataterpilih = null;
    int baris,kolom;

    public ControllerContact(ModelContact model, ViewContact view) {
        this.modelnya = model;
        this.viewnya = view;
        if (modelnya.banyaknyaData() != 0) {
            String kontaknya[][] = modelnya.tampilkanData();
            viewnya.tabel.setModel(new JTable(kontaknya, viewnya.kolom).getModel());
        } else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
         viewnya.btn_tambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (viewnya.getTfnama().equals("")
                        || viewnya.getTfnohp().equals("")
                        || viewnya.getTfumur().equals("")
                        || viewnya.getTfemail().equals("")) {
                    JOptionPane.showMessageDialog(null, "field kosong");
                } else {
                    String nama = viewnya.getTfnama();
                    String no_hp = viewnya.getTfnohp();
                    String umur = viewnya.getTfumur();
                    String email = viewnya.getTfemail();
                    modelnya.masukkanData(nama,no_hp,umur,email);
                    viewnya.tfnama.setText("");
                    viewnya.tfnohp.setText("");
                    viewnya.tfumur.setText("");
                    viewnya.tfemail.setText("");

                    updateTable();              
                }
            }

        });
      viewnya.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                baris = viewnya.tabel.getSelectedRow();
                viewnya.tfnama.setText(viewnya.tabel.getValueAt(baris, 0).toString());
                viewnya.tfnohp.setText(viewnya.tabel.getValueAt(baris, 1).toString());
                viewnya.tfumur.setText(viewnya.tabel.getValueAt(baris, 2).toString());
                viewnya.tfemail.setText(viewnya.tabel.getValueAt(baris, 3).toString());
                dataterpilih = viewnya.tabel.getValueAt(baris, 3).toString();
//                System.out.println(dataterpilih);
                if (dataterpilih != null) {
                    viewnya.btn_hapus.setEnabled(true);
                    viewnya.btn_edit.setEnabled(true);
                }
            }

        });   
       viewnya.btn_edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String nama = viewnya.getTfnama();
                String nohp = viewnya.getTfnohp();
                String umur = viewnya.getTfumur();
                String email = viewnya.getTfemail();
                
                modelnya.updateData(nama, nohp, umur,email);
                viewnya.tfnama.setText("");
                viewnya.tfnohp.setText("");
                viewnya.tfumur.setText("");
                viewnya.tfemail.setText("");
                updateTable();
            }
        }
        );
       viewnya.btn_cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                viewnya.tfnama.setText("");
                viewnya.tfnohp.setText("");
                viewnya.tfumur.setText("");
                viewnya.tfemail.setText("");
                dataterpilih=null;
                viewnya.btn_hapus.setEnabled(false);
                viewnya.btn_edit.setEnabled(false);
            }
        });
       viewnya.btn_hapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                    if (dataterpilih != null) {
                        modelnya.hapusData(dataterpilih);
                        updateTable();
                        viewnya.tfnama.setText("");
                        viewnya.tfnohp.setText("");
                        viewnya.tfumur.setText("");
                        viewnya.tfemail.setText("");  
                        dataterpilih=null;
                        viewnya.btn_hapus.setEnabled(false);
                        viewnya.btn_edit.setEnabled(false);
                }
            }
        });
    }
      private void updateTable() {
        String kontaknya[][] = modelnya.tampilkanData();
        viewnya.tabel.setModel(new JTable(kontaknya, viewnya.kolom).getModel());
    }
}
