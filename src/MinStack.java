public class MinStack {
    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(85);
        obj.push(-99);
        obj.push(67);
        System.out.println(obj.getMin());
        obj.push(-27);
        obj.push(85);
        obj.push(61);
        obj.push(-97);
        obj.push(-27);
        obj.push(35);
        System.out.println(obj.top());
        obj.push(99);
        obj.push(-66);
        System.out.println(obj.getMin());
        obj.pop();
        obj.pop();
        obj.pop();
        System.out.println(obj.top());
        System.out.println(obj.top());
        obj.pop();
        System.out.println(obj.top());
        obj.push(12);
        System.out.println(obj.top());
        obj.push(13);
        obj.push(14);
        obj.push(15);
        obj.push(16);
        obj.push(16);
        obj.push(16);
        obj.push(16);
        obj.push(16);
        obj.push(16);
        obj.push(16);
        obj.push(16);
        obj.push(16);
        obj.push(16);
        obj.push(17);


    }

 int[]arr ;
 int size=0;
int freeSpace =9;
    public MinStack() {
arr= new int[10];
    }
    public void push(int val) {
if (freeSpace>=0){
    arr[freeSpace]=val;
freeSpace--;
}
else {
    int[]newArr = new int[2*arr.length];
    for (int i = 0; i < arr.length ; i++) {
        newArr[newArr.length - i - 1] = arr[arr.length - i - 1];
    }
        newArr[newArr.length- arr.length-1]=val;
        freeSpace=arr.length-2;
        arr=newArr;

}
    }

    public void pop() {
        System.out.println(arr[freeSpace+1]);
        freeSpace++;

    }

    public int top() {
return arr[freeSpace+1];
    }

    public int getMin() {
        int min = Integer.MAX_VALUE;
        for (int i = arr.length-1; i >freeSpace ; i--) {
            if (arr[i]<min) min = arr[i];
        }
    return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */