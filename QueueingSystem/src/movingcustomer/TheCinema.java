/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movingcustomer;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author xianze_98
 */
public class TheCinema extends JPanel{
    private static final int UPDATE_RATE=30;
    
    private Customer cust;
    private ArrayList<Customer> vipArr = new ArrayList<>();
    private ArrayList<Customer> NArr = new ArrayList<>();
    private Bg bg;
    
    private DrawCanvas canvas;
    private int canvaswidth;
    private int canvasheight;
    char type;
    
    int radius=10;
    int xV=310;
    int yV=300;
    int xN=360;
    int yN=300;
    int speed =5;
    
    Graphics g;
    Customer customerA = null;
    Customer customerB = null;
    Customer customerC = null;
    Customer customerD = null;
    Customer[] threadPoint = new Customer[1];
    
    public TheCinema(int width, int height){
        canvaswidth=width;
        canvasheight=height;
        
 //       if(type=='v'){
            
            //cust=new Customer('v',xV,y,radius,speed,speed);
            
            bg=new Bg(0,0,canvaswidth,canvasheight);
            
            canvas=new DrawCanvas();
            this.g = canvas.g;
            this.setLayout(new BorderLayout());
            this.add(canvas,BorderLayout.CENTER);
            
            
            walk();
//       }else if(type=='n'){
//           int radius=10;
//            int x=300;
//            int y=500;
//            int speed =5;
//            cust=new Customer('v',x,y,radius,speed,speed);
//            
//            bg=new Bg(0,0,canvaswidth,canvasheight);
//            
//            canvas=new DrawCanvas();
//            this.setLayout(new BorderLayout());
//            this.add(canvas,BorderLayout.SOUTH);
//            
//            
//            walk();
//       }
        
        
    }
    
    public void walk(){
        Thread gameThread = new Thread() {
         public void run() {
            while (true) {
               // Execute one time-step for the game 
               walkupdate();
               // Refresh the display
               repaint();
               // Delay and give other thread a chance
               try {
                  Thread.sleep(1000 / UPDATE_RATE);
               } catch (InterruptedException ex) {}
            }
         }
      };
      gameThread.start(); 
    }
    
    
    public void walkupdate(){
        //cust.move(bg);
        //cust.moveToCounter(bg, "");
        
    }
    
    class DrawCanvas extends JPanel{
        Graphics g;
        public void paintComponent(Graphics g){
            this.g = g;
            super.paintComponent(g);
            //bg.draw(g);
            //cust.draw(g);
            g.fillRect(275, 150, 50, 50);
            g.fillRect(175, 150, 50, 50);		
            g.fillRect(375, 150, 50, 50);
            g.fillRect(475, 150, 50, 50);
        
            g.drawString("counter 1", 175, 150);
            g.drawString("counter 2", 275, 150);
            g.drawString("counter 3", 375, 150);
            g.drawString("counter 4", 475, 150);
        
            g.drawLine(350, 300, 350, 500);
            g.drawString("VIP lane",250 ,310 );
            g.drawString("NORMAL lane",403 ,310 );
            g.drawLine(300, 300, 300, 500);
            g.drawLine(400, 300, 400, 500);
            g.drawLine(10, 175, 550, 175);
            g.drawLine(600, 175, 690, 175);
            g.drawLine(550, 175, 550, 100);
            g.drawLine(600, 175, 600, 100);

            for(int i = 0; i < vipArr.size(); i++)
                vipArr.get(i).draw(g);
            for(int i = 0; i < NArr.size(); i++)
                NArr.get(i).draw(g);
            
            if(customerA != null)
                customerA.draw(g);
            if(customerB != null)
                customerB.draw(g);
            if(customerC != null)
                customerC.draw(g);
            if(customerD != null)
                customerD.draw(g);
            
        }
        public Dimension getPreferredSize() {
         return (new Dimension(canvaswidth, canvasheight));
      }
    }
    
    public void iniCustomer(String type){
        if(type.equals("V")){
            yV = 300 + vipArr.size()*20;
            vipArr.add(new Customer('v',xV,yV,radius,speed,speed));
            System.out.println("VIP + " + vipArr.get(vipArr.size()-1).x);
        }else{
            yN = 300 + NArr.size()*20;
            NArr.add(new Customer('n',xN,yN,radius,speed,speed));
        }
    }
    
    public void dequeueToCounter(String type, String co, int loc) throws InterruptedException {
        Customer customer;
        
        if(type.equals("VIP")){
            switch(type){
                case "A":
                    customerA = vipArr.remove(0);
                    threadPoint[0] = customerA;
                case "B":
                    customerB = vipArr.remove(0);
                    threadPoint[0] = customerB;
                case "C":
                    customerC = vipArr.remove(0);
                    threadPoint[0] = customerC;
                case "D":
                    customerD = vipArr.remove(0);
                    threadPoint[0] = customerD;
                    
            }
            System.out.println("VIP");
            
        }else{
            switch(type){
                case "A":
                    customerA = NArr.remove(0);
                    threadPoint[0] = customerA;
                case "B":
                    customerB = NArr.remove(0);
                    threadPoint[0] = customerB;
                case "C":
                    customerC = NArr.remove(0);
                    threadPoint[0] = customerC;
                case "D":
                    customerD = NArr.remove(0);
                    threadPoint[0] = customerD;
                    
            }
            System.out.println("NOR");
        }
        Thread gameThread = new Thread() {
            public void run() {
                while(threadPoint[0].x != loc || threadPoint[0].y != 220){
                    threadPoint[0].moveToCounter(bg, type, loc);
                    repaint();
                    try {
                        Thread.sleep(1000 / UPDATE_RATE);
                    } catch (InterruptedException ex) {}
                }
            }
        };
        gameThread.start();
        gameThread.join(2000);
    }
    
}
