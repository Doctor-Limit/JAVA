package Work1.Day10.Example9_11;

import javax.swing.*;
import java.awt.*;

/**
 * ********概述：
 */
public class WindowMove extends JFrame {
    LP layeredPane;
    WindowMove() {
        layeredPane = new LP();
        add(layeredPane, BorderLayout.CENTER);
        setVisible(true);
        setBounds(12,12,300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
