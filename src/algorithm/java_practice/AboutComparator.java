package algorithm.java_practice;

import java.util.Comparator;

/**
 * Comparator에 대해서
 * - 매개변수 2개의 객체를 비교한다.
 * - Comparable과 유사하게 인터페이스로 구성되어 있다.
 */
public class AboutComparator {
    public static void main(String[] args) {
        Student s1 = new Student(10, "hello");
        Student s2 = new Student(20, "world");
        Student s3 = new Student(20, "bye");

        s1.compare(s2, s3); // s1은 s2와 s3의 비교에 있어서 아무런 관계가 없다.
        // 이러한 문제를 위해서 익명 객체(클래스)를 사용한다.
        // 이렇게 익명 객체를 사용하면 Student내에 Compare를 따로 구현 할 필요가 없다.
        Comparator<Student> comp1 = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.age - o2.age;
            }
        };

        comp1.compare(s2, s3); // s1.compare(s2,s3) 했을 때와 결과가 같다.

    }

    static class Student implements Comparator<Student> {
        int age;
        String name;

        public Student(int age, String name) {
            this.age = age;
            this.name = name;
        }

        // 아래와 같이 재정의하여 사용 할 수 있다.
        @Override
        public int compare(Student o1, Student o2) {
            return o1.age - o2.age;
        }
    }
}
