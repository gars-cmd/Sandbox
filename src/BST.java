
import com.sun.source.tree.Tree;

import java.util.*;

public class BST implements AbstractBST {
    public static void main(String[] args) {
//        BST tree = new BST();
//        tree.add(8);
//        tree.add(3);
//        tree.add(1);
//        tree.add(6);
//        tree.add(4);
//        tree.add(7);
//        tree.add(10);
//        tree.add(14);
//        tree.add(13);
//
//
//        System.out.println(sumOfRightChild(tree));

        TreeNode test = new TreeNode();
        test.val = 1;
        test.left.val = 2;
        test.left.left.val = 4;
        test.left.left.left.val = 7;
        test.left.right.val = 5;
        test.right.val = 3;
        test.right.right.val = 6;
        test.right.right.right.val = 8;

        System.out.println(deepestLeavesSum(test));
    }

    private Node root;

    @Override
    public int min() {
        if (root == null) throw new NoSuchElementException("The tree is empty");
        return min(root);
    }

    private int min(Node current) {
        return (current.left == null) ? current.data : min(current.left); //shorter if
    }

    public Node getRoot() {
        return this.root;
    }

    @Override
    public int max() {
        Node current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.data;
    }

    private int MaxValue(Node curr) {
        while (curr.right != null) {
            curr = curr.right;
        }
        return curr.data;
    }

    private int MinValue(Node curr) {
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr.data;
    }

    @Override
    public boolean contains(int key) {
        return contains(key, root);
    }

    private boolean contains(int key, Node current) {
        if (current == null) return false;
        if (current.data == key) return true;
        else if (current.data < key) return contains(key, current.right);
        else return contains(key, current.left);
    }

    @Override
    public int height() {
        return height(root);
    }

    private int height(Node current) {
        if (current == null) return -1;
        return Integer.max(height(current.right), height(current.left)) + 1;
    }

