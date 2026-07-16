class practise{
    // to check number is odd or even 

    public boolean ToCkeckOddOREven(int n){
        if (((n )& 1)==0) {
            return true;
        }
        return false;
    }

    // swap a number 

    public void Swap(int a, int b){
        a = a^b;
        b =  a^b;
        a =  a^b;
    }


    // to check missing a number from a array

    public int Missing(int[] arr){
        int n = arr.length;
        int sum = n+(n+1)/2;
      int  s2 = 0;
        for(int i = 0;i<n;i++){
          s2 = s2+arr[i];  
        }
        return sum-s2;
    }

    // count of no of 1 bits

    public int Count(int n){
        int count = 0;
        while (n!=0) {
            n = n &n-1;
            count++;
        }
        return count;
    }

    // to check of power of two or not 


    public boolean Power(int n){
        return n>0 &&(n & (n-1))==0;
    }

    // Binary number with alternating bits

    public boolean alternating(int n){
        int num = n ^(n>>1);
        return (num & num+1)==0;
    }

    // Reverse BIt

    public int Reverse(int n){
        int ans = 0;
        for(int i = 0;i<32;i++){
            ans = ans<<1;
            ans = ans|(n&1);
            n = n>>1;
        }
        return ans;
    }





    }
