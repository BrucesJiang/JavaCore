package com.bruce.multithread.bounceThread;

import com.bruce.multithread.bounce.Ball;

import java.awt.*;

/**
 * A runnable that animates a bouncing ball
 * Created by bruce-jiang on 2016/2/24.
 * @version  1.0
 */
public class BallRunnable implements Runnable{
    private Ball ball;
    private Component component;
    private static final int STEPS = 1000;
    private static final int DELAY = 5;

    /**
     * Constructs the runnable
     * @param aBall the ball to bounce
     * @param aComp the component in which the ball bounces
     */
    public BallRunnable(Ball aBall, Component aComp){
        ball = aBall;
        component = aComp;
    }

    public void run(){
        try{
            for(int i=1;i<=STEPS;i++){
                ball.move(component.getBounds());
                component.repaint();
                Thread.sleep(DELAY);
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}