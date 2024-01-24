import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        var mohArrayStack = new MohArrayStack();
        mohArrayStack.push(1);
        mohArrayStack.push(2);
        mohArrayStack.push(3);
        mohArrayStack.push(4);
        var result = mohArrayStack.peek();
        System.out.println(result);
        System.out.println(Arrays.toString(mohArrayStack.getItems()));
    }
}

