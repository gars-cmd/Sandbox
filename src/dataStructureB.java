import java.util.Arrays;
import java.util.NoSuchElementException;

public class dataStructureB {
    public static void main(String[] args) {
        dataStructureB test = new dataStructureB(17);
        test.insert(1);
        test.insert(12);
        test.insert(7);
        test.insert(4);
        test.insert(11);
        test.insert(2);
        test.insert(9);
        System.out.println(test.bigger(8));
        System.out.println(Arrays.toString(test.list));
    }

    private int tvah;
    private int[] list = new int[tvah];

    public dataStructureB(int t) {
        this.tvah = t;
        list = new int[tvah];
        for (int i = 0; i < tvah; i++) {
            list[i] = -1;
        }
    }

    public void insert(int x) {
        list[x] = x;
        for (int i = x; i < this.tvah-1; i++) {
            if (list[i + 1] < list[i]) list[i + 1] = list[i];
        }
        if (list[x - 1] == -1) Arrays.fill(list, x);
        else{
            while (list[x-1]>list[x]){
                list[x-1]=list[x];
                x=x-1;
            }
        }

    }

public int bigger(int x){
        if (x>this.tvah) throw  new NoSuchElementException("too big number for our data structure");
else return list[x];
    }


}

