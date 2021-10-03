package algorithm.T1003;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * N이 주어졌을 때, 오름차순+내림차순의 합계를 반환하라.
 */
public class Solution003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 정수 n을 오름차순, 내림차순으로 변환
        List<Integer> numList = Stream.of(String.valueOf(n).split("")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());

        // List<String> collect = Stream.of(String.valueOf(n).split("")).collect(Collectors.toList()); // String형 List를 생성한다.
        // List<Integer> collect = Stream.of(String.valueOf(n).split("")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList()); // Integer형 ArrayList를 생성한다.

        // 오름차순
        numList.sort((o1, o2) -> o1 - o2); // 오름차순 (default)
        //numList.sort(Comparator.comparingInt(o -> o));

        for (int i = 0; i < numList.size(); i++) {
            System.out.println(numList.get(i));
        }

        // List<Integer> -> 각 숫자를 문자열로 변환하여 결합하는 연산
        // [1, 2, 4, 6] -> 1246
        int min = Integer.parseInt(numList.stream().map(String::valueOf).collect(Collectors.joining()));
        System.out.println("min = " + min);

        // 각 요소별 합계 구하기
        //int a = numList.stream().reduce(Integer::sum).orElse(0);
        //System.out.println(a);

        // 내림차순
        numList.sort((o1, o2) -> o2 - o1); // 내림차순
        int max = Integer.parseInt(numList.stream().map(String::valueOf).collect(Collectors.joining()));
        System.out.println("max = " + max);
        System.out.println("result:"+(min+max));

        // 정답
//        List<Integer> numList = Stream.of(String.valueOf(n).split("")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
//        numList.sort((o1, o2) -> o1 - o2);
//        int min = Integer.parseInt(numList.stream().map(String::valueOf).collect(Collectors.joining()));
//        numList.sort((o1, o2) -> o2 - o1); // 내림차순
//        int max = Integer.parseInt(numList.stream().map(String::valueOf).collect(Collectors.joining()));
//        System.out.println("result:"+(min+max));
    }
}
