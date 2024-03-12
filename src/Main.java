import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        var mohQueue = new MohaArrayQueue(6);
        mohQueue.enqueue(10);
        mohQueue.enqueue(20);
        mohQueue.enqueue(30);
        mohQueue.enqueue(40);
        mohQueue.enqueue(50);
        mohQueue.enqueue(60);
        System.out.println("Is Empty: " + mohQueue.isEmpty());
        System.out.println("Is Full: " + mohQueue.isFull());
        mohQueue.print();
    }
}

