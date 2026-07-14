import java.util.*;
class LongestValidPalindrome{
    public int valid(String s){
        Stack<Integer>stack = new Stack<>();
        // remove valid parenthesis and store invalid paranthesis index.
        remove(stack,s);
        // agar string empty ho gyi to ans string ki length hoga
        if (stack.isEmpty()) {
            return s.length();
        }
        // stack me index descending order me honge  isliye hame use sotred order me lana hoga
        ArrayList<Integer>res = new ArrayList<>();
        reverseStack(stack,res);
        
        // boundary set krenge agr invalid index hame 0 index ya last index pe milega to..

        res.add(0,-1);
        res.add(s.length());

        // maximum area calculate karenge 

        int max = 0;
        for(int i = 1;i<res.size();i++){
            max = Math.max(max, res.get(i)-res.get(i-1)-1);
        }
        return max;
    }

    public void remove(Stack<Integer>stack,String s){
        for(int i = 0;i<s.length();i++){
        char ch = s.charAt(i);
        if (ch=='(') {
            stack.push(i);
        }else{
                if (stack.isEmpty() || s.charAt(stack.peek())==')') {
                    stack.push(i);
                }else{
                    stack.pop();
                }
        }
        }
    }
    public void reverseStack(Stack<Integer>stack,ArrayList<Integer>res){
        while (!stack.isEmpty()) {
            res.add(0,stack.pop());
        }
    }
}