public class CheckbitDemo {
    public static void Demo(int num, int k){
        if (((1<<k)&num)>0) {
            System.out.println("Bit is set .");
        }else{
            System.out.println("Bit is unset");
        }
    }
    public static void main(String[] args) {
        int num = 11;
        int k = 2;
        Demo(num,k);
    }
}
