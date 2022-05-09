package Work1.Day10.Example9_10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * ********概述：
 */
public class MousePolice implements MouseListener {
    WindowMouse view;

    public void setView(WindowMouse view) {
        this.view = view;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() >= 2)
            view.area.setText("鼠标连击\n");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == view.button && e.getButton() == MouseEvent.BUTTON1) {
            view.area.append("在按钮上按下鼠标左键:\n");
            view.area.append(e.getX() + "," + e.getY() + "\n");
        } else if (e.getSource() == view && e.getButton() == MouseEvent.BUTTON1) {
            view.area.append("在窗口上按下鼠标左键:\n");
            view.area.append(e.getX() + "," +e.getY() + "\n");
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() instanceof Button)
            view.area.append("\n鼠标进入按钮,位置:" +e.getX() + "," +e.getY() + "\n");
        if (e.getSource() instanceof JFrame)
            view.area.append("\n鼠标进入窗口,位置:" +e.getX() + "," +e.getY() + "\n");
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
