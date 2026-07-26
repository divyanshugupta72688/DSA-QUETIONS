package PRIORITYQUEUE;

import java.util.*;

public class Practice {


    // PRIORITY QUEUE ME OBJECT KAISE USE KARENGE 
    static class Student implements Comparable<Student> {
        String name;
        int rank;

        public Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2) {
            return this.rank - s2.rank;
        }
    }

    public static void main(String[] args) {

        PriorityQueue<Student> pq = new PriorityQueue<>();

        pq.add(new Student("Rahul", 5));
        pq.add(new Student("Aman", 2));
        pq.add(new Student("Karan", 1));
        pq.add(new Student("Rohit", 3));

        while (!pq.isEmpty()) {
            Student s = pq.remove();
            System.out.println(s.name + " -> " + s.rank);
        }
    }
}