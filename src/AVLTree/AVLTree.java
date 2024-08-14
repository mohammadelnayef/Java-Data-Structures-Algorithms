package AVLTree;

public class AVLTree {

    private AVLNode root;

    private class AVLNode {
        private int height;
        private int value;
        private AVLNode leftChild;
        private AVLNode rightChild;

        public AVLNode(int value) {
            this.value = value;
        }

        @Override
        public String toString()
        {
            return "AVLNode: " + value;
        }
    }

    public void insert(int number){
        root = insert(root, number);
    }

    private AVLNode insert(AVLNode root, int number)
    {
        if( root == null){
            return new AVLNode(number);
        }
        if(number < root.value) {
            root.leftChild = insert(root.leftChild, number);
        }
        else{
            root.rightChild = insert(root.rightChild, number);
        }

        root.height = Math.max(height(root.leftChild), height(root.rightChild)) + 1;

        return root;
    }

    private int height(AVLNode node)
    {
        if(node == null){
            return -1;
        }
        return node.height;
    }
}
