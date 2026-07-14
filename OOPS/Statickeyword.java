public class Statickeyword {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.schoolName = "JMV";
        System.out.println(s1.schoolName);
        Student s2 = new Student();
        System.out.println(s2.schoolName);

        Student s3 = new Student();
        s3.schoolName = "SGM";
        System.out.println(s3.schoolName);
         System.out.println(s2.schoolName);
    }
}
 class Student{
    String name;
    int roll;
    static String schoolName;
    void setNAme(String name){
        this.name = name;
    }
     String getNAme(){
        return this.name ;
    }
 }