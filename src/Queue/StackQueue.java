package Queue;

import java.util.Stack;

public class StackQueue {
    private Stack<Integer> items;
    private int count;

    public StackQueue()
    {
        items = new Stack<>();
    }

    public void enqueue(int item)
    {
        items.push(item);
        count++;
    }

    public int dequeue()
    {
        Stack<Integer> tmpStack = new Stack<>();

        while(!items.empty()){
            tmpStack.push(items.pop());
        }

        var returnItem = tmpStack.pop();

        while(!tmpStack.empty()){
            items.push(tmpStack.pop());
        }

        System.out.println(items.toString());

        count--;
        return returnItem;
    }


}
