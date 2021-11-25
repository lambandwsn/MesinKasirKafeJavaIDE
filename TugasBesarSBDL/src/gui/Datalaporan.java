/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Service.Koneksi;
import com.mysql.jdbc.CallableStatement;
import com.mysql.jdbc.PreparedStatement;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Lambang
 */
@SuppressWarnings("unchecked")
public class Datalaporan extends javax.swing.JFrame {
    /**
     * Creates new form DataLaporan
     */
    ArrayList<String> id = new ArrayList();
    ArrayList<Integer> id_table = new ArrayList();
    public Datalaporan() {
        initComponents();
        cbmenu.removeAllItems();
        comboset();
        load_table();
        theme();
        btnHapus.setVisible(false);
        btnSimpan.setVisible(false);
        btnbatal.setVisible(false);
        lblStatus.setVisible(false);
        this.setLocationRelativeTo(null);
    }
    private void comboset(){
        Connection conn;
        Koneksi koneksi = new Koneksi();
        conn = koneksi.getConnection();
        try {
            Statement s = conn.createStatement();
            ResultSet res = s.executeQuery("SELECT id, nama_menu FROM tbl_produk ORDER BY nama_menu ASC");
            this.id.clear();
            while (res.next()) {
                this.id.add(res.getInt("id")+"");
                cbmenu.addItem(res.getString("nama_menu"));
            }
            s.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     private void load_table(){
        setTabelModel();
        DefaultTableModel model = (DefaultTableModel) table_laporan.getModel();
        Connection conn;
        Koneksi koneksi = new Koneksi();
        conn = koneksi.getConnection();
        try {
            Statement s = conn.createStatement();
            ResultSet res = s.executeQuery("SELECT * FROM tabel_laporan");
            this.id_table.clear();
            while (res.next()) {              
                Object[] data = new Object[6];
                this.id_table.add(res.getInt("id_menu"));
                data[0] = res.getString("nomer_nota"); 
                data[1] = res.getString("tgl_transaksi");
                data[2] = res.getString("nama_menu");
                data[3] = res.getInt("jumlah");
                data[4] = res.getString("harga");
                data[5] = res.getString("total");
                model.addRow(data);
            }
            table_laporan.setModel(model);
            s.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
private void setTabelModel(){
        //setting kolom tabel
        DefaultTableModel model = new DefaultTableModel(){
        public boolean isCellEditable(int rowIndex, int mColIndex){
        return false;
        }
        };
        model.addColumn("Nomer Nota");
        model.addColumn("Tanggal Transaksi");
        model.addColumn("Nama Menu");
        model.addColumn("Jumlah");
        model.addColumn("Harga");
        model.addColumn("Total");
        table_laporan.setModel(model);
        
        TableColumnModel columnModel = table_laporan.getColumnModel();
        columnModel.getColumn(2).setWidth(250);
        columnModel.getColumn(2).setPreferredWidth(250);
        table_laporan.setColumnModel(columnModel);
        table_laporan.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
        } catch (IOException ex) {
            Logger.getLogger(DataMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cbmenu = new javax.swing.JComboBox<>();
        txtjumlah = new javax.swing.JTextField();
        txtnota = new javax.swing.JTextField();
        txttgl = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btngenerate = new javax.swing.JButton();
        btntambah = new javax.swing.JButton();
        btnprint = new javax.swing.JButton();
        btnKasir = new javax.swing.JButton();
        btnHistory = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnHapus = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        btnbatal = new javax.swing.JButton();
        lblStatus = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_laporan = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setMaximumSize(new java.awt.Dimension(811, 148));
        jPanel1.setMinimumSize(new java.awt.Dimension(811, 148));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbmenu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cbmenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, 198, -1));

        txtjumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtjumlahKeyTyped(evt);
            }
        });
        jPanel1.add(txtjumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 74, 198, -1));

