package Recursion.Practise;

class AllQuetion{

// factorial Number

public static int Factorial(int n){
   if(n==0){
    return 1;
   }

   return n*Factorial(n-1);
}

// fibonacci nu,ber

public static int fibonacci(int n){
    if(n==0){
        return 0;
    }
    if(n==1){
        return 1;
    }
    return fibonacci(n-1)+fibonacci(n-2);
}

// Binary search

public int BinarySearch(int[]arr,int si,int ei,int target){
    if (si>ei) {
        return -1 ;
    }

    int mid = si + (ei-si)/2;

    if (target==arr[mid]) {
        return mid;
    }
    if (target>arr[mid]) {
        return BinarySearch(arr, mid+1, ei, target);
    }else{
        return BinarySearch(arr, si, mid-1, target);
    }
    
}

// climbing stairs


    public int ClimbingStair(int n){
        if (n==0) {
            return 1;
        }
        if (n==1) {
            return 1;
        }
        return ClimbingStair(n-1)+ClimbingStair(n-2);
    }

   // House Rober

   public int HouseRobberOne(int[] arr,int i){
    if (i>arr.length) {
        return -1;
    }

    int includeans = arr[0] + HouseRobberOne(arr, i+2);
    int excluseans = 0 + HouseRobberOne(arr, i+1);
    int finalans = Math.max(includeans, excluseans);
    return finalans;
   }



   public static void main(String[] args) {
    
    int n=5;
    System.out.println(Factorial(n));   
}
}