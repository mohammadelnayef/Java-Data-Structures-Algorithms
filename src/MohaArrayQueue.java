import java.util.Arrays;

public class MohaArrayQueue {

    private int[] items;
    private int front = 0;
    private int rear = 0;

    public MohaArrayQueue()
    {
        items = new int[5];
    }

    // enqueue
    public void enqueue(int item)
    {
        items[front] = item;
        front++;
        rear++;
    }
    // dequeue
    public void dequeue()
    {

    }

    // peek
    public int peek()
    {
        return 0;
    }

    // isEmpty
    public boolean isEmpty()
    {
        return true;
    }

    // isFull
    public boolean isFull()
    {
        return true;
    }

    public void print()
    {
        System.out.println(Arrays.toString(items));
    }
}
