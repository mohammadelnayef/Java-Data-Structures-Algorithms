import java.sql.Array;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class MohArrayStack {

    private int[] items = new int[5];
    private int count = 0;

    public void push(int item)
    {
        if(count == items.length){
            throw new StackOverflowError();
        }
        items[count] = item;
        count++;
    }

    public int pop()
    {
        if(count == 0){
            throw new IllegalStateException();
        }
        int currentCount = count;
        count--;
        return items[currentCount];
    }

    public int peek()
    {
        if(count == 0){
            throw new IllegalStateException();
        }
        return items[count-1];
    }

    public boolean isEmpty()
    {
        return count == 0;
    }

    @Override
    public String toString()
    {
        var content = Arrays.copyOfRange(items,0, count);
        return Arrays.toString(content);
    }
}

