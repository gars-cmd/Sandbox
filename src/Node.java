public class Node {
        Node right;
        Node left;
        public int data;
        public int BF;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
            this.BF = 0;
        }
    }

