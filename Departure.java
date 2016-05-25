
package Terminal;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Cursor;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;


public class Departure extends javax.swing.JFrame {
    
    public Departure() throws SQLException, InterruptedException {
        dataBase = new DBConnection();
        dataBase.init();
        initComponents();
        initScheduleTable();
        applyMouseDrag();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tableScrollPane = new javax.swing.JScrollPane();
        backButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        closeBut = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableScrollPane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 102), 3));
        getContentPane().add(tableScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 125, 1000, 414));

        backButton.setBackground(new java.awt.Color(183, 0, 183));
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backBut.png"))); // NOI18N
        backButton.setContentAreaFilled(false);
        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backButtonMouseExited(evt);
            }
        });
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 40));

        jLabel1.setBackground(new java.awt.Color(139, 43, 142));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("СПРАВКА "); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 130));

        closeBut.setBackground(new java.awt.Color(153, 0, 153));
        closeBut.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        closeBut.setForeground(new java.awt.Color(204, 204, 204));
        closeBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cross.png"))); // NOI18N
        closeBut.setContentAreaFilled(false);
        closeBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closeButMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                closeButMouseExited(evt);
            }
        });
        closeBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButActionPerformed(evt);
            }
        });
        getContentPane().add(closeBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 0, 50, 40));

        jLabel2.setBackground(new java.awt.Color(139, 43, 142));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText(" INFORMATION"); // NOI18N
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, 520, 130));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void closeButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButActionPerformed
        if (JOptionPane.showConfirmDialog(this, "ARE YOU SURE TO EXIT?", "CONFIRM EXIT", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
            System.exit(0);
    }//GEN-LAST:event_closeButActionPerformed

    private void closeButMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeButMouseEntered
        closeBut.setOpaque(true);
    }//GEN-LAST:event_closeButMouseEntered

    private void closeButMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeButMouseExited
        closeBut.setOpaque(false);
    }//GEN-LAST:event_closeButMouseExited

    private void backButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseEntered
        backButton.setOpaque(true);
    }//GEN-LAST:event_backButtonMouseEntered

    private void backButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseExited
        backButton.setOpaque(false);
    }//GEN-LAST:event_backButtonMouseExited

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        new UserLogin().setVisible(true);
        dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void applyMouseDrag(){
        addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
                position = e.getPoint();
                getComponentAt(position);
            }
        });
         
        addMouseMotionListener(new MouseMotionAdapter(){
            @Override
            public void mouseDragged(MouseEvent e) {
                //old position
                int thisX = (int)getLocation().getX();
                int thisY = (int)getLocation().getY();
                //new position
                int xMoved = thisX + (e.getX()-position.x);
                int yMoved = thisY + (e.getY()-position.y);

                setLocation(xMoved, yMoved);
            }   
        });
    }

    private void initScheduleTable() throws SQLException, InterruptedException{
        scheduleTable = new JTable(new ScheduleTableModel(dataBase.getTableData(), dataBase.getColumnNames())){
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component comp = super.prepareRenderer(renderer, row, column);
                
                setRowBackground(comp,row);
                
                setColumnForeground(comp, column);
                
                return comp;
            }  
            
            private void setRowBackground(Component comp, int row){
                switch (row%2){
                    case 0:
                        comp.setBackground(new Color(102,0,102));
                        break;
                    case 1:
                        comp.setBackground(new Color(153,50,204));
                }
            }
            
            private void setColumnForeground(Component comp, int column){
                switch(column){
                    case 0:case 1:
                        comp.setForeground(Color.WHITE);
                        break;
                    case 3:
                        comp.setForeground(new Color(216,169,3));
                        break;
                    default:
                        break;
                }
            }
        };
        
        scheduleTable.getColumnModel().getColumn(2).setCellRenderer(new ScheduleTableRenderer());
        ///////////////////////////////////////////
        Thread statusThread = new Thread(() -> {
            scheduleTable.getColumnModel().getColumn(4).setCellRenderer(new StatusRenderer());
            scheduleTable.repaint();
        });
        statusThread.start();
        statusThread.join();
        ///////////////////////////////////////////
        scheduleTable.getTableHeader().setDefaultRenderer(new HeaderRenderer());

        tableModifications();
        tableScrollPane.setViewportView(scheduleTable);
    }
    
    private void tableModifications(){
        scheduleTable.getTableHeader().setReorderingAllowed(false);
        scheduleTable.setRowSelectionAllowed(true);
        scheduleTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scheduleTable.setCellSelectionEnabled(false);
        
        ListSelectionModel scheduleListModel = scheduleTable.getSelectionModel();
        scheduleListModel.addListSelectionListener((e) -> {
                int row = scheduleTable.getSelectedRow();
                flightData = new ArrayList<>();
                flightData.add(scheduleTable.getValueAt(row, 0).toString());
                flightData.add(scheduleTable.getValueAt(row, 1).toString());
                flightData.add(scheduleTable.getValueAt(row, 3).toString());
                
                this.setVisible(false);
                aircraft = new Aircraft(flightData);
                aircraft.setVisible(true);
        });
        
        scheduleTable.setRowHeight(40);
        scheduleTable.setCursor(new Cursor(Cursor.HAND_CURSOR));
        scheduleTable.setFont(new Font("Calibri", Font.BOLD, 30));
        scheduleTable.getColumnModel().getColumn(0).setMinWidth(120);
        scheduleTable.getColumnModel().getColumn(0).setMaxWidth(120);
        scheduleTable.getColumnModel().getColumn(1).setMinWidth(150);
        scheduleTable.getColumnModel().getColumn(1).setMaxWidth(150);
        scheduleTable.getColumnModel().getColumn(2).setMinWidth(100);
        scheduleTable.getColumnModel().getColumn(2).setMaxWidth(100);
        scheduleTable.getColumnModel().getColumn(3).setMinWidth(230);
        scheduleTable.getColumnModel().getColumn(3).setMaxWidth(230);
        scheduleTable.getColumnModel().getColumn(4).setMinWidth(400);
        scheduleTable.getColumnModel().getColumn(4).setMaxWidth(400);
    }
    
    public ArrayList<String> getFlightData(){
        return flightData;
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
            java.util.logging.Logger.getLogger(Departure.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Departure.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Departure.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Departure.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


//        java.awt.EventQueue.invokeLater(()->{
//            try {
//                new Departure().setVisible(true);
//            } catch (SQLException ex) {
//                Logger.getLogger(Departure.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        });
    }
    
    DBConnection dataBase;
    private Point position;
    private JTable scheduleTable;
    ArrayList<String> flightData;
    Aircraft aircraft;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton closeBut;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane tableScrollPane;
    // End of variables declaration//GEN-END:variables
}

