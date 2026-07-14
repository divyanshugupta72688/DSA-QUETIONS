import java.util.*;
class Asteroids{
    static int[] Collosions(int[]nums){
         Stack<Integer>stack = new Stack<>();
        for(int i = 0;i<nums.length;i++){
           if (stack.isEmpty() || nums[i]>0) {
             stack.push(nums[i]);
           }else{
            while (!stack.isEmpty()) {
                int top = stack.peek();
                if (top<0) {
                    stack.push(nums[i]);
                    break;
                }
                int modvalue = Math.abs(nums[i]);
                if (modvalue==top) {
                    stack.pop();
                    break;
                }else if (top>modvalue) {
                    break;
                }else{
                    stack.pop();
                    if (stack.isEmpty()) {
                        stack.push(nums[i]);
                        break;
                    }
                }
            }
           }
        }
        int len = stack.size();
        int[] ans = new int[stack.size()];
        for(int i = len;i<=len;i++){
            ans[i] = stack.pop();
        }
        return ans;
    }
}