public class Sortof0and1 {
    // public static void Print(int[]arr){
    //     int left = 0;
    //     for(int right = 0;right<arr.length;right++){
    //         if (arr[right]==0) {
    //             int temp = arr[right];
    //             arr[right] = arr[left];
    //             arr[left] = temp;
    //             left++;
    //         }
    //     }
    // }
    // public static void main(String[] args) {
    //     int[] arr = {1,0,1,1,0,0,1};
    //    Print(arr);
    //    for (int i : arr) {
    //     System.out.print(i+" ");
    //    }
    // }

    public static void Sort(int[] arr){
        int count0 = 0;
        int count1 = 0;
        for(int i = 0;i<arr.length;i++){
            if (arr[i]==0) {
                count0++;
            }else{
                count1++;
            }
        }
        int index = 0;
        while(count0>0){
            arr[index] = 0;
            index++;
            count0--;
        }
         while(count1>0){
            arr[index] = 1;
            index++;
            count1--;
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,0,1,1,0,0,1};
       Sort(arr);
       for (int i : arr) {
        System.out.print(i+" ");
       }
}
}