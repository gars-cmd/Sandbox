import java.util.Comparator;
import java.util.EmptyStackException;
import java.util.PriorityQueue;

public class Ex3 {
    public static void main(String[] args) {
    }
    private PriorityQueue<Duo> PQ = new PriorityQueue<>(5, new Comparator<Duo>() {
        public int compare(Duo o1, Duo o2) {
            return o2.getCount()- o1.getCount();
        }
    });
    private int count=0;

    public void push(int data){
            Duo node = new Duo(data, count++);
            PQ.add(node);
}

public int  pop(){
        if (count==0) throw new EmptyStackException();
        else {
            count--;
            return PQ.poll().getData();
        }

}
public int peek(){
        if (count==0) throw new EmptyStackException();
        else return PQ.peek().getData();
}
public boolean isEmpty(){
        return (count==0);
}

}
