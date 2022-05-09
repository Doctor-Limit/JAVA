package Work1.Day10.Example9_3;

import javax.swing.*;
import java.awt.*;

/**
 * ********概述：
 */
public class ComponentInWindow  extends JFrame {
    JCheckBox checkBox1,checkBox2;
    JRadioButton radioM,radioF;
    ButtonGroup group;
    JComboBox<String> comBox;
    public ComponentInWindow() {
        init();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    void init() {
        setLayout(new FlowLayout());
        comBox = new JComboBox();
        checkBox1 = new JCheckBox("喜欢音乐");
        checkBox2 = new JCheckBox("喜欢旅游");
        group = new ButtonGroup();
        radioM = new JRadioButton("男");
        radioF = new JRadioButton("女");
        group.add(radioM);
        group.add(radioF);
        add(checkBox1);
        add(checkBox2);
        add(radioF);
        add(radioM);
        comBox.addItem("音乐天地");
        comBox.addItem("武术天地");
        add(comBox);
    }
}
