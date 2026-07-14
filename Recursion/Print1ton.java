 class Print1ton{
    static void Print(int n){
        if (n==0) {
            return;
        }
        
        Print(n-1);
        System.out.println(n);
    }
    public static void main(String[]args){
        Print(5);
    }
 }