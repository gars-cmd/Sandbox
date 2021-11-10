import java.util.NoSuchElementException;
import java.util.Stack;

public class MyStack {
private int[]stack;
private int size= 0;

    public static void main(String[] args) {
MyStack stackTest = new MyStack(5);
stackTest.push(1);
stackTest.push(3);
stackTest.push(4);
stackTest.push(2);
        //System.out.println(stackTest.toString());
String str = "2435.56742";
        //System.out.println( stackTest.sortStack());
        System.out.println(isPalyndromeString(str));
    }

public MyStack(int capacity){
        this.stack = new int[capacity];
}

private void ensureTheCapacity(){
        int[]stackV2 = new int[this.size*2];
    for (int i = 0; i < this.size ; i++) {
        stackV2[i] = stack[i];
    }
    stack = stackV2;
}

public  void push(int element){ //add them with LIFO way
        if (this.size==this.stack.length){
         ensureTheCapacity();
         this.size++;
        }
        else {
            this.stack[this.size] = element;
            this.size++;
        }

}
public int pop(){
        if (size==0) throw new NoSuchElementException("the stack is empty");
        else return stack[--size]; //reduce the value of the size and return it
}
public int top(){
        if (this.size==0) throw new NoSuchElementException("the stack is empty");
        return this.stack[this.size-1];
}
public boolean isEmpty(){return this.size==0;}

public void clear(){this.size = 0;}

    public int search(int key){
        int i = 0;
        while (i<size){
            if (this.stack[i]==key) break;
        i++;
        }
        if (i==size) return -1;
        else return i++;
    }

    public int Size() {return this.size;}

    public String toString(){
        String ans = "Stack: [";
        for (int i = 0; i <size ; i++) {
            ans += this.stack[i]+", ";
        }
        ans = ans.substring(0,ans.length()-2
        );
    return ans+" ->";
    }
public MyStack sortStack(){
        MyStack help_stack = new MyStack(size); // creating the help stack
        while (!this.isEmpty()){    // as long as the main stack is not empty
            int temp = this.pop();  // temp = the last value of main
            while (!help_stack.isEmpty() && help_stack.top()>temp ){
                // as long as the help stack is not empty and the top of the helped stack > temp
                this.push(help_stack.pop()); // add to  the main stack the top of helped stack
            }
        help_stack.push(temp); //add to the helped stackc the temp value
        }
return help_stack;
    }
public static  boolean isPalyndromeString(String str) {
    str = str.replaceAll("[.]", "");
    if (str.length() == 0) return true;
    if (!(str.length() % 2 == 0)) {
        return false;
    } else {
        MyStack the_stack = new MyStack(str.length() / 2);
        for (int i = 0; i < (str.length() / 2); i++) {
            the_stack.push(Integer.parseInt("" + str.charAt(i)));
        }
        str = str.substring(str.length() / 2);
        for (int i = 0; i < str.length(); i++) {
            if (Integer.parseInt("" + str.charAt(i)) != the_stack.pop()) return false;
        }
        return true;
    }
}
public static boolean BLABLA(String str){
    Stack<Character> steck = new Stack<>();
    for (int i = 0; i < str.length() ; i++) {
        char curr = str.charAt(i);
        if (curr == '(' || curr == '[' || curr == '{') steck.push(curr);
        else{
            if (steck.isEmpty()) return false;
            char top = steck.pop();
            if (    (top == '{' && curr!='}') ||
                    (top == '(' && curr!=')') ||
                    (top =='[' && curr!=']') ); return false;
    }
    }
    return steck.isEmpty();
    }


    }





