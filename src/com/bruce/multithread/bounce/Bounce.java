package com.bruce.multithread.bounce;

import javax.swing.*;
import java.awt.*;

/**
 * Created by bruce-jiang on 2016/2/24.
 * @version  1.0
 */
public class Bounce {
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new BounceFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}
