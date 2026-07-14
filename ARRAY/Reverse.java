public class Reverse {

    public static void reverse(int[] arr) {
        int l = 0;
        int r = arr.length - 1;

        while (l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 23, 456, 8};

        reverse(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
} 