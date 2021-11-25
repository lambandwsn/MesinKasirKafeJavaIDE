package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import java.awt.print.PrinterJob;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumnModel;

public class Print extends javax.swing.JFrame {
    public Print() {
        initComponents();
        setLocationRelativeTo(null);
    }
    public Print(DefaultTableModel model,int tunai, int total, int kembali,int numberpart) {
        initComponents();
        int max=19;
        this.setResizable(false);
        txtnumberofpart.setText("Nota : "+numberpart);
        if(model.getRowCount()<=max){
        tblStruk.setModel(model);    
        }else{
            String[] header = {"Nama","Jumlah","Harga","Total"};
            DefaultTableModel part = new DefaultTableModel(header,0);
            DefaultTableModel left = new DefaultTableModel(header,0);
            for(int i=0; i<max; i++){
            String[] row ={
                model.getValueAt(i, 0).toString(),
                model.getValueAt(i, 1).toString(),
                model.getValueAt(i, 2).toString(),
                model.getValueAt(i, 3).toString(),
            };
            part.addRow(row);
            }
            tblStruk.setModel(part);
            for(int i=max; i<model.getRowCount();i++){
                String[] row ={
                model.getValueAt(i, 0).toString(),
                model.getValueAt(i, 1).toString(),
                model.getValueAt(i, 2).toString(),
                model.getValueAt(i, 3).toString(),
            };
            left.addRow(row);
            }
            numberpart++;
            Print newStruk = new Print(left,tunai,total,kembali,numberpart);
            newStruk.setVisible(true);
        }
        setLocationRelativeTo(null);
        tblStruk.getTableHeader().setUI(null);
        lbltotal.setText("Total Belanja : "+total);
        lblTunai.setText("Tunai : "+tunai);
        lblKembali.setText("Kembalian : "+kembali);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        TableColumnModel columnModel = tblStruk.getColumnModel();
        columnModel.getColumn(0).setWidth(250);
        columnModel.getColumn(0).setPreferredWidth(250);
        tblStruk.setColumnModel(columnModel);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        layoutpane = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStruk = new javax.swing.JTable();
        lblTunai = new javax.swing.JLabel();
        lblKembali = new javax.swing.JLabel();
        lbltotal = new javax.swing.JLabel();
        txtnumberofpart = new javax.swing.JLabel();
        btnPrint = new javax.swing.JButton();
        btncancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        layoutpane.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("OCR A Std", 3, 14)); // NOI18N
        jLabel1.setText("Kafe Late");

        jLabel2.setText("JL Sempit Sekali km 10 Jogjakarta");

        tblStruk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblStruk.setGridColor(new java.awt.Color(255, 255, 255));
        tblStruk.setInheritsPopupMenu(true);
        tblStruk.setOpaque(false);
        jScrollPane1.setViewportView(tblStruk);

        lblTunai.setText("Tunai : 0");

        lblKembali.setText("Kembalian : 0");

        lbltotal.setText(" Total Belanja : 0");

        txtnumberofpart.setText("Nota : ");

        javax.swing.GroupLayout layoutpaneLayout = new javax.swing.GroupLayout(layoutpane);
        layoutpane.setLayout(layoutpaneLayout);
        layoutpaneLayout.setHorizontalGroup(
            layoutpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layoutpaneLayout.createSequentialGroup()
                .addGroup(layoutpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layoutpaneLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layoutpaneLayout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addGroup(layoutpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbltotal, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTunai, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layoutpaneLayout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addGroup(layoutpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layoutpaneLayout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtnumberofpart)
                                .addGap(40, 40, 40)))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layoutpaneLayout.setVerticalGroup(
            layoutpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layoutpaneLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(layoutpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtnumberofpart))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbltotal)
                .addGap(4, 4, 4)
                .addComponent(lblTunai)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblKembali)
                .addGap(26, 26, 26))
        );

        btnPrint.setText("Print");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        btncancel.setText("Cancel");
        btncancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btncancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPrint))
                    .addComponent(layoutpane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(layoutpane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrint)
                    .addComponent(btncancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        // TODO add your handling code here:
        printRecord(layoutpane);
    }//GEN-LAST:event_btnPrintActionPerformed

    private void btncancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btncancelActionPerformed

    private void printRecord(JPanel panelPrint){
        PrinterJob print = PrinterJob.getPrinterJob();
        print.setPrintable(new Printable() {
            @Override
            public int print(Graphics graphics, PageFormat pageformat, int pageIndex) throws PrinterException {
                if(pageIndex>0){
                    return Printable.NO_SUCH_PAGE;
                }
                Graphics2D graphics2d = (Graphics2D) graphics;
                graphics2d.translate(pageformat.getImageableX()*2, pageformat.getImageableY()*2);
                graphics2d.scale(1.3, 1.3);
                panelPrint.paint(graphics2d);
                return Printable.PAGE_EXISTS;
            }
        });
        boolean returningResult = print.printDialog();
        if(returningResult){
            try{
                print.print();
                JOptionPane.showMessageDialog(null, "Print Sukses");
                dispose();
            }catch(PrinterException printer){
                JOptionPane.showMessageDialog(this, "Print Error : "+printer.getMessage());
            }
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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Print().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btncancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel layoutpane;
    private javax.swing.JLabel lblKembali;
    private javax.swing.JLabel lblTunai;
    private javax.swing.JLabel lbltotal;
    private javax.swing.JTable tblStruk;
    private javax.swing.JLabel txtnumberofpart;
    // End of variables declaration//GEN-END:variables
}
