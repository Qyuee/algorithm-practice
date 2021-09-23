package algorithm.youtube_dongbinna.DFS_BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 미로탈출
 * - N x M의 미로가 있다.
 * - (1,1)에서 시작하고 n, M까지 미로를 탈출해야한다.
 * - 첫번째(1,1) 가장 마지막(n,m)은 항상 1이다.
 * - 각 미로는 0과 1로 표현되면 0은 이동할 수 없는 곳. 1은 이동 할 수 있는 곳.
 * - 탈출하기 위해서 움직여야하는 최소 칸의 개수는?
 */
public class BfsSolution001 {
    public static int n, m;
    public static int[][] map = new int[201][201];
    public static int dx[] = {-1, 1, 0, 0};
    public static int dy[] = {0, 0, -1, 1};

    public static void main(String[] args) {
        // 입력부
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();


        // 초기화
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        // 초기화 검증
        /*for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(map[i][j]);
            }
        }*/

        // 구현부(논리)
        // x와 y의 범위를 제한해야한다.
        // 방문한 노드는 방문처리를 반드시 해야한다. -> 노드의 거리를 표시한다.
        // (1,1)를 기점으로 상하좌우 노드를 모드 탐색한다. -> 더 이상 이동이 불가능한 경우인데 (n,m)이 아니라면 다음
        System.out.println(bfs(0, 0));
    }

    public static int bfs(int x, int y) {
        // 큐 생성
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));            // 큐에다가 현재 노드 정보를 넣고

        while(! q.isEmpty()) {  // 큐가 비어있지 않으면 무한실행 -> 빌때까지 진행
            Node node = q.poll(); // 큐에서 하나를 빼내어온다.
            x = node.getX();
            y = node.getY();

            // 상하좌우 네가지 방향으로 검사를 진행한다.
            for (int i = 0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (map[nx][ny] == 0) continue;

                // 이동이 가능한 노드라면 -> 해당 노드에 처음 방문하는 경우에만 최단 거리 기록
                if (map[nx][ny] == 1) {
                    map[nx][ny] = map[x][y] + 1;    // 기존 노드의 거리에 +1 하여
                    q.offer(new Node(nx, ny));
                }
            }
        }

        return map[n-1][m-1];
    }
}

class Node {
    private final int x;
    private final int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
