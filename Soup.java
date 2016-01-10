package prodcon;

/**
 * Created by Tricia on 9/28/15.
 */

import java.util.*;

public class Soup {
    private ArrayList <String> buffer = new ArrayList<String>();  // soup letters
    private int capacity = 6;  // max letters in soup

    public synchronized String eat() {
        // Blocks other threads
        while (buffer.isEmpty()) {  // check for no letters
            try {
                wait();  // until more avail
            } catch(InterruptedException e) {}
        }

        String toReturn = buffer.get((int)(Math.random() * buffer.size()));
        buffer.remove(toReturn);
        buffer.trimToSize(); // Notify we ate
        return(toReturn);
    }

    public synchronized void add(String c) {
        while (buffer.size() == capacity) {  // Buffer full -- wait
            try {
                wait();
            } catch (InterruptedException e) {
            }
            ;
        }

            buffer.add(c);
            notifyAll();
    }

    public ArrayList <String> getContents() { // this is BAD
        return(buffer);
    }
}
