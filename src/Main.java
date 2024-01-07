import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        var mohaList = new MohaLinkedList();
        mohaList.addLast(10);
        mohaList.addLast(20);
        mohaList.addLast(30);

        var mohListArray = mohaList.toArray();
        System.out.println(Arrays.toString(mohListArray));
        
    }
}

