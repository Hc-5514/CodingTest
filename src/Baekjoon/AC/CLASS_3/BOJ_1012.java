/**
 * 문제 : 유기농 배추
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

public class BOJ_1012 {

    static int M, N, cnt;
    static final int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
    static int[][] map;
    static boolean[][] visit;

    static class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void bfs() {
        Queue<Coordinate> q = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visit[i][j]) {
                    q.offer(new Coordinate(i, j));
                    visit[i][j] = true;
                    while (!q.isEmpty()) {
                        Coordinate tmp = q.poll();
                        for (int k = 0; k < 4; k++) {
                            int x = tmp.x + dx[k];
                            int y = tmp.y + dy[k];
                            if (x < 0 || x >= M || y < 0 || y >= N) continue;
                            if (map[x][y] == 1 && !visit[x][y]) {
                                q.offer(new Coordinate(x, y));
                                visit[x][y] = true;
                            }
                        }
                    }
                    cnt++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            // M x N 농장, K: 배추 개수
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            map = new int[M][N];
            visit = new boolean[M][N];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                map[a][b] = 1;
            }
            cnt = 0;
            bfs();
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
