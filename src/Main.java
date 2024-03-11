import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        var mohArrayQueue = new MohaArrayQueue();
        mohArrayQueue.enqueue(10);
        mohArrayQueue.enqueue(20);
        mohArrayQueue.enqueue(30);
        mohArrayQueue.enqueue(40);
        mohArrayQueue.enqueue(50);
        mohArrayQueue.print();

//        var queue = new ArrayDeque<Integer>();
//        queue.add(10);
//        queue.add(20);
//        queue.add(30);
//        reverse(queue);
//        System.out.println(queue);
    }

//    public static void reverse(Queue<Integer> queue)
//    {
//        var tmp = new Stack<Integer>();
//
//        while(!queue.isEmpty()){
//            var item = queue.remove();
//            tmp.push(item);
//        }
//
//        while(!tmp.isEmpty()){
//            var item = tmp.pop();
//            queue.add(item);
//        }
//    }
}

