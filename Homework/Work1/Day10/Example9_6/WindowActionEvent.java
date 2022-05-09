package Work1.Day10.Example9_6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * ********概述：
 */
public class WindowActionEvent extends JFrame {
    JTextField text;
    ActionListener listener;
    public WindowActionEvent() {
        setLayout(new FlowLayout());
        text = new JTextField(10);
        add(text);
        listener = new ReaderListener();
        text.addActionListener(listener);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
