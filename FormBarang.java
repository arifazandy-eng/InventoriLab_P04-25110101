/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Barang;
public class FormBarang extends javax.swing.JFrame {
    private static final long serialVersionUID = 1L;
private final List<Barang> daftarBarang = new ArrayList<Barang>();
private DefaultTableModel modelTabel;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormBarang.class.getName());

    
    public FormBarang() {
    initComponents();
    siapkanTabel();
    isiDataContoh();
    setLocationRelativeTo(null);
}
private void siapkanTabel() {
    modelTabel = new DefaultTableModel(
            new Object[]{"Kode", "Nama Barang", "Tersedia"}, 0) {
        private static final long serialVersionUID = 1L;

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    tblBarang.setModel(modelTabel);
    tblBarang.setRowHeight(26);
    tblBarang.getTableHeader().setReorderingAllowed(false);
}

private void isiDataContoh() {
    daftarBarang.add(new Barang("BRG-001", "Keyboard USB", 10));
    daftarBarang.add(new Barang("BRG-002", "Mouse USB", 8));
    perbaruiTabel();
    lblStatus.setText("Siap. Dua data contoh dimuat di memori.");
}

private void perbaruiTabel() {
    modelTabel.setRowCount(0);
    for (Barang barang : daftarBarang) {
        modelTabel.addRow(new Object[]{
            barang.getKode(),
            barang.getNama(),
            barang.getJumlahTersedia()
        });
    }
}

private void bersihkanInput() {
    txtKode.setText("");
    txtNama.setText("");
    txtJumlah.setText("");

    txtKode.requestFocusInWindow();
}

private void tambahDemo() {
    String kode = txtKode.getText().trim();
    String nama = txtNama.getText().trim();
    String teksJumlah = txtJumlah.getText().trim();

    try {
        if (kode.isEmpty() || nama.isEmpty() || teksJumlah.isEmpty()) {
            throw new IllegalArgumentException(
                    "Kode, nama, dan jumlah wajib diisi.");
        }

        int jumlah = Integer.parseInt(teksJumlah);

        Barang barang = new Barang(kode, nama, jumlah);

        daftarBarang.add(barang);
        perbaruiTabel();
        bersihkanInput();

        lblStatus.setText(
            "Barang " + barang.getNama() + " ditambahkan ke daftar sementara."
        );

    } catch (NumberFormatException e) {

        lblStatus.setText(
            "Jumlah belum valid. Data tidak ditambahkan."
        );

        JOptionPane.showMessageDialog(
            this,
            "Jumlah harus berupa angka.",
            "Input jumlah",
            JOptionPane.WARNING_MESSAGE
        );

        txtJumlah.requestFocusInWindow();
        txtJumlah.selectAll();

    } catch (IllegalArgumentException e) {

        lblStatus.setText(
            "Data tidak ditambahkan: " + e.getMessage()
        );

        JOptionPane.showMessageDialog(
            this,
            e.getMessage(),
            "Periksa data barang",
            JOptionPane.WARNING_MESSAGE
        );
    }
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblJudul = new javax.swing.JLabel();
        lblInfo = new javax.swing.JLabel();
        pnlInput = new javax.swing.JPanel();
        lblNama = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        lblJumlah = new javax.swing.JLabel();
        txtJumlah = new javax.swing.JTextField();
        btnTambah = new javax.swing.JButton();
        btnBersihkan = new javax.swing.JButton();
        btnTutup = new javax.swing.JButton();
        lblStatus = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBarang = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtKode = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inventori Laboratorium - Data Barang");
        setPreferredSize(new java.awt.Dimension(760, 520));

        lblJudul.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lblJudul.setText("INVENTORI LABORATORIUM");

        lblInfo.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblInfo.setText("Latihan antarmuka - data tersimpan sementara.");

        pnlInput.setBorder(javax.swing.BorderFactory.createTitledBorder("Input Barang"));

        javax.swing.GroupLayout pnlInputLayout = new javax.swing.GroupLayout(pnlInput);
        pnlInput.setLayout(pnlInputLayout);
        pnlInputLayout.setHorizontalGroup(
            pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        pnlInputLayout.setVerticalGroup(
            pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        lblNama.setText("Nama Barang");

        lblJumlah.setText("Jumlah Tersedia");

        txtJumlah.addActionListener(this::txtJumlahActionPerformed);

        btnTambah.setText("Tambah Demo");
        btnTambah.addActionListener(this::btnTambahActionPerformed);

        btnBersihkan.setText("Bersihkan Input");
        btnBersihkan.addActionListener(this::btnBersihkanActionPerformed);

        btnTutup.setText("Tutup");
        btnTutup.addActionListener(this::btnTutupActionPerformed);

        lblStatus.setText("Siap Isi data barang");

        tblBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblBarang);

        jLabel1.setText("Kode Barang");

        txtKode.addActionListener(this::txtKodeActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblJudul, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnTambah)
                                .addGap(104, 104, 104)
                                .addComponent(btnBersihkan)
                                .addGap(80, 80, 80)
                                .addComponent(btnTutup))
                            .addComponent(pnlInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblNama, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblJumlah)
                                            .addComponent(jLabel1))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtJumlah)
                                            .addComponent(txtKode, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)))))
                            .addComponent(lblInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblStatus))))
                .addContainerGap(284, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblJudul, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblInfo)
                .addGap(33, 33, 33)
                .addComponent(pnlInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNama)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblJumlah)
                    .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblStatus)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah)
                    .addComponent(btnBersihkan)
                    .addComponent(btnTutup))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtJumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJumlahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJumlahActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
tambahDemo();        
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnBersihkanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBersihkanActionPerformed
bersihkanInput();
lblStatus.setText("Input dibersihkan. Daftar barang tetap.");        
    }//GEN-LAST:event_btnBersihkanActionPerformed

    private void btnTutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTutupActionPerformed
dispose();        
    }//GEN-LAST:event_btnTutupActionPerformed

    private void txtKodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKodeActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new FormBarang().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBersihkan;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnTutup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblJudul;
    private javax.swing.JLabel lblJumlah;
    private javax.swing.JLabel lblNama;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JPanel pnlInput;
    private javax.swing.JTable tblBarang;
    private javax.swing.JTextField txtJumlah;
    private javax.swing.JTextField txtKode;
    private javax.swing.JTextField txtNama;
    // End of variables declaration//GEN-END:variables
}
