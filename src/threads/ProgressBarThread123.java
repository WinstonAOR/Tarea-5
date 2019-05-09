/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import domain.Point;
import domain.Square;
import java.util.Random;

/**
 *
 * @author Winston
 */
public class ProgressBarThread123 extends Thread {

    private Square mySquare;
    private int delayTime;

    public ProgressBarThread123(Square mySquuare, int delayTime) {
        this.mySquare = mySquuare;
        this.delayTime = delayTime;
    }

    @Override
    public void run() {
        while (true) {
            try {
                sleep(delayTime);
                for (int i = 0; i < 400; i++) {
                  
                    mySquare.setPointPosition(mySquare.getPointPosition());  
                    mySquare.setPointPosition(new Point(i, 250));  
                    sleep(delayTime);
                }
                
            } catch (InterruptedException iex) {
                System.out.println(iex.getMessage());
            }
        }
    }
}
