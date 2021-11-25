package gui;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import Service.Koneksi;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.TableColumnModel;
import javax.swing.ListSelectionModel;
@SuppressWarnings("unchecked")
public class DataMenu extends javax.swing.JFrame {
    JFileChooser pilihFile;
    File gambar;
    ArrayList id = new ArrayList();

    public DataMenu() {
        initComponents();
        setLocationRelativeTo(null);
        load_table();
        setTitle("Data Menu");
        btnBatal.setVisible(false);
        btnSimpan.setVisible(false);
        lblStatus.setVisible(false);
        btnHapus.setVisible(false);
        txtname.setHorizontalAlignment(SwingConstants.CENTER);
        theme();
        setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblfoto = new javax.swing.JLabel();
        btnadd = new javax.swing.JButton();
        txtname = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableData = new javax.swing.JTable();
        btnback = new javax.swing.JButton();
        controlerPane = new javax.swing.JPanel();
        btnHapus = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        lblStatus = new javax.swing.JLabel();
        btnTambah = new javax.swing.JButton();
        txtNama = new javax.swing.JTextField();
        cbJenis = new javax.swing.JComboBox<>();
        txtHarga = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cari = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 255, 204));

        lblfoto.setBackground(new java.awt.Color(255, 255, 255));
        lblfoto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        lblfoto.setOpaque(true);

        btnadd.setText("Pilih Gambar");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });

        tableData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama", "Jenis", "Gambar", "Harga"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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

        btnback.setText("Selesai Mengedit");
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });

        controlerPane.setBackground(new java.awt.Color(255, 0, 51));
        controlerPane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        controlerPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        controlerPane.add(btnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(446, 78, -1, -1));

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        controlerPane.add(btnSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(367, 78, -1, -1));

        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });
        controlerPane.add(btnBatal, new org.netbeans.lib.awtextra.AbsoluteConstraints(304, 78, -1, -1));

        lblStatus.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblStatus.setText("Edit Data");
        controlerPane.add(lblStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(364, 49, -1, -1));

        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });
        controlerPane.add(btnTambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(408, 8, -1, -1));
        controlerPane.add(txtNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 9, 319, -1));

        cbJenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cookies", "Waffel", "Ice Cream", "Juice", "Snack" }));
        controlerPane.add(cbJenis, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 34, 207, -1));

        txtHarga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHargaKeyTyped(evt);
            }
        });
        controlerPane.add(txtHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 65, 207, -1));

        jLabel4.setText("Harga          :");
        controlerPane.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 68, -1, -1));

        jLabel2.setText("Nama Menu :");
        controlerPane.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 12, -1, -1));

        jLabel3.setText("Jenis Menu  :");
        controlerPane.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 37, -1, -1));

        cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cariKeyReleased(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cari :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(btnback))
                            .addComponent(lblfoto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(btnadd, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(controlerPane, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnback)
                        .addGap(11, 11, 11)
                        .addComponent(lblfoto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnadd))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(controlerPane, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(jLabel1)
                                .addGap(2, 2, 2)
                                .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        // TODO add your handling code here:
        pilihFile = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image",ImageIO.getReaderFileSuffixes());
        pilihFile.setMultiSelectionEnabled(false);
        pilihFile.setAcceptAllFileFilterUsed(false);
        pilihFile.setFileFilter(filter);
        if(pilihFile.showOpenDialog(lblfoto)==JFileChooser.APPROVE_OPTION){
            
            Toolkit toolkit=Toolkit.getDefaultToolkit();
            Image image=toolkit.getImage(pilihFile.getSelectedFile().getAbsolutePath());
            Image imagedResized=image.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
            ImageIcon imageIcon=new ImageIcon(imagedResized);
            lblfoto.setIcon(imageIcon);
            gambar = new File(pilihFile.getSelectedFile().getPath());
            txtname.setText(gambar.getName());
        }
        
        
    }//GEN-LAST:event_btnaddActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        if(!txtNama.getText().equals("") && !txtHarga.getText().equals("")){
        int iddata=1;
        if(!this.id.isEmpty()){
            iddata =Integer.parseInt(this.id.get(this.id.size()-1).toString())+1;
        }
        int harga = Integer.parseInt(txtHarga.getText())+0;
        String nama = txtNama.getText();
        String jenis = cbJenis.getSelectedItem().toString();
        String namagambar =  (Integer.parseInt(this.id.get(this.id.size()-1).toString())+1)+"";
        try {
            String path=new File(".").getCanonicalPath();
            FileUtils.copyFileToDirectory(gambar, new File(path+"/gambar"));
            File old = new File(path+"/gambar/"+gambar.getName());
            File rename = new File(path+"/gambar/"+namagambar+"."+FilenameUtils.getExtension(gambar.getName()));
            if(old.renameTo(rename)){
                namagambar = rename.getName();
                System.out.println("Renamed");
            }else{
                System.out.println("False Renamed");
            }
            Connection conn = new Koneksi().getConnection();
        try{
          String query = "INSERT INTO tbl_produk(id,nama_menu,jenis_menu,gambar_menu,harga) VALUES (?,?,?,?,?)";
          PreparedStatement ps = conn.prepareStatement(query);
          ps.setInt(1, iddata);
          ps.setString(2,nama);
          ps.setString(3,jenis);
          ps.setString(4,namagambar);
          ps.setInt(5, harga);
          ps.executeUpdate();
          ps.close();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Gagal Memasukkan data");
            Logger.getLogger(DataMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Mohon untuk menambah gambar");
            Logger.getLogger(DataMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        load_table();
        } else{
            if(txtNama.getText().equals("") && txtHarga.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Nama dan harga tidak boleh kosong");
            } else if(txtNama.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Nama tidak boleh kosong");
            }else if(txtHarga.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Harga tidak boleh kosong");
            }
        }
    }//GEN-LAST:event_btnTambahActionPerformed

    public void cari(String kunci){
        setTabelModel();
        DefaultTableModel model = (DefaultTableModel) tableData.getModel();
        Connection conn;
        Koneksi koneksi = new Koneksi();
        conn = koneksi.getConnection();
        try {
            Statement s = conn.createStatement();
            ResultSet res = s.executeQuery(
                    "SELECT * FROM tbl_produk where nama_menu LIKE '%"
                    +kunci+"%' OR jenis_menu LIKE '%"+kunci+"%' OR gambar_menu LIKE '%"
                    +kunci+"%' OR harga LIKE '%"+kunci+"%'"
            );
            this.id.clear();
            while (res.next()) {              
                this.id.add(res.getInt("id"));
                Object[] data = new Object[4];
                data[0] = res.getString("nama_menu"); 
                data[1] = res.getString("jenis_menu");
                data[2] = res.getString("gambar_menu");
                data[3] = res.getInt("harga");
                if(data[3].toString().equals("0")){
                    data[3]="Gratis";
                }
                model.addRow(data);
            }
            tableData.setModel(model);
            s.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        System.out.println("Batal");
        btnSimpan.setVisible(false);
        btnBatal.setVisible(false);
        lblStatus.setVisible(false);
        btnHapus.setVisible(false);
        btnTambah.setVisible(true);
        txtNama.setText("");
        txtHarga.setText("");
        lblfoto.setIcon(null);
        txtname.setText("");
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        int row = tableData.getSelectedRow();
        
        try{
          String nama = txtNama.getText();
          String jenis = cbJenis.getSelectedItem().toString();
          int harga = Integer.parseInt(txtHarga.getText())+0;
          Connection conn = new Koneksi().getConnection();
          String query = "UPDATE tbl_produk SET nama_menu=?,jenis_menu=?,gambar_menu=?,harga=? WHERE id=?";
          PreparedStatement ps = conn.prepareStatement(query);
          ps.setString(1,nama);
          ps.setString(2,jenis);
          if(txtname.getText().equals(tableData.getValueAt(row, 2).toString())){
          ps.setString(3,tableData.getValueAt(row, 2).toString());
          } else{
            try {
            String namagambar = this.id.get(row).toString();
            String path=new File(".").getCanonicalPath();
            File hapus =new File(path+"/gambar/"+tableData.getValueAt(row, 2).toString());
            
            if(hapus.delete()){
                System.out.println(hapus.getName()+" berhasil dihapus");
            }else {
                System.out.println("Gagal Menghapus");
            }
            FileUtils.copyFileToDirectory(gambar, new File(path+"/gambar"));
            File old = new File(path+"/gambar/"+gambar.getName());
            File rename = new File(path+"/gambar/"+namagambar+"."+FilenameUtils.getExtension(gambar.getName()));
            if(old.renameTo(rename)){
                namagambar = rename.getName();
                System.out.println("Renamed");
            }else{
                System.out.println("False Renamed");
            }
            ps.setString(3,namagambar);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Mohon untuk menambah gambar");
            Logger.getLogger(DataMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
          }
          ps.setInt(4, harga);
          int idtable = Integer.parseInt(this.id.get(row).toString());
          ps.setInt(5, idtable);
          ps.executeUpdate();
          ps.close();
          System.out.println("Batal");
        btnSimpan.setVisible(false);
        btnBatal.setVisible(false);
        lblStatus.setVisible(false);
        btnHapus.setVisible(false);
        btnTambah.setVisible(true);
        txtNama.setText("");
        txtHarga.setText("");
        lblfoto.setIcon(null);
        txtname.setText("");
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Gagal Mengedit data");
            Logger.getLogger(DataMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(cari.getText().equals("")){
        load_table();
        }else {
            cari(cari.getText());
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        int row = tableData.getSelectedRow();
        if(row == -1){
        JOptionPane.showMessageDialog(null, "Pilih Data yang Ingin Anda Hapus!", "Kesalahan!", JOptionPane.ERROR_MESSAGE);
        }else{
        int yes_no = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus?","Hapus",JOptionPane.YES_NO_OPTION);
        if(yes_no == JOptionPane.YES_OPTION){
        Connection conn = new Koneksi().getConnection();
        try{
          String query = "DELETE FROM tbl_produk WHERE id=?";
          PreparedStatement ps = conn.prepareStatement(query);
          int idtable = Integer.parseInt(this.id.get(row).toString());
          ps.setInt(1, idtable);
          String path=new File(".").getCanonicalPath();
          File hapus =new File(path+"/gambar/"+tableData.getValueAt(row, 2).toString());
          this.id.remove(row);
          if(hapus.delete()){
            System.out.println(hapus.getName()+" berhasil dihapus");
          }else {
                System.out.println("Gagal Menghapus");
          }
          ps.execute();
          ps.close();
        btnSimpan.setVisible(false);
        btnBatal.setVisible(false);
        lblStatus.setVisible(false);
        btnHapus.setVisible(false);
        btnTambah.setVisible(true);
        txtNama.setText("");
        txtHarga.setText("");
        lblfoto.setIcon(null);
        txtname.setText("");
          load_table();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Gagal Memasukkan data");
            Logger.getLogger(DataMenu.class.getName()).log(Level.SEVERE, null, ex);
        }   catch (IOException ex) {
                Logger.getLogger(DataMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void txtHargaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHargaKeyTyped
        // TODO add your handling code here:
        int key = evt.getKeyChar();
        if(!(key>=48 && key<=57)){
            evt.consume();
        }
    }//GEN-LAST:event_txtHargaKeyTyped

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        // TODO add your handling code here:
        PilihMenu form = new PilihMenu();
        form.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnbackActionPerformed

    private void tableDataMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDataMouseReleased
        // TODO add your handling code here:
        int row = tableData.getSelectedRow();
            if(!(row+"").equals("") && !(row+"").equals("-1")){
            btnSimpan.setVisible(true);
            btnBatal.setVisible(true);
            lblStatus.setVisible(true);
            btnHapus.setVisible(true);
            btnTambah.setVisible(false);
            try{
            Toolkit toolkit=Toolkit.getDefaultToolkit();
            String path=new File(".").getCanonicalPath();
            Image image=toolkit.getImage(path+"/gambar/"+tableData.getValueAt(row, 2));
            Image imagedResized=image.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
            ImageIcon icon=new ImageIcon(imagedResized);
            lblfoto.setIcon(icon);
            txtNama.setText(tableData.getValueAt(row, 0).toString());
            if(tableData.getValueAt(row, 3).toString().equals("Gratis")){
            txtHarga.setText("0");
            }else{
            txtHarga.setText(tableData.getValueAt(row, 3).toString());
            }
            Object cb = tableData.getValueAt(row, 1);
            cbJenis.setSelectedItem(cb);
            txtname.setText(tableData.getValueAt(row, 2).toString());
            
        } catch (IOException ex) {
            Logger.getLogger(DataMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_tableDataMouseReleased

    private void cariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cariKeyReleased
        // TODO add your handling code here:
        if(!cari.getText().equals("")){
                cari(cari.getText());
            }else{
                load_table();
            }
    }//GEN-LAST:event_cariKeyReleased
    private void setTabelModel(){
        //setting kolom tabel
        DefaultTableModel model = new DefaultTableModel(){
        public boolean isCellEditable(int rowIndex, int mColIndex){
        return false;
        }
        };
        model.addColumn("Nama");
        model.addColumn("Jenis");
        model.addColumn("Gambar");
        model.addColumn("Harga");
        tableData.setModel(model);
        
        TableColumnModel columnModel = tableData.getColumnModel();
        columnModel.getColumn(0).setWidth(250);
        columnModel.getColumn(0).setPreferredWidth(250);
        tableData.setColumnModel(columnModel);
        tableData.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
            while (res.next()) {              
                this.id.add(res.getInt("id"));
                Object[] data = new Object[4];
                data[0] = res.getString("nama_menu"); 
                data[1] = res.getString("jenis_menu");
                data[2] = res.getString("gambar_menu");
                data[3] = res.getInt("harga");
                if(data[3].toString().equals("0")){
                    data[3]="Gratis";
                }
                model.addRow(data);
            }
            tableData.setModel(model);
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
        } catch (IOException ex) {
            Logger.getLogger(DataMenu.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(DataMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btnback;
    private javax.swing.JTextField cari;
    private javax.swing.JComboBox<String> cbJenis;
    private javax.swing.JPanel controlerPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblfoto;
    private javax.swing.JTable tableData;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtNama;
    private javax.swing.JLabel txtname;
    // End of variables declaration//GEN-END:variables
}
