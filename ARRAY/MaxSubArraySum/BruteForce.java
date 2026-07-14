public class BruteForce {
    public static void Subarray(int[] arr) {
        int maxsum = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++) {

            for(int j = i; j < arr.length; j++) {

                int currsum = 0;

                for(int k = i; k <= j; k++) {
                    currsum += arr[k];
                }

                System.out.println(currsum);

                maxsum = Math.max(maxsum, currsum);
            }
        }

        System.out.println("Maximum Sum = " + maxsum);
    }

    public static void main(String[] args) {
        int[] arr = {2,4,6,8,10};
        Subarray(arr);
    }
}