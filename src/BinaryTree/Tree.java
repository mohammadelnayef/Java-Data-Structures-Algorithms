package BinaryTree;

import java.util.ArrayList;

public class Tree {

    // Node class to be used in the Binary Search Tree
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

    // Root of the BST.
    private Node root;

    // Function that inserts Node with a value in the BST.
    public void insert(int value)
    {
        // Since we will always insert a node, we can declare it at the beginning of the function.
        var newNode = new Node(value);

        // If the root is empty, it means the BST is empty, and we can add our node to the root.
        if(root == null){
            root = newNode;
            return;
        }

        // If the root is not empty, we will traverse the BST until we find the right parent for our Node.
        // We will start from the top, by creating the current Node and setting it as the root.
        var current = root;

        //We create an infinite loop and break out of it when we find the desired parent Node.
        while (true){
            //If the Node we are about to add value is smaller than the current Node's value, we go to the left side.
            if(value < current.value){
                // If on the left side of the current Node there is no child Node, we found our parent Node.
                if(current.leftChild == null){
                    current.leftChild = newNode;
                    break;
                }
                // If the left side of the current Node is occupied by another Node, we set that Node to be the current Node
                // No further checks will validate, so we will start from the top of the while loop again.
                current = current.leftChild;
            }
            //If the Node we are about to add value is bigger than the current Node's value, we go to the right side.
            if(value > current.value){
                // If on the right side of the current Node there is no child Node, we found our parent Node.
                if(current.rightChild == null){
                    current.rightChild = newNode;
                    break;
                }
                //If the right side of the current Node is occupied by another Node, we set that Node to be the current Node
                // Same as above, at this point we will go to the beginning of the while loop and start all over again.
                current = current.rightChild;
            }
        }
    }

    // Function that checks if a value is present in the BST.
    public boolean find(int value)
    {
        // We start the search from the root.
        var current = root;

        // We will now loop through the Nodes while the current Node is not null.
        while(current != null){
            // If the value we are looking for is smaller than the current Node's value, we go to the left side of the BST.
            if(value < current.value){
                current = current.leftChild;
            }
            // If the value we are looking for is greater than the current Node's value, we go to the right side of the BST.
            else if (value > current.value) {
                current = current.rightChild;
            }
            else {
                // If the current Node's value is neither smaller nor bigger, it means the value is equal.
                // So the BST contains the searched value.
                return true;
            }
        }

        // If we got to this point, it means that we could not find the value in the BST.
        return false;
    }

    public void traversePreOrder()
    {
        traversePreOrder(root);
    }

    private void traversePreOrder(Node root)
    {
        if(root == null){
            return;
        }
        // visit root, print the value
        System.out.println(root.value);
        // then visit left
        traversePreOrder(root.leftChild);
        // then visit right
        traversePreOrder(root.rightChild);
    }

    public void traverseInOrder()
    {
        traverseInOrder(root);
    }

    private void traverseInOrder(Node root)
    {
        if(root == null){
            return;
        }

        // left
        traverseInOrder(root.leftChild);
        // root
        System.out.println(root.value);
        // right
        traverseInOrder(root.rightChild);
    }

    public void traversePostOrder()
    {
        traversePostOrder(root);
    }

    private void traversePostOrder(Node root)
    {
        if(root == null){
            return;
        }

        //left
        traversePostOrder(root.leftChild);
        //right
        traversePostOrder(root.rightChild);
        //root
        System.out.println(root.value);
    }

    public int height()
    {
        return height(root);
    }

    private int height(Node root)
    {
        if(root == null){
            return -1;
        }
        if(isLeaf(root)){
            return 0;
        }
        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    private boolean isLeaf(Node node)
    {
        return node.leftChild == null && node.rightChild == null;
    }

    public int min()
    {
        return min(root);
    }

    private int min(Node root)
    {
        if(isLeaf(root)){
            return root.value;
        }

        var left = min(root.leftChild);
        var right = min(root.rightChild);

        return Math.min(root.value, Math.min(left,right));
    }

    public boolean equals(Tree other)
    {
        return equals(root, other.root);
    }

    private boolean equals(Node first, Node second)
    {
        //If both nodes are equal, we exit and return true.
        if(first == null && second == null){
            return true;
        }
        // If both nodes are not null, we continue with the traversal
        if(first != null && second != null){
            // preorder, we first check root, then left , then right.
            return first.value == second.value
                    && equals(first.leftChild, second.leftChild)
                    && equals(first.rightChild, second.rightChild);
        }

        //One node is null the other is not, tree is not equal
        return false;
    }

    public boolean isBinarySearchTree()
    {
        //Since we start from the root, there is no constraint, so we can have any min and max.
        return isBinarySearchTree(root,Integer.MIN_VALUE, Integer.MAX_VALUE );
    }

    private boolean isBinarySearchTree(Node root, int minValue, int maxValue)
    {
        if(root == null){
            return true;
        }

        if(root.value < minValue || root.value > maxValue){
            return false;
        }

        return
            isBinarySearchTree(root.leftChild, minValue, root.value -1)
            && isBinarySearchTree(root.rightChild, root.value + 1, maxValue);
    }

    public ArrayList<Integer> getNodesAtDistance(int distance)
    {
        var list = new ArrayList<Integer>();
        getNodesAtDistance(root,distance,list);
        return list;
    }

    private void getNodesAtDistance(Node root, int distance, ArrayList<Integer> list)
    {
        if(root == null){
            return;
        }

        if(distance == 0){
            list.add(root.value);
            return;
        }

        getNodesAtDistance(root.leftChild, distance -1,list);
        getNodesAtDistance(root.rightChild, distance -1, list);
    }

    public void traverseLevelOrder()
    {
        for(var i = 0; i <= height(); i++){
            for (var value :  getNodesAtDistance(i)){
                System.out.println(value);
            }
        }
    }
}
