package algorithm.youtube_dongbinna.sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * 두 배열의 원소 교체
 * - 두 개의 배열 A, B가 있다. (N개로 구성)
 * - 최대 K번의 바꿔치기를 할 수 있음
 * - 목표는 배열 A의 모든 원소의 합이 최대가 되도록 하는 것.
 *
 * - 최대 몇번의 바꿔치기를 해야 배열 A의 모든 원소의 합이 최대가 될 수 있는가?
 */
public class SortingSolution001 {
    public static void main(String[] args) {
        // A:[1,2,3,4,5]
        // B:[5,5,5,6,6]
        // C:[1,2,3,4,5,| 5,5,5,6,6]

        // 아이디어
        // 배열 A와 B를 오름차순으로 정렬한다.
        // 그 중, N개만 잘라서 최종목표인 상태의 배열 상태(C)를 구한다.
        // A배열에서 C가 되기 위해 필요한 인자가 무엇인지 파악한다.
        // 오름차순으로 정렬된 A의 앞에서부터 K개와, 오름차순으로 정렬된 B배열의 뒤에서 K를 변경

        // 입력부
        // N -> 배열의 개수
        // K -> 바꿔치기 할 수 있는 개수

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        sc.nextLine();

        String arr1 = sc.nextLine();
        //Integer[] A = Stream.of(arr1.split(" ")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);   // int[]을 Integer[]로 변환하기 -> boxed()사용
        int[] arrA = Stream.of(arr1.split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        String arr2 = sc.nextLine();
        Integer[] B = Stream.of(arr2.split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .toArray(Integer[]::new);

        int[] arrB = Arrays.stream(B).mapToInt(value -> value).toArray();

        // 구현부
        //int[] C = IntStream.concat(IntStream.of(A), IntStream.of(B)).sorted().toArray();        // A + B 오름차순
        for (int i = 0; i < K; i++) {
            int temp = arrA[i];
            arrA[i] = arrB[i];
            arrB[i] = temp;
        }

        int result = 0;
        for (int i : arrA) {
            result += i;
        }

        System.out.println(result);
    }
}
