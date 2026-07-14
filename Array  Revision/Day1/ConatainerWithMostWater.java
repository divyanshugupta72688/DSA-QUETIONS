public class ConatainerWithMostWater {
  
    public int maxArea(int[] height) {
         int n= height.length;
        int left = 0;
        int right = n-1;
        int calarea = 0;
        while(left<right){
            int h = Math.min(height[left], height[right]);
            int width = right- left;
            int area  = h*width;
         calarea = Math.max(calarea, area);
         if (height[left]<=height[right]) {
            left++;
         }
         else{
            right--;
         }
        }
        return calarea;
    }

}
