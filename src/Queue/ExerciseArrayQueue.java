package Queue;

import java.util.Arrays;

public class ExerciseArrayQueue
{
    private int[] items;
    private int rear;
    private int front;
    private int count;

    public ExerciseArrayQueue(int capacity)
    {
        items = new int[capacity];
    }

    // enqueue
    public void enqueue(int item)
    {
        if(count == items.length){
            throw new IllegalStateException();
        }
        items[rear] = item;
        rear = (rear + 1) % items.length;
        count++;
    }
    // dequeue
    public int dequeue()
    {
        var item = items[front];
        items[front] = 0;
        front = (front + 1) % items.length;
        count--;
        return item;
    }

    @Override
    public String toString()
    {
        return Arrays.toString(items);
    }

}
