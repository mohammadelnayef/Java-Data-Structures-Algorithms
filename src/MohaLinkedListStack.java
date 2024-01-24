
public class MohaLinkedListStack {

    private MohaLinkedList linkedList = new MohaLinkedList();
    private int numberOfItems = 0;

    // push
    public void push(int item)
    {
        linkedList.addLast(item);
        numberOfItems++;
    }

    // pop
    public int pop()
    {
        if(numberOfItems == 0){
            throw new IllegalStateException();
        }
        var value = linkedList.getTail();
        linkedList.removeLast();

        return value;
    }

    // peek
    public int peek()
    {
        if(numberOfItems == 0){
            throw new IllegalStateException();
        }
        return linkedList.getTail();
    }

    // isEmpty
    public boolean isEmpty()
    {
        return linkedList.size() == 0;
    }

}
