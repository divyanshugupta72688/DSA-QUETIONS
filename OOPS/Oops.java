public class Oops{
  public static void main(String[] args) {
    Pen p1 = new Pen();//created a pen objected named p1
    p1.setcolor("Blue");
    System.out.println(p1.color);
  }
}
class Pen{
    String color;
    int tip;

    void setcolor(String newColor){
        color = newColor ;
    }
    void setTip(int newTip){
        tip = newTip;
    }
}