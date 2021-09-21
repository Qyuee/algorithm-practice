package algorithm.youtube_dongbinna.greed;

import java.util.Scanner;

/**
 * N이 주어지고, 00시 00분 00초부터 N시 00분 00초까지
 * N이 들어간 시간을 모두 체크한다.
 *
 * N이 들어간 시간은 총 몇개인지 구하라.
 *
 *
 * [문제분석]
 * 1. 분, 초에 N이 들어간 경우는 N-1번 반복된다.
 *  - 분을 10으로 나누었을 때, 몫과 나머지를 보면 N이 들어갔는지 아닌지 알 수 있다.
 *  - ex) N=5, 59분/10 -> 몫:5, 나머지: 9 -> N이 포함되었음으로 해당됨
 *  - 단, 0은 제외한다.
 *
 * 2. N시인 경우는 모든 분/초가 N이 들어가므로 60*60의 경우이므로 1번 결과에 1800을 더한다.
 *  - 단, "N시"가 N의 배
 *
 */
public class implementSolution002 {
    // 오답
    public static void main2(String[] args) {
        // 입력부
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // 초기화부
        int second = 60;

        // 구현부
        // 초에 대한 N이 들어간 횟수를 구한다. -> second_result
        // 예상로직: result: ((second_result * 59) * N-1)

        // 0시 0~59분 0~59초
        // 5가 들어 갈 수 있는 경우 : 15*59 -> 885개
        // 0~4시까지 885*5 =
        // 5시 -> 60*60 = 3600
        int secondResult = 0;
        for (int i = 1; i < second; i++) {
            if (i/10 == N || i%10 == N) {
                secondResult++;
            }
        }

        // 초단위: 5 15 25 35 45 50~59 = 15개
        // 분단위: 15*59(0분~59분) = 885개 --> 이 분단위의 생각이 오류! 05분의 60개, 15분의 60개...5x분의 60개씩이 모두 포함되어야 한다.,
        // 시단위: (0~4) * 15 * 59 + 3600

        // 0분 5초  0분 15초 ... 0분 59초 -> 15개
        // 1분 5초  1분 15초 ... 1분 59초 -> 15개
        // ...
        // 59분 5초 59분 15초 ... 59분 59초 -> 15개 -> 이 생각이 틀렸음 : 5분, 15분 모두 5가 들어가므로 모든 초가 포함되어야 한다.

        // 위의 반복이 0시 ~ 4시까지 반복
        System.out.println("secondResult:"+secondResult);

        int result = (secondResult * 59 * (N-1)) + 3600;
        System.out.println("result:" +  result);
    }

    public static void main(String[] args) {
        // 입력부
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int result = 0;

        for (int h = 0; h <= N; h++) {
            for (int m = 0; m < 60; m++) {
                for (int s = 0; s < 60; s++) {
                    if (h/10 == N || h%10 == N || m/10 == N || m%10 == N || s/10 == N || s%10 == N) {
                        result++;
                        System.out.println("h:"+h+", m:"+m+", "+"s:"+s);
                    }
                }
            }
        }

        System.out.println("result = " + result);
    }
}
