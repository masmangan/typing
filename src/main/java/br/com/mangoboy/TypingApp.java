package br.com.mangoboy;

import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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

        String keys = """
                QWERTYUIOP'[
                ASDFGHJKLÇ~]
                \\ZXCVBNM,.;/
                """;
        JPanel p = new JPanel();
        for (char c : keys.toCharArray()) {
            if (c != '\n') {
                JButton b = new JButton("" + c);
                b.setEnabled(false);
                p.add(b);
            }
        }
        p.setOpaque(true);

        frame.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
            
        }
        
        
        );
        frame.add(p);
        frame.pack();
        frame.setVisible(true);

    }

    /**
     * 
     * @param args not used
     */
    public static void main(String[] args) {
        logger.info("Touch Typing!");
        javax.swing.SwingUtilities.invokeLater(TypingApp::createAndShowGUI);

    }
}
