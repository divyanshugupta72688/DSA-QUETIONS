public class Oddevencheck{

    public static boolean iseven(int num){
if ((num &1)==0) {
    return true;
}
return false;
    }
    public static void main(String[] args) {
        int num = 11;
        System.out.println(iseven(num));
    }
}