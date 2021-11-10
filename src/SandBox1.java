import com.sun.source.tree.BinaryTree;
import com.sun.source.tree.ExpressionTree;
import com.sun.source.tree.Tree;
import com.sun.source.tree.TreeVisitor;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;

public class SandBox1 {


    public static void main(String[] args) {
        System.out.println(isPrime(63));
        System.out.println(isStrong(145));
        System.out.println(isArmstrong(407));
        System.out.println(isArmstrongRec(407));


//        String[] votes = {"WXYZ","XYZW"};
//        System.out.println(rankTeams(votes));


//        BST tree = new BST();
//        tree.add(5);
//        tree.add(2);
//        tree.add(1);
//        tree.add(3);
//        tree.add(4);
//        tree.add(6);
//        tree.add(8);
//        tree.add(7);
//        tree.add(9);
//        System.out.println(numOfBigger(3,tree));
//        int[] arr = {4,8,19,21,33,52,54};
//        int[] arr2 = {0,100,2000,220000};

        //       System.out.println(triple(arr));
        //System.out.println(minDiff(arr,arr2));
        //System.out.println(result != -1 ? "found at Index "+result:"not found");

//        Map<String, Integer> ages = new HashMap<>();
//        ages.put("avidan", 23);
//        ages.put("Aron", 17);
//        ages.put("Salomon", 56);
//        ages.put("Muriel", 54);
//        ages.put("Sarah", 21);
//        ages.put("Yoram", 15);
//        System.out.println(ages.replace("Salomon", 56, 55));
//        System.out.println(ages.toString());
    }

    public static int BinarySearch(int[] arr, int key) {
        int low = 0, high = arr.length - 1, mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (key == arr[mid]) {
                return mid + 1;
            } else if (key < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }


    private static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean semi(int n) {
        if (n == 1) {
            return false;
        }
        if (n == 2) {
            return false;
        }
        for (int i = 2; i < (n / 2) + 1; i++) {
            if (isPrime(i) && (n % i) == 0) {
                if (isPrime(n / i)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int findMaximum(String str) {
        String numbers = "0123456789";
        String max_numbers = "0";
        for (int i = 0; i < str.length(); i++) {
            String current_max = "0";
            if (numbers.contains("" + str.charAt(i))) {
                while (numbers.contains("" + str.charAt(i)) && (i < str.length() - 1)) {
                    current_max += str.charAt(i);
                    i++;
                }
                if (Integer.parseInt(max_numbers) < Integer.parseInt(current_max)) {
                    max_numbers = current_max;
                }
            }
        }
        return Integer.parseInt(max_numbers);
    }

    public static String theLongestWord(String a) {
        String l_word = "";
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == ' ') {

                if (l_word.length() < a.substring(0, i).length()) {
                    l_word = a.substring(0, i);
                    a = a.substring(i + 1);
                }
            }
        }
        return l_word;
    }

    public static boolean isSimI(double[] arr) {
        double[] newlist = new double[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            newlist[Math.abs(i - (arr.length - 1))] = arr[i];
        }
        boolean check = true;
        for (int i = 0; i < arr.length; i++) {
            if (newlist[i] != arr[i]) {
                check = false;
                break;
            }
        }
        return check;

    }

    private static boolean isHere(int[] a, int n) {
        for (int i = 0; i < a.length; i++) {
            if (n == a[i]) {
                return true;
            }
        }
        return false;
    }

    private static int howMany(int[] a, int n) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == n) {
                count++;
            }
        }
        return count;
    }

