class Intro{
  public   static void changeArr(int[]nums,int index,int value){
        //BASR CASE
        if (index == nums.length) {
            printArray(nums);
            return ;
        }
        // RECUSRIVE CALL
         
        nums[index] = value;
        changeArr(nums, index+1, value+1);
        
        // backtracking

        nums[index] = nums[index]-2;
    }
    public static void  printArray(int []nums){
        for(int i = 0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[]args){
        int[]nums = new int[5];
        changeArr(nums,0,1);
        printArray(nums);
    }
}