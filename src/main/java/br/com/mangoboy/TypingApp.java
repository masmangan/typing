package br.com.mangoboy;

import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
                p.add(b);
            }
        }
        p.setOpaque(true);
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
