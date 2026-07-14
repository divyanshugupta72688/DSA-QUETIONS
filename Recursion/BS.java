class BS {

    static int Binary(int[] arr, int si, int ei, int target) {

        if (si > ei) {
            return -1;
        }

        int mid = si + (ei - si) / 2;

        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            return Binary(arr, mid + 1, ei, target);
        } else {
            return Binary(arr, si, mid - 1, target);
        }
    }
    public static void main(String[] args) {
        int[]arr = {10,20,30,4,0,50,6,700,50,};
        System.out.println(Binary(arr, 0, arr.length-1, 700));
    }
}