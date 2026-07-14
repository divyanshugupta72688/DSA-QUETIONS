import java.util.*;
public class RemoveDuplicates {
    static int Duplicates(int[]nums){
        int n = nums.length;
        int left = 0;
        int right = 1;
        while (right<n) {
            if (nums[left]==nums[right]) {
                right++;
            }else{
                left++;
                nums[left]=nums[right];
                right++;
            }
        }
        return left+1;

    }
}
