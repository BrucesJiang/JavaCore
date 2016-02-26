package com.bruce.multithread.bounce;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * The component draws the balls
 * Created by bruce-jiang on 2016/2/24.
 * @version  1.0
 */
public class BallComponent extends JPanel{
    private static final int  DEFAULT_WIDTH = 450;
    private static final int  DEFAULT_HEIGHT = 350;

    private java.util.List<Ball> balls = new ArrayList<>();

    /**
     * Add a ball to the component
     * @param ball the ball to add
     */
    public void add(Ball ball){
        balls.add(ball);
    }
    /**
     *
     * @param g
     */
    public void paintComponent(Graphics g){
        super.paintComponent(g); //erase background
        Graphics2D g2 = (Graphics2D)g;
        for(Ball ball : balls){
           g2.fill(ball.getShape());
        }
    }
    public Dimension getPreferredSize(){return new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT);}

}
