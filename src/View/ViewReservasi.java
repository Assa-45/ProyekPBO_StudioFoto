
package View;
import Controller.ControllerReservasi;
import Model.Reservasi.ModelReservasi;
import Model.TemplateTable;
import Swing.ScrollBar;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;


public class ViewReservasi extends javax.swing.JFrame {
    private ControllerReservasi ctrl;
    private int selectedReservasiId = -1;

    public ViewReservasi() {
        initComponents(); 
        setBackground(new Color(0, 0, 0, 0));
        menu1.initMoving(ViewReservasi.this);
        spTable.setVerticalScrollBar(new ScrollBar());
        spTable.getVerticalScrollBar().setBackground(Color.WHITE);
        spTable.getViewport().setBackground(Color.WHITE);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        setVisible(true);
         
        ctrl = new ControllerReservasi(this);
        ctrl.showAll();
        
        searchComponent.setSearchListener(keyword -> {
            ctrl.search(keyword);
        });

    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new Swing.PanelBorder();
        searchComponent = new Component.Search();
        panelBorder2 = new Swing.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        spTable = new javax.swing.JScrollPane();
        table = new Swing.Table();
        menu1 = new Component.Menu();
        tombolEdit = new Swing.ButtonCustom();
        tombolTambah = new Swing.ButtonCustom();
        tombolDelete = new Swing.ButtonCustom();
        tombolReset = new Swing.ButtonCustom();
        inputCustomerName = new Swing.RoundedTextField();
        namaCustLabel = new javax.swing.JLabel();
        tglLabel = new javax.swing.JLabel();
        inputTanggal = new com.toedter.calendar.JDateChooser();
        inputNoHP = new Swing.RoundedTextField();
        noHpLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        inputStudio = new javax.swing.JComboBox<>();
        durasiLabel = new javax.swing.JLabel();
        inputDurasi = new com.toedter.components.JSpinField();
        inputJam = new Component.TimePicker();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelBorder1.setBackground(new java.awt.Color(237, 239, 220));
        panelBorder1.setPreferredSize(new java.awt.Dimension(1096, 666));

        panelBorder2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(127, 127, 127));
        jLabel1.setText("Tabel Reservasi");

        spTable.setBorder(null);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tanggal", "Customer", "No HP", "Jenis Studio", "Harga Per Jam", "Jam Mulai", "Jam Selesai", "Durasi", "Total Harga", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setRequestFocusEnabled(false);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        spTable.setViewportView(table);

