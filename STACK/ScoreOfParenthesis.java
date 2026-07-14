import java.util.*;

public class ScoreOfParenthesis {
    static int Score(String s){
        
        int n = s.length();
        Stack<Integer>stack = new Stack<>();
        int score =0;
        for(int i = 0;i<n;i++){
            char ch  = s.charAt(i);
            if (ch=='(') {
                stack.push(score);
                score = 0;
            }else{
                score = stack.pop()+Math.max(score*2, 1);
            }
        }
        return score;
    }
}
