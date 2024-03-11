import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        MohArrayStack stack = new MohArrayStack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack.peek());
    }
}

