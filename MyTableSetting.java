package prodcon;

/**
 * Created by Tricia on 9/28/15.
 */

import java.applet.Applet;
import java.util.*;
import java.awt.*;

public class MyTableSetting extends Applet {
    Soup s;
    int bowlLength = 150;
    int bowlWidth = 220;
    int bowlX = 60;
    int bowlY = 10;

    public void init() {
        setSize(400,200);  //Big enough for soup bowl
        s = new Soup();

        Producer p1 = new Producer(this, s);
        Consumer c1 = new Consumer(this, s);

        p1.start();
        c1.start();
    }

    public void paint (Graphics g) {
        int x, y;

        g.setColor(Color.orange);
        g.fillOval(bowlX, bowlY, bowlWidth, bowlLength);
        g.setColor(Color.cyan);
        g.fillOval(10, 25, 40, 55);
        g.fillOval(25, 80, 8, 75);
        g.setColor(Color.black);
        g.drawOval(10, 25, 40, 55);
        g.drawOval(25, 80, 8, 75);
        g.drawOval(bowlX, bowlY, bowlWidth, bowlLength);
        ArrayList <String> contents = s.getContents();

        for (String each: contents) {
            x = bowlX + bowlWidth/4 + (int)(Math.random() * (bowlWidth/2));
            y = bowlY + bowlLength/4 + (int)(Math.random() * (bowlLength/2));

            Font bigFont = new Font("Helvetica", Font.BOLD, 20);
            g.setFont(bigFont);
            g.drawString(each, x, y);
        }
    }
}
