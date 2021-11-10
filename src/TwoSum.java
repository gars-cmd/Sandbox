import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {

    }

public int[] twoSum( int[] num , int target){
        int[]ans = new int[2];
    Map<Integer,Integer> map =  new HashMap<>();
    for (int i = 0; i <num.length ; i++) {
        if (map.containsKey(target-num[i])){
            ans[1]=i;
            ans[0] = map.get(target-num[i]);
        }
    else map.put(num[i],i);
    }
return ans;
    }
}
