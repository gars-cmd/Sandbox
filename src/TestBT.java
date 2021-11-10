import com.sun.source.tree.BinaryTree;
import com.sun.source.tree.ExpressionTree;
import com.sun.source.tree.TreeVisitor;

import java.util.TreeMap;

public class TestBT {
    public static void main(String[] args) {
/////////////REGULAR TREE TEST//////////////////////////
   BST tree = new BST();
        tree.add(10);
        tree.add(9);
        tree.add(12);
        tree.add(5);
        tree.add(4);
        tree.add(6);
        tree.add(8);
        tree.add(11);
        tree.add(15);
        tree.add(14);
        tree.add(16);

        System.out.println(NORC(tree));


    }
public static int NORC(BST tree){
        return NORC(tree , tree.getRoot());
}
private static int NORC(BST tree , Node curr){
        if (curr==null)return 0;
        if (curr.right!=null) return NORC(tree,curr.right)+NORC(tree, curr.left)+curr.right.data;
else return NORC(tree, curr.left);
    }
}
