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

        // Check Node balance
        if(isLeftHeavy(root)){
            System.out.println(root.value + " is left heavy");
        }
        if(isRightHeavy(root)){
            System.out.println(root.value + " is right heavy");
        }

        return root;
    }

    private int height(AVLNode node)
    {
        if(node == null){
            return -1;
        }
        return node.height;
    }

    private boolean isLeftHeavy(AVLNode node)
    {
        return balanceFactor(node) > 1;
    }

    private boolean isRightHeavy(AVLNode node)
    {
        return balanceFactor(node) < -1;
    }

    private int balanceFactor(AVLNode node)
    {
        return (node == null) ? 0 : height(node.leftChild) - height(node.rightChild);
    }

}
