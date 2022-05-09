package Work1.Day10.Example9_10;

import javax.swing.*;
import java.awt.*;

/**
 * ********概述：
 */
public class WindowMouse extends JFrame {
    JButton button;
    JTextArea area;
    MousePolice police;
    WindowMouse() {
        init();
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    void init() {
        setLayout(new FlowLayout());
        area = new JTextArea(10,28);
        Font font = new Font("宋体", Font.PLAIN, 22);
        area.setFont(font);
        police = new MousePolice();
        police.setView(this);
        button = new JButton("按钮");
        button.addMouseListener(police);
        addMouseListener(police);
        add(button);
        add(new JScrollPane(area));
    }
}
