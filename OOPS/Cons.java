public class Cons {

    public static void main(String[] args) {
        Student s1 = new Student("Divyanshu Gupta");
        Student s2 = new Student();
        s2.name = "aman";
        s2.roll = 655;
        Student s3 = new Student(s2);
        
    }
}

class Student{
    String name;
    int roll;

    Student(Student s2){// copy constructor
        this.name = s2.name;
        this.roll = s2.roll;
    }
    Student(String name){//paramterized constructor
        this.name = name;
    }
    Student(){// non- paramterized
        System.out.println("non-paramterized");
    }
}

