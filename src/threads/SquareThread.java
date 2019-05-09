/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package threads;

import domain.Point;
import domain.Square;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Fabian
 */
public class SquareThread extends Thread{
    
    //variables
    private Square mySquare;
    private int delayTime;

    public SquareThread(Square mySquare, int delayTime) {
        super(mySquare.identification);
        this.mySquare = mySquare;
        this.delayTime = delayTime;
    }
    
    
    @Override
    public void run() {
        try {
            //sleep for the animation
            sleep(delayTime);
            
            //move the object
            Random random = new Random();
            int newX = (int)(random.nextDouble() * 500);
            int newY = (int)(random.nextDouble() * 500);
            mySquare.setPointPosition(new Point(newX, newY));
            
            
                        
        } catch (InterruptedException ex) {
            Logger.getLogger(SquareThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//end run

    
}
