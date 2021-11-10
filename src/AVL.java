import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class AVL implements AbstractBalancedBST{
      private Node root;

    @Override
    public int min() {
        if (root == null) throw new NoSuchElementException("The tree is empty");
        return min(root);
    }
    private int min(Node current){
        return (current.left==null)? current.data : min(current.left); //shorter if
    }

    public Node getRoot(){return this.root;}

    @Override
    public int max() {
        Node current = root;
        while (current.right!=null){current = current.right;}
        return current.data;
    }
    private int MaxValue(Node curr){
        while (curr.right!=null){curr=curr.right;}
        return curr.data;
    }
    private int MinValue(Node curr){
        while (curr.left!=null){curr=curr.left;}
        return curr.data;
    }
    @Override
    public boolean contains(int key) { return contains(key,root);}
    private boolean contains(int key , Node current){
        if (current==null)return false;
        if (current.data == key) return true;
        else if (current.data < key) return contains(key,current.right);
        else return contains(key, current.left);
    }

    @Override
    public int height() { return height (root);}
    private static int height (Node current){
        if (current==null) return -1;
        return Integer.max(height(current.right),height(current.left)) + 1;
    }

    @Override
    public void preOrder() { preOrder(root);}
    private void preOrder(Node current){
        if (current!=null){
            System.out.print(current+" ");
            preOrder(current.left);
            preOrder(current.right);
        }
    }

    @Override
    public void inOrder() { inOrder(root);}
        private void inOrder(Node current){
            if (current!=null){
                inOrder(current.left);
                System.out.print(current+" ");
                inOrder(current.right);
            }
        }

    @Override
    public void postOrder() {preOrder(root);}
    private void postOrder(Node current){
        if (current!=null){
            postOrder(current.left);
            postOrder(current.right);
            System.out.print(current+" ");
        }
    }

    @Override
    public void delete(int key) {
    throw new RuntimeException("there is no need to know how to do that");
    }
    @Override
    public int size() {
            return size(root);
        }
        private int size(Node current){
            return (current == null) ? 0 : size(current.left)+size(current.right)+1;
    }
    public int numberOfChildren(int data){
        Node current = root;
        boolean found = this.contains(data,root);
        if (!found) throw new NoSuchElementException("data doesn't exist in the tree");
    else {
        while (current.data!=data){
           if (current.data==data) break;
           else if (data>current.data) current=current.right;
           else current = current.left;
        }
            return size(current.left)+size(current.right)-1;
        }
    }

    public boolean isBSTree(){
        return isBSTreeV2(root , Integer.MIN_VALUE , Integer.MAX_VALUE);
    }
private boolean isBSTree(Node curr){// work but don't efficient
        if (curr==null) return true;
        if (curr!=null && MaxValue(curr.left)>curr.data) return false;
        if (curr!=null && MinValue(curr.right)< curr.data) return false;
        if (!isBSTree(curr.left) || (!isBSTree(curr.right))) return false;
        else return true;
}
private boolean isBSTreeV2(Node curr , int min , int max){
    if (curr==null) return true;
    if (curr.data<min || curr.data>max) return false;
    return (isBSTreeV2(curr.left,min, curr.data-1) && isBSTreeV2(curr.right, curr.data+1,max));
}
public boolean isTheseTreeSame(Node x , Node y){
        if (x==null && y==null ) return true;
        if (x!=null && y!=null) {
            return (x.data == y.data && isTheseTreeSame(x.left, y.left) && isTheseTreeSame(x.right, y.right));
        }
            return false;
        }

        private static void swapNode(Node root){
        if (root == null ){ return;}
    Node temp = root.left;
    root.left = root.right;
    root.right = temp;
        }

public static void convertToMirror (Node root){
        if (root==null) {return;}
        convertToMirror(root.left);
        convertToMirror(root.right);
        swapNode(root);
    }
 public Node returnNodeInBinaryTree(Node current, int key){
        if (current == null) return null;
        if (current.data == key) return current;
        Node l = returnNodeInBinaryTree(current.left,key);
        Node r = returnNodeInBinaryTree(current.right,key);
        if (r!= null) return r;
        if (l!= null) return l;
    return null;
 }
public int findLCA(int n1, int n2){return findLCA(root , n1 , n2).data;}

    private Node findLCA(Node node , int n1 , int n2){
        if (node == null) return null;
if (node.data>n1 && node.data>n2) return findLCA(node.left,n1,n2);
if (node.data<n1 && node.data<n2) return findLCA(node.right,n1,n2);
return node;
    }

public int Kthsmallest(Node root ,int k){ // not very efficient solution
        if (k>size() ) return Integer.MAX_VALUE;
    List<Integer> list = new ArrayList<>();
    InOrderToArray(root,list);
    return list.get(k-1);// get the k-est lower element
}
private void InOrderToArray(Node root , List<Integer> list){
        //like printing In-order but placing each element in growth order intot the list
        if (root==null) return;
        //In-order adding
        InOrderToArray(root.left,list);
        list.add(root.data);
        InOrderToArray(root.right,list);
}
public String isLeaf(int data){
        Node current = root;
        while (current!=null){
            if (data == current.data) break;
            else if (data< current.data) current=current.left;
            else current=current.right;
        }
if (current==null) return "not a vertex";
if (current.right==null || current.left== null) return "it is not a leaf";
else return "leaf";
    }
    ///////////////////////FOR BALANCING //////////////////////////////////////
    @Override
    public void add(int value) {
        if (contains(value)){
            root = add(value,root);
        }

    }
    private Node add(int value , Node current){
        if (current==null) return new Node(value);
        else if (value< current.data) current.left=add(value, current.left);
        else current.right=add(value, current.right);
        update(current);
    return balance(current);
    }

    @Override
    public void update(Node node) {// only make an update of the balanced factor
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        node.BF = rightHeight-leftHeight;
    }

    @Override
    public Node balance(Node node) {
    if (node.BF == 2){  //R
        if (node.right.BF<=0){ //RL
    return rightLeftCase(node);
        }
        else //RR
            return righRightCase(node);
        }
    else if (node.BF == -2){ //L
        if (node.left.BF <= 0){ //LL
            return leftLeftCase(node);
        }
    else  //LR
        return leftRightCase(node);
    }
    else return node;

    }
    private Node rightLeftCase(Node node){
        node.right = rightRotation(node.right);
        return leftRotation(node);
    }
    private Node righRightCase(Node node){
       return leftRotation(node);
    }
    private Node leftLeftCase(Node node){
        return rightRotation(node);
    }
    private Node leftRightCase(Node node){
        node.left = leftRotation(node.left);
        return rightRotation(node);
    }
    private Node leftRotation(Node z){
        Node y = z.right;
        z.right = y.left;
        y.left = z;
        update(z);
        update(y);
        return y; // return the new root

    }
    private Node rightRotation(Node z) {
        Node y = z.left;
        z.left = y.right;
        y.right = z;
        update(z);
        update(y);
        return y; // return the new root
    }
    public static boolean isBalanced(Node root) {
        if (root == null) return true;
        else return (isBalanced(root.right) && // is the right child is balanced
                isBalanced(root.left) && // is the left child is balanced
                Math.abs(height(root.right) - height(root.left)) <= 1);  //the substraction beetween the heights is <=1
    }



}


