import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        var mohaList = new MohaLinkedList();
        mohaList.addLast(10);
        mohaList.addLast(20);
        mohaList.addLast(30);
        mohaList.addLast(40);
        mohaList.addLast(50);
        mohaList.addLast(60);

        System.out.println(mohaList.getKthFromTheEnd(4));

    }
}

