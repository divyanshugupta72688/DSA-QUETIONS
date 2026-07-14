import java.util.*;

public class Permutation {

    static void getpermutation(int[] nums,
                               List<Integer> output,
                               List<List<Integer>> ans,
                               boolean[] used) {

        
        if (output.size()==nums.length) {
            ans.add(new ArrayList<>(output));
            return;
        }
        for(int i = 0;i<nums.length;i++){
            if (used[i]) {
                continue;
            }
            used[i] = true;
            output.add(nums[i]);
            getpermutation(nums, output, ans, used);
            output.remove(output.size()-1);
            used[i] = false;
        }
    }

    static List<List<Integer>> Per(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        getpermutation(nums, output, ans, used);

        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};

        System.out.println(Per(nums));
    }
}