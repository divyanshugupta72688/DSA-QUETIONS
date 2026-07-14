import java.util.*;

class NextGreaterElement {
    static ArrayList<Integer> One(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                list.add(-1);
            } else {
                list.add(stack.peek());
            }
            stack.push(nums[i]);
        }
        Collections.reverse(list);
        return list;
    }
}