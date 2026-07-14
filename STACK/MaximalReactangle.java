import java.util.*;
 class MaximalReactangle {
    // make a histogram

        public int Area(char[][] matrix){
            int n = matrix.length;// row ki length
            int m = matrix[0].length;// column ki length
            int[] height = new int[m];// kyuki mera histogram coln se banega
            int maxarea  = 0;
            //BUILD HISTOGRAM
            for(int i = 0;i<n;i++){
                for(int j = 0;j<m;j++){
                    if (matrix[i][j]=='1') {
                        height[j]++;
                    }else{
                        height[j] = 0;
                    }
                }
                 maxarea = Math.max(maxarea, largesthistogram(height));
            }
            return maxarea;
        }
        private  int largesthistogram(int[] height){
            int area = 0;
            int n = height.length;
            Stack<Integer>stack = new Stack<>();
            int [] nextsmaller = new int[n];
            int[] prevsmaller = new int[n];

            // next smaller

            for(int i = n-1;i>=0;i--){
                while (!stack.isEmpty()&& height[stack.peek()]>=height[i]) {
                    stack.pop();
                }if (stack.empty()) {
                    nextsmaller[i] = n;
                }else{
                    nextsmaller[i] = stack.peek();
                }
                stack.push(i);
            }
            stack.clear();

            // PREVIOUS SMALLER

            for(int i = 0;i<n;i++){
                while (!stack.isEmpty() && height[stack.peek()]>=height[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    prevsmaller[i] = -1;
                }else{
                    prevsmaller[i] = stack.peek();
                }
                stack.push(i);
            }
            stack.clear();

            // CALCULATION FOR AREA  

            for(int i = 0;i<n;i++){
                int h = height[i];
                int width = nextsmaller[i] - prevsmaller[i]-1;
                int calarea = h*width;
                area = Math.max(area, calarea);
            }
            return area;
        }
}
