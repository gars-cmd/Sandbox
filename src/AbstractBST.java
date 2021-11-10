public interface AbstractBST {

    public int min();
    public int max();
    public boolean contains(int key);
    public int height();
    public void preOrder();
    public void inOrder();
    public void postOrder();
    public void add(int value);
    public void delete(int key);
    public int size();
    public Node getRoot();



}
