import java.util.Comparator;
import java.util.PriorityQueue;

public class MyMedian {
    public static void main(String[] args) {
        MyMedian test = new MyMedian();
        test.insert(2);
        test.insert(7);
        test.insert(9);
        test.insert(5);
        test.insert(3);
        test.insert(4);
        test.insert(0);
        test.insert(12);
        test.insert(15);
        test.insert(8);
        test.insert(11);
        test.insert(6);
        test.insert(14);

        System.out.println(test.maxHeap.toString());
        System.out.println(test.minHeap.toString());
        System.out.println(test.median());
        System.out.println(test.size);

    }

    private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());
    private int size;


    public int median() {
        if (minHeap.size()>maxHeap.size()) return maxHeap.peek();
        else return maxHeap.peek();
    }

    public void insert(int q) {
    if (size == 0) minHeap.add(q);
    else {
        if (minHeap.size() > maxHeap.size()) {
            if (q > minHeap.peek()) {
                maxHeap.add(minHeap.poll());
                minHeap.add(q);
            } else {
                maxHeap.add(q);
            }
        } else if (minHeap.size() < maxHeap.size()) {
            if (q < minHeap.peek()) {
                minHeap.add(maxHeap.poll());
                maxHeap.add(q);
            } else minHeap.add(q);
        } else {
            if (q < minHeap.peek()) maxHeap.add(q);
            else minHeap.add(q);
        }
    }
    size++;
    }
}
