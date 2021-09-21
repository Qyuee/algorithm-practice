package algorithm.youtube_dongbinna.DFS_BFS;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * DFS는 깊이우선 탐색이다.
 * 즉, 그래프의 깊은 부분부터 탐색을 수행한다.
 * 보통은 스택 자료구조 혹은 재귀함수를 사용하여 문제를 해결 할 수 있다.
 * 1. 탐색노드를 스택에 쌓고 방문처리를 한다.
 * 2. 스택의 최상단 노드에 방분하지 않은 인접노드가 하나라도 있으면 그 노드를 스택에 넣고 방문처리한다.
 *    방문하지 않은 인접 노드가 없으면 스택에서 최상단 노드를 꺼낸다.
 * 3. 더 이상 2번의 과정을 수행 할 수 없을 때까지 반복한다.
 */
public class DfsSolution001 {
    public static int n, m;
    public static int[][] graph = new int[1001][1001];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();

        for (int i =0; i<n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        int result = 0;
        for (int i = 0; i<n; i++) {
            for (int j = 0; j < m; j++) {
                // DFS 수행
                if (dfs(i, j)) {
                    result++;
                }
            }
        }

        System.out.println("result = " + result);
    }

    public static boolean dfs(int i, int j) {
        // 예외범위 선정
        if (i <= -1 || i >= n || j <= -1 || j >= m) {
            return false;
        }

        // dfs 수행 - 상하좌우 모든 방향을 탐색한다.
        if (graph[i][j] == 0) { // 0인 경우. 즉, 아직 방문이 되지 않은 지역
            // 해당 노드는 방문표시
            graph[i][j] = 1;

            // 상하좌우에 있는 각 노드로 탐색을 진행한다. -> 언제까지? 단순하게 모두 탐색 할 때까지. 즉. 연결된 모든 노드들을 방문하는 것이 목표.
            dfs(i-1, j);    // 상
            dfs(i+i, j);    // 하
            dfs(i, j-1);    // 좌
            dfs(i, j+1);    // 우

            return true;
        }

        // dfs 수행종료 조건 명시 - 이미 방문한 노드라면 false 리턴하여 dfs함수 종료.
        return false;
    }

    // 핵심은 문제를 그래프로써 생각하여 각 노드를 방문처리하는 것이다.
    // 방문처리를 함에 있어서 각 문제가 준 조건에 따라 result를 어떻게 카운팅 할지는 문제마다 다를 것이다.
    // 어렵다.. 일단. DFS문제라서 재귀함수가 사용되었다. 방문의 순서는 중요하지 않은 문제였음. 단지 인접한 노드가 0이냐 1이냐에 따라서 카운팅을 하는 문제.
}