    public static boolean equal(int[] a, int[] b) {
        if (a.length != b.length) {
            return false;
        } else {
            for (int i = 0; i < a.length; i++) {
                if (isHere(b, a[i]) && (howMany(a, a[i]) != howMany(b, a[i]))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static String[] StringArr2set(String[] a) {
        String ans = "";
        for (int i = 0; i < a.length; i++) {
            if (!ans.contains(a[i])) {
                ans += a[i] + ",";
            }
        }
        String[] answer = ans.split(",");
        return answer;
    }

    public static int maxMonotoneArr(double[] a) {
        int max = 0;
        int count = 1;
        boolean check = true;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] < a[i + 1]) {
                count++;
            } else if (a[i] > a[i + 1]) {
                if (max < count) {
                    max = count;
                    count = 1;
                }
            }
        }
        if (max < count) {
            return count;
        } else {
            return max;
        }
    }

    public static boolean isMinHeap(int[] list) {
        for (int i = 0; i <= (list.length - 2) / 2; i++) {
            if (2 * i + 1 > list.length - 1) return true;
            if (list[2 * i + 1] < list[i]) return false;
            if (2 * i + 2 > list.length - 1) return true;
            if (list[2 * i + 2] < list[i]) return false;
        }
        return true;
    }


    private static void addM(int[] list, int i, int m) {
        if (i >= list.length) ;
        else {

            list[i] += m;
            addM(list, 2 * i + 1, m);
            addM(list, 2 * i + 2, m);
        }
    }
//public static int[] ex4guimel(int[]list, int i , int m ){
//        int[]newlist = new int[addM(list,i,m,0)];
//    int j= i;
//    int k = 0;
//        while (j<list.length){
//            newlist[k] = list[j];
//            k++;
//            newlist[k] = list[2*j+1];
//            j=j*2+2;
//
//    }
//
//    }

    public static boolean triple(int[] A) {
        for (int i = 0, n = A.length; i < n - 1; i++) { //O(n)
            for (int j = i + 1; j < n; j++) {   //
                double test = Math.pow(A[i], 2) + Math.pow(A[j], 2);
                int count = n - 1;
                while (count != j) {
                    if (test == Math.pow(A[count], 2)) {
                        System.out.println("the result is index " + i + "^2 + index " + j + "^2 = index " + count + "^2");
                        return true;
                    } else if (Math.pow(A[count], 2) > test) count--;
                    else if (test > (Math.pow(A[count], 2))) break;
                    else break;
                }
            }
        }
        return false;
    }

    public static int minDiff(int[] A, int[] B) {
        int i = 0;
        int j = 0;
        int stock = Integer.MAX_VALUE;
        int n = A.length;
        while (i < n) {
            if (Math.abs(A[i] - B[j]) < stock) {
                stock = Math.abs(A[i] - B[j]);
                j++;
            } else if (Math.abs(A[i] - B[j]) > stock) break;
            i++;
        }
        return stock;
    }

    public static int numOfBigger(int n, BST tree) {
        return numOfBigger(tree.getRoot(), tree, n);
    }

    private static int numOfBigger(Node curr, BST tree, int n) {
        if (curr.data == n) return numOfRight(curr.data, tree);
        else if (curr.data < n) return (numOfBigger(curr.right, tree, n));
        else return (numOfBigger(curr.left, tree, n) + numOfRight(curr.data, tree) + 1);
    }


    private static int numOfRight(int n, BST tree) {
        return Sum(Findit(tree, n).right, tree);
    }

    private static int numOfLeft(int n, BST tree) {
        return Sum(Findit(tree, n).left, tree);
    }

    private static int Sum(Node curr, BST tree) {
        if (curr == null) return 0;
        return (Sum(curr.left, tree) + Sum(curr.right, tree) + 1);
    }

    public static Node Findit(BST tree, int n) {
        return Findit(tree, tree.getRoot(), n);
    }

    private static Node Findit(BST tree, Node curr, int n) {
        if (curr.data == n) return curr;
        else if (curr.data < n) return Findit(tree, curr.right, n);
        else return Findit(tree, curr.left, n);
    }


    public static int Range(int[] A, int k, int a, int b) {
        int[] C = new int[k];
        for (int i = 0; i < k; i++) {
            C[i] = 0;
        }
        for (int j = 0; j < A.length; j++) {
            C[A[j]] += 1;
        }
        for (int i = 2; i < k; i++) {
            C[i] = C[i] + C[i - 1];
        }
        return C[b] - C[a - 1];

    }

    public static void PrintTree(int[] arr) {
        PrintTree(arr, 0, arr.length);
    }


    private static void PrintTree(int[] arr, int left, int right) {
        if (left - right == 0) ;
        else {
            int root = getMin(arr, left, right);
            System.out.print("  " + arr[root]);

            PrintTree(arr, left, root);

            PrintTree(arr, root + 1, right);

        }
    }

    private static int getMin(int[] arr, int left, int right) {
        int min = left;
        for (int i = left; i < right; i++) {
            if (arr[i] < arr[min]) min = i;
        }
        return min;
    }

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] > nums[j]) count++;
            }
            result[i] = count;
        }
        return result;
    }

    public static String rankTeams(String[] votes) {
        int word_length = votes[0].length();
        int length = votes.length;
        HashMap<Character, Integer> test = new HashMap<>(word_length);
        for (int i = 0; i < word_length; i++) {
            test.put(votes[0].charAt(i), 0);
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < word_length; j++) {
                test.put((char) votes[i].charAt(j), (int) test.get((char) votes[i].charAt(j)) + 2 * (word_length - j));
            }
        }
        return biggest(test, votes, Integer.MAX_VALUE, word_length);
    }

    private static String biggest(HashMap map, String[] votes, int olderValue, int count) {
        if (count == 0) {
        } else {
            char[] phrase = votes[0].toCharArray();
            Arrays.sort(phrase);
            String text = "";
            if (!thesame(map)) {
                for (int i = 0; i < phrase.length; i++) {
                    text += phrase[i];
                }
                return text;
            }
            int max = olderValue;
            char winner = ' ';
            int newval = 0;
            for (int i = 0; i < votes[0].length(); i++) {
                if (map.get(votes[0].charAt(i)) == null) continue;
                int x = olderValue - (int) map.get(votes[0].charAt(i));
                if (x < max) {
                    max = x;
                    winner = votes[0].charAt(i);
                    newval = (int) map.get(winner);
                }
            }
            map.put(winner, 0);
            return winner + biggest(map, votes, newval, count - 1);
        }
        return " ";
    }

    private static boolean thesame(HashMap map) {
        if (map.size() == 1) return false;
        if (map.get(map.keySet().toArray()[0]) == map.get(map.keySet().toArray()[1])) return false;
        return true;
    }

    public static void F(Queue q1, Queue q2) {
        Queue q3 = new PriorityQueue(5);
        for (int i = 0; i < q2.size(); i++) {
            for (int j = 0; j < q1.size(); j++) {
                if (j % 2 == 0) {
                    if (q2.peek() == q1.peek()) q1.poll();
                    else q3.add(q1.poll());
                } else {
                    if (q2.peek() == q3.peek()) q3.poll();
                    else q1.add(q3.poll());
                }
            }
            q2.poll();
        }
    }

    public static void Inorder(TreeNode tree) {
        if (tree != null) {
            Inorder(tree.left);
            System.out.println(tree.val);
            Inorder(tree.right);
        }
    }


    private static TreeNode bstToGst(TreeNode root, int sum) {
        if (root != null) {
            bstToGst(root.left, sum);
            int temp = root.val;
            root.val = sum;
            sum -= temp;
            bstToGst(root.right, sum);
        }
        return root;
    }


    public static String longestCommonPrefix(String[] str) {
        if (str.length == 0) return "";
        String prefix = str[0];
        for (int i = 1; i < str.length; i++) {
            while (str[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            if (prefix.length()==0) return "";
            }
        }
        return prefix;
    }

    public static String longestCommonPrefix2(String[] strs) {
            return longestCommonPrefix2(strs , 0 , strs.length);
        }
private static String longestCommonPrefix2(String[]strs, int s,int e){
            if (s==e) return strs[s];
            int mid = (s+e)/2;
            String lcpl = longestCommonPrefix2(strs,s,mid);
            String lcpr = longestCommonPrefix2(strs, mid+1, e);
            return commonPrefix(lcpl,lcpr);
}
private static String commonPrefix(String s1 , String s2){
        int length = Math.min(s1.length(),s2.length());
    for (int i = 0; i <length-1 ; i++) {
        if (s1.charAt(i)!=s2.charAt(i)) return s1.substring(0,i-1);
    }
    return s1.substring(0,length-1);
    }

    private static boolean isPrime2(int n){
        if (n==1 || n==2){
            return true;
        }
        else {
            for (int i = 2; i < n / 2; ++i) {
                if (n % i == 0) return false;
            }
        }
        return true;
    }
    private static boolean isStrong( int n ){
        int m = n;
        int sum = 0;
        int rest = 0;
        while (m>0){
            rest = m%10;
            int sum2=rest;
            while (rest>1){
                rest--;
                sum2 = sum2*rest;
            }
            sum+=sum2;
            m=m/10;
        }
        return n==sum;
    }
    public static int ArmstrongHelp(int n){
        int count = 0;
        while (n>0){
            n=n/10;
            count++;
        }
        return count;
    }

    public static boolean isArmstrong(int n){
        int a;
        int sum = 0;
        int b = n;
        int i = ArmstrongHelp(n);
        while (b>0){
            int calc = 1;
            a = b%10;
            for (int j = 0; j <i ; ++j) {
                calc *=a;
            }
            sum+=calc;
            b=b/10;
        }
        return n==sum;
    }
public static boolean isArmstrongRec(int n){
        int count = ArmstrongHelp(n);
        int sum = 0;
        int new_sum = ArmstrongRecHelp(n,count ,sum);
        return n==new_sum;
}

private static int ArmstrongRecHelp(int n , int count , int sum){
        if (n== 0)return sum;
        else {
            int rest = n%10;
            int calc = 1;
            for (int i = 0; i <count ; i++) {
                calc *=rest;
            }
            sum +=calc;
            return ArmstrongRecHelp(n/10,count,sum);
        }
    }


}








