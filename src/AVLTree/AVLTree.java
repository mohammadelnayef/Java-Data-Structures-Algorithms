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

        setHeight(root);

        return balance(root);
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

    private AVLNode balance(AVLNode root)
    {
        if(isLeftHeavy(root)){
            if(balanceFactor(root.leftChild) < 0){
                root.leftChild = leftRotate(root.leftChild);
            }
            return rightRotate(root);
        }
        if(isRightHeavy(root)){
            if(balanceFactor(root.rightChild) > 0){
                root.rightChild = rightRotate(root.rightChild);
            }
            return leftRotate(root);
        }
        return root;
    }

    public AVLNode rightRotate(AVLNode root)
    {
        var newRoot = root.leftChild;
        root.leftChild = newRoot.rightChild;
        newRoot.rightChild = root;

        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }

    public AVLNode leftRotate(AVLNode root)
    {
        var newRoot = root.rightChild;
        root.rightChild = newRoot.leftChild;
        newRoot.leftChild = root;

        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }

    private void setHeight(AVLNode node)
    {
        node.height = Math.max(height(node.leftChild), height(node.rightChild)) + 1;
    }

}
