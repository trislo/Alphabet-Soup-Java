package prodcon;

/**
 * Created by Tricia on 9/28/15.
 */
public class Producer extends Thread {
    private Soup soup;
    private String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private MyTableSetting bowlView;

    public Producer(MyTableSetting bowl, Soup a) {
        bowlView = bowl;  //Gui to show what's happening

        soup = a;  //soup - the monitor
    }

    public void run() {
        String c;
        for (int i = 0; i < 10; i++) {
            //assign random letter
            c = String.valueOf(alphabet.charAt((int)(Math.random()) * 26));
            soup.add(c);  // put in soup

            System.out.println("Added " + c + "to the soup");
            bowlView.repaint();

            try {
                sleep((int)(Math.random() * 2000)) ;
            } catch (InterruptedException e) {};
        }
    }
}
