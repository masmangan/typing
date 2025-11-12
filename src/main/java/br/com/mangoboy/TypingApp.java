package br.com.mangoboy;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.*;

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

        // https://docs.oracle.com/javase/8/docs/api/java/awt/GridBagLayout.html
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints gc = new GridBagConstraints();

        JPanel p = new JPanel();
        p.setLayout(gridbag);

        Map<String, JButton> keymap = new HashMap<>();

        for (char c : keys.toCharArray()) {
            if (c != '\n') {
                JButton b = new JButton("" + c);
                if (c == ']' || c == '[') {
                    gc.gridwidth = GridBagConstraints.REMAINDER;
                    gridbag.setConstraints(b, gc);
                }
                p.add(b);
                keymap.put("" + c, b);
            }
        }
        p.setOpaque(true);
        frame.setFocusable(true);

        frame.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                logger.info(e.toString());
                JButton b = keymap.get("" + e.getKeyChar());
                if (b != null) {
                    logger.info(b.getText());
                    logger.info("Pressing a button");
                    var model = b.getModel();
                    model.setArmed(true);
                    model.setPressed(true);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                logger.info(e.toString());
                JButton b = keymap.get("" + e.getKeyChar());
                if (b != null) {
                    logger.info(b.getText());
                    logger.info("Releasing a button");
                    var model = b.getModel();
                    model.setPressed(false);
                    model.setArmed(false);
                }
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
