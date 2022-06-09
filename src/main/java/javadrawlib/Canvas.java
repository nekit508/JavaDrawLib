package javadrawlib;

import javadrawlib.drawtools.Draw;
import javautils.types.lambdas.Out0In0;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Canvas extends java.awt.Canvas {
    public void render(Out0In0 od) {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(2);
            requestFocus();
            return;
        }
        Graphics2D g2d = (Graphics2D) bs.getDrawGraphics();

        Draw.g2d = () -> g2d;

        od.get();

        Draw.reset();

        g2d.dispose();
        bs.show();
    }
}
