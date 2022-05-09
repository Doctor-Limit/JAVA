package Work1.Day10.Example9_5;

import javax.swing.*;

/**
 * ********概述：
 */
public class WindowBoxLayout extends JFrame {
    Box boxH;
    Box boxVOne,boxVTwo;
    public WindowBoxLayout() {
        setLayout(new java.awt.FlowLayout());
        init();
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    void init() {
        boxH = Box.createHorizontalBox();
        boxVOne = Box.createVerticalBox();
        boxVTwo = Box.createVerticalBox();
        boxVOne.add(new JLabel("姓名:"));
        boxVOne.add(new JLabel("职业:"));
        boxVTwo.add(new JTextField(10));
        boxVTwo.add(new JTextField(10));
        boxH.add(boxVOne);
        boxH.add(Box.createVerticalStrut(10));
        boxH.add(boxVTwo);
        add(boxH);

    }
}
