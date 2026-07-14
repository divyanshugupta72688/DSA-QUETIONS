package Day2;

public class MostConsecutiveOnes {
    public static int Ones(int[]nums){
        int maxcount = 0;
        int count = 0;
        for(int i = 0;i<nums.length;i++){
            if (nums[i]==1) {
                count++;
                maxcount = Math.max(maxcount, count);
            }else{
                count = 0;
            }
        }
        return maxcount;
    }
}
