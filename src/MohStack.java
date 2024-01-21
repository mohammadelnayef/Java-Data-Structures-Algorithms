import java.util.Stack;
public class MohStack {

    public String reverseString(String input)
    {
        if(input == null){
             throw new IllegalArgumentException();
        }

        // We create a stack
        Stack<Character> stack = new Stack<>();

        // We loop through the characters of the string and push them to the stack
        // Since stacks are last in first out, the first item pushed into the stack will be the last item in the stack.
        for(char character : input.toCharArray()) {
            stack.push(character);
        }

        // In order to optimize the algorithm, we use the StringBuffer for efficient string manipulation.
        StringBuffer reversed = new StringBuffer();

        // We append to the StringBuffer each character at a time, until the Stack is empty.
        while(!stack.empty()){
            reversed.append(stack.pop());
        }

        // After the stack is empty, and we have the complete reversed string in the buffer, we convert it to a String and return it.
        return reversed.toString();
    }
}
