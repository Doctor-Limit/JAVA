package Work1.Day10.Example9_9;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ********概述：
 */
public class HandListener implements ActionListener {
    WindowDocument view;

    public void setView(WindowDocument view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       String str = e.getActionCommand();
       if (str.equals("copy"))
           view.showText.copy();
       else if (str.equals("cut"))
           view.showText.cut();
       else if (str.equals("paste"))
           view.showText.paste();

    }
}
