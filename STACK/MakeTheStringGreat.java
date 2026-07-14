import java.util.*;
public class MakeTheStringGreat {
    static String Great(String s){
        int n = s.length();
        Stack<Character>stack = new Stack<>();
        for(int i = 0;i<n;i++){
            char ch = s.charAt(i);
            if (!stack.isEmpty() && Math.abs(stack.peek()-ch)==32) {
                stack.pop();
            }else{
                stack.push(ch);
            }
        }
        StringBuilder ans = new StringBuilder();
        for(char ch : stack){
            ans.append(ch);
        }
        return ans.toString();
    }
}
