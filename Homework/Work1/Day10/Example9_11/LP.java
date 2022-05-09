package Work1.Day10.Example9_11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * ********概述：
 */
public class LP extends JLayeredPane implements MouseListener, MouseMotionListener {
    JButton buttonTom,buttonJerry;
    int x,y,a,b,x0,y0;
    LP() {
        buttonTom = new JButton("用鼠标拖动 Tom");
        buttonTom.addMouseListener(this);
        buttonTom.addMouseMotionListener(this);
        buttonJerry = new JButton("用鼠标拖动 Jerry");
        buttonJerry.addMouseListener(this);
        buttonJerry.addMouseMotionListener(this);
        setLayout(new FlowLayout());
        add(buttonTom,JLayeredPane.DEFAULT_LAYER);
        add(buttonJerry,JLayeredPane.DEFAULT_LAYER);
    }
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        JComponent com = null;
        com = (JComponent) e.getSource();
        setLayer(com,JLayeredPane.DRAG_LAYER);
        a = com.getBounds().x;
        b = com.getBounds().y;
        x0 = e.getX();
        y0 = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        JComponent com = null;
        com = (JComponent) e.getSource();
        setLayer(com,JLayeredPane.DEFAULT_LAYER);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Component com = null;
        if (e.getSource() instanceof Component) {
            com = (Component) e.getSource();
            a = com.getBounds().x;
            b = com.getBounds().y;
            x = e.getX();
            y = e.getY();
            a += x;
            b += y;
            com.setLocation(a - x0,b - y0);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
