import java.util.NoSuchElementException;
import java.util.Stack;

public class Ex2 {
    public static void main(String[] args) {
        Ex2 test = new Ex2();

test.enQueue(5);
 test.enQueue(6);
 test.enQueue(7);
 test.enQueue(8);
 test.enQueue(9);
 test.enQueue(10);
 System.out.println(test.queue.peek());
 test.deQueue();
 System.out.println(test.queue.peek());
 System.out.println(test.isEmpty());
 test.deQueue();
 test.deQueue();
 test.deQueue();
 test.deQueue();
 test.deQueue();
 System.out.println(test.isEmpty());


    }
private Stack<Integer> steck1 = new Stack<>();
private Stack<Integer> queue = new Stack<>();
private int size = 0;

public void enQueue(int element){
if (this.size==0){
    queue.push(element);
    size++;
}else {
    for (int i = 0; i <size ; i++) {
        steck1.push(queue.pop());
    }
steck1.push(element);
    size++;
    for (int i = 0; i <size ; i++) {
        queue.push(steck1.pop());
    }
}
}

public void deQueue(){
    if (size==0) throw new NoSuchElementException("The stack is empty");
    else {
        queue.pop();
        size--;
    }
}

public boolean isEmpty(){
    return size==0;
}
}
