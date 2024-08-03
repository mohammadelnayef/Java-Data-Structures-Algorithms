package LinkedList;

import java.util.NoSuchElementException;

public class MohaLinkedList {

    private class Node {
        private int value;
        private Node next;

        public Node(int value)
        {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    private Node first;
    private Node last;
    private int size;


    //addFirst
    public void addFirst(int item)
    {
        var node = new Node(item);

        if(isEmpty()){
            first = node;
            last = node;
        }
        else {
            node.next = first;
            first = node;
        }

        size++;
    }

    //addLast
    public void addLast(int item)
    {
        var node = new Node(item);

        //If the list is empty, set the new node as both the head and the tail.
        if(isEmpty()){
            first = node;
            last = node;
        }
        else {
            last.next = node;
            last = node;
        }

        size++;
    }

    //removeFirst
    public void removeFirst()
    {
        // If list is empty throw error
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        // If there is only 1 item in the list, remove it from both the Head and Tail.
        else if ( first == last) {
            first = null;
            last = null;
        }
        // If there are multiple items in the list, save the reference of the Head.next,
        // then remove the reference of the Head to the next element (for garbage collection)
        // then set the Head to be the 2nd item in the list (the original Head.next)
        else {
            var newFirstNode = first.next;
            first.next = null;
            first = newFirstNode;
        }

        size--;
    }

    //removeLast
    public void removeLast()
    {
        // If list is empty throw error
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        // If there is only 1 item in the list, remove it from both the Head and Tail.
        else if ( first == last) {
            first = null;
            last = null;
        }
        // If there are multiple items in the list, we should traverse the list and check if the
        // current item.next in the loop is the same as the node that we passed,
        // if it is return it (because it means it is the previous node)
        // then update Tail of the list to the previous node and set the Tail.next to null (for garbage collection).
        else {
            var previousNode = getPreviousNode(last);
            last = previousNode;
            last.next = null;
        }

        size--;
    }

    //contains
    public boolean contains(int item)
    {
        // We reuse the indexOf method, because any index other than -1 means the item exist in the list.
        return indexOf(item) != -1;
    }

    //indexOf
    public int indexOf(int item)
    {
        var currentNode = first;
        int index = 0;

        while(currentNode != null){
            //Check value
            if(currentNode.value == item){
                return index;
            }
            //Update current node to be the next node
            currentNode = currentNode.next;
            index++;
        }
        return -1;

    }

    //size
    public int size()
    {
        return size;
    }

    // reverse
    public void reverse()
    {
        // In order to reverse a linked list, we have to flip the direction of the node connections
        // and then update the Head and Tail of the list once the reversal is completed.

        // Since we begin with the first element in the list, it has no previous node, so we set previousNode to null
        // After that we set the currentNode to be the first node, since this is the Node we will start with.
        // After that we will declare a temp Node variable that will be used to save the current's node next.
        // (We do this because we will lose the reference once we change the direction of the connection [from next to previous])
        Node previousNode = null;
        Node currentNode = first;
        Node tmpNext;

        // We check if the current node is not null, if not, we start traversing the list
        // We first save the current node next node to a temp variable
        // Then we reverse the direction of the connection by setting the currentNode next node to the previous node.
        // Then we set the previous node to be the current node.
        // And finally we set the current node to be the temp variable that we defined above.

        while(currentNode != null){
            tmpNext = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = tmpNext;
        }

        // After we finished reversing the list, we have to switch the head and tail between them.
        Node tmpLast = last;
        last = first;
        first = tmpLast;
    }

    // K th node from the end
    public int getKthFromTheEnd(int kth)
    {
        if(isEmpty()){
            throw new IllegalStateException();
        }

        Node nodeA = first;
        Node nodeB = first;

        for(int i = 0; i < kth -1; i++){
            nodeB = nodeB.next;

            if(nodeB == null){
                throw new IllegalArgumentException();
            }
        }

        while(nodeB != last) {
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }

        return nodeA.value;
    }

    public int[] toArray()
    {
        // Create the initial empty array with the size of the current Linked List.
        int[] array = new int[size];

        // Initialize the variables needed for traversing the list
        var currentNode = first;
        var index = 0;

        // Traverse the list and add each node's value to the array.
        while(currentNode != null){
            array[index] = currentNode.value;
            currentNode = currentNode.next;
            index++;
        }

        // After the traversing is finished return the populated array.
        return array;
    }

    private boolean isEmpty(){
        return first == null;
    }

    private Node getPreviousNode(Node node)
    {
        var currentNode = first;

        while(currentNode != null){

            if(currentNode.next == node)
            {
                return currentNode;
            }

            currentNode = currentNode.next;
        }
        return null;
    }

    public int getHead()
    {
        if(first == null){
           throw new IllegalStateException();
        }
        return first.getValue();
    }

    public int getTail()
    {
        if(last == null){
            throw new IllegalStateException();
        }
        return last.getValue();
    }

}
