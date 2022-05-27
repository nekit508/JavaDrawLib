package javadrawlib.drawtools;

import javautils.structs.Seq;
import javautils.types.lambdas.Out1In0;

import java.awt.*;

public class Draw {
    public static Out1In0<Graphics2D> g2d;
    public static Seq<Color> colors = new Seq<Color>();
    public static Seq<Font> fonts = new Seq<Font>();
    public static Font classicFont = new Font("Arial", Font.PLAIN, 14);

    public static Color toColor(float r, float g, float b, float a){
        return new Color(r, g, b, a);
    }

    public static Color toColor(float r, float g, float b){
        return new Color(r, g, b, 1f);
    }

    public static void pushColor(Color col){
        g2d.get().setColor(col);
        colors.add(col);
    }

    public static void popColor(){
        colors.pop();
        if(colors.getSize() == 0) g2d.get().setColor(new Color(0f, 0f, 0f, 0f));
        else g2d.get().setColor(colors.getLastElement());
    }

    public static void pushFont(Font f){
        g2d.get().setFont(f);
        fonts.add(f);
    }

    public static void popFont(){
        fonts.pop();
        if(fonts.getSize() == 0) g2d.get().setFont(classicFont);
        else g2d.get().setFont(fonts.getLastElement());
    }

    public static void rectf(int x, int y, int w, int h){
        g2d.get().fillRect(x, y, w, h);
    }

    public static void circlef(int x, int y, int r){
        g2d.get().fillOval(x + r/2, y + r/2, r/2, r/2);
    }

    public static void polyf(int[] x, int[] y, int n){
        g2d.get().fillPolygon(x, y, n);
    }

    public static void rect(int x, int y, int w, int h){
        g2d.get().drawRect(x, y, w, h);
    }

    public static void circle(int x, int y, int r){
        g2d.get().drawOval(x + r/2, y + r/2, r/2, r/2);
    }

    public static void poly(int[] x, int[] y, int n){
        g2d.get().drawPolygon(x, y, n);
    }

    public static void polyLine(int[] x, int[] y, int n){
        g2d.get().drawPolyline(x, y, n);
    }

    public static void line(int x, int y, int w, int h){
        g2d.get().drawLine(x, y, x+w, y+h);
    }

    public static void text(int x, int y, String text){
        g2d.get().drawString(text, x, y);
    }
}
