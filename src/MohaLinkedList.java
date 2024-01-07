import java.util.NoSuchElementException;

public class MohaLinkedList {

    private class Node {
        private int value;
        private Node next;

        public Node(int value)
        {
            this.value = value;
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

}
