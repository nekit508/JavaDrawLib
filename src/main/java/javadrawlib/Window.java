package javadrawlib;

import javautils.types.lambdas.Out0In0;

import javax.swing.*;
import java.awt.Dimension;
import java.util.Timer;
import java.util.TimerTask;

public class Window extends JFrame {
    Out0In0 onDraw;
    public final short fps;

    public Window(int w, int h, Out0In0 od, short fps){
        super();
        onDraw = od;
        this.fps = fps;

        Canvas canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(w, h));

        setBounds(0, 0, w, h);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        add(canvas);
        pack();

        setVisible(true);
        setResizable(false);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                canvas.render(onDraw);
            }
        }, 1000/fps);
    }
}
