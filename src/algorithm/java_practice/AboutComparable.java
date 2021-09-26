package algorithm.java_practice;

/**
 * 주제: Comparable과 Comparator의 차이가 무엇일까?
 * - 데이터를 정렬하는데 많이 사용 될 수 있을 것으로 보인다. 왜? 어원그대로 비교를 하는 어떤? 동작이니깐
 * - 이 두개의 인터페이스의 존재 이유가 뭘까? -> 객체를 비교하기위해서
 */
public class AboutComparable {
    public static void main(String[] args) {
        /*
        Comparable, Comparator 모두 인터페이스이다. -> 즉, 인터페이스내의 어떤 메소드를 구현해야한다.
        - Comparable은 compareTo 메소드를 구현해줘야 한다. ex) compareTo(T o)
         - 자기자신과 매개변수 객체를 비교한다.
        - Comparator은 compare 메소드를 구현해야줘야 한다. ex) compare(T o1, T o2)
         - 두 매개변수 객체를 비교한다.
         */
    }

    class Student implements Comparable<Student> {
        String name;
        int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        // Student 객체를 비교 할 때, 어떤 기준으로 비교 할 것인지를 정의해줄 수 있다.
        // 기준은 자기자신이고 유입된 매개변수 객체와의 비교를 진행한다.
        // compareTo의 반환값이 1, 0, -1이 아니여도 된다. 양이냐 음이냐 0이냐를 구별 할 뿐이다.
        // 예를 들어서 this.age = 7, o.age = 3이라면 둘 사이의 차이는 '자기자신'을 기준으로 +4 이다. -> 양의 정수이다. -> 내가 더 크다. 즉, 1을 리턴한다.
        // 반대로 this.age = 7, o.age = 10이라면 둘 사의 차이는 -3이다. -> 음의 정수이다. -> 내가 더 작다. 즉 -1을 리턴한다.
        @Override
        public int compareTo(Student o) {
            if (this.age > o.age) {
                return 1;   // 내가 더 크다.
            } else if (this.age == o.age) {
                return 0;   // 같다.
            } else {
                return -1;  // 내가 더 작다.
            }
        }

        // 좀 더 생각해보자.
        // 결국 어떤 기준의 둘 사이의 차이가 음이냐 양이냐 혹은 0이냐가 지금 중요한거다.
        // 그러면 이렇게 표현 할 수 있다.
        /*
        @Override
        public int compareTo(Student o) {
            return this.age - o.age;
        }

        [주의사항]
        단, return을 대소비교를 하여 구분하는 경우 underflow와 overflow 이슈를 염두해야한다.
        ex) 1 - (-2,147,483,648) -> 양수가 나와야 하지만 실제로는 underflow이기에 음수가 나온다.
        그렇기에 1이 -2147~~ 보다 더 작은 수로 처리가 되는 상황이 올 수 있다.
        */
    }
}
