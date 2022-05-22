package javadrawlib;

import javadrawlib.drawtools.Draw;
import javautils.types.lambdas.Out0In1;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    Out0In1<Graphics2D> onDraw;

    public Window(int w, int h, Out0In1<Graphics2D> od){
        super();
        onDraw = od;

        setBounds(0, 0, w, h);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        setVisible(true);
    }

    @Override
    public void repaint(long tm) {
        super.repaint(tm);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        Draw.g2d = () -> g2d;
        onDraw.get(g2d);
        g2d.dispose();
    }
}
