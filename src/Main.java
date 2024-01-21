import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        var mohStack = new MohStack();
        var result = mohStack.reverseString("sony");
        System.out.println(result);

//        System.out.println(stack);
//
//        var top = stack.pop();
//        System.out.println(top);
//
//        System.out.println(stack);
    }
}

