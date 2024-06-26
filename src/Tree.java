public class Tree {

    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString()
        {
            return "Node: " + value;
        }
    }

    private Node root;

    public void insert(int value)
    {
        var newNode = new Node(value);

        if(root == null){
            root = newNode;
            return;
        }

        var current = root;
        while (true){
            if(value < current.value){
                if(current.leftChild == null){
                    current.leftChild = newNode;
                    break;
                }
                current = current.leftChild;
            }
            else{
                if(current.rightChild == null){
                    current.rightChild = newNode;
                    break;
                }
                current = current.rightChild;
            }
        }
    }

    public boolean find(int value)
    {
        var current = root;

        while(current != null){
            if(value < current.value){
                current = current.leftChild;
            }
            else if (value > current.value) {
                current = current.rightChild;
            }
            else {
                return true;
            }
        }
        return false;
    }
}
