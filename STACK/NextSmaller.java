import java.util.Stack;

class NextSmaller{
   public static int[] Smaller(int[]nums){
    int n = nums.length;
    Stack<Integer>stack = new Stack<>();
    int[] res = new int[n];
    for(int i = n-1;i>=0;i--){
        while (!stack.isEmpty() && stack.peek()>=nums[i]) {
            stack.pop();
        }
        if (stack.isEmpty()) {
            res[i] = -1;
        }else{
            res[i]  = stack.peek();
        }
        stack.push(nums[i]);
    }
    return res;
    }
}