package com.bruce.logging;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *The frame shows the image
 * Created by bruce-jiang on 2016/2/21.
 * @version 1.0
 */
public class ImageViewerFrame extends JFrame{
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    private JLabel label = null;
    private static Logger logger = Logger.getLogger("com.bruce.corejava");

    public ImageViewerFrame(){
        logger.entering("ImageViewFrame","<init>");
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);

        //set up menu bar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("File");
        menuBar.add(menu);
        JMenuItem openItem = new JMenuItem("Open");
        menu.add(openItem);
        openItem.addActionListener(new FileOpenListener());
        JMenuItem exitItem = new JMenuItem("Exit");
        menu.add(exitItem);
        exitItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                System.exit(0);
            }
        });

        //use a label to display the images
        label = new JLabel();
        add(label);
        logger.exiting("ImageViewerFrame","<init>");
    }

    private class FileOpenListener implements ActionListener {
        public void actionPerformed(ActionEvent event){
            logger.entering("ImageViewerFrame.FileOpenListener","actionPerformed",event);

            //set up file chooser
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new File("."));

            //accept all file ending with .gif
            chooser.setFileFilter(new javax.swing.filechooser.FileFilter(){
               public boolean accept(File f){
                   return f.getName().toLowerCase().endsWith(".gif") || f.isDirectory();
               }
                public String getDescription(){
                    return "GIF Images";
                }
            });

            //show file chooser dialog
            int r = chooser.showOpenDialog(ImageViewerFrame.this);

            //if image file accpeted , set it as icon of the label
            if(r==JFileChooser.APPROVE_OPTION){
                String name = chooser.getSelectedFile().getPath();
                logger.log(Level.FINE,"Reading file{0}",name);
                label.setIcon(new ImageIcon(name));
            }else{
                logger.fine("File open dialog canceled.");
            }
            logger.exiting("ImageViewerFrame.FileOpenListener","actionPerformed");
        }
    }
}
