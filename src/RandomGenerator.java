public class RandomGenerator {
    public static void main(String[] args) {
        RandomGenerator test = new RandomGenerator();
        System.out.println(test.next());
        System.out.println(test.next());
        System.out.println(test.previous);

    }
    int curr ;
    int previous;

public RandomGenerator(int x){
    if (x<1) throw new IllegalArgumentException("the minimum is 1");
    this.curr = x;
}
public RandomGenerator(){
    curr=1;
}
public int next(){
    previous = curr;
    curr = ((previous*25173)+13894)%65536;
    return curr;
}


}
