package Heap;

public class Heap {
    private int[] items = new int[10];
    private int size;

    public void insert(int value)
    {
        if(isFull()){
            throw new IllegalStateException();
        }

        items[size] = value;
        size++;

        //If the new item is > parent, we should bubble up this item until it's in the right position.
        bubbleUp();
    }

    public boolean isFull()
    {
        return size == items.length;
    }

    private void bubbleUp()
    {
        var index = size -1;

        //The loop continues to execute as long as the current index is greater than 0 (meaning it's not at the root of the heap)
        // and the current item is greater than its parent item.
        while(index > 0 && items[index] > items[parent(index)]){

            //we swap the current item with its parent. This helps "bubble up" the larger item closer to the top of the heap.
            swap(index, parent(index));

            //The purpose of the index update is to move the current focus up the heap.
            // By doing this, the algorithm continues to check if the new position of the element (after the swap) still violates the heap property.
            index = parent(index);
        }
    }

    private int parent(int index)
    {
        return (index -1) / 2;
    }

    private void swap(int first, int second)
    {
        var tmp = items[first];
        items[first] = items[second];
        items[second] = tmp;
    }

    public int remove()
    {
        if(isEmpty()){
            throw new IllegalStateException();
        }
        //Last item in the heap replaces the root
        var root = items[0];
        items[0] = items[size-1];
        size--;

        //If now the item in the root is smaller thant it's children, we need to bubble it down.
        //we repeat this until the item is in the right position.
        bubbleDown();
        return root;
    }

    private void bubbleDown()
    {
        var index = 0;

        while(index <= size && !isValidParent(index)){
            var largerChildIndex = getLargerChildIndex(index);

            swap(index, largerChildIndex);
            index = largerChildIndex;
        }
    }

    private boolean hasLeftChild(int index)
    {
        return leftChildIndex(index) <= size;
    }

    private boolean hasRightChild(int index)
    {
        return rightChildIndex(index) <= size;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    private int getLargerChildIndex(int index)
    {
        if(!hasLeftChild(index)){
            return index;
        }

        if(!hasRightChild(index)){
            return leftChildIndex(index);
        }

       return (leftChild(index) > rightChild(index)) ? leftChildIndex(index): rightChildIndex(index);
    }

    private boolean isValidParent(int index)
    {
        if(!hasLeftChild(index)){
            return true;
        }

        var isValid = items[index] >= leftChild(index);
        if(hasRightChild(index)){
            isValid = isValid & items[index] >= rightChild(index);
        }

        return isValid;
    }

    private int leftChild(int index)
    {
        return items[leftChildIndex(index)];
    }

    private int rightChild(int index)
    {
        return items[rightChildIndex(index)];
    }

    private int leftChildIndex(int index)
    {
        return index * 2 + 1;
    }

    private int rightChildIndex(int index)
    {
        return index * 2 + 2;
    }
}
