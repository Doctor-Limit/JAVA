package Work.homework12;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.util.Scanner;

class Work extends JFrame implements DocumentListener {
    JPanel panel,outpanel;
    JLabel label;
    JTextArea inputArea,outputArea;
    Work(String s){
        init();
        setContentPane(outpanel);
        setTitle(s);
        setVisible(true);
        setSize(1000,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    void init(){
        panel = new JPanel();
        outpanel = new JPanel();
        outpanel.setLayout(new BorderLayout());
        inputArea = new JTextArea(10,30);
        outputArea = new JTextArea(10,30);
        Font font = new Font("宋体", Font.BOLD, 40);
        label = new JLabel("请在左边文本框输入数字并用空格隔开",SwingConstants.CENTER);
        label.setFont(font);
        font = new Font("宋体", Font.BOLD,25);
        inputArea.setFont(font);
        outputArea.setFont(font);
        outputArea.setEditable(false);
        panel.add(new JScrollPane(inputArea));
        panel.add(outputArea);
        outpanel.add(panel,BorderLayout.CENTER);
        outpanel.add(label,BorderLayout.NORTH);
        (inputArea.getDocument()).addDocumentListener(this);
    }
    @Override
    public void changedUpdate(DocumentEvent e) {
        String s = inputArea.getText();
        Scanner reader = new Scanner(s);
        int count = 0;
        double avg = 0,sum = 0;
        while (reader.hasNextDouble()){
            count++;
            sum+=reader.nextDouble();
        }
        avg = sum/count;
        outputArea.setText("和为："+sum+"\n"+"平均值为："+avg);
    }
    @Override
    public void insertUpdate(DocumentEvent e) {changedUpdate(e);}

    @Override
    public void removeUpdate(DocumentEvent e) {changedUpdate(e);}
}