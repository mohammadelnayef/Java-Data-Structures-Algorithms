import java.sql.Array;
import java.util.NoSuchElementException;

public class MohArrayStack {

    private int[] items;
    private int numberOfItems = 0;

    public MohArrayStack()
    {
        items = new int[1];
    }

    //push
    public void push(int item)
    {
        if(numberOfItems == items.length){
            int[] tmpArray = new int[items.length + 1];

            for(int i = 0; i < items.length; i++){
                tmpArray[i] = items[i];
            }
            tmpArray[items.length] = item;
            items = tmpArray;
        }
        else {
            items[numberOfItems] = item;
        }
        numberOfItems++;
    }

    //pop
    public int pop()
    {
        if(numberOfItems == 0){
            throw new NoSuchElementException();
        }
        int tmp = items[numberOfItems -1];
        int[] tmpArray = new int[items.length -1];

        for(int i = 0; i < items.length -1 ; i++){
            tmpArray[i] = items[i];
        }
        items = tmpArray;
        numberOfItems--;
        return tmp;
    }

    //peek
    public int peek()
    {
        if(numberOfItems == 0){
            throw new NoSuchElementException();
        }
        return items[numberOfItems -1];
    }

    //isEmpty
    public boolean isEmpty()
    {
        return numberOfItems == 0;
    }

    public int[] getItems()
    {
        return items;
    }

}

