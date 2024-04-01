import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        MohPriorityQueueArray pqueue = new MohPriorityQueueArray();
        pqueue.add(10);
        pqueue.add(5);
        pqueue.add(20);
        pqueue.add(7);

        System.out.println(pqueue);

        while(!pqueue.isEmpty()){
            System.out.println(pqueue.remove());
        }

    }
}

