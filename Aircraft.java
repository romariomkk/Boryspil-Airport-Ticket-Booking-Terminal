
package Terminal;

import com.itextpdf.text.DocumentException;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class Aircraft extends javax.swing.JFrame 
                      implements LanguageSettings{

    ResourceBundle resource = null;
    Locale locale;
    JTable seatTable;
    ArrayList<String> flightData;
    String[][] seats = {{"1", "A", "2"},
            {"1", "B", "2"},
            {"1", "C", "2"},
            {"1", "D", "2"},
            {"1", "E", "2"},
            {"1", "F", "2"},
            {"1", "G", "2"},
            {"1", "H", "2"},
            {"1", "I", "2"},
            {"1", "J", "2"}
    };
    String[] colName = {"", "", "", "", ""};
    
    public Aircraft(ArrayList<String> flightData) {
        initComponents();
        applyLanguage();
        initTable();
        initFields(flightData);
    }

    @Override
    public void applyLanguage(){
        if (LangChoice.LANG_MODE)
            locale = new Locale("ru", "RU");
        else
            locale = Locale.US;
        
        resource = ResourceBundle.getBundle("Properties/AircraftSUPER", locale);
        changeLabels();
    }
    @Override
    public void changeLabels(){
        destLabel.setText(resource.getString("resultPane.destLabel.text"));
        flightNumLabel.setText(resource.getString("resultPane.flightNumLabel.text"));
        passengerLabel.setText(resource.getString("resultPane.passengerName.text"));
        pdfCreateButton.setText(resource.getString("resultPane.pdfCreateButton.text"));
        seatLabel.setText(resource.getString("resultPane.seatLabel.text"));
        timeLabel.setText(resource.getString("resultPane.timeLabel.text"));
    }
    
    private void initTable(){
        seatTable = new JTable(new AircraftTableModel(seats, colName));
        seatTable.setTableHeader(null);
        seatTable.setRowHeight(33);
        seatTable.setFont(new Font("Calibri", Font.BOLD, 25));
        seatTable.setRowSelectionAllowed(false);
        seatTable.setCellSelectionEnabled(true);
        seatTable.setSelectionBackground(Color.GREEN);
        seatTable.setSelectionForeground(Color.WHITE);
        seatTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        seatTable.getColumnModel().getColumn(0).setCellRenderer(new AircraftCellRenderer());
        seatTable.getColumnModel().getColumn(2).setCellRenderer(new AircraftCellRenderer());
        seatTable.getColumnModel().getColumn(1).setCellRenderer(new AircraftCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                setBackground(Color.GRAY);
                return this;
            }
        });
        seatTable.setShowGrid(false);
        seatTable.setShowVerticalLines(true);
        
        seatTable.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = seatTable.getSelectedRow(),
                    column = seatTable.getSelectedColumn();
                if (column != 1){
                    seatField.setText(seatTable.getValueAt(row, 1).toString() + seatTable.getValueAt(row, column).toString());
                }else{
                    seatField.setText("");
                }
            }
        });
        
        seatPane.setViewportView(seatTable);
    }
    
    private void initFields(ArrayList<String> flightData){
        this.flightData = flightData;
        timeField.setText(this.flightData.get(0));
        flightField.setText(this.flightData.get(1));
        destField.setText(this.flightData.get(2));
        passengerField.setText(UserLogin.CURRENT_USER_NAME);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        seatPane = new javax.swing.JScrollPane();
        backButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        resultPane = new javax.swing.JPanel();
        seatLabel = new javax.swing.JLabel();
        seatField = new javax.swing.JTextField();
        flightNumLabel = new javax.swing.JLabel();
        flightField = new javax.swing.JTextField();
        timeLabel = new javax.swing.JLabel();
        timeField = new javax.swing.JTextField();
        destLabel = new javax.swing.JLabel();
        destField = new javax.swing.JTextField();
        passengerLabel = new javax.swing.JLabel();
        passengerField = new javax.swing.JTextField();
        exitBut = new javax.swing.JButton();
        pdfCreateButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        seatPane.setBorder(null);
        getContentPane().add(seatPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, 130, 330));

        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backBut.png"))); // NOI18N
        backButton.setContentAreaFilled(false);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 0, 50, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/plane1.png"))); // NOI18N
        jLabel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 660));

        resultPane.setOpaque(false);

        seatLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        seatLabel.setForeground(new java.awt.Color(255, 255, 255));
        seatLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seatLabel.setText(""); // NOI18N

        seatField.setEditable(false);
        seatField.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N

        flightNumLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        flightNumLabel.setForeground(new java.awt.Color(255, 255, 255));
        flightNumLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        flightNumLabel.setText("НОМЕР РЕЙСА"); // NOI18N

        flightField.setEditable(false);
        flightField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        timeLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        timeLabel.setForeground(new java.awt.Color(255, 255, 255));
        timeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeLabel.setText("ВРЕМЯ ВЫЛЕТА"); // NOI18N

        timeField.setEditable(false);
        timeField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        destLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        destLabel.setForeground(new java.awt.Color(255, 255, 255));
        destLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        destLabel.setText("АЭРОПОРТ НАЗНАЧЕНИЯ"); // NOI18N

        destField.setEditable(false);
        destField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        passengerLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        passengerLabel.setForeground(new java.awt.Color(255, 255, 255));
        passengerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        passengerLabel.setText("ИМЯ ПАССАЖИРА"); // NOI18N

        passengerField.setEditable(false);

        javax.swing.GroupLayout resultPaneLayout = new javax.swing.GroupLayout(resultPane);
        resultPane.setLayout(resultPaneLayout);
        resultPaneLayout.setHorizontalGroup(
            resultPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resultPaneLayout.createSequentialGroup()
                .addGroup(resultPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(passengerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(flightNumLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(timeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(destLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(seatLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(passengerField)
            .addComponent(flightField)
            .addComponent(timeField)
            .addComponent(destField)
            .addComponent(seatField)
        );
        resultPaneLayout.setVerticalGroup(
            resultPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resultPaneLayout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(passengerLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passengerField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(flightNumLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(flightField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(timeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(timeField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(destLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(destField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(seatLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seatField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        getContentPane().add(resultPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(748, 118, -1, -1));

        exitBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cross.png"))); // NOI18N
        exitBut.setContentAreaFilled(false);
        exitBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButActionPerformed(evt);
            }
        });
        getContentPane().add(exitBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 0, 50, 50));

        pdfCreateButton.setBackground(new java.awt.Color(102, 216, 202));
        pdfCreateButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pdfCreateButton.setForeground(new java.awt.Color(255, 255, 255));
        pdfCreateButton.setText("СОЗДАТЬ БИЛЕТ"); // NOI18N
        pdfCreateButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        pdfCreateButton.setContentAreaFilled(false);
        pdfCreateButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pdfCreateButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pdfCreateButtonMouseExited(evt);
            }
        });
        pdfCreateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdfCreateButtonActionPerformed(evt);
            }
        });
        getContentPane().add(pdfCreateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(748, 554, 190, 50));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/background.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 660));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void exitButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButActionPerformed
        if (JOptionPane.showConfirmDialog(this, "ARE YOU SURE TO EXIT?", "CONFIRM EXIT", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
            System.exit(0);
    }//GEN-LAST:event_exitButActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        showDepartureTable();
    }//GEN-LAST:event_backButtonActionPerformed

    private void pdfCreateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pdfCreateButtonActionPerformed
        if (!seatField.getText().isEmpty()){
            try {
                new PDFCreator().generate(collectPDFdata());
                JOptionPane.showMessageDialog(this, "PRINTED TO PDF/COMPLETE TICKETS", "TICKET PRINT", JOptionPane.PLAIN_MESSAGE, new ImageIcon("src/images/ok.png"));
                showDepartureTable();
            } catch (DocumentException | IOException ex) {
                Logger.getLogger(Aircraft.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(this, "ВЫБЕРИТЕ МЕСТО!", "TICKET PRINT", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_pdfCreateButtonActionPerformed

    private void pdfCreateButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pdfCreateButtonMouseEntered
        pdfCreateButton.setOpaque(true);
    }//GEN-LAST:event_pdfCreateButtonMouseEntered

    private void pdfCreateButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pdfCreateButtonMouseExited
        pdfCreateButton.setOpaque(false);
    }//GEN-LAST:event_pdfCreateButtonMouseExited

    private ArrayList<String> collectPDFdata(){
        ArrayList<String> pdfText = new ArrayList<>();
        pdfText.add(passengerField.getText());
        pdfText.add(flightField.getText());
        pdfText.add(timeField.getText());
        pdfText.add(destField.getText());
        pdfText.add(seatField.getText());
        return pdfText;
    }
    
    private void showDepartureTable(){
        try {
            dispose();
            new Departure().setVisible(true);
        } catch (SQLException | InterruptedException ex) {
            Logger.getLogger(Aircraft.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
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
            java.util.logging.Logger.getLogger(Aircraft.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Aircraft.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Aircraft.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Aircraft.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
//        ArrayList<String> str = new ArrayList<>();
//        str.add("");str.add("");str.add("");
//        java.awt.EventQueue.invokeLater(() -> {
//                new Aircraft(str).setVisible(true);
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JTextField destField;
    private javax.swing.JLabel destLabel;
    private javax.swing.JButton exitBut;
    private javax.swing.JTextField flightField;
    private javax.swing.JLabel flightNumLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField passengerField;
    private javax.swing.JLabel passengerLabel;
    private javax.swing.JButton pdfCreateButton;
    private javax.swing.JPanel resultPane;
    private javax.swing.JTextField seatField;
    private javax.swing.JLabel seatLabel;
    private javax.swing.JScrollPane seatPane;
    private javax.swing.JTextField timeField;
    private javax.swing.JLabel timeLabel;
    // End of variables declaration//GEN-END:variables
}

