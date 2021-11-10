import java.util.ArrayList;
import java.util.NoSuchElementException;

public class MaxHeap {
    public static void main(String[] args) {

    }
private int[] heap;
    private int size;

public void add(int value){
    if (size== heap.length-1) ensureCap();
    heap[size+1] = value;
    size++;
    swapUp(size-1);
}
private void ensureCap(){
    int[] newArr = new int[size*2];
    for (int i = 1; i <size ; i++) {
        newArr[i] = heap[i];
    }
heap= newArr;
}

private void swapUp(int index){
    if (index != 1){
        int parent = index/2;
        if (heap[parent]<heap[index]){
            swap(heap,parent,index);
            swapUp(parent);
        }
    }
}
private void swap(int[] arr , int i , int j){
    int temp = heap[i];
    heap[i]= heap[j];
    heap[j]= temp;
}

private int parent(int index){
    if (index<=1) throw new NoSuchElementException();
        return (index/2);
}
public int removeMax(){
    if (size==0)throw new NoSuchElementException();
    else {
        swap(heap,size,1);
        size--;
        maxHeapify(1);
    }
return heap[size+1];
}

private void maxHeapify (int i) {
    int left, right;
    try {
        left = left(i);
    } catch (NoSuchElementException exception) {
        left = 0;
    }
    try {
        right = right(i);
    } catch (NoSuchElementException exception) {
        right = 0;
    }
    int largest = i;
    if (left >= 1 && heap[left] > heap[i]) largest = left;
    if (right >= 1 && heap[right] > heap[i]) largest = right;
    if (largest != i) {
        swap(heap,largest, i);
        maxHeapify(largest);
    }
}
private int left(int i){
    int ans = 2*i;
    if (ans>size)throw new NoSuchElementException();
    return ans;
}
private int right(int i){
int ans = (2+1)+1;
if (ans>size) throw new NoSuchElementException();
return ans;
}
public int max(){ if (size>1) return heap[1];else throw new NoSuchElementException();}


    public MaxHeap(int capacity){
    if (capacity<0)throw new NoSuchElementException();
heap = new int[capacity+1];
this.size = 0;
}

public MaxHeap (int[] arr){
    for (int i = 1; i < heap.length ; i++) {
        heap[i] = arr[i-1];
}
size = arr.length;
buildHeap();
}
private void buildHeap(){
    for (int i = size/2; i >=1 ; i--) {
maxHeapify(i);
    }

}
}