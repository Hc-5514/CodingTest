/**
 * 문제 : 쉬운 최단거리
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_3;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14940 {

    private static int[] dRow = {-1, 1, 0, 0}, dCol = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];
        int[][] result = new int[n][m];
        boolean[][] visit = new boolean[n][m];

        Queue<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 2) {
                    q.offer(new int[]{i, j});
                    visit[i][j] = true;
                    result[i][j] = 0;
                }
                if (board[i][j] == 0) {
                    visit[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int k = 0; k < 4; k++) {
                int r = cur[0] + dRow[k];
                int c = cur[1] + dCol[k];
                if (r < 0 || c < 0 || r >= n || c >= m) continue;
                if (visit[r][c]) continue;
                q.offer(new int[]{r, c});
                visit[r][c] = true;
                result[r][c] = result[cur[0]][cur[1]] + 1;
            }
        }

        // 갈 수 없는 땅 -1로 채우기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visit[i][j]) {
                    result[i][j] = -1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                bw.write(result[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}