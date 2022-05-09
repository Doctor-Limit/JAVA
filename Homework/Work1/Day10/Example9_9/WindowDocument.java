package Work1.Day10.Example9_9;

import javax.swing.*;
import javax.swing.text.Document;
import java.awt.*;

/**
 * ********概述：
 */
public class WindowDocument extends JFrame {
    JTextArea inputText,showText;
    JMenuBar menubar;
    JMenu menu;
    JMenuItem itemCopy,itemCut,itemPaste;
    TextListener textChangeLister;
    HandListener handListener;
    WindowDocument () {
        init();
        setLayout(new FlowLayout());
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    void init() {
        inputText = new JTextArea(10,28);
        showText = new JTextArea(10,28);
        showText.setWrapStyleWord(true);
        Font font = new Font("宋体", Font.PLAIN, 25);
        inputText.setFont(font);
        showText.setFont(font);
        menubar = new JMenuBar();
        menu = new JMenu("编辑");
        itemCopy = new JMenuItem("复制(C)");
        itemCut = new JMenuItem("剪切(T)");
        itemPaste = new JMenuItem("粘贴(P)");
        itemCopy.setAccelerator(KeyStroke.getKeyStroke('c'));
        itemCut.setAccelerator(KeyStroke.getKeyStroke('t'));
        itemPaste.setAccelerator(KeyStroke.getKeyStroke('p'));
        itemCopy.setActionCommand("copy");
        itemCut.setActionCommand("cut");
        itemPaste.setActionCommand("paste");
        menu.add(itemCopy);
        menu.add(itemCut);
        menu.add(itemPaste);
        menubar.add(menu);
        setJMenuBar(menubar);
        add(new JScrollPane(inputText));
        add(new JScrollPane(showText));
        textChangeLister = new TextListener();
        handListener = new HandListener();
        textChangeLister.setView(this);
        handListener.setView(this);
        Document document = inputText.getDocument();
        document.addDocumentListener(textChangeLister);
        itemCopy.addActionListener(handListener);
        itemCut.addActionListener(handListener);
        itemPaste.addActionListener(handListener);
    }
}
