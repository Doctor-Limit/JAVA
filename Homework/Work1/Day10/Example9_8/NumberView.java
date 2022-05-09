package Work1.Day10.Example9_8;


import javax.swing.*;
import java.awt.*;

/**
 * ********概述：
 */
public class NumberView extends JFrame {
    public JTextField inputNumberOne,inputNumberTwo;
    public JComboBox<String> choiceFuhao;
    public JTextArea textShow;
    public JButton button;
    public OperatorListener operator;
    public ComputerListener computer;
    public NumberView () {
        init();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    void init() {
        setLayout(new FlowLayout());
        Font font = new Font("宋体", Font.BOLD, 22);
        inputNumberOne = new JTextField(5);
        inputNumberTwo = new JTextField(5);
        inputNumberOne.setFont(font);
        inputNumberTwo.setFont(font);
        choiceFuhao = new JComboBox<>();
        choiceFuhao.setFont(font);
        button = new JButton("计算");
        button.setFont(font);
        choiceFuhao.addItem("选择运算符号:");
        String[] a = {"+","-","*","/"};
        for (int i = 0; i < a.length; i++) {
            choiceFuhao.addItem(a[i]);
        }
        choiceFuhao.setSelectedIndex(-1);
        textShow = new JTextArea(9,30);
        textShow.setFont(font);
        operator = new OperatorListener();
        computer = new ComputerListener();
        operator.setView(this);
        computer.setView(this);
        choiceFuhao.addItemListener(operator);
        choiceFuhao.addActionListener(operator);
        button.addActionListener(computer);
        add(inputNumberOne);
        add(choiceFuhao);
        add(inputNumberTwo);
        add(button);
        add(new JScrollPane(textShow));
    }
}
