package br.com.mangoboy;

import java.util.logging.Logger;

import javax.swing.JFrame;

/**
 * 
 */
public class TypingApp {

    private static Logger logger = Logger.getLogger(TypingApp.class.getName());

    /**
     * 
     */
    private static void createAndShowGUI() {
        final JFrame frame = new JFrame("Touch Typing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
        
        frame.pack();
        frame.setVisible(true);        
    }

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        logger.info("Touch Typing!");
        javax.swing.SwingUtilities.invokeLater(TypingApp::createAndShowGUI);

    }
}
