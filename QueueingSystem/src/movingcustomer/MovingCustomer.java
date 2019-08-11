/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movingcustomer;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author xianze_98
 */
public class MovingCustomer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
//        javax.swing.SwingUtilities.invokeLater(new Runnable(){
//            public void run(){
//                JFrame frame = new JFrame("MOVING CUSTOMERS");
//                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                frame.setContentPane(new TheCinema(700, 500)); 
//                frame.pack();            
//                frame.setVisible(true);
//            }        
//        });
        
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("MOVING CUSTOMERS");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(new TheCinema(700, 500)); 
                frame.pack();            
                frame.setVisible(true);
        });
        
        
        
    }
    
    
    
    
}
