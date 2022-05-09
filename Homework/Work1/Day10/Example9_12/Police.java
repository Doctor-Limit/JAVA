package Work1.Day10.Example9_12;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * ********概述：
 */
public class Police implements KeyListener, FocusListener {
    Win view;

    public void setView(Win view) {
        this.view = view;
    }

    public void keyTyped1(KeyEvent e) {
        JTextField text = (JTextField) e.getSource();
        if (text.getText().length() == 6) {
            text.setEnabled(false);
            text.transferFocus();
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (e.getSource() == view.button) {
            for (int i = 0; i < 3; i++) {
                view.text[i].setEnabled(true);
            }
        }
        if (e.getSource() instanceof  JTextField) {
            JTextField text = (JTextField) e.getSource();
            text.setText(null);
        }
    }

    @Override
    public void focusLost(FocusEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
