/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movingcustomer;

import java.awt.*;
//import java.util.Formatter;

/**
 *
 * @author xianze_98
 */
public class Customer {
    char type;
    int extime;
    int counter;
    public float x,y;
    float speedX,speedY;
    float radius;
    private Color custcolour;
    private static final Color DEFAULT_CUST=Color.BLACK;
    
    public Customer(char type, float x, float y, float radius, float speedX, float speedY){
        this.custcolour=DEFAULT_CUST;
        this.radius=radius;
        this.speedX=speedX;
        this.speedY=speedY;
        this.x=x;
        this.y=y;
        this.type=type;
    }
    
    public void draw(Graphics g){
//        if(type=='v'){
            g.setColor(custcolour);
            g.fillOval((int)(x-radius),(int)(y-radius),(int)(radius*2),(int)(radius*2));
//            g.drawString("VIP", (int)x, (int)y);
//        }else if(type=='n'){
//            g.setColor(custcolour);
//            g.fillOval((int)(x-radius),(int)(y-radius),(int)(radius*2),(int)(radius*2));
//            g.drawString("NORMAL", (int)x, (int)y);
//        }
//        g.setColor(custcolour);
//        g.fillOval((int)(x-radius),(int)(y-radius),(int)(radius*2),(int)(radius*2));
    }
    
    public void move(Bg bg){
        
        x+=speedX;
        y-=speedY;
        
        
        if(y>320){
            speedX=0;
        }else{
            speedY=0;
            
//            if(x<=500){
//               //while(x<=500){
//                            speedX=5;
//               //         }
//            }else{
//                speedX=0;
//            }
        }
        
    }
    
    public void moveToCounter(Bg bg, String type, int loc){
        if(y>220){
            speedY=5;
            speedX=0;
        }else{
            speedY=0;
            //move left
            if(loc>350){
                if(x<=500){
                    speedX=5;
                }else{
                    speedX=0;
                } 
            //move right
            }else{
                if(x>=200){
                    speedX=-5;
                }else{
                    speedX=0;
                }
            }
        }
        x+=speedX;
        y-=speedY;
    }
        
        
        
        
//        if(type=='v'){
//            if(y>220){
//                speedX=0;
//            }else if(y>=220){
//                speedY=0;
//                boolean done=false;
//                switch (counter) {
//                    case 1:
//                        while(x>=200){
//                        speedX=-temp;
//                        //code for staying through execution time
//                    }
//                    case 2:
//                        while(x>=300){
//                            speedX=-temp;
//                        }
//                    case 3:
//                        while(x>=400){
//                            speedX=temp;
//                        }
//                    case 4:
//                        while(x>=500){
//                            speedX=temp;
//                        }
//                    default:
//                        break;
//            }
//        }
//        }else if(type=='n'){
//            if(y>220){
//                speedX=0;
//            }else if(y>=220){
//                speedY=0;
//                switch (counter) {
//                    case 1:
//                        while(x>=200){
//                        speedX=temp;
//                        }
//                    case 2:
//                        while(x>=300){
//                            speedX=temp;
//                        }
//                    case 3:
//                        while(x>=400){
//                            speedX=-temp;
//                        }
//                    case 4:
//                        while(x>=500){
//                            speedX=-temp;
//                        }
//                    default:
//                        break;
//            }
//        }
//        }
        
        
        
    }
    
    
    
    
    
    
