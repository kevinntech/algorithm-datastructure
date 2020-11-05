package algorithm.basic_ps.stack_queue;

import java.util.*;

public class ValidParentheses {

    public static void main(String[] args) {
        String exp="{()}";
        System.out.println(isValid(exp));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char topElement = ' ';

        for(char bracket : s.toCharArray()){
            if(bracket == ')'){
                topElement = stack.empty() ? ' ' : stack.pop();

                if(topElement != '(')
                    return false;
            }else if(bracket == ']'){
                topElement = stack.empty() ? ' ' : stack.pop();

                if(topElement != '[')
                    return false;
            }else if(bracket == '}'){
                topElement = stack.empty() ? ' ' : stack.pop();

                if(topElement != '{')
                    return false;
            }else{
                stack.push(bracket);
            }
        }

        return stack.empty();
    }

}
