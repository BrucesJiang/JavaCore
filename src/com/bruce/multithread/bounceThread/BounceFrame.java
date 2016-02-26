package com.bruce.multithread.bounceThread;

import com.bruce.multithread.bounce.Ball;
import com.bruce.multithread.bounce.BallComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The frame with ball component and buttons
 * Created by bruce-jiang on 2016/2/24.
 * @version  1.0
 */
public class BounceFrame extends JFrame{
    private BallComponent ballComp;
    private static final int  STEPS  = 1000;
    private static final int DELAY = 3;

    /**
     * Constructs the frame with the component for showing the bouncing ball and
     * Start button and Close button
     */
    public BounceFrame(){
        setTitle("Bounce");

        ballComp  = new BallComponent();
        //add the ball component
        add(ballComp, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        addButton(buttonPanel,"Start",new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                addBall();
            }
        });

        addButton(buttonPanel, "Close", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(buttonPanel,BorderLayout.SOUTH);
        pack();
    }

    /**
     * Adds a button to a container
     * @param c the container
     * @param title the button title
     * @param listener the action listener for the button
     */
    private void addButton(Container c , String title , ActionListener listener){
        JButton button = new JButton(title);
        c.add(button);
        button.addActionListener(listener);
    }

    /**
     * Adds a bouncing ball to the panel and makes it bounce 1,000 times
     */
    private void addBall(){
        Ball ball = new Ball();
        ballComp.add(ball);
        Runnable r = new BallRunnable(ball,ballComp);
        new Thread(r).start();
    }
}
