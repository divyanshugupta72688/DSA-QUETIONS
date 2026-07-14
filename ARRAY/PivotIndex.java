public class PivotIndex {
    public static int Pivot(int[]arr){
        int n = arr.length;
        int[]left = new int[n];
        int[] right = new int[n];
        left[0] = arr[0];
        for(int i = 1;i<n;i++){
            left[i] = arr[i] + left[i-1];
        }
        right[n-1] = arr[n-1];
        for(int i = n-2;i>=0;i--){
            right[i] = arr[i] + right[i+1];
        }
        for(int i = 0;i<n;i++){
            if (left[i]==right[i]) {
                return left[i];
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {1,7,3,6,5,6};
        System.out.println(Pivot(arr));
    }
}
