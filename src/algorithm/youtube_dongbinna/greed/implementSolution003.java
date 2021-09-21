package algorithm.youtube_dongbinna.greed;

import java.util.Scanner;

/**
 * 8x8 좌표평면위에 체스말이 있다.
 * 이 말은 다음과 같이 2가지의 경우로 이동 할 수 있다.
 * - 수평으로 두칸 이동한 뒤, 수직으로 한 칸 이동
 * - 수직으로 두칸 이동한 뒤, 수평으로 한 칸 이동
 *
 * 행은 1~8로 표현
 * 열은 a~h로 표현
 *
 * 특정 위치가 'c2'와 같이 입력되었을 때, 각 말이 이동 할 수 있는 경우의 수를 구하시오.
 */
public class implementSolution003 {
    public static void main(String[] args) {
        // 말이 이동 할 수 있는 경우의 수 (총 8가지)
            // 수평으로 두 칸, 수직으로 한 칸 이동하는 경우
                // y+2, x+1
                // y+2, x-1
                // y-2, x+1
                // y-2, x-1
            // 수직으로 두 칸, 수평으로 한 칸 이동하는 경우
                // x+2, y+1
                // x+2, y-1
                // x-2, y+1
                // x-2, y-1
        // 이를 배열로 표현해보면
        int[] moveXIndex = new int[]{1 ,-1,  1, -1, 2,  2, -2, -2};
        int[] moveYIndex = new int[]{2,  2, -2, -2, 1, -1,  1, -1};
        String[] xPositionToEn = new String[]{"a", "b", "c", "d", "e", "f", "g", "h"};

        // 입력부
        Scanner sc = new Scanner(System.in);
        String position = sc.nextLine();
        String positionX = position.split("")[0];
        int y = Integer.parseInt(position.split("")[1]);

        // 주어진 입력을 좌표평면으로 변경
        int x = 0;
        for (int i = 0; i < xPositionToEn.length; i++) {
            if (positionX.equals(xPositionToEn[i])) {
                x = i + 1;
            }
        }

        int result = 0;

        // 구현부
        for (int i = 0; i < moveXIndex.length; i++) {
            if (x + moveXIndex[i] <= 0 || x + moveXIndex[i] > 8) {
                continue;
            }

            if (y + moveYIndex[i] <= 0 || y + moveYIndex[i] > 8) {
                continue;
            }
            result++;
        }

        System.out.println("result = " + result);
    }
}
