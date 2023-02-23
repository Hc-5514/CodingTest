/**
 * 문제 : 섬의 개수
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4963 {

    static StringBuilder sb = new StringBuilder();
    static int w, h, cnt = 0;
    static int[][] map;
    static boolean[][] visit;
    // 가로 세로 대각선
    static int[] dRow = new int[]{-1, 0, 1, -1, 1, -1, 0, 1}, dCol = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};

    private static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (map[i][j] == 1 && !visit[i][j]) {
                    cnt++;
                    q.offer(new int[]{i, j});
                    visit[i][j] = true;
                    while (!q.isEmpty()) {
                        int[] tmp = q.poll();
                        for (int k = 0; k < 8; k++) {
                            int row = tmp[0] + dRow[k];
                            int col = tmp[1] + dCol[k];
                            if (row < 0 || col < 0 || row >= h || col >= w) continue;
                            if (map[row][col] == 1 && !visit[row][col]) {
                                q.offer(new int[]{row, col});
                                visit[row][col] = true;
                            }
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        while (!(w == 0 & h == 0)) { // 0 0: 종료
            // h x w 지도 입력
            map = new int[h][w];
            visit = new boolean[h][w];
            cnt = 0;
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            bfs();
            sb.append(cnt).append("\n");

            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
        }

        System.out.println(sb);
        br.close();
    }
}
