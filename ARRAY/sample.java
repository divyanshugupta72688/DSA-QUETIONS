public class sample{
    public static void main(String[] args){
        int arr[] = {10,20,30,40,15,70,13,12};
        int n  = arr.length;
        int max = arr[0];
        for(int i = 0;i<n;i++){
            if (arr[i]>max) {
                max = arr[i];
            }
        }
        System.out.println(max);
    }
}