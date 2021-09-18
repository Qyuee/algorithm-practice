package algorithm.youtube_dongbinna.greed;

import java.util.Scanner;

/**
 * 난이도 : level1
 * 제한시간: 15분
 * 어떠한 수 N이 1이 될 때까지 다음의 두 과정 중 하나를 반복적으로 선택하여 수행한다.
 * (2번 연산은 N이 K로 나누어 떨어질 때만 수행할 수 있다.)
 * 1. N에서 1을 뺀다.
 * 2. N을 K로 나눈다.
 *
 * N과 K가 주어질 때, N이 1이 될 때까지 1번 혹은 2번의 과정을 수행해야하는 최소 횟수를 구하는 프로그램을 작성해라.
 */
public class GreedSolution001 {
    public static void main2(String[] args) {
        int count = 0;
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        // 풀이 아이디어
            // 연산의 최소 개수는 최대한 많이 나누기하는 것이다.

        // N을 1로 만드는 가장 빠른 방법은 K로 나누었을 때, 딱 떨어지는 경우이다. 즉, N==K인 경우이다.
        while(N != 1) {
            // N이 K로 나누어 떨어지는가? -> 2번 연산 반복
            if (N % K == 0) {
                while (N != 1 && N >= K && N%K == 0) {
                    N = N/K;
                    count++;
                    //System.out.println("2번 연산 N:"+ N);
                }

            } else {    // 1번 연산
                N = N - 1;
                count++;
                //System.out.println("1번 연산 N:"+N);
            }
        }
        System.out.println("N:"+N+", count:"+count);
    }

    public static void main(String[] args) {
        int result = 0;
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        while(true) {
            // N이 K로 나누어지는 수일 때까지 1번 연산
            // N을 K로 나눈 몫에 K를 곱하였을 때, 나누어 떨어진다면 target은 0이므로 1번연산을 할 필요가 없음을 나타낸다.
            int target = (N / K) * K;

            // 하지만, 나머지가 1 혹은 그 이상일 때, 1번의 연산을 그 개수만큼 수행 했다고 생각 할 수 있다.
            result += (N - target);

            // N이 K보다 적으면 중지 (더 이상 나눌 수 없음)
            if (N < K) break;

            // N을 K로 나누기
            N = N/K;
            result++;
        }

        System.out.println("result:"+result);
    }
}
