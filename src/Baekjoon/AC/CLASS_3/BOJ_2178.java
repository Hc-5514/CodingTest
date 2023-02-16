/**
 * 문제 : 미로 탐색
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178 {

    static int n, m;

    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {1, 0, 0, -1};

    static int[][] map;

    static boolean[][] visit;

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        visit[0][0] = true;

        while (!q.isEmpty()) {
            int[] coordinate = q.poll();
            for (int i = 0; i < 4; i++) {
                int x = coordinate[0] + dx[i];
                int y = coordinate[1] + dy[i];

                if (x < 0 || x >= n || y < 0 || y >= m)
                    continue;

                if (map[x][y] == 1 && !visit[x][y]) {
                    q.offer(new int[]{x, y});
                    visit[x][y] = true;
                    map[x][y] = map[coordinate[0]][coordinate[1]] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // n x m 미로 입력
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = tmp.charAt(j) - '0';
            }
        }

        bfs();

        System.out.println(map[n - 1][m - 1]);
        br.close();
    }
}
