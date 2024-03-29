/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds.assign1;


import static ds.assign1.A_Counter.customerToA;
import static ds.assign1.B_Counter.customerToB;
import static ds.assign1.C_Counter.customerToC;
import static ds.assign1.DS_Main.generator;

import static ds.assign1.D_Counter.customerToD;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import movingcustomer.*;


/**
 *
 * @author ASUS
 */
public class GUI extends javax.swing.JFrame {

    int ctn = 0;
    TimerDisplay t = new TimerDisplay();
    WriteFile wf = new WriteFile();
    
    /**
     * Creates new form GUI
     */
    public GUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboTicket = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        BtnEnqueue = new javax.swing.JButton();
        RBtnVIP = new javax.swing.JRadioButton();
        RBtnNormal = new javax.swing.JRadioButton();
        Start = new javax.swing.JButton();
        jComboCustomerNum = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jBtnClock = new javax.swing.JButton();
        jBtnReport = new javax.swing.JButton();
        jBtnStop = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 255, 102));

        jComboTicket.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        jLabel1.setText("Type : ");

        jLabel2.setText("Number of Tickets : ");

        BtnEnqueue.setText("Enqueue");
        BtnEnqueue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEnqueueActionPerformed(evt);
            }
        });

        RBtnVIP.setText("VIP");
        RBtnVIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBtnVIPActionPerformed(evt);
            }
        });

        RBtnNormal.setText("Normal");
        RBtnNormal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBtnNormalActionPerformed(evt);
            }
        });

        Start.setText("Start");
        Start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartActionPerformed(evt);
            }
        });

        jComboCustomerNum.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));

        jLabel3.setText("Number of Customer : ");

        jBtnClock.setText("Clock");
        jBtnClock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnClockActionPerformed(evt);
            }
        });

        jBtnReport.setText("Report");
        jBtnReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnReportActionPerformed(evt);
            }
        });

        jBtnStop.setText("Stop");
        jBtnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnStopActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(RBtnVIP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(RBtnNormal))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboCustomerNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Start)
                    .addComponent(jBtnClock))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BtnEnqueue)
                    .addComponent(jBtnStop))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtnReport)
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(RBtnVIP)
                        .addComponent(RBtnNormal)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboCustomerNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnEnqueue)
                    .addComponent(jBtnClock))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Start)
                    .addComponent(jBtnReport)
                    .addComponent(jBtnStop))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnEnqueueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEnqueueActionPerformed
        String customerType = null;
        if(RBtnVIP.isSelected()){
            customerType = "V";
        }else if(RBtnNormal.isSelected()){
            customerType = "N";
        }
        int numOfTicket = Integer.parseInt((String)jComboTicket.getSelectedItem());
        int numOfCustomer = Integer.parseInt((String)jComboTicket.getSelectedItem());
        try {
            //for(int i=0; i<numOfCustomer; i++){
                generator(customerType, numOfTicket);
            //}
        } catch (InterruptedException ex) {
             ex.printStackTrace();
        }
        RBtnVIP.setSelected(false);
        RBtnNormal.setSelected(false);
        jComboTicket.setSelectedIndex(0);
        jComboCustomerNum.setSelectedIndex(0);
        ctn++;
       
    }//GEN-LAST:event_BtnEnqueueActionPerformed

    private void RBtnNormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBtnNormalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RBtnNormalActionPerformed

    private void RBtnVIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBtnVIPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RBtnVIPActionPerformed

    private void StartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartActionPerformed
//        Serve serve = new Serve();
//            SwingUtilities.invokeLater(() -> {
//                try {
//                    serve.serving();
//                } catch (InterruptedException ex) {
//                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            });
//            thread1.start();
//            thread2.start();
//            thread4.start();
//            thread3.start();

            //System.out.println("Counter A Open");
            
    }//GEN-LAST:event_StartActionPerformed

    private void jBtnClockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnClockActionPerformed
        DigitalClock dc = new DigitalClock();
        SwingUtilities.invokeLater(() -> {
            JFrame.setDefaultLookAndFeelDecorated(true);
            JFrame f = new JFrame("Digital Clock");
            f.setSize(300,150);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setLayout(new GridLayout(3, 1));

            f.add(dc.dateLable);
            f.add(dc.timeLable);
            f.add(dc.dayLable);
            
            f.getContentPane().setBackground(Color.black);
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        });
    }//GEN-LAST:event_jBtnClockActionPerformed

    private void jBtnReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnReportActionPerformed
        wf.writeF_ALL(); //write overall report
        wf.writeF_Counter(customerToA, "A");//write counter A report
        wf.writeF_Counter(customerToB, "B");//write counter B report
        wf.writeF_Counter(customerToC, "C");//write counter C report
        wf.writeF_Counter(customerToD, "D");//write counter D report
    }//GEN-LAST:event_jBtnReportActionPerformed

    private void jBtnStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnStopActionPerformed
        //thread1.interrupt();
//        thread1.stop();
        
//        System.out.println("Counter A Closed");
        //thread2.interrupt();
        //System.out.println("Counter B Closed");
        //thread3.interrupt();
        //System.out.println("Counter C Closed");
        //thread4.interrupt();
        //System.out.println("Counter D Closed");
        
        
    }//GEN-LAST:event_jBtnStopActionPerformed

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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnEnqueue;
    private javax.swing.JRadioButton RBtnNormal;
    private javax.swing.JRadioButton RBtnVIP;
    private javax.swing.JButton Start;
    private javax.swing.JButton jBtnClock;
    private javax.swing.JButton jBtnReport;
    private javax.swing.JButton jBtnStop;
    private javax.swing.JComboBox<String> jComboCustomerNum;
    private javax.swing.JComboBox<String> jComboTicket;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