        txtnota.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnotaKeyTyped(evt);
            }
        });
        jPanel1.add(txtnota, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 198, -1));

        txttgl.setDateFormatString("Y-MM-dd");
        jPanel1.add(txttgl, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 103, 198, -1));

        jLabel1.setText("Nomer Nota            :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 110, -1));

        jLabel2.setText("Menu                       :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, -1, -1));

        jLabel3.setText("Jumlah                    :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 74, -1, -1));

        jLabel4.setText("Tanggal Transaksi :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 109, -1, -1));

        btngenerate.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btngenerate.setText("Generate Nomer");
        btngenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngenerateActionPerformed(evt);
            }
        });
        jPanel1.add(btngenerate, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, -1, -1));

        btntambah.setText("Tambah");
        btntambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambahActionPerformed(evt);
            }
        });
        jPanel1.add(btntambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, -1, -1));

        btnprint.setText("Print");
        btnprint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprintActionPerformed(evt);
            }
        });
        jPanel1.add(btnprint, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 40, 101, -1));

        btnKasir.setText("Kembali ke Kasir");
        btnKasir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKasirActionPerformed(evt);
            }
        });
        jPanel1.add(btnKasir, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        btnHistory.setText("History Delete");
        btnHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistoryActionPerformed(evt);
            }
        });
        jPanel1.add(btnHistory, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 10, -1, -1));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        jPanel2.add(btnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, -1, -1));

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        jPanel2.add(btnSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, -1, -1));

        btnbatal.setText("Batal");
        btnbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbatalActionPerformed(evt);
            }
        });
        jPanel2.add(btnbatal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, -1, -1));

        lblStatus.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblStatus.setText("Edit Data");
        jPanel2.add(lblStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, 250, 80));

        table_laporan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_laporan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_laporanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_laporan);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 843, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void table_laporanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_laporanMouseClicked
        // TODO add your handling code here:
        btntambah.setVisible(false);
        btnbatal.setVisible(true);
        btnSimpan.setVisible(true);
        btnHapus.setVisible(true);
        lblStatus.setVisible(true);
        int row = table_laporan.getSelectedRow();
        if(!(row+"").equals("") && !(row+"").equals("-1")){
            try {
                txtnota.setText(table_laporan.getValueAt(row, 0).toString());
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(table_laporan.getValueAt(row, 1).toString());
                txttgl.setDate(date);
                cbmenu.setSelectedItem(table_laporan.getValueAt(row, 2));
                txtjumlah.setText(table_laporan.getValueAt(row, 3).toString());
            } catch (ParseException ex) {
                Logger.getLogger(Datalaporan.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
    }//GEN-LAST:event_table_laporanMouseClicked

    private void btnbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbatalActionPerformed
        // TODO add your handling code here:
        btntambah.setVisible(true);
        btnHapus.setVisible(false);
        btnSimpan.setVisible(false);
        btnbatal.setVisible(false);
        lblStatus.setVisible(false);
    }//GEN-LAST:event_btnbatalActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        int row = table_laporan.getSelectedRow();
        try{
            String nota = txtnota.getText();
            int id_menu  = Integer.parseInt(this.id.get(cbmenu.getSelectedIndex()));
            int jumlah = Integer.parseInt(txtjumlah.getText())+0;
            String date =((JTextField)txttgl.getDateEditor().getUiComponent()).getText();
            Connection conn = new Koneksi().getConnection();
            String query = "UPDATE transaksi SET nomer_nota=?,id_menu=?,jumlah=?,tgl_transaksi=? WHERE nomer_nota=? AND id_menu=?";
            PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query);
            ps.setString(1,nota);
            ps.setInt(2,id_menu);
            ps.setInt(3, jumlah);
            ps.setString(4, date);
            String old_nomor_nota = table_laporan.getValueAt(row, 0).toString();
            ps.setString(5, old_nomor_nota);
            int old_id_menu = id_table.get(row);
            ps.setInt(6, old_id_menu);
            ps.executeUpdate();
            ps.close();
            load_table();
        } catch (SQLException ex) {
            Logger.getLogger(DataMenu.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        int row = table_laporan.getSelectedRow();
        if(row == -1){
            JOptionPane.showMessageDialog(null, "Pilih Data yang Ingin Anda Hapus!", "Kesalahan!", JOptionPane.ERROR_MESSAGE);
        }else{
            int yes_no = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus?","Hapus",JOptionPane.YES_NO_OPTION);
            if(yes_no == JOptionPane.YES_OPTION){
                Connection conn = new Koneksi().getConnection();
                try{
                    String query = "DELETE FROM transaksi WHERE nomer_nota=? AND id_menu=?";
                    java.sql.PreparedStatement ps = conn.prepareStatement(query);
                    int idtable = Integer.parseInt(this.id_table.get(row).toString());
                    ps.setString(1, table_laporan.getValueAt(row, 0).toString());
                    ps.setInt(2, idtable);
                    ps.execute();
                    ps.close();
                    btnSimpan.setVisible(false);
                    btnbatal.setVisible(false);
                    lblStatus.setVisible(false);
                    btnHapus.setVisible(false);
                    btntambah.setVisible(true);
                    txtnota.setText("");
                    txtjumlah.setText("");
                    txttgl.setDate(null);
                    load_table();
                }catch (SQLException ex) {
                    Logger.getLogger(DataMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistoryActionPerformed
        // TODO add your handling code here:
        DeleteHistory form = new DeleteHistory();
        form.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnHistoryActionPerformed

    private void btnKasirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKasirActionPerformed
        // TODO add your handling code here:
        PilihMenu form = new PilihMenu();
        form.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnKasirActionPerformed

    private void btnprintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprintActionPerformed
        // TODO add your handling code here:
        String reportSource = System.getProperty("user.dir") + "/src/report/laporan.jrxml";
        String reportDest = System.getProperty("user.dir") + "/src/report/laporan.jasper";
        try {
            Connection conn = new Koneksi().getConnection();
            JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,null,conn);
            JasperExportManager.exportReportToHtmlFile(jasperPrint, reportDest);
            JasperViewer.viewReport(jasperPrint,false);
        }catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_btnprintActionPerformed

    private void btntambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambahActionPerformed
        // TODO add your handling code here:
        Connection conn;
        Koneksi koneksi = new Koneksi();
        conn = koneksi.getConnection();

        try {
            CallableStatement s = (CallableStatement) conn.prepareCall("{call inserttrans(?,?,?,?)}");
            s.setString(1, txtnota.getText());
            s.setInt(2, Integer.parseInt(this.id.get(cbmenu.getSelectedIndex())));
            s.setInt(3, Integer.parseInt(txtjumlah.getText()));
            String date =((JTextField)txttgl.getDateEditor().getUiComponent()).getText();
            s.setString(4,date);
            s.execute();
            load_table();
        } catch (SQLException ex) {
            if(ex.getErrorCode()==1062){
                JOptionPane.showMessageDialog(null, "Nomor nota dan item sudah ada!");
            }
        }

    }//GEN-LAST:event_btntambahActionPerformed

    private void btngenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngenerateActionPerformed
        // TODO add your handling code here:
        Connection conn;
        Koneksi koneksi = new Koneksi();
        conn = koneksi.getConnection();
        try {
            CallableStatement s = (CallableStatement) conn.prepareCall("{?=call gen_no_transaksi()}");
            s.registerOutParameter(1, Types.VARCHAR);
            s.execute();
            txtnota.setText(s.getString(1));
        } catch (SQLException ex) {
            Logger.getLogger(DataMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btngenerateActionPerformed

    private void txtnotaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnotaKeyTyped
        // TODO add your handling code here:
        int key = evt.getKeyChar();
        if(!(key>=48 && key<=57)){
            evt.consume();
        }else if(txtnota.getText().length()>=12){
            evt.consume();
        }
    }//GEN-LAST:event_txtnotaKeyTyped

    private void txtjumlahKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtjumlahKeyTyped
        // TODO add your handling code here:
        int key = evt.getKeyChar();
        if(!(key>=48 && key<=57)){
            evt.consume();
        }
    }//GEN-LAST:event_txtjumlahKeyTyped

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Datalaporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Datalaporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Datalaporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Datalaporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Datalaporan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnHistory;
    private javax.swing.JButton btnKasir;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnbatal;
    private javax.swing.JButton btngenerate;
    private javax.swing.JButton btnprint;
    private javax.swing.JButton btntambah;
    private javax.swing.JComboBox<String> cbmenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JTable table_laporan;
    private javax.swing.JTextField txtjumlah;
    private javax.swing.JTextField txtnota;
    private com.toedter.calendar.JDateChooser txttgl;
    // End of variables declaration//GEN-END:variables
}
