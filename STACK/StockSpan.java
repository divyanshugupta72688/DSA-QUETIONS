import java.util.ArrayList;
import java.util.Stack;
import java.util.*;
class StockSpan {
    Stack<Integer>stack = new Stack<>();
    ArrayList<Integer>list = new ArrayList<>();
    public StockSpan(){
        stack = new Stack<>();
        list = new ArrayList<>();
    }
    public int Solve(int price){
        while(!stack.isEmpty() && list.get(stack.peek())<=price) {
            stack.pop();
        }
        int ans;
        if (stack.isEmpty()) {
            ans = list.size()+1;
        }else{
            ans = list.size()-stack.peek();
        }
        list.add(price);
        stack.push(list.size()-1);
        return ans;
    }
}
