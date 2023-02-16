/**
 * 문제 : 단지번호붙이기
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2667 {

    static int n;

    static int[] dx = new int[]{-1, 0, 1, 0};

    static int[] dy = new int[]{0, 1, 0, -1};

    static int[][] map;

    static boolean[][] visit;

    static List<Integer> list = new ArrayList<>();

    private static class coordinate {
        int x;
        int y;

        public coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void bfs() {
        Queue<coordinate> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !visit[i][j]) {
                    q.offer(new coordinate(i, j));
                    visit[i][j] = true;
                    int cnt =1;
                    while (!q.isEmpty()) {
                        coordinate tmp = q.poll();
                        // 상하좌우 탐색
                        for (int k = 0; k < 4; k++) {
                            int x = tmp.x + dx[k];
                            int y = tmp.y + dy[k];
                            if (x < 0 || y < 0 || x >= n || y >= n) continue;
                            if (map[x][y] == 1 && !visit[x][y]) {
                                q.offer(new coordinate(x, y));
                                visit[x][y] = true;
                                map[x][y] = map[tmp.x][tmp.y] + 1;
                                cnt++;
                            }
                        }
                    }
                    list.add(cnt);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // n x n 배열
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        bfs();

        sb.append(list.size()).append("\n");
        Collections.sort(list);
        for (int n : list)
            sb.append(n).append("\n");

        System.out.println(sb);
        br.close();
    }
}
