class Removeduplicates{
 public   static int Remove(int[]arr){
        int i = 0;
        int j = 1;
        while (j<arr.length) {
            if (arr[i]==arr[j]) {
                j++;
            }else{
                i++;
                arr[i] = arr[j];
                j++;
            }
        }
        return i+1;
    }
    public static void main(String[] args) {
        int[]arr = {1,2,2,2,2,3,3,4};
        System.out.println(Remove(arr));
    }
}