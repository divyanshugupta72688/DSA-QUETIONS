public class PrintAlternate {
    public static void print(int[]arr){
        int n = arr.length;
        int i = 0;
        int j = n-1;
         while(i<=j){
            if (i==j) {
                System.out.println(arr[i]);
                return;
            }else{
                System.out.println(arr[i]);
                i++;
                System.out.println(arr[j]);
                j--;
            }
         }
         
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        print(arr);
        
    }
}
