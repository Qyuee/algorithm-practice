package algorithm.youtube_dongbinna.DFS_BFS;

import java.util.Scanner;

/**
 * 재귀함수 예제2
 * - 유클리드 호제법
 *  - 최대공약수(GCD) 계산하기
 *  - A와 B가 있을 때, A를 B로 나눈 나머지를 R이라 한다.
 *  이 때, A와 B의 최대 공약수는 B와 R의 최대공약수와 같다.
 *  -> 즉, A/B -> R
 *        B/R -> R2
 *        R/R2 -> R3
 *        R2/R3 -> R4
 *  B와 R, R과 R2, R2와 R3 ... Rn과 Rn+1의 최대 공약수는 같다.
 */
public class Recursive002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();

        System.out.println(gcd(A, B));
    }

    public static int gcd(int a, int b) {
        if (a%b == 0) {
            return b;
        }
        return gcd(b,a%b);
    }
}
