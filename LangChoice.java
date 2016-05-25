
package Terminal;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JButton;
import javax.swing.border.LineBorder;


public class LangChoice extends javax.swing.JFrame {

    public static boolean LANG_MODE;
    
    Point position;
    //UserLogin loginFrame = new UserLogin();
    
    public LangChoice() {
        initComponents();
        applyMouseDrag();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rusMode = new javax.swing.JButton();
        engMode = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rusMode.setBackground(new java.awt.Color(102, 216, 202));
        rusMode.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        rusMode.setForeground(new java.awt.Color(255, 255, 255));
        rusMode.setText("РУССКИЙ");
        rusMode.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        rusMode.setContentAreaFilled(false);
        rusMode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rusModeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                rusModeMouseExited(evt);
            }
        });
        rusMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rusModeActionPerformed(evt);
            }
        });
        getContentPane().add(rusMode, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 290, 70));

        engMode.setBackground(new java.awt.Color(102, 216, 202));
        engMode.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        engMode.setForeground(new java.awt.Color(255, 255, 255));
        engMode.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        engMode.setContentAreaFilled(false);
        engMode.setLabel("ENGLISH");
        engMode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                engModeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                engModeMouseExited(evt);
            }
        });
        engMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                engModeActionPerformed(evt);
            }
        });
        getContentPane().add(engMode, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 290, 70));

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 51));
        jLabel1.setText("Boryspil Booking System(c)");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/background.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 333));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rusModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rusModeActionPerformed
        LANG_MODE = true;
        modifyBut(rusMode);
        setVisible(false);
        new UserLogin().setVisible(true);
    }//GEN-LAST:event_rusModeActionPerformed

    private void engModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_engModeActionPerformed
        LANG_MODE = false;
        modifyBut(engMode);
        setVisible(false);
        new UserLogin().setVisible(true);
    }//GEN-LAST:event_engModeActionPerformed

    private void rusModeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rusModeMouseEntered
        rusMode.setOpaque(true);
    }//GEN-LAST:event_rusModeMouseEntered

    private void rusModeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rusModeMouseExited
        rusMode.setOpaque(false);
    }//GEN-LAST:event_rusModeMouseExited

    private void engModeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_engModeMouseEntered
        engMode.setOpaque(true);
    }//GEN-LAST:event_engModeMouseEntered

    private void engModeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_engModeMouseExited
        engMode.setOpaque(false);
    }//GEN-LAST:event_engModeMouseExited

    private void modifyBut(JButton but){
        but.setBackground(new Color(0,100,170));
        but.setOpaque(true);
        but.setBorder(new LineBorder(new Color(0,40,150), 3));
        but.setRolloverEnabled(true);
    }

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
            java.util.logging.Logger.getLogger(LangChoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LangChoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LangChoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LangChoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton engMode;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton rusMode;
    // End of variables declaration//GEN-END:variables
}
