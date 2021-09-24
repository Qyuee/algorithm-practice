package algorithm.programmers.Sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * [가장 큰 수]
 * - https://programmers.co.kr/learn/courses/30/lessons/42746<br>
 *
 * <br>[문제 설명]<br>
 * 0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
 * 예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.
 * 0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.<br>
 *
 * <br>[제한 사항]<br>
 * numbers의 길이는 1 이상 100,000 이하입니다.
 * numbers의 원소는 0 이상 1,000 이하입니다.
 * 정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
 *
 */
public class Lessons42746 {
    public static void main(String[] args) {
        // 문제분석
        // 1. 주어진 숫자로 구성 할 수 있는 숫자를 모두 생성한다.
        // 2. 정렬하여 가장 큰 수를 구한다.

        // Keypoint.
        // 경우의 수를 구하기. -> how?
            // 각 숫자의 1의 자리수가 가장크고 length가 가장 작은게 앞으로오면 될 듯.
                // 1의 자리가 같으면 10의 자리비교 -> 100의자리 비교 (1000이하이므로)
            // 1자리인 수, 2자리인 수, 3자리인 수를 나누어서 정렬
                // 2자리인데 10의 자리가 같은 경우 -> 1의 자리비교
            // 검증 필요

        int a[] = {3, 30, 34, 5, 9};
        int[] sizeOne = IntStream.of(a).filter(value -> value < 10).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
        int[] sizeTwo = IntStream.of(a).filter(value -> value < 100 && value >= 10).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
        int[] sizeThree = IntStream.of(a).filter(value -> value < 1000 && value >= 100).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();

        int[] sizeFour = IntStream.of(a)
                .filter(value -> value == 1000)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        IntStream oneTwo = IntStream.concat(IntStream.of(sizeOne), IntStream.of(sizeTwo));
        IntStream oneTowThree = IntStream.concat(oneTwo, IntStream.of(sizeThree));
        Integer[] resultArr = IntStream.concat(oneTowThree, IntStream.of(sizeFour)).boxed().toArray(Integer[]::new);

        Map<Integer, Integer> test = Stream.of(resultArr)
                .collect(Collectors.toMap(
                        v1 -> v1,
                        v2 -> {
                            if (v2<10) {
                                return v2;
                            } else if (v2 < 100) {
                                return v2/10;
                            } else if (v2 < 1000) {
                                return v2/100;
                            } else {
                                return 0;
                            }
                        }
                ));



        String result = "";
        for (int i = 0; i < resultArr.length; i++) {
            result += String.valueOf(resultArr[i]);
        }

        System.out.println(result);
        // 숫자로 구성된 배열을 붙여서 문자열로 변환하기

        // 3 30 34 5 9 72
        // 1의 숫자만 정렬 -> 9 5 34 3 72 30
        // 10의 숫자만 정렬 -> 9 72 5 34 3 30

        // 3 30 34 5 9
        // 9 5 3
        // 34 30

        // 9 5 3
        // 72 34 30
        // 834 321 145

        // 10미만 -> 그대로
        // 100미만 -> 10으로 나누어서 몫 계산
        // 1000미만 -> 100으로 나누어서 몫 계산

        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length; j++) {
                if (a[i] < 10 && a[i] < a[j]) {
                    int tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }

                if (a[i] >= 10 && a[i] < 100 && a[i]/10 < a[j]/10) {
                    int tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }

                if (a[i] >= 100 && a[i] < 1000 && a[i]/100 < a[j]/100) {
                    int tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
            }
        }

        for (int i : a) {
            System.out.println(a[i]+" ");
        }
    }
}
