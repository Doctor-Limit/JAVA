package Work1.Day10.Example9_8;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * ********概述：
 */
public class OperatorListener implements ItemListener, ActionListener {
    NumberView view;

    public void setView(NumberView view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String fuhao = view.choiceFuhao.getSelectedItem().toString();
        view.computer.setFuhao(fuhao);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        String fuhao = view.choiceFuhao.getSelectedItem().toString();
        view.computer.setFuhao(fuhao);
    }
}
