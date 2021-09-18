package algorithm.youtube_dongbinna.greed;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 각 자리가 숫자 0~9로만 구성된 문자열 S가 주어졌을 때, 왼쪽부터 오른쪽으로 하나씩 모든 숫자를 확인하며
 * 숫자사이에 'x' 혹은 '+'연산자를 하여 결과적으로 만들어질 수 있는 최대의 수를 구하는 프로그램을 작성하라.
 * (단, +보다 x를 먼저 계산하는 일반적인 방식과 달리, 모든 연산은 왼쪽에서 오른쪽으로 이루어진다.)
 */
public class GreedSolution002 {
    public static void main(String[] args) {
        // 문제 분석
        // 문자열을 먼저 숫자 배열로 변환을 해야한다.
            // 가장 큰 수를 구하는 방법은?
            // 0인 경우 x를 하면 안된다. -> +를 해야한다.
            // 1인 경우 x를 하면 안된다. -> +를 해야한다.
            // 2~9인 경우 x를 하면 최대값에 가까워 진다.

        // 로직 순서
        /**
         * 1. 문자열을 숫자 배열로 변환한다.
         * 2. 0 혹은 1인 경우 결과값에 +를 수행한다.
         * 3. 2~9인 경우 x를 수행한다.
         *  - 단, 현재 result가 0인 경우 + 연산을 한다.
         */

        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        int result = 0;

        // String을 int[]로 변환 - 스트림
        int[] numList = Stream.of(S.split("")).mapToInt(Integer::parseInt).toArray();
        //int[] numList2 = Arrays.stream(S.split("")).mapToInt(Integer::parseInt).toArray();
        Stream<String> s1 = Stream.of(S);
        s1.forEach(s -> {
            System.out.println("s:"+s); // s:02984
        });

        Stream<String> s2 = Stream.of(S);
        IntStream intStream = s2.mapToInt(Integer::parseInt);
        intStream.forEach(value -> {
            System.out.println("value:"+value);
        });

        for (int i = 0; i < numList.length; i++) {
            if (numList[i] <= 1 || result == 0) {
                result += numList[i];
                continue;
            }
            result *=numList[i];
        }
        System.out.println("result:"+result);
    }
}
