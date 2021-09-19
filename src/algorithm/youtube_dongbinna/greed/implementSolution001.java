package algorithm.youtube_dongbinna.greed;

import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * 여행가 A는 NxN 크기의 정사각형이 있다.
 * 가장 왼쪽 위의 죄표는 1,1이다.
 * 가장 오른쪽 아래는 N,N이다.
 * 상하좌우로 이동 할 수 있다.
 * 여행가는 이동 계획서에 따라서 이동을 할 것이다.
 * (죄표를 벗어나면 무효이다.)
 * L - 왼쪽으로 이동
 * R - 오른쪽으로 이동
 * U - 위로 이동
 * D - 아래로 이동
 *
 *
 * 죄표 크기: N = 5
 * 계획서: R R R U D D
 *
 * 결과 3, 4
 *
 *
 */

/*
[문제분석]
1. 공간의 범위를 먼저 정의해야 한다.
2. 공간은 1,1 부터 시작하므로 초기화가 필요하다.
3. L, R, U, D에 해당하는 움직임에 대한 method를 분리해야 한다.
  L: y좌표를 -1한다.
  R: y좌표를 +1한다.
  U: x좌표를 +1한다.
  D: x좌표를 -1한다.
4. 공간을 벗어나면 무효처리가 필요하다.
 - x,y가 1보다 적은 경우
 - 다음이동 할 위치가 N보다 큰 경우
*/
public class implementSolution001 {
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        String movePlanStr = sc.nextLine();
        String[] movePlan = movePlanStr.split(" ");

        int[] result = new int[]{1, 1};
        for(int i = 0; i < movePlan.length; i++) {
            int nextX = 0;
            int nextY = 0;

            if (movePlan[i].equals("L")) {
                nextY -= 1;
            } else if (movePlan[i].equals("R")) {
                nextY += 1;
            } else if (movePlan[i].equals("U")) {
                nextX -= 1;
            } else {
                nextX += 1;
            }

            if (isRangeValid(N, result[0]+nextX, result[1]+nextY)) {
                result[0] += nextX;
                result[1] += nextY;
            }
        }

        System.out.println("("+result[0]+", "+result[1]+")");
    }

    public static boolean isRangeValid(int limit, int nextXPosition, int nextYPosition) {
        if (nextXPosition < 1 || nextYPosition < 1) {
            return false;
        }
        return (nextXPosition < limit + 1) && (nextYPosition < limit + 1);
    }

    // 풀이2
    public static void main(String[] args) {
        // 입력부
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        String movePlanStr = sc.nextLine();
        String[] movePlan = movePlanStr.split(" ");

        // 초기화부 (L, R, U, D 순으로) -> 방향성을 가진 벡터를 지정한다.
        int[] dx = new int[]{0, 0, -1 ,1};
        int[] dy = new int[]{-1, 1, 0, 0};
        String[] direction = new String[]{"L", "R", "U", "D"};

        int[] result = new int[]{1, 1};

        // 구현부
        for (int i = 0; i < movePlan.length; i++) {
            for (int j = 0; j < direction.length; j++) {
                int expectedX = 0;
                int expectedY = 0;

                if (movePlan[i].equals(direction[j])) {
                    expectedX = result[0] + dx[j];
                    expectedY = result[1] + dy[j];

                    if (expectedX < 1 || expectedY < 1 || expectedX > N + 1 || expectedY > N + 1) {
                        continue;
                    }
                    result[0] = expectedX;
                    result[1] = expectedY;
                }
            }
        }

        System.out.println("("+result[0]+", "+result[1]+")");
    }
}
