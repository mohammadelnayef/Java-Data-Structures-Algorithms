package Heap;

public class PriorityQueueWithHeap {

    //Priority Queue implemented with Heaps has O(log n) time complexity for insertion and deletion
    // Array P. Queue has O(n) for insertion and 0(1) for deletion.
    // So P. Queue implemented via Heaps is used when a lot of insertions are needed.

    private Heap heap = new Heap();

    public void enqueue(int item)
    {
        heap.insert(item);
    }

    public int dequeue(int item)
    {
        return heap.remove();
    }

    public boolean isEmpty()
    {
        return heap.isEmpty();
    }
}
