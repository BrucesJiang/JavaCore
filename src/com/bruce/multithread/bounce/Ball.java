package com.bruce.multithread.bounce;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 *A ball that moves and bounds off the edges of a rectangle
 * Created by bruce-jiang on 2016/2/24.
 * @version  1.0
 */
public class Ball {
    private static final int XSIZE = 15;
    private static final int YSIZE = 15;
    private double x = 0;
    private double y = 0;
    private double dx = 1;
    private double dy = 1;

    /**
     * Move the ball to the next position , reversing direction if it hits one of the edges
     * @param bounds the bounds of the area
     */
    public void move(Rectangle2D bounds){
        x += dx;
        y += dy;
        //if the ball is at the most left position
        if(x <bounds.getMinX()){
            x = bounds.getMinX();
            dx = -dx;
        }
        //if the ball is at the most top position
        if(y< bounds.getMinY()){
            y = bounds.getMinY();
            dy = -dy;
        }
        //if the ball is at the most right position
        if(x + XSIZE >= bounds.getMaxX()){
            x = bounds.getMaxX() - XSIZE;
            dx = -dx;
        }
        //if the ball is at the most bottom position
        if(y + YSIZE >= bounds.getMaxY()){
            y = bounds.getMaxY() - YSIZE;
            dy = -dy;
        }
    }

    /**
     * Gets the shape of the ball at its current position
     * @return tha shape of the ball
     */
    public Ellipse2D getShape(){
        return new Ellipse2D.Double(x,y,XSIZE,YSIZE);
    }

}
