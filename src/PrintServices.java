import java.util.LinkedList;
import java.util.Queue;

public class PrintServices {
    public static void PrintByLevels(AbstractBST tree){
        // Base case
        if (tree.getRoot()==null) return;
        //Step case
        Queue <Node> q = new LinkedList<>();//new queue
        q.add(tree.getRoot());//adding the root

        while (!q.isEmpty()){
            int numberOfNodesAtCurrentLevel = q.size();
            while (numberOfNodesAtCurrentLevel>0){//as long as there  elements
               Node top =  q.poll();//get out the top element
                 //print it
                System.out.print(top.data+ " ");
                if (top.left!=null)q.add(top.left);//if it has leftchild add it to the queue
                if (top.right!=null)q.add(top.right);//if it has rightchild add it to the queue

                numberOfNodesAtCurrentLevel--;
            }
            System.out.println();
        }

    }
        }