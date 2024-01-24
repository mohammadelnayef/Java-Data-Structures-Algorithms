import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        var mohaLinkedListStack = new MohaLinkedListStack();
        mohaLinkedListStack.push(10);
        mohaLinkedListStack.push(20);
        mohaLinkedListStack.push(30);
        var result = mohaLinkedListStack.peek();
        System.out.println(mohaLinkedListStack.isEmpty());

    }
}

