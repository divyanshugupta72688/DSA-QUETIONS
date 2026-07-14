import java.util.*;
class CountTheReversal{
    static int reverse(String s){
        int n = s.length();
        if (n%2!=0) {
            return -1;
        }
        Stack<Character>stack = new Stack<>();
        for(int i =0;i<n;i++){
            char ch = s.charAt(i);
            if (ch=='{') {
                stack.push(ch);
            }else{
                if (stack.isEmpty() || stack.peek()=='}') {
                    stack.push(ch);
                }else{
                    stack.pop();
                }
            }
        }
        int ans = 0;
        int ob = 0;
        int cb = 0;
        while (!stack.isEmpty()) {
            char top = stack.pop();
            if (top=='{') {
                ob++;
            }else{
                cb++;
            }
        }
        ans = (int)(Math.ceil(ob/2.0)+Math.ceil(cb/2.0));
        return ans;
    }
}