package Work1.Day10.Example9_6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ********概述：
 */
public class ReaderListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        System.out.println(str + ":" + str.length());
    }
}
