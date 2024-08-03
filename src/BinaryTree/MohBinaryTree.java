package BinaryTree;

public class MohBinaryTree {

    private Node root;
    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }

        public Node getRightChild() {
            return rightChild;
        }

        public void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }

    }

    // When inserting a value, we should find where in the tree we should insert that value
    public void insert(int value)
    {
        if(root == null){
            root = new Node(value);
        }

        var current = root;

        while(current.getValue() > value || current.getValue() < value){

            if(current.getValue() > value){
                if(current.leftChild == null){
                    current.leftChild = new Node(value);
                    return;
                }
                current = current.leftChild;
            }

            if(current.getValue() < value){
                if(current.rightChild == null){
                    current.rightChild = new Node(value);
                    return;
                }
                current = current.rightChild;
            }
        }
    }

    public boolean find(int value)
    {
        if(root == null){
            return false;
        }

        var current = root;

        if(current.getValue() == value){
            return true;
        }

        while(current.getValue() > value || current.getValue() < value){

            if(current.getValue() > value){
                if(current.leftChild == null){
                    return false;
                }
                current = current.leftChild;
            }

            if(current.getValue() < value){
                if(current.rightChild == null){
                    return false;
                }
                current = current.rightChild;
            }
        }

        return true;
    }

}
