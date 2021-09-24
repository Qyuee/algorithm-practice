package algorithm.youtube_dongbinna.greed;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * 모험가 길드 문제
 * - 모험가 N명이 있다.
 * - 공포도를 측정하였다.
 * - 공포도가 X인 모험가는 반드시 X명 이상으로 구성한 모험가 그룹에 참여해야 여행을 떠날 수 있다.
 * - 최대 몇개의 모험가 그룹을 생성할 수 있을까?
 * - N명의 모험가에 대한 정보가 주어졌을 때 여행을 떠날 수 있는 그룹 수의 최대값을 구하라.
 *
 * input
 * - N=5
 * - 2 3 1 2 2 (공포도) -> 32 22 1
 * - 1 22 23
 *
 */
public class GreedSolution003 {
    public static void main(String[] args) {
        // 그룹을 최대한 구성해야한다.
            // 만약 24122라면?
            // 가장 큰 숫자 4의 모험가는 4명이 포함된 그룹에 들어가야한다.
            // 가장 낮은 숫자 1의 모험가는 혼자서도 갈 수 있다.
                // 정렬을 할까..? (내림차순)
            // 4222 1
            // 3424235
                // 54433 22
            // 가장 큰 공포도를 가진 모험가를 기준으로 그룹을 형성하면 나머지 모험가들은 모두 별다른 제약없이 그룹에 포함 될 수 있다.
            // 반대로 가장큰 공포도를 가진 모험가를 버려도 되지 않는가?
                // 버리는 케이스가,, (조건이..?)
            // 8112244
                // 8 4422 1 1 => 8은 버리고 3개 그룹
            // 8112244123
                // 8 4432 22 1 1 1 => 8은 버리고 5개 그룹 최대
                // 1 1 1 22 2344 |8 -> 8을 탐색하는 시점에서 공포도보다 남은 모험가가 적으면 버린다.


        // 로직
        // 1. 오름차순으로 입력된 공포도를 정렬한다.
        // 2. 0번째부터 공포도가 1이면 result는 +1한다.
        // 3. 공포도가 2이상인 경우 다음 인수의 수를 비교한다.
        // - 3-1) 만약 공포도가 같으면 result를 +1한다.
        // - 3-2) 만약 공포도가 더 높으면 그 다음 인수를 확인한다. (3-1 반복)

        int result = 0;

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        String fearStr = sc.nextLine(); // next()는 공백을 받아주지 않는다.
        int[] fearIndex = Stream.of(fearStr.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.sort(fearIndex);

        for (int i = 0; i < fearIndex.length; i++) {
            if (fearIndex[i] == 1) {
                result+=1;
                continue;
            }

            if (fearIndex[i] > 1) {
                int tmp = i+1;
                while (tmp < fearIndex.length) {
                    if (fearIndex[tmp] == fearIndex[i]) {
                        result+=1;
                        i = tmp+1;
                        break;
                    }
                    tmp+=1;
                }
            }
        }

        System.out.println("result:"+result);
    }
}
