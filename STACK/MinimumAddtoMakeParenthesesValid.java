import java.util.Stack;

public class MinimumAddtoMakeParenthesesValid {
    static int Count(String s){
        int n = s.length();
        Stack<Character>stack = new Stack<>();
        for(int i = 0;i<n;i++){
            char ch = s.charAt(i);
            if (ch=='(') {
                stack.push(ch);
            }else{
                if (!stack.isEmpty() && stack.peek()=='(') {
                    stack.pop();
                }else{
                    stack.push(ch);
                }
            }
        }
        return stack.size();
    }
}