        javax.swing.GroupLayout panelBorder2Layout = new javax.swing.GroupLayout(panelBorder2);
        panelBorder2.setLayout(panelBorder2Layout);
        panelBorder2Layout.setHorizontalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addContainerGap(865, Short.MAX_VALUE))
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spTable)
                .addContainerGap())
        );
        panelBorder2Layout.setVerticalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spTable, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        tombolEdit.setBackground(new java.awt.Color(40, 167, 69));
        tombolEdit.setForeground(new java.awt.Color(255, 255, 255));
        tombolEdit.setText("Edit");
        tombolEdit.setFocusPainted(false);
        tombolEdit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tombolEdit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tombolEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolEditActionPerformed(evt);
            }
        });

        tombolTambah.setBackground(new java.awt.Color(0, 123, 255));
        tombolTambah.setForeground(new java.awt.Color(255, 255, 255));
        tombolTambah.setText("Tambah");
        tombolTambah.setFocusPainted(false);
        tombolTambah.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tombolTambah.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tombolTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolTambahActionPerformed(evt);
            }
        });

        tombolDelete.setBackground(new java.awt.Color(220, 53, 69));
        tombolDelete.setForeground(new java.awt.Color(255, 255, 255));
        tombolDelete.setText("Hapus");
        tombolDelete.setFocusPainted(false);
        tombolDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tombolDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tombolDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolDeleteActionPerformed(evt);
            }
        });

        tombolReset.setBackground(new java.awt.Color(255, 193, 7));
        tombolReset.setForeground(new java.awt.Color(255, 255, 255));
        tombolReset.setText("Reset");
        tombolReset.setFocusPainted(false);
        tombolReset.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tombolReset.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tombolReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolResetActionPerformed(evt);
            }
        });

        namaCustLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        namaCustLabel.setText("Nama Customer");

        tglLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tglLabel.setText("Tanggal");

        inputTanggal.setDateFormatString("dd-MM-yy");
        inputTanggal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        noHpLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        noHpLabel.setText("No HP");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Pilih Studio");

        inputStudio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Small", "Medium", "Large" }));

        durasiLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        durasiLabel.setText("Durasi");

        inputDurasi.setMaximum(5);
        inputDurasi.setMinimum(0);

        inputJam.setAlignmentX(0.0F);
        inputJam.setAlignmentY(0.0F);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Jam Mulai");

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(menu1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchComponent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(panelBorder2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(namaCustLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tglLabel)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(inputCustomerName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(inputTanggal, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                            .addComponent(inputStudio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(noHpLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inputJam, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(durasiLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(inputNoHP, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                    .addComponent(inputDurasi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tombolEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tombolTambah, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                                .addComponent(tombolReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(tombolDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44))))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menu1, javax.swing.GroupLayout.PREFERRED_SIZE, 678, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(searchComponent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelBorder2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(noHpLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(namaCustLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tombolTambah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(inputCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(inputNoHP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(5, 5, 5)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tombolEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelBorder1Layout.createSequentialGroup()
                                        .addComponent(durasiLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(10, 10, 10))
                                    .addComponent(tglLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelBorder1Layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addComponent(tombolDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tombolReset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelBorder1Layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(inputTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(inputDurasi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelBorder1Layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(inputStudio, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(panelBorder1Layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(inputJam, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, 1222, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, 678, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tombolTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolTambahActionPerformed
        try {
            String namacust = getInputCustomerName();
            String nohp = getInputNoHP();
            int durasi = getInputDurasi();
            String jenisstudio = getInputStudio();
            Date tanggal = getInputTanggal();
            Time waktu = getInputJam();
            double hargaperjam;

            if (namacust.isEmpty() || nohp.isEmpty() || tanggal == null || durasi == 0 || waktu == null) {
                javax.swing.JOptionPane.showMessageDialog(this, "Isi semua data dengan benar!");
                return;
            }

            ModelReservasi reservasibaru = new ModelReservasi();
            reservasibaru.setDurasi_jam(durasi);
            reservasibaru.setNama_customer(namacust);
            reservasibaru.setNomor_hp_customer(nohp);
            reservasibaru.setTanggal(new java.sql.Date(tanggal.getTime()));
            reservasibaru.setTipe_studio(jenisstudio);
            reservasibaru.setJam_mulai(waktu);
            
            if(jenisstudio.equals("Small")){hargaperjam = 75000;}
            else if(jenisstudio.equals("Medium")){hargaperjam = 100000;}
            else{hargaperjam = 150000;}
            
            reservasibaru.setHarga_per_jam(hargaperjam);

            ctrl.insertData(new java.sql.Date(tanggal.getTime()), waktu, durasi, namacust, nohp, jenisstudio, hargaperjam);

            // reset inputan
            clearForm();
        }catch(Exception e){
           JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menambah data : " + e.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_tombolTambahActionPerformed

    private void tombolEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolEditActionPerformed
        try {
            if (selectedReservasiId != -1) {
                String namacust = getInputCustomerName();
                String nohp = getInputNoHP();
                int durasi = getInputDurasi();
                String jenisstudio = getInputStudio();
                Date tanggal = getInputTanggal();
                Time waktu = getInputJam();
                double hargaperjam;

                if (namacust.isEmpty() || nohp.isEmpty() || tanggal == null || durasi == 0 || waktu == null) {
                    JOptionPane.showMessageDialog(this, "Isi semua data dengan benar!");
                    return;
                }

                if(jenisstudio.equals("Small")){ hargaperjam = 75000; }
                else if(jenisstudio.equals("Medium")){ hargaperjam = 100000; }
                else { hargaperjam = 150000; }

                ctrl.editReservasi(selectedReservasiId, new java.sql.Date(tanggal.getTime()), waktu, durasi, namacust, nohp, jenisstudio, hargaperjam);

                clearForm(); 
                selectedReservasiId = -1;
                this.dispose();
                ctrl.showAll(); 
            } else {
                JOptionPane.showMessageDialog(this, createStyledPanel("Silahkan pilih baris yang akan diubah."), "Pilih Baris", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat mengubah data : " + e.getMessage(), "Edit Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_tombolEditActionPerformed

    private void tombolDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolDeleteActionPerformed
         try {
            int selectedRow = table.getSelectedRow();
            if(selectedRow != -1){
                ctrl.deleteReservasi(selectedRow);
                ctrl.showAll();
                clearForm();
            } else {
                JOptionPane.showMessageDialog(this, createStyledPanel("Silahkan pilih baris yang akan dihapus."), "Pilih Baris", JOptionPane.INFORMATION_MESSAGE);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menghapus data : " + e.getMessage(), "Delete Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_tombolDeleteActionPerformed

    private void tombolResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolResetActionPerformed
        clearForm();
    }//GEN-LAST:event_tombolResetActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        int selectedRow = table.getSelectedRow();

        if (selectedRow != -1) {
            try {
                selectedReservasiId = Integer.parseInt(table.getValueAt(selectedRow, 0).toString());
                Date tanggal = (Date) table.getValueAt(selectedRow, 1);
                String namaCustomer = table.getValueAt(selectedRow, 2).toString();
                String nomorHP = table.getValueAt(selectedRow, 3).toString();
                String tipeStudio = table.getValueAt(selectedRow, 4).toString();
                Object jamMulaiObj = table.getValueAt(selectedRow, 6);
                int durasiJam = Integer.parseInt(table.getValueAt(selectedRow, 8).toString());
                

                // Konversi jam mulai
                if (jamMulaiObj instanceof Time) {
                    System.out.println("jamMulaiObj is Time: " + jamMulaiObj.toString());
                    inputJam.setTime((Time) jamMulaiObj);
                } else if (jamMulaiObj instanceof String) {
                    String timeStr = jamMulaiObj.toString();
                    System.out.println("jamMulaiObj is String: " + timeStr);
                    if (timeStr.matches("\\d{2}:\\d{2}(:\\d{2})?")) {
                        inputJam.setTime(Time.valueOf(timeStr.length() == 5 ? timeStr + ":00" : timeStr));
                    } else {
                        System.err.println("Format jam tidak valid: " + timeStr);
                    }
                }


                // Set ke input
                inputCustomerName.setText(namaCustomer);
                inputNoHP.setText(nomorHP);
                inputStudio.setSelectedItem(tipeStudio);
                inputDurasi.setValue(durasiJam);
                inputTanggal.setDate(tanggal);

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Gagal mengambil data dari tabel.\n" + e.getMessage());
            }
        }

    }//GEN-LAST:event_tableMouseClicked

    public JTable getTableReservasi() {
        return table;
    }
    
    private JPanel createStyledPanel(String message) {
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createLineBorder(new Color(220, 53, 69), 2));
        JLabel label = new JLabel("<html><div style='padding:8px;font-size:12px;color:#dc3545;'>" + message + "</div></html>");
        label.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        panel.add(label);
        return panel;
    }
    
    private void clearForm(){
        inputCustomerName.setText("");
        inputNoHP.setText("");
        inputDurasi.setValue(0);
        inputTanggal.setDate(null);
        inputStudio.setSelectedIndex(0);
        inputJam.setTime(new Time(0));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel durasiLabel;
    private Swing.RoundedTextField inputCustomerName;
    private com.toedter.components.JSpinField inputDurasi;
    private Component.TimePicker inputJam;
    private Swing.RoundedTextField inputNoHP;
    private javax.swing.JComboBox<String> inputStudio;
    private com.toedter.calendar.JDateChooser inputTanggal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private Component.Menu menu1;
    private javax.swing.JLabel namaCustLabel;
    private javax.swing.JLabel noHpLabel;
    private Swing.PanelBorder panelBorder1;
    private Swing.PanelBorder panelBorder2;
    private Component.Search searchComponent;
    private javax.swing.JScrollPane spTable;
    private Swing.Table table;
    private javax.swing.JLabel tglLabel;
    private Swing.ButtonCustom tombolDelete;
    private Swing.ButtonCustom tombolEdit;
    private Swing.ButtonCustom tombolReset;
    private Swing.ButtonCustom tombolTambah;
    // End of variables declaration//GEN-END:variables

    public String getInputCustomerName() {
        return inputCustomerName.getText();
    }

    public int getInputDurasi() {
        return inputDurasi.getValue();
    }

    public Time getInputJam() {
        return inputJam.getTime();
    }

    public String getInputNoHP() {
        return inputNoHP.getText();
    }

    public String getInputStudio() {
        Object selectedItem = inputStudio.getSelectedItem();
        String studio = (selectedItem != null) ? selectedItem.toString() : "";
        return studio;
    }

    public Date getInputTanggal() {
        return inputTanggal.getDate();
    }
}
