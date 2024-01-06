import java.sql.SQLOutput;
import java.util.Arrays;

public class MohArray {

    private int[] items;
    private int count;

    // create
    public MohArray(int length)
    {
        items = new int[length];
    }

    // print
    public void print()
    {
        for(int i = 0; i < count; i++){
            System.out.println(items[i]);
        }
    }

    // Insert
    public void insert(int number)
    {
        if(items.length == count){
            // Create a new array (twice the size)
            int[] tmpArray = new int[count * 2];

            // Copy all the existing items to the new array
            for(int i = 0; i < count; i++ ){
                tmpArray[i] = items[i];
            }

            // Set the "items" array to be the new tmpArray
            items = tmpArray;
        }
        items[count] = number;
        count++;
    }

    // remove at
    public void removeAt(int index)
    {
        if(index < 0 || index >= count){
            throw new IllegalArgumentException();
        }

        // Shift the items to the left to fill the hole
        for( int i = index; i < count; i++){

            if(i < count -1 ){
                items[i] = items[i + 1];
            }

        }

        // Since count represents the total number of items in the array,
        // we decrement it to make the last item inaccessible.
        count--;
    }

    // indexOf
    public int indexOf(int number)
    {
        // Loop through the items to find the number
        for(int i = 0; i < count; i++) {

            if(items[i] == number) {
                // If found, return the index of the number
                return i;
            }
        }

        // If not found, return -1
        return -1;
    }
}
