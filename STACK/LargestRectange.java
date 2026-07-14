import java.util.Stack;

class LargestRectange {
    static int[] nextSmaller(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] <= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                res[i] = n;
            } else {
                res[i] = stack.peek();
            }
            stack.push(i);
        }
        return res;
    }

    static int[] prevsmaller(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] <= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = stack.peek();
            }
            stack.push(i);
        }
        return res;
    }

    static int InHistogram(int[] heights) {
        int n = heights.length;
        int max = Integer.MIN_VALUE;
        int[] ns = nextSmaller(heights);
        int[] ps = prevsmaller(heights);
        for (int i = 0; i < n; i++) {
            int h = heights[i];
            int width = ns[i] - ps[i] - 1;
            int area = h * width;
            max = Math.max(max, area);
        }
        return max;
    }
}