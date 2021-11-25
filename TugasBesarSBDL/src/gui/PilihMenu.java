package gui;

import Service.Koneksi;
import com.mysql.jdbc.CallableStatement;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Lambang
 */
@SuppressWarnings("unchecked")
public class PilihMenu extends javax.swing.JFrame {
    private ArrayList gambar = new ArrayList();
    private ArrayList id = new ArrayList();
    private ArrayList id_nota = new ArrayList();
    private int temp_id_nota=0;
    public PilihMenu() {
        initComponents();
        setLocationRelativeTo(null);
        load_table();
        setTabelNotaModel();
        txtjumlah.setHorizontalAlignment(SwingConstants.CENTER);
        setTitle("Aplikasi Mesin Kasir");
        txtjumlah.setVisible(false);
        btntambah.setVisible(false);
        btnkurang.setVisible(false);
        addData.setVisible(false);
        lblJumlah.setVisible(false);
        theme();
        setResizable(false);
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSemua = new javax.swing.JButton();
        btnCookies = new javax.swing.JButton();
        btnWaffel = new javax.swing.JButton();
        btnIceCream = new javax.swing.JButton();
        btnJuice = new javax.swing.JButton();
        btnSnack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableData = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblNota = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        txtTunai = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        lblKembalian = new javax.swing.JLabel();
        btnPrint = new javax.swing.JButton();
        lblMenu = new javax.swing.JLabel();
        btnHitung = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        btnedit = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        showmenu = new javax.swing.JPanel();
        lblnamamenu = new javax.swing.JLabel();
        lbljenismenu = new javax.swing.JLabel();
        lblmenuharga = new javax.swing.JLabel();
        lblJumlah = new javax.swing.JLabel();
        btntambah = new javax.swing.JButton();
        txtjumlah = new javax.swing.JTextField();
        btnkurang = new javax.swing.JButton();
        addData = new javax.swing.JButton();
        lblfoto = new javax.swing.JLabel();
        btnLaporan = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnSemua.setBorder(null);
        btnSemua.setOpaque(false);
        btnSemua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSemuaActionPerformed(evt);
            }
        });

        btnCookies.setBorder(null);
        btnCookies.setOpaque(false);
        btnCookies.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCookiesActionPerformed(evt);
            }
        });

        btnWaffel.setBorder(null);
        btnWaffel.setOpaque(false);
        btnWaffel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWaffelActionPerformed(evt);
            }
        });

        btnIceCream.setBorder(null);
        btnIceCream.setOpaque(false);
        btnIceCream.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIceCreamActionPerformed(evt);
            }
        });

        btnJuice.setBorder(null);
        btnJuice.setOpaque(false);
        btnJuice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJuiceActionPerformed(evt);
            }
        });

        btnSnack.setBorder(null);
        btnSnack.setOpaque(false);
        btnSnack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSnackActionPerformed(evt);
            }
        });

        tableData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nama", "Jenis", "Harga"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableDataMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tableData);

        tblNota.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nama", "Jumlah", "Harga", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblNota);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Tabel Nota");

        lblTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTotal.setText("Total Bayar : 0");

        txtTunai.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTunaiKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Tunai :");

        lblKembalian.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblKembalian.setText("Kembalian : ");

        btnPrint.setText("Print");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        lblMenu.setFont(new java.awt.Font("Trajan Pro 3", 1, 24)); // NOI18N
        lblMenu.setForeground(new java.awt.Color(255, 255, 255));
        lblMenu.setText("Semua Menu");

        btnHitung.setText("Hitung");
        btnHitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHitungActionPerformed(evt);
            }
        });

        btnhapus.setText("Hapus Item");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });

        btnedit.setText("Edit daftar menu");
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        showmenu.setBackground(new java.awt.Color(255, 255, 255));

        lblnamamenu.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblnamamenu.setText("Nama :");

        lbljenismenu.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbljenismenu.setText("Jenis :");

        lblmenuharga.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblmenuharga.setText("Harga :");

        lblJumlah.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblJumlah.setText("Jumlah");

        btntambah.setText("+");
        btntambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambahActionPerformed(evt);
            }
        });

        txtjumlah.setText("0");
        txtjumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtjumlahKeyTyped(evt);
            }
        });

        btnkurang.setText("-");
        btnkurang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkurangActionPerformed(evt);
            }
        });

        addData.setText("Tambah Ke Nota");
        addData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDataActionPerformed(evt);
            }
        });

        lblfoto.setBackground(new java.awt.Color(255, 255, 255));
        lblfoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        lblfoto.setOpaque(true);

        javax.swing.GroupLayout showmenuLayout = new javax.swing.GroupLayout(showmenu);
        showmenu.setLayout(showmenuLayout);
        showmenuLayout.setHorizontalGroup(
            showmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 552, Short.MAX_VALUE)
            .addGroup(showmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(showmenuLayout.createSequentialGroup()
                    .addGap(0, 12, Short.MAX_VALUE)
                    .addComponent(lblfoto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(showmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblnamamenu, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbljenismenu, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblmenuharga, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(showmenuLayout.createSequentialGroup()
                            .addGap(39, 39, 39)
                            .addComponent(lblJumlah))
                        .addGroup(showmenuLayout.createSequentialGroup()
                            .addComponent(btnkurang)
                            .addGap(10, 10, 10)
                            .addComponent(txtjumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(btntambah)
                            .addGap(6, 6, 6)
                            .addComponent(addData)))
                    .addGap(0, 12, Short.MAX_VALUE)))
        );
        showmenuLayout.setVerticalGroup(
            showmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 181, Short.MAX_VALUE)
            .addGroup(showmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(showmenuLayout.createSequentialGroup()
                    .addGap(0, 5, Short.MAX_VALUE)
                    .addGroup(showmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblfoto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(showmenuLayout.createSequentialGroup()
                            .addComponent(lblnamamenu, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(6, 6, 6)
                            .addComponent(lbljenismenu, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(6, 6, 6)
                            .addComponent(lblmenuharga, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lblJumlah)
                            .addGap(11, 11, 11)
                            .addGroup(showmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnkurang)
                                .addGroup(showmenuLayout.createSequentialGroup()
                                    .addGap(1, 1, 1)
                                    .addComponent(txtjumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(btntambah)
                                .addComponent(addData))))
                    .addGap(0, 5, Short.MAX_VALUE)))
        );

        btnLaporan.setText("Laporan Transaksi");
        btnLaporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLaporanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnedit)
                        .addGap(10, 10, 10)
                        .addComponent(btnLaporan, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(lblMenu))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSemua, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCookies, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnWaffel, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnIceCream, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnJuice, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSnack, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(showmenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel2)
                        .addGap(269, 269, 269)
                        .addComponent(btnhapus)
                        .addGap(10, 10, 10)
                        .addComponent(btnReset))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btnHitung)
                        .addGap(142, 142, 142)
                        .addComponent(btnPrint))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, 0)
                        .addComponent(txtTunai, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110)
                        .addComponent(lblKembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(3, 3, 3))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLaporan)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnedit)
                            .addComponent(lblMenu))))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSemua, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btnCookies, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(btnWaffel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(btnIceCream, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(btnJuice, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(btnSnack, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(showmenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel2))
                    .addComponent(btnhapus)
                    .addComponent(btnReset))
                .addGap(6, 6, 6)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(lblTotal))
                    .addComponent(btnHitung)
                    .addComponent(btnPrint))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTunai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(lblKembalian)))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIceCreamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIceCreamActionPerformed
        // TODO add your handling code here:
        lblMenu.setText("Ice Cream");
        load_table(lblMenu.getText());
    }//GEN-LAST:event_btnIceCreamActionPerformed

    private void btnJuiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJuiceActionPerformed
        // TODO add your handling code here:
        lblMenu.setText("Juice");
        load_table(lblMenu.getText());
    }//GEN-LAST:event_btnJuiceActionPerformed

    private void btnSnackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSnackActionPerformed
        // TODO add your handling code here:
        lblMenu.setText("Snack");
        load_table(lblMenu.getText());
    }//GEN-LAST:event_btnSnackActionPerformed

    private void btnSemuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSemuaActionPerformed
        // TODO add your handling code here:
        lblMenu.setText("Semua Menu");
        load_table();
    }//GEN-LAST:event_btnSemuaActionPerformed

    private void btnCookiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCookiesActionPerformed
        // TODO add your handling code here:
        lblMenu.setText("Cookies");
        load_table(lblMenu.getText());
    }//GEN-LAST:event_btnCookiesActionPerformed

    private void btnWaffelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWaffelActionPerformed
        // TODO add your handling code here:
        lblMenu.setText("Waffel");
        load_table(lblMenu.getText());
        
    }//GEN-LAST:event_btnWaffelActionPerformed

    private void txtjumlahKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtjumlahKeyTyped
        // TODO add your handling code here:
        int key = evt.getKeyChar();
        if(!(key>=48 && key<=57)){
            evt.consume();
        }
    }//GEN-LAST:event_txtjumlahKeyTyped

    private void btnkurangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkurangActionPerformed
        // TODO add your handling code here:
        int jumlah = Integer.parseInt(txtjumlah.getText().toString());
        if(jumlah>0){
            jumlah--;
            txtjumlah.setText(jumlah+"");
        }
    }//GEN-LAST:event_btnkurangActionPerformed

    private void btntambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambahActionPerformed
        // TODO add your handling code here:
        int jumlah = Integer.parseInt(txtjumlah.getText().toString());
        jumlah++;
            txtjumlah.setText(jumlah+"");
    }//GEN-LAST:event_btntambahActionPerformed

    private void addDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDataActionPerformed
        // TODO add your handling code here:
        if(txtjumlah.getText().equals("")){
            txtjumlah.setText("0");
        }
        if(!lblnamamenu.getText().substring(6).equals("")&& Integer.parseInt(txtjumlah.getText())>0){
        DefaultTableModel model = (DefaultTableModel) tblNota.getModel();
        boolean isDataFound=false;
        int row=0;
        if(model.getRowCount()>0){
            for (int i = 0; i < model.getRowCount(); i++) {
                if(lblnamamenu.getText().substring(7).equals(tblNota.getValueAt(i, 0))){
                    isDataFound=true;
                    row=i;
                    break;
                }
            }
        }
        if(isDataFound){
        int jumlah = Integer.parseInt(model.getValueAt(row, 1).toString());
        jumlah += Integer.parseInt(txtjumlah.getText());
        model.setValueAt(jumlah,row ,1);
        model.setValueAt((Integer.parseInt(model.getValueAt(row, 2).toString())*jumlah), row, 3);
        }else{
        Object[] data = new Object[4];
        this.id_nota.add(temp_id_nota);
        data[0] = lblnamamenu.getText().substring(7);
        data[1] = txtjumlah.getText();
        data[2] = lblmenuharga.getText().substring(8);
        data[3] = (Integer.parseInt(data[1].toString())*Integer.parseInt(data[2].toString()))+"";
        model.addRow(data);
        tblNota.setModel(model);
        }
        int total=0;
            for (int i = 0; i < model.getRowCount(); i++) {
                total+= Integer.parseInt(tblNota.getValueAt(i, 3).toString());
            }
        lblTotal.setText("Total Bayar : "+total);
        txtjumlah.setText("0");
        }
        
        
    }//GEN-LAST:event_addDataActionPerformed

    private void txtTunaiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTunaiKeyTyped
        // TODO add your handling code here:
        int key = evt.getKeyChar();
        if(!(key>=48 && key<=57)){
            evt.consume();
        }
        
    }//GEN-LAST:event_txtTunaiKeyTyped

    private void btnHitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHitungActionPerformed
        // TODO add your handling code here:
        int total = Integer.parseInt(lblTotal.getText().substring(14));
        if(!txtTunai.getText().equals("") && total>0){
        int bayar = Integer.parseInt(txtTunai.getText());
        if(total<=bayar){
            lblKembalian.setText("Kembalian : "+(bayar-total));
        }else {
            lblKembalian.setText("Kembalian : Jumlah Uang Kurang");
        }
        }
    }//GEN-LAST:event_btnHitungActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        // TODO add your handling code here:
        int row = tblNota.getSelectedRow();
        if(row == -1){
        JOptionPane.showMessageDialog(null, "Pilih Data yang Ingin Anda Hapus!", "Kesalahan!", JOptionPane.ERROR_MESSAGE);
        }else{
            int yes_no = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus?","Hapus",JOptionPane.YES_NO_OPTION);
            if(yes_no == JOptionPane.YES_OPTION){            
            ((DefaultTableModel) tblNota.getModel()).removeRow(row);
            id_nota.remove(row);
            int total=0;
            for (int i = 0; i <((DefaultTableModel) tblNota.getModel()).getRowCount() ; i++) {
                total+= Integer.parseInt(tblNota.getValueAt(i, 3).toString());
            }
            lblTotal.setText("Total Bayar : "+total);
            }
        }
    }//GEN-LAST:event_btnhapusActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        // TODO add your handling code here:
        
        Connection conn;
        Koneksi koneksi = new Koneksi();
        conn = koneksi.getConnection();
       if(!(txtTunai.getText().equals("") || lblTotal.getText().substring(14).equals("") ||
           lblKembalian.getText().substring(12).equals("") || lblKembalian.getText().substring(12).equals("Jumlah Uang Kurang"))){
        int yes_no = JOptionPane.showConfirmDialog(this, "Print nota?","Print",JOptionPane.YES_NO_OPTION);
            if(yes_no == JOptionPane.YES_OPTION){            
        String nota="";
        try {
            CallableStatement no_nota = (CallableStatement) conn.prepareCall("{?=call gen_no_transaksi()}");
            no_nota.registerOutParameter(1, Types.VARCHAR);
            no_nota.execute();
            nota=no_nota.getString(1);
        } catch (SQLException ex) {
            Logger.getLogger(DataMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
           try {
            for(int i=0; i<tblNota.getRowCount();i++){
            CallableStatement st = (CallableStatement) conn.prepareCall("{call inserttrans(?,?,?,?)}");
            st.setString(1, nota);
            st.setInt(2, Integer.parseInt(this.id.get(i).toString()));
            st.setInt(3, Integer.parseInt(tblNota.getValueAt(i, 1).toString()));
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
            LocalDateTime now = LocalDateTime.now();  
            String date =dtf.format(now);
            st.setString(4,date);
            st.execute();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        DefaultTableModel model = (DefaultTableModel) tblNota.getModel();
        int tunai = Integer.parseInt(txtTunai.getText());
        int total = Integer.parseInt(lblTotal.getText().substring(14));        
        int kembali = Integer.parseInt(lblKembalian.getText().substring(12));        
        Print struk = new Print(model,tunai,total,kembali,1);
        struk.setVisible(true);
       }
       }
    }//GEN-LAST:event_btnPrintActionPerformed

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        // TODO add your handling code here:
        DataMenu form = new DataMenu();
        form.setVisible(true);
        dispose();
    }//GEN-LAST:event_btneditActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        int yes_no = JOptionPane.showConfirmDialog(this, "Anda yakin ingin mereset nota?","Reset",JOptionPane.YES_NO_OPTION);
            if(yes_no == JOptionPane.YES_OPTION){            
            setTabelNotaModel();
            id_nota.clear();
            lblTotal.setText("Total Bayar : 0");
            txtTunai.setText("");
            }
    }//GEN-LAST:event_btnResetActionPerformed

    private void tableDataMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDataMouseReleased
        // TODO add your handling code here:
        int row = tableData.getSelectedRow();
            if(!(row+"").equals("") && !(row+"").equals("-1")){
            txtjumlah.setVisible(true);
            btntambah.setVisible(true);
            btnkurang.setVisible(true);
            addData.setVisible(true);
            lblJumlah.setVisible(true);
            temp_id_nota= Integer.parseInt(this.id.get(row).toString());
            try{
            Toolkit toolkit=Toolkit.getDefaultToolkit();
            String path=new File(".").getCanonicalPath();
            Image image=toolkit.getImage(path+"/gambar/"+gambar.get(row).toString());
            Image imagedResized=image.getScaledInstance(150, 150, Image.SCALE_DEFAULT);
            ImageIcon icon=new ImageIcon(imagedResized);
            lblfoto.setIcon(icon);
            lblnamamenu.setText("Nama : "+tableData.getValueAt(row, 0).toString());
            if(lblMenu.getText().equals("Semua Menu")){
            lbljenismenu.setText("Jenis : "+tableData.getValueAt(row, 1).toString());
            lblmenuharga.setText("Harga : "+tableData.getValueAt(row, 2));
            }else {
                lbljenismenu.setText("Jenis : "+lblMenu.getText());
                lblmenuharga.setText("Harga : "+tableData.getValueAt(row, 1));
            }
            txtjumlah.setText("0");
        } catch (IOException ex) {
            Logger.getLogger(DataMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_tableDataMouseReleased

    private void btnLaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLaporanActionPerformed
        // TODO add your handling code here:
        Datalaporan form = new Datalaporan();
        form.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnLaporanActionPerformed
    private void setTabelModel(){
        //setting kolom pada jtbMahasiswa
        DefaultTableModel model = new DefaultTableModel(){
        public boolean isCellEditable(int rowIndex, int mColIndex){
        return false;
        }
        };
        
        model.addColumn("Nama");
        model.addColumn("Jenis");
        model.addColumn("Harga");
        
        tableData.setModel(model);
        TableColumnModel columnModel = tableData.getColumnModel();
        columnModel.getColumn(0).setWidth(250);
        columnModel.getColumn(0).setPreferredWidth(250);
        tableData.setColumnModel(columnModel);
        tableData.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
    }
    private void setTabelNotaModel(){
        //setting kolom pada jtbMahasiswa
        DefaultTableModel model = new DefaultTableModel(){
        public boolean isCellEditable(int rowIndex, int mColIndex){
        return false;
        }
        };
        
        model.addColumn("Nama");
        model.addColumn("Jumlah");
        model.addColumn("Harga");
        model.addColumn("Total");
        
        tblNota.setModel(model);
        TableColumnModel columnModel = tblNota.getColumnModel();
        columnModel.getColumn(0).setWidth(250);
        columnModel.getColumn(0).setPreferredWidth(250);
        tblNota.setColumnModel(columnModel);
        tblNota.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    private void load_table(){
        setTabelModel();
        DefaultTableModel model = (DefaultTableModel) tableData.getModel();
        Connection conn;
        Koneksi koneksi = new Koneksi();
        conn = koneksi.getConnection();
        try {
            Statement s = conn.createStatement();
            ResultSet res = s.executeQuery("SELECT * FROM tbl_produk");
            this.id.clear();
            this.gambar.clear();
            while (res.next()) { 
                this.id.add(res.getInt("id"));
                Object[] data = new Object[3];
                data[0] = res.getString("nama_menu"); //nama_matkul adalah nama kolom di mysql
                data[1] = res.getString("jenis_menu");
                this.gambar.add(res.getString("gambar_menu"));
                data[2] = res.getInt("harga");
                if(data[2].toString().equals("0")){
                    data[2]="Gratis";
                }
                model.addRow(data);
            }
            tableData.setModel(model);
            s.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void load_table(String katagori){
        
        DefaultTableModel model = new DefaultTableModel(){
        public boolean isCellEditable(int rowIndex, int mColIndex){
        return false;
        }
        };
        model.addColumn("Nama");
        model.addColumn("Harga");
        
        tableData.setModel(model);
        tableData.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        TableColumnModel columnModel = tableData.getColumnModel();
        columnModel.getColumn(0).setWidth(250);
        columnModel.getColumn(0).setPreferredWidth(250);
        tableData.setColumnModel(columnModel);
        tableData.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        DefaultTableModel modeldata = (DefaultTableModel) tableData.getModel();
        Connection conn;
        Koneksi koneksi = new Koneksi();
        conn = koneksi.getConnection();
        try {
            Statement s = conn.createStatement();
            ResultSet res = s.executeQuery("SELECT * FROM tbl_produk WHERE jenis_menu='"+katagori+"'");
            this.id.clear();
            this.gambar.clear();
            while (res.next()) { 
                this.id.add(res.getInt("id"));
                Object[] data = new Object[2];
                data[0] = res.getString("nama_menu"); //nama_memu adalah nama kolom di mysql
                this.gambar.add(res.getString("gambar_menu"));
                data[1] = res.getInt("harga");
                if(data[1].toString().equals("0")){
                    data[1]="Gratis";
                }
                model.addRow(data);
            }
            tableData.setModel(modeldata);
            s.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void theme(){
        try {
            
            Toolkit toolkit=Toolkit.getDefaultToolkit();
            String path=new File(".").getCanonicalPath();
            
            JLabel background =new JLabel("",
            new ImageIcon(
            toolkit.getImage(path+"/asset/background.png").getScaledInstance(1245, 655, Image.SCALE_DEFAULT)),JLabel.CENTER
            );
            background.setBounds(0, 0, 1245, 655);
            this.add(background);
            btnSemua.setIcon(new ImageIcon(
            toolkit.getImage(path+"/asset/btnsemua.png").getScaledInstance(180, 90, Image.SCALE_DEFAULT))
            );
            btnCookies.setIcon(new ImageIcon(
            toolkit.getImage(path+"/asset/btncookies.png").getScaledInstance(180, 90, Image.SCALE_DEFAULT))
            );
            btnWaffel.setIcon(new ImageIcon(
            toolkit.getImage(path+"/asset/btnwaffel.png").getScaledInstance(180, 90, Image.SCALE_DEFAULT))
            );
            btnIceCream.setIcon(new ImageIcon(
            toolkit.getImage(path+"/asset/btnicecream.png").getScaledInstance(180, 90, Image.SCALE_DEFAULT))
            );
            btnSnack.setIcon(new ImageIcon(
            toolkit.getImage(path+"/asset/btnsnack.png").getScaledInstance(180, 90, Image.SCALE_DEFAULT))
            );
            btnJuice.setIcon(new ImageIcon(
            toolkit.getImage(path+"/asset/btnjuice.png").getScaledInstance(180, 90, Image.SCALE_DEFAULT))
            );
            
        } catch (IOException ex) {
            Logger.getLogger(PilihMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PilihMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PilihMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PilihMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PilihMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PilihMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addData;
    private javax.swing.JButton btnCookies;
    private javax.swing.JButton btnHitung;
    private javax.swing.JButton btnIceCream;
    private javax.swing.JButton btnJuice;
    private javax.swing.JButton btnLaporan;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSemua;
    private javax.swing.JButton btnSnack;
    private javax.swing.JButton btnWaffel;
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnkurang;
    private javax.swing.JButton btntambah;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblJumlah;
    private javax.swing.JLabel lblKembalian;
    private javax.swing.JLabel lblMenu;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblfoto;
    private javax.swing.JLabel lbljenismenu;
    private javax.swing.JLabel lblmenuharga;
    private javax.swing.JLabel lblnamamenu;
    private javax.swing.JPanel showmenu;
    private javax.swing.JTable tableData;
    private javax.swing.JTable tblNota;
    private javax.swing.JTextField txtTunai;
    private javax.swing.JTextField txtjumlah;
    // End of variables declaration//GEN-END:variables
}
