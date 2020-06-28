/*
    Nama	: Paramadina Mulya Majid
    Stambuk	: 13020180006
    Hari/Tgl	: Jumat, 26 Juni 2020
    Waktu	: 22.40 WITA
*/
package View;

import Source.ImplementLaundry;
import Source.InterfaceLaundry;
import Source.KoneksiDatabase;
import Source.Laundry;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Pemesanan extends javax.swing.JFrame {

    DefaultTableModel model = new DefaultTableModel();
    InterfaceLaundry interfaceLaundry;
    List record = new ArrayList();
    int baris;
    String kJen;
    
    public Pemesanan() {
        initComponents();
        KoneksiDatabase.getConnection();
        interfaceLaundry = new ImplementLaundry();
        Bayar.setEnabled(true);
        
        daftarJenisCuci();
    }
    
    void daftarJenisCuci() { 
        Object[] jen = {"Cuci Basah", "Cuci Kering", "Cuci Setrika"};
        for (int i = 0; i < jen.length; i++) { 
            CbJenisCuci.addItem(jen[i].toString()); 
        } 
        String kJen = CbJenisCuci.getSelectedItem().toString(); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Bayar = new javax.swing.JButton();
        Batal = new javax.swing.JButton();
        txtNamaPemesan = new javax.swing.JTextField();
        txtHargaPerKilo = new javax.swing.JTextField();
        txtBerat = new javax.swing.JTextField();
        txtTotalHarga = new javax.swing.JTextField();
        txtBayar = new javax.swing.JTextField();
        txtNoPesanan = new javax.swing.JTextField();
        CbJenisCuci = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Bayar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-mobile-payment-48.png"))); // NOI18N
        Bayar.setText("Bayar");
        Bayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BayarActionPerformed(evt);
            }
        });
        getContentPane().add(Bayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, 130, 50));

        Batal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-cancel-40.png"))); // NOI18N
        Batal.setText("Batal");
        Batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BatalActionPerformed(evt);
            }
        });
        getContentPane().add(Batal, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 520, 130, -1));
        getContentPane().add(txtNamaPemesan, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 230, 40));
        getContentPane().add(txtHargaPerKilo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, 230, 40));

        txtBerat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBeratKeyReleased(evt);
            }
        });
        getContentPane().add(txtBerat, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 230, 40));
        getContentPane().add(txtTotalHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 340, 230, 40));
        getContentPane().add(txtBayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 390, 230, 40));
        getContentPane().add(txtNoPesanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 230, 40));

        CbJenisCuci.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Silahkan Pilih" }));
        CbJenisCuci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbJenisCuciActionPerformed(evt);
            }
        });
        getContentPane().add(CbJenisCuci, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 230, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/pemesanan.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BayarActionPerformed
        // TODO add your handling code here:
        try {
            if (txtNoPesanan.getText().equals("") && txtNamaPemesan.getText().equals("") && txtHargaPerKilo.getText().equals("") 
                    && CbJenisCuci.getSelectedItem().equals("") && txtBerat.getText().equals("") && txtTotalHarga.getText().equals("") && txtBayar.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "silahkan isi data yang akan ditambah");
            } else {
                
                Laundry p = new Laundry();
                p.setNoPesanan(txtNoPesanan.getText());
                p.setNamaPemesan(txtNamaPemesan.getText());
                p.setHargaPerKilo(txtHargaPerKilo.getText());
                p.setJenisCuci((String) CbJenisCuci.getSelectedItem());
                p.setBerat(txtBerat.getText());
                p.setTotalHarga(txtTotalHarga.getText());
                p.setBayar(txtBayar.getText());
                int bayar = Integer.parseInt(txtBayar.getText());
                int totalhrg = Integer.parseInt(txtTotalHarga.getText());
                int kembalian = bayar-totalhrg;
                String kembali = Integer.toString(kembalian);
                JOptionPane.showMessageDialog(null, "Kembalian Anda : \n"+ kembali);
                interfaceLaundry.insert(p);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
        
        CbJenisCuci.setSelectedIndex(0);
        txtNamaPemesan.setText("");
        txtNoPesanan.setText("");
        txtHargaPerKilo.setText("");
        txtBerat.setText("");
        txtTotalHarga.setText("");
        txtBayar.setText("");
    }//GEN-LAST:event_BayarActionPerformed

    private void BatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BatalActionPerformed
       
        Menu m = new Menu();
        m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_BatalActionPerformed

    private void CbJenisCuciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbJenisCuciActionPerformed
       
        if(CbJenisCuci.getSelectedItem().toString().equalsIgnoreCase("Cuci Basah")){
            txtHargaPerKilo.setText("3000");
        }else if(CbJenisCuci.getSelectedItem().toString().equalsIgnoreCase("Cuci Kering")){
            txtHargaPerKilo.setText("4000");
        }else if(CbJenisCuci.getSelectedItem().toString().equalsIgnoreCase("Cuci Setrika")){
            txtHargaPerKilo.setText("5000");
        }
    }//GEN-LAST:event_CbJenisCuciActionPerformed

    private void txtBeratKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBeratKeyReleased
        
        int harga = Integer.parseInt(txtHargaPerKilo.getText());
        int berat = Integer.parseInt(txtBerat.getText());
        int totalbyr = harga*berat;
        String total = Integer.toString(totalbyr);
        txtTotalHarga.setText(total);
    }//GEN-LAST:event_txtBeratKeyReleased

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
            java.util.logging.Logger.getLogger(Pemesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pemesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pemesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pemesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pemesanan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Batal;
    private javax.swing.JButton Bayar;
    private javax.swing.JComboBox<String> CbJenisCuci;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtBayar;
    private javax.swing.JTextField txtBerat;
    private javax.swing.JTextField txtHargaPerKilo;
    private javax.swing.JTextField txtNamaPemesan;
    private javax.swing.JTextField txtNoPesanan;
    private javax.swing.JTextField txtTotalHarga;
    // End of variables declaration//GEN-END:variables
}