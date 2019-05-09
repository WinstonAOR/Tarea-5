/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadsandgraphics;

import visual.LandFrame;
import threads.RepaintLandThread;
import threads.SquareThread;
import domain.Point;
import domain.Square;
import java.util.ArrayList;
import javax.swing.JFrame;
import threads.ProgressBarThread1;
import threads.ProgressBarThread12;
import threads.ProgressBarThread123;
import threads.ProgressBarThread1234;

/**
 *
 * @author root
 */
public class ThreadsAndGraphics {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //create the domain squares
        Square square1 = new Square("Thread-1", new Point(0, 50), 50);
        Square square2 = new Square("Thread-2", new Point(0, 150), 70);
        Square square3 = new Square("Thread-3", new Point(0, 250), 90);
        Square square4 = new Square("Thread-4", new Point(0, 380), 110);

        //create the array list for the frame to paint
        ArrayList squareList = new ArrayList();
        squareList.add(square1);
        squareList.add(square2);
        squareList.add(square3);
        squareList.add(square4);

        //create the new frame and send the square list
        LandFrame myLand = new LandFrame(squareList);
        myLand.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //thread for repainting
        RepaintLandThread repaintThread = new RepaintLandThread(myLand, 200);
        repaintThread.start();

//        //thread for controlling the movement of the squares
        ProgressBarThread1 progressBar1 = new ProgressBarThread1(square1, 10);
        ProgressBarThread12 progressBar2 = new ProgressBarThread12(square2, 50);
        ProgressBarThread123 progressBar3 = new ProgressBarThread123(square3, 200);
        ProgressBarThread1234 progressBar4 = new ProgressBarThread1234(square4, 50);

        progressBar1.start();
        progressBar2.start();
        progressBar3.start();
        progressBar4.start();
    }//end main
}
