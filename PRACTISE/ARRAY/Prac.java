import java.util.*;
public class Prac{
public static void movesZero(int[]arr){
    int left = 0;
    for(int right = 0;right<arr.length;right++){
        if (arr[right]!=0) {
            int temp = arr[right];
            arr[right] = arr[left];
            arr[left] = temp;
            left++;
        }
    }
}

public static int[] Twosum(int[] arr, int target){
    int left = 0;
    int right = arr.length-1;
    while (left<right) {
        int sum = arr[left]+arr[right];

        if (sum==target) {
            return new int[]{left+1,right+1};
        }
        else if(sum>target) {
            right--;
        }else{
            left++;
        }
    }
    return new int[]{-1,-1};
}

public static List<List<Integer>>ThreeSum(int[]arr){
List<List<Integer>>res = new ArrayList<>();
Arrays.sort(arr);
int n = arr.length;
for(int i = 0;i<n-2;i++){
    if (i>0&&arr[i]==arr[i-1]) {
        continue;
    }
    int left = i+1;
    int right = n-1;
    while (left<right) {
        int sum = arr[i]+arr[left]+arr[right];
        if (sum==0) {
            res.add(Arrays.asList(arr[i],arr[left],arr[right]));
            while (left<right&&arr[left]==arr[left+1]) {
                left++;
            }while(left<right&&arr[right]==arr[right-1]){
                right--;
            }
            left++;
            right--;
        }
        else if (sum>0) {
            right--;
        }else{
            left++;
        }
    }
}
return res;
}

public static int Remove(int[]arr){
    int n = arr.length;
    int left = 0;
    int right = 1;
    while (left<right) {
        if (arr[left]==arr[right]) {
            right++;
        }
        else{
            left++;
            arr[left] = arr[right];
            right++;
        }
    }
    return left+1;
}
public static int Pivot(int[]arr){
    int n = arr.length;
    int[]leftsum = new int[n];
    int[]rightsum = new int[n];
    leftsum[0] = arr[0];
    for(int i =1;i<n;i++){
        leftsum[i] = arr[i]+leftsum[i-1];
    }
    rightsum[n-1] = arr[n-1];
    for(int i = n-1;i>=0;i--){
        rightsum[i] = rightsum[i+1]+arr[i];
    }
    for(int i = 0;i<n;i++){
        if (leftsum[i]==rightsum[i]) {
            return i;
        }
    }
    return -1;
}


public static int SubArray(int[]arr){
    int sum = 0;
    int n = arr.length;
    int maxsum = Integer.MIN_VALUE;
    for(int i =0;i<n;i++){
        sum +=arr[i];
        maxsum = Math.max(maxsum, sum);
        if (sum<0) {
            sum = 0;
        }
    }
    return maxsum;
} 

public static int Maxp(int[]arr){
    int maxProduct = arr[0];
    int minpro=  arr[0];
    int ans = arr[0];
    for(int i = 0;i<arr.length;i++){
        if (arr[i]<0) {
            int temp = maxProduct;
            maxProduct = minpro;
            minpro = temp;
        }
        maxProduct = Math.max(arr[i], maxProduct*arr[i]);
        ans = Math.max(ans, maxProduct);
    }
    return ans;
}
public static int[][] Transpose(int[][] arr){
    int totolrow = arr.length;
    int totalcoln = arr[0].length;

    int newtotalrow =  totalcoln;
    int newtotalcoln = totolrow;
    int[][] ans = new int[newtotalrow][newtotalcoln];
    for(int row = 0;row<totolrow;row++){
        for(int coln = 0;coln<totalcoln;coln++){
            ans[coln][row] = arr[row][coln];
        }
    }
    return ans;
}

public static void RotateImage(int[][]matrix){
    int m = matrix.length;
    int n = matrix[0].length;
    for(int i = 0;i<m;i++){
        for(int j= i+1;j<n;j++){
            int temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
        }
    }
    for(int row = 0;row<m;row++){
        int stcoln = 0;
        int endcoln = n-1;
        while (stcoln<=endcoln) {
            int temp = matrix[row][stcoln];
            matrix[row][stcoln] = matrix[row][endcoln];
            matrix[row][endcoln] = temp;
            stcoln++;
            endcoln--;
        }
    }
}
public void Sortcolors(int[] nums){
        int count0 = 0;
        int count1 = 1;
        int count2 = 0;
        for(int i  = 0;i<nums.length;i++){
            if (nums[i]==0) {
                count0++;
            }else if (nums[i]==1) {
                count1++;
            }else{
                count2++;
            }
        }
        int index = 0;
        while (count0>0) {
            nums[index] = 0;
            index++;
            count0--;
        }while (count1>0) {
            nums[index] = 1;
            index++;
            count1--;
        }while (count2>0) {
            nums[index] = 2;
            index++;
            count2--;
        }
    }
    public static int Mostconsecutive(int[]nums){
        int count = 0;
        int maxcount = 0;
        for(int  i =0;i<nums.length;i++){
            if (nums[i]==1) {
                count++;
                maxcount = Math.max(maxcount, count);
            }else{
                count = 0;
            }
        }
        return maxcount;
    }

    public static int Findmax(int[]nums,int k){
        int windowsum = 0;
        for(int i = 0;i<k;i++){
            windowsum += nums[i];
        }int maxsum  = windowsum;
        for(int i = k;i<nums.length;i++){
            windowsum += nums[i];
            windowsum -= nums[i-k];
            maxsum = Math.max(maxsum, windowsum);
        }
        return maxsum;
    }

    public static int Lower(int nums[],int target){
        int n = nums.length;
        int s = 0;
         int e = n-1;
         int ans = 1;
         while (s<=e) {
            int mid = s+(e-s)/2;
            if (nums[mid]>=target) {
                ans = mid;
                e = mid-1;
            }else{
                s = mid+1;
            }
         }
         return ans;
    }
    public static int Upper(int nums[],int target){
        int n = nums.length;
        int s = 0;
         int e = n-1;
         int ans = 1;
         while (s<=e) {
            int mid = s+(e-s)/2;
            if (nums[mid]<=target) {
                s = mid+1;
            }else{
                ans = mid;
                e = mid-1;
            }
         }
         return ans;
    }

    public static int Peakindex(int[] nums){
        int n= nums.length;
        int s = 0;
        int e = n-1;
        while(s<e){
            int mid  = s+(e-s)/2;
            if (nums[mid]<nums[mid+1]) {
                s= mid+1;
            }else{
                e = mid;
            }
        }
        return s;
    }
}