    @Override
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node current) {
        if (current != null) {
            System.out.print(current + " ");
            preOrder(current.left);
            preOrder(current.right);
        }
    }

    @Override
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node current) {
        if (current != null) {
            inOrder(current.left);
            System.out.print(current + " ");
            inOrder(current.right);
        }
    }

    @Override
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node current) {
        if (current != null) {
            postOrder(current.left);
            postOrder(current.right);
            System.out.print(current + " ");
        }
    }

    @Override
    public void add(int value) {
        root = add(value, root);
    }

    private Node add(int value, Node current) {
        if (current == null) return new Node(value);
        else if (value < current.data) current.left = add(value, current.left);
        else current.right = add(value, current.right);
        return current;
    }

    @Override
    public void delete(int key) {
        root = delete(key, root);
    }

    private Node delete(int key, Node current) {
        if (current == null) return null;
        if (key < current.data) current.left = delete(key, current.left);
        else if (key > current.data) current.right = delete(key, current.right);
        else { //we found the element

            //leaf
            if (current.left == null && current.right == null) return null;

            //one children
            if (current.left == null) return current.right;
            else if (current.right == null) return current.left;

            //we have two children
            int minValue = min(current.right);
            current.data = minValue;
            current.right = delete(minValue, current.right);
        }
        return current;
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node current) {
        return (current == null) ? 0 : size(current.left) + size(current.right) + 1;
    }

    public int numberOfChildren(int data) {
        Node current = root;
        boolean found = this.contains(data, root);
        if (!found) throw new NoSuchElementException("data doesn't exist in the tree");
        else {
            while (current.data != data) {
                if (current.data == data) break;
                else if (data > current.data) current = current.right;
                else current = current.left;
            }
            return size(current.left) + size(current.right) - 1;
        }
    }

    public boolean isBSTree() {
        return isBSTreeV2(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBSTree(Node curr) {// work but don't efficient
        if (curr == null) return true;
        if (curr != null && MaxValue(curr.left) > curr.data) return false;
        if (curr != null && MinValue(curr.right) < curr.data) return false;
        if (!isBSTree(curr.left) || (!isBSTree(curr.right))) return false;
        else return true;
    }

    private boolean isBSTreeV2(Node curr, int min, int max) {
        if (curr == null) return true;
        if (curr.data < min || curr.data > max) return false;
        return (isBSTreeV2(curr.left, min, curr.data - 1) && isBSTreeV2(curr.right, curr.data + 1, max));
    }

    public boolean isTheseTreeSame(Node x, Node y) {
        if (x == null && y == null) return true;
        if (x != null && y != null) {
            return (x.data == y.data && isTheseTreeSame(x.left, y.left) && isTheseTreeSame(x.right, y.right));
        }
        return false;
    }

    private static void swapNode(Node root) {
        if (root == null) {
            return;
        }
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    public static void convertToMirror(Node root) {
        if (root == null) {
            return;
        }
        convertToMirror(root.left);
        convertToMirror(root.right);
        swapNode(root);
    }

    public Node returnNodeInBinaryTree(Node current, int key) {
        if (current == null) return null;
        if (current.data == key) return current;
        Node l = returnNodeInBinaryTree(current.left, key);
        Node r = returnNodeInBinaryTree(current.right, key);
        if (r != null) return r;
        if (l != null) return l;
        return null;
    }

    public int findLCA(int n1, int n2) {
        return findLCA(root, n1, n2).data;
    }

    private Node findLCA(Node node, int n1, int n2) {
        if (node == null) return null;
        if (node.data > n1 && node.data > n2) return findLCA(node.left, n1, n2);
        if (node.data < n1 && node.data < n2) return findLCA(node.right, n1, n2);
        return node;
    }

    public int Kthsmallest(Node root, int k) { // not very efficient solution
        if (k > size()) return Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();
        InOrderToArray(root, list);
        return list.get(k - 1);// get the k-est lower element
    }

    private void InOrderToArray(Node root, List<Integer> list) {
        //like printing In-order but placing each element in growth order intot the list
        if (root == null) return;
        //In-order adding
        InOrderToArray(root.left, list);
        list.add(root.data);
        InOrderToArray(root.right, list);
    }

    public String isLeaf(int data) {
        Node current = root;
        while (current != null) {
            if (data == current.data) break;
            else if (data < current.data) current = current.left;
            else current = current.right;
        }
        if (current == null) return "not a vertex";
        if (current.right == null || current.left == null) return "it is not a leaf";
        else return "leaf";
    }

    public static int sumOfRightChild(BST tree) {
        Node curr = tree.root;
        return sumOfRight(curr);
    }

    private static int sumOfRight(Node curr) {
        if (curr == null) {
            return 0;
        } else if (curr.right == null) {
            return sumOfRight(curr.left) + 0;
        } else {
            return curr.right.data + sumOfRight(curr.right) + sumOfRight(curr.left);

        }
    }

    public static int deepestLeavesSum(TreeNode root) {
        return deepestLeavesSum(root, findDeepest(root), 0);
    }

    private static int findDeepest(TreeNode root) {
        if (root == null) return 0;
        int left = findDeepest(root.left);
        int right = findDeepest(root.right);
        return Math.max(left, right) + 1;

    }

    private static int deepestLeavesSum(TreeNode root, int maxlevel, int level) {
        if (root == null) return 0;
        if (level == maxlevel) return root.val;
        else {
            return deepestLeavesSum(root.left, maxlevel, ++level) + deepestLeavesSum(root.right, maxlevel, ++level);
        }
    }

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {

        return Inorder(original, cloned, target);
    }

    private static TreeNode Inorder(TreeNode original, TreeNode cloned, TreeNode target) {
        if (original != null) {
            Inorder(original.left, cloned.left, target);
            if (original == target) return cloned;
            Inorder(original.right, cloned.right, target);
        }
        return Inorder(original.right, cloned.right, target);
    }

    public int sumEvenGrandparent(TreeNode root) {
        return sumEvenGrandparent(root,null,null,0);
    }
    private int sumEvenGrandparent(TreeNode curr , TreeNode GP , TreeNode P ,int sum ){
        if (curr==null) return 0;
        if (GP!=null&& GP.val%2==0)return curr.val+ sumEvenGrandparent(curr.left,P,curr,sum)+sumEvenGrandparent(curr.right,P,curr,sum);
        else return sumEvenGrandparent(curr.left,P,curr,sum)+sumEvenGrandparent(curr.right,P,curr,sum);
    }
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root==null) return 0;
        else if (root.val>high) return rangeSumBST(root.left,low,high);
        else if (root.val<low) return rangeSumBST(root.right,low,high);
        else return root.val+
                rangeSumBST(root.left, low, high)+rangeSumBST(root.right,low,high);
    }
    public TreeNode bstToGst(TreeNode root) {
        int sumOfNode = sumOfNodes(root);
     return bstToGst( root, sumOfNode);
    }
private TreeNode bstToGst(TreeNode root , int sum) {
    if (root != null) {
         bstToGst(root.left, sum);
        root.val += sum;
        bstToGst(root.right, sum - root.val);
    }
    return root;
    }



private int sumOfNodes(TreeNode root){
    if (root==null)return 0;
    else return root.val+sumOfNodes(root.left)+sumOfNodes(root.right);
    }

public static void HasLeaf_Child(TreeNode root ){
         HasLeaf_Child(root,0);
}
private static  void HasLeaf_Child(TreeNode root , int n){
        if (root!=null){
            if (n==-1) System.out.println(root);
            HasLeaf_Child(root.left);
            HasLeaf_Child(root.right);
            n=-1;
        }
}
}
