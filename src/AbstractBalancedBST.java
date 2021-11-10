public interface AbstractBalancedBST extends AbstractBST {
    //Balancing

    public void update(Node node);// update the tree
    /**
     * Description getting node as a root which can be unbalanced
     * @param node is the root
     *return balanced true
     * @return
     */
    public Node balance(Node node);

}
