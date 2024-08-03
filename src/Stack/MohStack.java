package Stack;

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

    public boolean isBalancedExpression(String input)
    {
        //We create a stack
        Stack<Character> openingTags = new Stack<>();

        // Then we loop trough each character of the input String
        for(char character : input.toCharArray()){

            //If the current character in the loop is an opening tag, we push it into the stack.
            if(character == '(' || character == '[' || character == '<' || character == '{'){
                openingTags.push(character);
            }

            //If the current character in the loop is a closing tag, we do some checks:
            if(character == ')' || character == ']' || character == '>' || character == '}'){

                // We first check if the stack contains an opening bracket, if not, it means the expression is not balanced,
                // so we exit with the result set to false.
                if(openingTags.empty()){
                    return false;
                }

                // If the stack is not empty, we pop the last element from the top of the stack, and we compare it with the
                // current character, we do this in order to check that the current tag has its corresponding closing tag
                var top = openingTags.pop();

                if(
                    (character == ')' && top != '(' ) ||
                    (character == ']' && top != '[' ) ||
                    (character == '>' && top != '<' ) ||
                    (character == '}' && top != '{' )
                ){
                    // In case any of these checks is truthy, it means that the opening bracket doesn't have the correct closing bracket
                    // So we exit the function and return false.
                    return false;
                }

            }
        }

        // Lastly, we return the result of the Stack is empty method. If the stack is empty, the expression is balanced.
        return openingTags.empty();
    }

}
