import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyQueue {
    public static void main(String[] args) {
        MyQueue test = new MyQueue();
        test.enQueue(1);
        test.enQueue(2);
        test.enQueue(3);
        System.out.println(test.toString());
        test.deQueue(2);
        System.out.println(test.toString());
    }

    private int[] queue;
    int size = 0;

    public void enQueue(int element) {
        if (size == 0) {
            queue = new int[1];
            queue[0] = element;
            size++;
        } else if (size < queue.length) {
            queue[size] = element;
            size++;
        } else if (size == queue.length) {
            int[] newqueue = new int[queue.length * 2];
            for (int i = 0; i < size; i++) {
                newqueue[i] = queue[i];
            }
            newqueue[size] = element;
            size++;
            queue = newqueue;
        }
    }

    public void deQueue(int element) {
        if (this.contains(element)) {
            int[] newqueue = new int[size - 1];
            int index = this.indexOf(element);
            for (int i = 0; i < index; i++) {
                newqueue[i] = queue[i];
            }
            for (int i = index + 1; i < size; i++) {
                newqueue[i - 1] = queue[i];
            }
            size--;
            queue = newqueue;
        }
    }

    public boolean contains(int element) {
        if (size == 0) return false;
        boolean check = false;
        for (int i = 0; i < size; i++) {
            if (queue[i] == element) {
                check = true;
                break;
            }
        }
        return check;
    }

    private int indexOf(int element) {
        if (!this.contains(element)) throw new NoSuchElementException("the number doesn't exist in the queue");
        else {
            int i = 0;
            while (i < size) {
                if (queue[i] == element) break;
                i++;
            }
            return i;
        }
    }

    public int peek() {
        if (size == 0) throw new NoSuchElementException("the queue is empty");
        else return queue[0];
    }

    public void clear() {
        if (size == 0) return;
        else {
            size = 0;
        }
    }

    public String toString() {
        String str;
        if (size == 0) return "null";
        else {
             str = "The queue[<- ";
            for (int i = 0; i < size; i++) {
                str += Integer.toString(queue[i]);
                if (i < size - 1) str += ",";

            }
            str += " ]";
        }
        return str;
    }
}







