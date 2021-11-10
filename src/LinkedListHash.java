import java.util.Arrays;
import java.util.LinkedList;

public class LinkedListHash {
    private LinkedList<HashNode>[] buckets;

    public LinkedListHash (int capacity){
        buckets = new LinkedList[capacity];
        Arrays.fill(buckets,new LinkedList<HashNode>());
    }
public LinkedListHash (LinkedListHash other){
        this.buckets = new LinkedList[other.buckets.length];
    for (int i = 0; i <other.buckets.length ; i++) {
        HashNode[]newBucket = (HashNode[]) Arrays.copyOf(other.buckets[i].toArray(),other.buckets[i].size());
    buckets[i] = (LinkedList<HashNode>) Arrays.asList(newBucket);
    }
}

public Integer insert(int key , Students value){
        int h = Hash(key);
        //check if key is already present
    if (get(key) != null) {
        for (int i = 0; i < buckets[h].size(); i++) {
            if (buckets[h].get(i).equals(key)) {
                buckets[h].get(i).value = value;
            }
        }
    }
        else buckets[h].add(new HashNode(key,value));
    return key;
    }



public Students get(int key){
        int h = Hash(key);
    for (int i = 0; i <buckets[h].size() ; i++)
        if (buckets[h].get(i).equals(key))
            return buckets[h].get(i).value;
         return null;
}
public void remove (int key){
        if (get(key)==null) return;
        else {
            int h= Hash(key);
            for (int i = 0; i <buckets[h].size() ; i++) {
                if (buckets[h].get(i).equals(key)) buckets[h].remove(i);
            }
        }
}

public int Hash(int x) { return  x % buckets.length;}

}
