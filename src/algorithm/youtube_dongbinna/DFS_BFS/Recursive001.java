package algorithm.youtube_dongbinna.DFS_BFS;

import java.util.Scanner;

/**
 * 재귀함수 예제
 * - 팩토리얼
 */
public class Recursive001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(factorial(N));
    }

    public static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    // 5 * factorial(5-1) // 120        // 호출은 아래로
    // 4 * factorial(4-1) // 24
    // 3 * factorial(3-1) // 6
    // 2 * factorial(2-1) // 2
    // 1                                // 결과 반환은 위로

}
