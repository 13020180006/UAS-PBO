/*
    Nama	: Paramadina Mulya Majid
    Stambuk	: 13020180006
    Hari/Tgl	: Jumat, 26 Juni 2020
    Waktu	: 22.48 WITA
*/
package View;

import Source.ImplementLaundry;
import Source.InterfaceLaundry;
import Source.KoneksiDatabase;
import Source.Laundry;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class HistoryPemesanan extends javax.swing.JFrame {

    DefaultTableModel model = new DefaultTableModel();
    InterfaceLaundry interfaceLaundry;
    List record = new ArrayList();
    int baris;
    
    public HistoryPemesanan() {
        initComponents();
        KoneksiDatabase.getConnection();
        interfaceLaundry = new ImplementLaundry();
        Edit.setEnabled(true);
        Hapus.setEnabled(true);
        Kembali.setEnabled(true);
        ambil_data();
        daftarJenisCuci();
    }
    
    void daftarJenisCuci() { 
        Object[] jen = {"Cuci Basah", "Cuci Kering", "Cuci Setrika"};
        for (int i = 0; i < jen.length; i++) { 
            CbJenisCuci.addItem(jen[i].toString()); 
        } 
        String kJen = CbJenisCuci.getSelectedItem().toString(); 
    }
    
    public void ambil_data() {
        try {
            record = interfaceLaundry.getAll();
            Object data[][] = new Object[record.size()][7];
            int x = 0;
            for (Iterator it = record.iterator(); it.hasNext();) {
                Laundry p = (Laundry) it.next();
                data[x][0] = p.getNoPesanan();
                data[x][1] = p.getNamaPemesan();
                data[x][2] = p.getJenisCuci();
                data[x][3] = p.getHargaPerKilo();
                data[x][4] = p.getBerat();
                data[x][5] = p.getTotalHarga();
                data[x][6] = p.getBayar();
                x++;
            }
            String judul[] = {"NO PESANAN", "NAMA PEMESAN", "JENIS CUCI", "HARGA PER KILO", "BERAT", "TOTAL HARGA", "BAYAR"};
            jTable1.setModel(new DefaultTableModel(data, judul));
            jScrollPane1.setViewportView(jTable1);
        } catch (SQLException ex){
            Logger.getLogger(HistoryPemesanan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void loadData() { 
        try { 
            record = interfaceLaundry.getAll(); 
        } catch (SQLException ex) { 
            Logger.getLogger(KoneksiDatabase.class.getName()).log(Level.SEVERE, null, ex); 
        } 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Edit = new javax.swing.JButton();
        Hapus = new javax.swing.JButton();
        Kembali = new javax.swing.JButton();
        txtNamaPemesan = new javax.swing.JTextField();
        txtHargaPerKilo = new javax.swing.JTextField();
        txtBerat = new javax.swing.JTextField();
        txtTotalHarga = new javax.swing.JTextField();
        txtBayar = new javax.swing.JTextField();
        txtNoPesanan = new javax.swing.JTextField();
        CbJenisCuci = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setBackground(new java.awt.Color(255, 204, 204));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "NO PEMESANAN", "NAMA PEMESAN", "JENIS CUCI", "HARGA PER KILO", "BERAT", "TOTAL HARGA", "BAYAR"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 820, 130));

        Edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-edit-64.png"))); // NOI18N
        Edit.setText("EDIT");
        Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditActionPerformed(evt);
            }
        });
        getContentPane().add(Edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 540, 130, 70));

        Hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-delete-bin-64.png"))); // NOI18N
        Hapus.setText("HAPUS");
        Hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HapusActionPerformed(evt);
            }
        });
        getContentPane().add(Hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 540, -1, -1));

        Kembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-back-64.png"))); // NOI18N
        Kembali.setText("KEMBALI");
        Kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KembaliActionPerformed(evt);
            }
        });
        getContentPane().add(Kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 540, -1, -1));

        txtNamaPemesan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaPemesanActionPerformed(evt);
            }
        });
        getContentPane().add(txtNamaPemesan, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 240, 180, 30));

        txtHargaPerKilo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHargaPerKiloActionPerformed(evt);
            }
        });
        getContentPane().add(txtHargaPerKilo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 340, 180, 30));

        txtBerat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBeratActionPerformed(evt);
            }
        });
        getContentPane().add(txtBerat, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 210, 180, 30));

        txtTotalHarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalHargaActionPerformed(evt);
            }
        });
        getContentPane().add(txtTotalHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 250, 180, 30));

        txtBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBayarActionPerformed(evt);
            }
        });
        getContentPane().add(txtBayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 300, 180, 30));

        txtNoPesanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNoPesananActionPerformed(evt);
            }
        });
        getContentPane().add(txtNoPesanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 180, 30));

        CbJenisCuci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbJenisCuciActionPerformed(evt);
            }
        });
        getContentPane().add(CbJenisCuci, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, 180, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/HISTORY.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void KembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KembaliActionPerformed
        
        Menu m = new Menu();
        m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_KembaliActionPerformed
String NoPesanAwal;
    private void EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditActionPerformed
        
        try { 
            Laundry l = new Laundry(); 
            l.setNoPesanan(txtNoPesanan.getText().trim()); 
            l.setNamaPemesan(txtNamaPemesan.getText().trim()); 
            l.setJenisCuci(String.valueOf(CbJenisCuci.getSelectedItem()).trim());
            
            
            
            
            l.setHargaPerKilo(txtHargaPerKilo.getText().trim());
            l.setBerat(txtBerat.getText().trim()); 
            l.setTotalHarga(txtTotalHarga.getText().trim());
            l.setBayar(txtBayar.getText().trim());
            interfaceLaundry.update(l, NoPesanAwal); 
            JOptionPane.showMessageDialog(this, "data berhasil diubah");
            ambil_data();
        } catch (SQLException ex) { 
            System.out.println(""+ex.getMessage());
            Logger.getLogger(HistoryPemesanan.class.getName()).log(Level.SEVERE, null, ex); 
        }
    }//GEN-LAST:event_EditActionPerformed

    private void HapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HapusActionPerformed
        
        try { 
            String NoPesanan = txtNoPesanan.getText(); 
            interfaceLaundry.delete(NoPesanan); 
             ambil_data ();
             txtNoPesanan.setText("");
             txtNamaPemesan.setText("");
             txtHargaPerKilo.setText("");
             txtBerat.setText("");
             txtTotalHarga.setText("");
             txtBayar.setText("");
             CbJenisCuci.setSelectedIndex(0);
            JOptionPane.showMessageDialog(this, "data berhasil dihapus"); 
        } catch (SQLException ex) { 
            Logger.getLogger(HistoryPemesanan.class.getName()).log(Level.SEVERE, null, ex); 
        }
    }//GEN-LAST:event_HapusActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
        int baris = jTable1.getSelectedRow();

    String kolom1 = jTable1.getValueAt(baris, 0).toString();
    String kolom2 = jTable1.getValueAt(baris, 1).toString();
    String kolom3 = jTable1.getValueAt(baris, 2).toString();
    String kolom4 = jTable1.getValueAt(baris, 3).toString();
    String kolom5 = jTable1.getValueAt(baris, 4).toString();
    String kolom6 = jTable1.getValueAt(baris, 5).toString();
    String kolom7 = jTable1.getValueAt(baris, 6).toString();

        NoPesanAwal = kolom1;
        txtNoPesanan.setText(kolom1);
        txtNamaPemesan.setText(kolom2);
        if(kolom3.equalsIgnoreCase("Cuci Basah")){
            CbJenisCuci.setSelectedIndex(0);
        }else if(kolom3.equalsIgnoreCase("Cuci Kering")){
            CbJenisCuci.setSelectedIndex(1);
        }else if(kolom3.equalsIgnoreCase("Cuci Setrika")){
            CbJenisCuci.setSelectedIndex(2);
        }
        txtHargaPerKilo.setText(kolom4);
        txtBerat.setText(kolom5);
        txtTotalHarga.setText(kolom6);
        txtBayar.setText(kolom7);
    }//GEN-LAST:event_jTable1MouseClicked

    private void txtNoPesananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNoPesananActionPerformed
       
        Edit.setEnabled(true);
        Hapus.setEnabled(true);
    }//GEN-LAST:event_txtNoPesananActionPerformed

    private void txtNamaPemesanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaPemesanActionPerformed
        
        Edit.setEnabled(true);
        Hapus.setEnabled(true);
    }//GEN-LAST:event_txtNamaPemesanActionPerformed

    private void CbJenisCuciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbJenisCuciActionPerformed


        if(CbJenisCuci.getSelectedItem().toString().equalsIgnoreCase("Cuci Basah")){
            txtHargaPerKilo.setText("3000");
            }else if(CbJenisCuci.getSelectedItem().toString().equalsIgnoreCase("Cuci Kering")){
                txtHargaPerKilo.setText("4000");
            }else if(CbJenisCuci.getSelectedItem().toString().equalsIgnoreCase("Cuci Setrika")){
                txtHargaPerKilo.setText("5000");
            }
       
        Edit.setEnabled(true);
        Hapus.setEnabled(true);
    }//GEN-LAST:event_CbJenisCuciActionPerformed

    private void txtHargaPerKiloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHargaPerKiloActionPerformed
        
        Edit.setEnabled(true);
        Hapus.setEnabled(true);
    }//GEN-LAST:event_txtHargaPerKiloActionPerformed

    private void txtBeratActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBeratActionPerformed
        
        int harga = Integer.parseInt(txtHargaPerKilo.getText());
        int berat = Integer.parseInt(txtBerat.getText());
        int totalbyr = harga*berat;
        String total = Integer.toString(totalbyr);
        txtTotalHarga.setText(total);
        Edit.setEnabled(true);
        Hapus.setEnabled(true);
    }//GEN-LAST:event_txtBeratActionPerformed

    private void txtTotalHargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalHargaActionPerformed
        
        Edit.setEnabled(true);
        Hapus.setEnabled(true);
    }//GEN-LAST:event_txtTotalHargaActionPerformed

    private void txtBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBayarActionPerformed
        
        Edit.setEnabled(true);
        Hapus.setEnabled(true);
    }//GEN-LAST:event_txtBayarActionPerformed

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
            java.util.logging.Logger.getLogger(HistoryPemesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HistoryPemesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HistoryPemesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HistoryPemesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HistoryPemesanan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CbJenisCuci;
    private javax.swing.JButton Edit;
    private javax.swing.JButton Hapus;
    private javax.swing.JButton Kembali;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtBayar;
    private javax.swing.JTextField txtBerat;
    private javax.swing.JTextField txtHargaPerKilo;
    private javax.swing.JTextField txtNamaPemesan;
    private javax.swing.JTextField txtNoPesanan;
    private javax.swing.JTextField txtTotalHarga;
    // End of variables declaration//GEN-END:variables
}
