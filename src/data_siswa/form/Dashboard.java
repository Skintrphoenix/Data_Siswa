package data_siswa.form;

import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JEditorPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

import data_siswa.database.Collection;
import data_siswa.database.OrangTua;
import data_siswa.database.Siswa;
import data_siswa.database.Siswa_Detail;
import data_siswa.database.Wali;

import java.awt.Component;
import java.awt.Toolkit;
import java.sql.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author ASUS
 */
public class Dashboard extends javax.swing.JFrame {

    /**
     * Creates new form Dashboard
     */
    public Dashboard() {
        initComponents();
        PlainDocument doc = (PlainDocument) siswa_anak_ke.getDocument();
        doc.setDocumentFilter(new MyIntFilter());

        Delete.enable(false);

        refreshTable();
        resetForm();
    }

    void refreshTable(){
        Collection<Siswa> col = (new Siswa()).getAll();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        for (int i = model.getRowCount() - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        
            

        for(Map.Entry<Integer, Siswa> entry : col.entrySet()) {
            Siswa siswa = entry.getValue();
            model.addRow(new Object[]{entry.getKey() + 1, siswa.nisn, siswa.nama_lengkap});
        }
    }

    boolean addorEdit(Siswa siswa, Siswa_Detail siswa_Detail, OrangTua orangTua, Wali wali){
        siswa.nama_lengkap = siswa_nama_lengkap.getText();
        siswa.nomor_induk = siswa_nomor_induk.getText();
        siswa.nisn = siswa_nisn.getText();
        siswa.gender = siswa_jk.getSelectedItem().toString();
        siswa.agama = siswa_agama.getSelectedItem().toString();
        siswa.status_dalam_keluarga = ssiwa_status_dalam_keluarga.getSelectedItem().toString();
        siswa.anak_ke = Integer.parseInt(siswa_anak_ke.getText());
        siswa.alamat = siswa_alamat.getText();
        siswa.nomor_telfon = siswa_nomor_telefon.getText();
        siswa.sekolah_asal = siswa_sekolah_asal.getText();
        siswa.tempat_lahir = siswa_tempat_lahir.getText();
        siswa.tanggal_lahir = new Date(siswa_tanggal_lahir.getDate().getTime());
        if(siswa.save()){
            siswa_Detail.siswa_id = siswa.id;
            siswa_Detail.siswa = siswa;
            siswa_Detail.di_kelas = siswa_detail_kelas.getText();
            siswa_Detail.pada_tanggal = new Date(siswa_detail_pada_tanggal.getDate().getTime());
            if(siswa_Detail.save()){
                orangTua.siswa_id = siswa.id;
                orangTua.nama_ayah = ortu_ayah_nama.getText();
                orangTua.nama_ibu = ortu_ibu_nama.getText();
                orangTua.alamat = ortu_alamat.getText();
                orangTua.pekerjaan_ayah = ortu_ayah_pekerjaan.getText();
                orangTua.pekerjaan_ibu = ortu_ibu_pekerjaan.getText();
                orangTua.nomor_telfon = ortu_nomor_telefon.getText();
                orangTua.siswa = siswa;
                if(orangTua.save()){
                    wali.siswa_id = siswa.id;
                    wali.nama = wali_nama.getText();
                    wali.alamat = wali_alamat.getText();
                    wali.pekerjaan = wali_pekerjaan.getText();
                    wali.nomor_telfon = wali_nomor_telefon.getText();
                    wali.siswa = siswa;
                    if(wali.save()){
                        JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan", "Success", JOptionPane.INFORMATION_MESSAGE);
                        refreshTable();
                        resetForm();
                        return true;
                    }
                }
            }
        }
        siswa.delete();
        JOptionPane.showMessageDialog(null, "Data Gagal Disimpan", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    void resetForm(){
        siswa_nama_lengkap.setText("");
        siswa_nomor_induk.setText("");
        siswa_nisn.setText("");
        siswa_anak_ke.setText("");
        siswa_alamat.setText("");
        siswa_nomor_telefon.setText("");
        siswa_sekolah_asal.setText("");
        siswa_tempat_lahir.setText("");
        siswa_tanggal_lahir.setDate(new java.util.Date());

        siswa_detail_kelas.setText("");
        siswa_detail_pada_tanggal.setDate(new java.util.Date());

        ortu_ayah_nama.setText("");
        ortu_ibu_nama.setText("");
        ortu_alamat.setText("");
        ortu_ayah_pekerjaan.setText("");
        ortu_ibu_pekerjaan.setText("");
        ortu_nomor_telefon.setText("");

        wali_nama.setText("");
        wali_alamat.setText("");
        wali_pekerjaan.setText("");
        wali_nomor_telefon.setText("");
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
        Delete = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        siswa_tempat_lahir = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        siswa_sekolah_asal = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        siswa_jk = new javax.swing.JComboBox<>();
        siswa_detail_kelas = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        siswa_agama = new javax.swing.JComboBox<>();
        jLabel45 = new javax.swing.JLabel();
        ssiwa_status_dalam_keluarga = new javax.swing.JComboBox<>();
        jLabel46 = new javax.swing.JLabel();
        siswa_anak_ke = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        label3 = new java.awt.Label();
        siswa_nama_lengkap = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        siswa_nomor_induk = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        siswa_alamat = new javax.swing.JTextArea();
        siswa_nisn = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        siswa_nomor_telefon = new javax.swing.JTextField();
        siswa_tanggal_lahir = new org.jdesktop.swingx.JXDatePicker();
        siswa_detail_pada_tanggal = new org.jdesktop.swingx.JXDatePicker();
        jPanel2 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        ortu_ayah_nama = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        ortu_ayah_pekerjaan = new javax.swing.JTextField();
        ortu_ibu_pekerjaan = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        ortu_ibu_nama = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ortu_alamat = new javax.swing.JTextArea();
        jLabel64 = new javax.swing.JLabel();
        ortu_nomor_telefon = new javax.swing.JTextField();
        label7 = new java.awt.Label();
        jPanel4 = new javax.swing.JPanel();
        label6 = new java.awt.Label();
        jLabel66 = new javax.swing.JLabel();
        wali_nama = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        wali_pekerjaan = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        wali_alamat = new javax.swing.JTextArea();
        jLabel72 = new javax.swing.JLabel();
        wali_nomor_telefon = new javax.swing.JTextField();
        Edit = new javax.swing.JButton();
        Tambah = new javax.swing.JButton();
        search = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(600, 300));
        setMinimumSize(new java.awt.Dimension(600, 300));
        setName("Dashboard"); // NOI18N
        setResizable(false);
        setSize(new java.awt.Dimension(600, 300));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "NISN", "Nama Lengkap"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTable1.setAutoscrolls(false);
        jTable1.setMaximumSize(new java.awt.Dimension(350, 150));
        jTable1.setMinimumSize(new java.awt.Dimension(350, 150));
        jTable1.setPreferredSize(new java.awt.Dimension(350, 150));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
        }

        Delete.setText("Delete");
        Delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeleteMouseClicked(evt);
            }
        });
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel50.setText("Sekolah Asal");

        jLabel42.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel42.setText(",");

        siswa_sekolah_asal.setName(""); // NOI18N

        jLabel43.setText("tempat, tanggal lahir");

        jLabel51.setText("Diterima di sekolah ini :");

        jLabel52.setText("Di kelas");

        jLabel44.setText("Jenis kelamin");

        siswa_jk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "laki-laki", "perempuan" }));

        siswa_detail_kelas.setName(""); // NOI18N

        jLabel53.setText("Pada Tanggal");

        siswa_agama.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Islam", "Katolik", "Kristen", "Hindu", "Budha", "Konghucu" }));

        jLabel45.setText("Agama");

        ssiwa_status_dalam_keluarga.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Anak Kandung", "Bukan Anak Kandung" }));

        jLabel46.setText("Status dalam keluarga");

        jLabel47.setText("Anak Ke");

        jLabel48.setText("Alamat Peserta Didik");

        jLabel39.setText("nama lengkap");

        label3.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        label3.setMaximumSize(new java.awt.Dimension(24, 210));
        label3.setMinimumSize(new java.awt.Dimension(24, 210));
        label3.setText("Data Siswa");

        siswa_nama_lengkap.setName(""); // NOI18N

        jLabel40.setText("nomor induk / nisn");

        siswa_alamat.setColumns(20);
        siswa_alamat.setRows(5);
        jScrollPane2.setViewportView(siswa_alamat);

        jLabel49.setText("nomor telepon rumah");

        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel41.setText("/");

        siswa_nomor_telefon.setName(""); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel39)
                            .addComponent(jLabel44)
                            .addComponent(jLabel40)
                            .addComponent(jLabel43)
                            .addComponent(jLabel45)
                            .addComponent(jLabel46)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel49)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel47, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel48, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addComponent(jLabel50, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(siswa_jk, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(siswa_sekolah_asal, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(siswa_anak_ke, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ssiwa_status_dalam_keluarga, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(siswa_tempat_lahir, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(siswa_tanggal_lahir, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(siswa_nomor_induk, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(siswa_nisn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(siswa_agama, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(siswa_nama_lengkap, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(24, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(siswa_nomor_telefon, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 36, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel51)
                    .addComponent(jLabel52)
                    .addComponent(jLabel53))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(siswa_detail_kelas, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(siswa_detail_pada_tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(163, 163, 163)
                            .addComponent(jLabel42))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(72, 72, 72)
                            .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(116, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(siswa_nama_lengkap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(siswa_nomor_induk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(siswa_nisn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(siswa_tempat_lahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43)
                    .addComponent(siswa_tanggal_lahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(siswa_jk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(siswa_agama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ssiwa_status_dalam_keluarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel46))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(siswa_anak_ke, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel47))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel48))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(siswa_nomor_telefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel49))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(siswa_sekolah_asal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel50))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel51)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(siswa_detail_kelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel53)
                    .addComponent(siswa_detail_pada_tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(38, 38, 38)
                    .addComponent(jLabel41)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel42)
                    .addContainerGap(493, Short.MAX_VALUE)))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel54.setText("Ayah : ");

        jLabel55.setText("Nama Lengkap");

        ortu_ayah_nama.setName(""); // NOI18N
        ortu_ayah_nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ortu_ayah_namaActionPerformed(evt);
            }
        });

        jLabel56.setText("Pekerjaan");

        ortu_ayah_pekerjaan.setName(""); // NOI18N
        ortu_ayah_pekerjaan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ortu_ayah_nama1ActionPerformed(evt);
            }
        });

        ortu_ibu_pekerjaan.setName(""); // NOI18N
        ortu_ibu_pekerjaan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ortu_ibu_pekerjaanortu_ayah_nama1ActionPerformed(evt);
            }
        });

        jLabel60.setText("Pekerjaan");

        ortu_ibu_nama.setName(""); // NOI18N
        ortu_ibu_nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ortu_ibu_namaActionPerformed(evt);
            }
        });

        jLabel61.setText("Nama Lengkap");

        jLabel62.setText("Ibu : ");

        jLabel63.setText("Alamat Orang Tua");

        ortu_alamat.setColumns(20);
        ortu_alamat.setRows(5);
        jScrollPane3.setViewportView(ortu_alamat);

        jLabel64.setText("nomor telepon rumah");

        ortu_nomor_telefon.setName(""); // NOI18N

        label7.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        label7.setMaximumSize(new java.awt.Dimension(24, 210));
        label7.setMinimumSize(new java.awt.Dimension(24, 210));
        label7.setText("Data Orang Tua");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel56)
                                .addGap(18, 18, 18)
                                .addComponent(ortu_ayah_pekerjaan, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(jLabel55)
                                    .addGap(18, 18, 18)
                                    .addComponent(ortu_ayah_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel54))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel60)
                                .addGap(18, 18, 18)
                                .addComponent(ortu_ibu_pekerjaan, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(jLabel61)
                                    .addGap(18, 18, 18)
                                    .addComponent(ortu_ibu_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel62))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel63)
                            .addComponent(jLabel64))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ortu_nomor_telefon, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(69, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(252, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jLabel54)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(ortu_ayah_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(ortu_ayah_pekerjaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel62)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel61)
                    .addComponent(ortu_ibu_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel60)
                    .addComponent(ortu_ibu_pekerjaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel63))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ortu_nomor_telefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel64))
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(320, Short.MAX_VALUE)))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        label6.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        label6.setMaximumSize(new java.awt.Dimension(24, 210));
        label6.setMinimumSize(new java.awt.Dimension(24, 210));
        label6.setText("Data Wali Peserta Didik");

        jLabel66.setText("Nama Lengkap");

        wali_nama.setName(""); // NOI18N
        wali_nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wali_namaActionPerformed(evt);
            }
        });

        jLabel67.setText("Pekerjaan");

        wali_pekerjaan.setName(""); // NOI18N
        wali_pekerjaan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wali_pekerjaanortu_ayah_nama1ActionPerformed(evt);
            }
        });

        jLabel71.setText("Alamat Orang Tua");

        wali_alamat.setColumns(20);
        wali_alamat.setRows(5);
        jScrollPane4.setViewportView(wali_alamat);

        jLabel72.setText("nomor telepon rumah");

        wali_nomor_telefon.setName(""); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel66)
                                .addGap(18, 18, 18)
                                .addComponent(wali_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel67)
                                .addGap(18, 18, 18)
                                .addComponent(wali_pekerjaan, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel71)
                            .addComponent(jLabel72))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(wali_nomor_telefon, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel66)
                    .addComponent(wali_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel67)
                    .addComponent(wali_pekerjaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel71))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wali_nomor_telefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel72))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        Edit.setText("Edit");
        Edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EditMouseClicked(evt);
            }
        });
        Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditActionPerformed(evt);
            }
        });

        Tambah.setText("Tambah");
        Tambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TambahMouseClicked(evt);
            }
        });
        Tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TambahActionPerformed(evt);
            }
        });

        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });

        jLabel1.setText("Search");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 20, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Tambah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Edit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Delete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DeleteActionPerformed

    private void DeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteMouseClicked
        // TODO add your handling code here:
        if(jTable1.getSelectedRow() != -1){
            Siswa siswa = new Siswa().where("nisn", jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 1).toString());
            int reply = JOptionPane.showConfirmDialog(null, "Apakah Mau Menghapus Data tersebut?", "Warning", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                if(siswa.delete()){
                    JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus", "Success", JOptionPane.INFORMATION_MESSAGE);
                    resetForm();
                }else{
                    JOptionPane.showMessageDialog(null, "Data Gagal Dihapus", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            refreshTable();
        }else{
            JOptionPane.showMessageDialog(null, "Pilihlah Data di Table yang Mau Dihapus", "Warning", JOptionPane.WARNING_MESSAGE);
        }

        Delete.enable(false);
    }//GEN-LAST:event_DeleteMouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        Delete.enable(true);
        if(jTable1.getSelectedRow() != -1){
            Siswa siswa = new Siswa().where("nisn", jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 1).toString());

            siswa_nama_lengkap.setText( siswa.nama_lengkap );
            siswa_nomor_induk.setText(siswa.nomor_induk);
            siswa_nisn.setText(siswa.nisn);
            siswa_jk.setSelectedItem(siswa.gender);
            siswa_agama.setSelectedItem(siswa.agama);
            ssiwa_status_dalam_keluarga.setSelectedItem(siswa.status_dalam_keluarga);
            siswa_anak_ke.setText(String.valueOf(siswa.anak_ke));
            siswa_alamat.setText(siswa.alamat);
            siswa_nomor_telefon.setText(siswa.nomor_telfon);
            siswa_sekolah_asal.setText(siswa.sekolah_asal);
            siswa_tempat_lahir.setText(siswa.tempat_lahir);
            siswa_tanggal_lahir.setDate(siswa.tanggal_lahir);

            Siswa_Detail siswa_Detail = (new Siswa_Detail()).where("siswa_id", String.valueOf(siswa.id));
            siswa_detail_kelas.setText(siswa_Detail.di_kelas);
            siswa_detail_pada_tanggal.setDate(siswa_Detail.pada_tanggal);

            OrangTua ortu = (new OrangTua()).where("siswa_id", String.valueOf(siswa.id));
            ortu_ayah_nama.setText(ortu.nama_ayah);
            ortu_ibu_nama.setText(ortu.nama_ibu);
            ortu_alamat.setText(ortu.alamat);
            ortu_ayah_pekerjaan.setText(ortu.pekerjaan_ayah);
            ortu_ibu_pekerjaan.setText(ortu.pekerjaan_ibu);
            ortu_nomor_telefon.setText(ortu.nomor_telfon);

            Wali wali = (new Wali()).where("siswa_id", String.valueOf(siswa.id));
            wali_nama.setText(wali.nama);
            wali_alamat.setText(wali.alamat);
            wali_pekerjaan.setText(wali.pekerjaan);
            wali_nomor_telefon.setText(wali.nomor_telfon);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void ortu_ayah_namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ortu_ayah_namaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ortu_ayah_namaActionPerformed

    private void ortu_ayah_nama1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ortu_ayah_nama1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ortu_ayah_nama1ActionPerformed

    private void ortu_ibu_pekerjaanortu_ayah_nama1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ortu_ibu_pekerjaanortu_ayah_nama1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ortu_ibu_pekerjaanortu_ayah_nama1ActionPerformed

    private void ortu_ibu_namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ortu_ibu_namaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ortu_ibu_namaActionPerformed

    private void wali_namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wali_namaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_wali_namaActionPerformed

    private void wali_pekerjaanortu_ayah_nama1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wali_pekerjaanortu_ayah_nama1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_wali_pekerjaanortu_ayah_nama1ActionPerformed

    private void EditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditMouseClicked
        if(jTable1.getSelectedRow() != -1){
            Siswa siswa = new Siswa().where("nisn", jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 1).toString());
            Siswa_Detail siswa_Detail = (new Siswa_Detail()).where("siswa_id", String.valueOf(siswa.id));
            OrangTua ortu = (new OrangTua()).where("siswa_id", String.valueOf(siswa.id));
            Wali wali = (new Wali()).where("siswa_id", String.valueOf(siswa.id));

            this.addorEdit(siswa, siswa_Detail, ortu, wali);
        }else{
            JOptionPane.showMessageDialog(null, "Pilihlah Data di Table yang Mau Diedit", "Warning", JOptionPane.WARNING_MESSAGE);
        }

        Delete.enable(false);
    }//GEN-LAST:event_EditMouseClicked

    private void EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EditActionPerformed

    private void TambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TambahMouseClicked
        // TODO add your handling code here:
        this.addorEdit(new Siswa(), new Siswa_Detail(), new OrangTua(), new Wali());

    }//GEN-LAST:event_TambahMouseClicked

    private void TambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TambahActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchActionPerformed

    private void searchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_searchKeyPressed

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
        // TODO add your handling code here:

        String key = search.getText();
        System.out.println(key);

        if(key == ""){
            refreshTable();
        }else{
            Collection<Siswa> col = (new Siswa()).sql("select * from tb_siswa where nisn like '%" +key +"%' or nama_lengkap like '%" + key +"%'");
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            for (int i = model.getRowCount() - 1; i >= 0; i--) {
                model.removeRow(i);
            }

            for(Map.Entry<Integer, Siswa> entry : col.entrySet()) {
                Siswa siswa = entry.getValue();
                model.addRow(new Object[]{entry.getKey() + 1, siswa.nisn, siswa.nama_lengkap});
            }
        }
    }//GEN-LAST:event_searchKeyReleased

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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Delete;
    private javax.swing.JButton Edit;
    private javax.swing.JButton Tambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private java.awt.Label label3;
    private java.awt.Label label6;
    private java.awt.Label label7;
    private javax.swing.JTextArea ortu_alamat;
    private javax.swing.JTextField ortu_ayah_nama;
    private javax.swing.JTextField ortu_ayah_pekerjaan;
    private javax.swing.JTextField ortu_ibu_nama;
    private javax.swing.JTextField ortu_ibu_pekerjaan;
    private javax.swing.JTextField ortu_nomor_telefon;
    private javax.swing.JTextField search;
    private javax.swing.JComboBox<String> siswa_agama;
    private javax.swing.JTextArea siswa_alamat;
    private javax.swing.JTextField siswa_anak_ke;
    private javax.swing.JTextField siswa_detail_kelas;
    private org.jdesktop.swingx.JXDatePicker siswa_detail_pada_tanggal;
    private javax.swing.JComboBox<String> siswa_jk;
    private javax.swing.JTextField siswa_nama_lengkap;
    private javax.swing.JTextField siswa_nisn;
    private javax.swing.JTextField siswa_nomor_induk;
    private javax.swing.JTextField siswa_nomor_telefon;
    private javax.swing.JTextField siswa_sekolah_asal;
    private org.jdesktop.swingx.JXDatePicker siswa_tanggal_lahir;
    private javax.swing.JTextField siswa_tempat_lahir;
    private javax.swing.JComboBox<String> ssiwa_status_dalam_keluarga;
    private javax.swing.JTextArea wali_alamat;
    private javax.swing.JTextField wali_nama;
    private javax.swing.JTextField wali_nomor_telefon;
    private javax.swing.JTextField wali_pekerjaan;
    // End of variables declaration//GEN-END:variables
}

class MyIntFilter extends DocumentFilter {
    public void replace(FilterBypass fb, int offs, int length,
        String str, AttributeSet a) throws BadLocationException {

        String text = fb.getDocument().getText(0,
                fb.getDocument().getLength());
        text += str;
        if ((fb.getDocument().getLength() + str.length() - length) <= 3
                && text.matches("^[0-9]+[.]?[0-9]{0,1}$")) {
            super.replace(fb, offs, length, str, a);
        } else {
            Toolkit.getDefaultToolkit().beep();
        }
    }

    public void insertString(FilterBypass fb, int offs, String str,
            AttributeSet a) throws BadLocationException {

        String text = fb.getDocument().getText(0,
                fb.getDocument().getLength());
        text += str;
        if ((fb.getDocument().getLength() + str.length()) <= 3
                && text.matches("^[0-9]+[.]?[0-9]{0,1}$")) {
            super.insertString(fb, offs, str, a);
        } else {
            Toolkit.getDefaultToolkit().beep();
        }
    }
}