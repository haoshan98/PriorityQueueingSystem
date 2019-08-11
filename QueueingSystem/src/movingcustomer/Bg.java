/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movingcustomer;

import java.awt.*;

/**
 *
 * @author xianze_98
 */
public class Bg {
    int minX,minY,maxX,maxY;
    private Color bgcolour=Color.white;
    private static final Color DEFAULT_COLOUR_BG=Color.white;
    //private final int MIN_X=0,MIN_Y=0,MAX_X=700,MAX_Y=500;
    
    public Bg(int minX,int minY,int maxX,int maxY){
        this.minX=minX;
        this.minY=minY;
        this.maxX=maxX;
        this.maxY=maxY;
        this.bgcolour=DEFAULT_COLOUR_BG;
        
        
    }
    
    public void draw(Graphics g){
        g.setColor(bgcolour);
        g.fillRect(minX, minY, maxX, maxY);
        
//        g.fillRect(275, 150, 50, 50);
//        g.fillRect(175, 150, 50, 50);		
//        g.fillRect(375, 150, 50, 50);
//        g.fillRect(475, 150, 50, 50);
//        
//        g.drawString("counter 1", 175, 150);
//        g.drawString("counter 2", 275, 150);
//        g.drawString("counter 3", 375, 150);
//        g.drawString("counter 4", 475, 150);
//        
//        g.drawLine(350, 300, 350, 500);
//        g.drawLine(300, 300, 300, 500);
//        g.drawLine(400, 300, 400, 500);
//        g.drawLine(10, 175, 550, 175);
//        g.drawLine(600, 175, 690, 175);
//        g.drawLine(550, 175, 550, 100);
//        g.drawLine(600, 175, 600, 100);

        
        
        
        
    }
    
    
    
    
    
    
    
}
