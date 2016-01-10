package prodcon;

/**
 * Created by Tricia on 9/28/15.
 */
public class Consumer extends Thread {
    private Soup soup;
    private MyTableSetting bowlView;

    public Consumer (MyTableSetting bowl, Soup s) {
        bowlView = bowl;  // GUI
        soup = s;  // the monitor
    }

    public void run () {
        String c;

        for (int i = 0; i < 10; i++) {
            c = soup.eat();  // take a letter
            System.out.println("Ate a letter: " + c);
            bowlView.repaint();

            try {
                sleep((int)(Math.random() * 3000));
            } catch (InterruptedException e) {}
        }
    }
}
