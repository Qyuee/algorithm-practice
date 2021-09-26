package algorithm.java_practice;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Comparable과 Comparator와 sort의 관계
 * - 보통 우리가 사용하는 Arrays.sort(), Collections.sort()는 모두 `오름차순`을 기준으로 정렬을 해준다. (기본값)
 * - 이 말인 즉, 선행원소가 후행원소보다 '작다'는 의미이다.
 *  - 만약 선행원소가 후행보다 작으면 음의 정수가 compareTo 혹은 compare를 통해서 반환되고
 *  - 선행원소가 후행보다 크면 양의 정수가 compareTo 혹은 compare를 통해서 반환된다.
 *  - 오름차순이므로 양의 정수가 나오면 두 데이터의 위치를 변경하는 것이다.
 * 정리하면
 * 1. 선행원소가 더 크다. -> 양의 정수 -> 두 데이터 위치 변경 O
 * 2. 선행원소가 더 작다. -> 음의 정수 -> 두 데이터 위치 변경 X
 *
 * 보통의 정렬 알고리즘인 insertion(삽입정렬), Quick(퀵정렬) 등 다양한 알고리즘은 두 데이터를 비교하여 데이터 위치를 변경하는데 기반한다. (물론 안그런 정렬도 있다)
 *
 */
public class CompWithSort {
    public static void main(String[] args) {
        int[] a = {10, 2, 1, 4, 5};
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        // 결과: 1 2 4 5 10

        System.out.println();
        System.out.println("==== comparable을 통한 정렬 ====");
        /*
        Arrays.sort()를 보면 단순히 배열을 전달해도 되지만, 배열과 함께 comparator를 함께 전달이 가능하다.
         */
        Test001[] testArr1 = new Test001[10];
        for (int i = 0; i < 10; i++) {
            testArr1[i] = new Test001((int)(Math.random() * 100));
        }

        // 정렬전
        for (int i = 0; i < 10; i++) {
            System.out.print(testArr1[i].num + " ");
        }

        System.out.println();

        // 정렬후
        // 만약, Test001 클래스에 compareTo가 정의되어 있지 않다면 에러가 발생한다. -> 객체를 어떤 기준으로 비교해야 할 지 알 수 없기에.
        Arrays.sort(testArr1);
        for (int i = 0; i < 10; i++) {
            System.out.print(testArr1[i].num + " ");
        }

        System.out.println();
        System.out.println();

        System.out.println("==== comparator를 통한 정렬 ====");
        Test002[] testArr2 = new Test002[10];
        for (int i = 0; i < 10; i++) {
            testArr2[i] = new Test002((int)(Math.random() * 100));
        }

        // 정렬전
        for (int i = 0; i < 10; i++) {
            System.out.print(testArr2[i].num + " ");
        }

        System.out.println();
        // 정렬기준을 정의한 comp1이라는 익명객체를 전달한다.
        Arrays.sort(testArr2, comp1);

        // 정렬후
        for (int i = 0; i < 10; i++) {
            System.out.print(testArr2[i].num + " ");
        }
        System.out.println();

        String str1 = "30";
        String str2 = "3";

        System.out.println(str1+str2);
        System.out.println(str2+str1);

        // 30 3
        // "303"과 "330"을 사전적 비교하여 결과를 확인 -> "303"이 사전적으로 더 앞서므로 -3(음수) 반환

        int i = (str1 + str2).compareTo(str2 + str1);
        System.out.println(i);

    }

    static class Test001 implements Comparable<Test001> {
        int num;

        public Test001(int num) {
            this.num = num;
        }

        @Override
        public int compareTo(Test001 o) {
            return this.num - o.num;    // 양: this가 더 큼, 음: o가 더 큼
        }
    }

    static class Test002 {
        int num;
        public Test002(int num) {
            this.num = num;
        }
    }

    static Comparator<Test002> comp1 = new Comparator<Test002>() {
        @Override
        public int compare(Test002 o1, Test002 o2) {
            return o1.num - o2.num; // 오름차순: 양수일 때, 데이터 교환.
        }
    };
}
