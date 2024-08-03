package Queue;

import java.util.Arrays;

public class MohaArrayQueue {

    private int[] items;
    private int front = 0;
    private int rear = 0;

    public MohaArrayQueue(int capacity)
    {
        items = new int[capacity];
    }

    // enqueue
    public void enqueue(int item)
    {
        if(items.length == rear){
            throw new IllegalStateException();
        }
        if(front == 0 && rear == 0){
            items[front] = item;
            rear++;
            return;
        }

        items[rear] = item;
        rear++;
    }
    // dequeue
    public void dequeue()
    {
        if(front == rear){
            throw new IllegalStateException();
        }
        front++;
    }

    // peek
    public int peek()
    {
        return items[front];
    }

    // isEmpty
    public boolean isEmpty()
    {
        return front == rear ;
    }

    // isFull
    public boolean isFull()
    {
        return rear == items.length;
    }

    public void print()
    {
        var tmpArray = Arrays.copyOfRange(items, front, rear);
        System.out.println(Arrays.toString(tmpArray));
    }
}
