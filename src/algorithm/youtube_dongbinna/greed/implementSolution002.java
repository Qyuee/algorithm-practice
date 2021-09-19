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
 * 2. N시인 경우는 모든 분/초가 N이 들어가므로 60*60의 경우이므로 1번 결과에 1800을 더한다.
 *  - 단, "N시"가 N의 배
 *
 */
public class implementSolution002 {
    public static void main(String[] args) {
        // 입력부
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // 초기화부
        int min = 60;
        int second = 60;

        // 구현부
        for (int i = 0; i < min; i++) {
            for
        }
    }
}
