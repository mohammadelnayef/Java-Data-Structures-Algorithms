import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        QueueWithTwoStacks queue = new QueueWithTwoStacks();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        var first = queue.dequeue();
        System.out.println(first);
    }
}

