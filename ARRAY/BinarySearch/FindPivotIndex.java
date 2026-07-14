public class FindPivotIndex {

    public static int Pivot(int[] nums) {
        int n = nums.length;
        int s = 0;
        int e = n - 1;
        int ans = -1;

        // Array is not rotated
        if (nums[s] < nums[e]) {
            return -1;
        }

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (nums[mid] < nums[n - 1]) {
                e = mid - 1;
            } else {
                ans = mid;
                s = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {50, 60, 70, 10, 20, 30, 40};
        System.out.println(Pivot(nums));
    }
}