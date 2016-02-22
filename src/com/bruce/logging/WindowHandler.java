package com.bruce.logging;

import javax.swing.*;
import java.io.OutputStream;
import java.util.logging.LogRecord;
import java.util.logging.StreamHandler;

/**
 * Created by bruce-jiang on 2016/2/21.
 * @version  1.0
 */
public class WindowHandler extends StreamHandler {
    private JFrame frame;

    public WindowHandler(){
        frame = new JFrame();
        final JTextArea output = new JTextArea();
        output.setEditable(false);
        frame.setSize(200,200);
        frame.add(new JScrollPane(output));
        frame.setFocusableWindowState(false);
        frame.setVisible(true);
        setOutputStream(new OutputStream(){
            public void write(int b){

            }
            public void write(byte[] b, int off , int len){
                output.append(new String(b,off,len));
            }
        });
    }
    public void publish(LogRecord record){
        if(!frame.isVisible()) return ;
        System.out.println(record.toString());
        super.publish(record);
        flush();
    }
}
