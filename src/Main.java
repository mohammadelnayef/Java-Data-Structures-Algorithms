import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        var mohStack = new MohStack();
        var result = mohStack.isBalancedExpression("{hello world}");
        System.out.println(result);

    }
}

