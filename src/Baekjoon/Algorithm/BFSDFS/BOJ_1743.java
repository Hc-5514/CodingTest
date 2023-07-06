/**
 * 문제 : 음식물 피하기
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.BFSDFS;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1743 {

    final static int[] dRow = {-1, 1, 0, 0}, dCol = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][M];
        boolean[][] visit = new boolean[N][M];

        Queue<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            board[r][c] = 1;
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 1) {
                    if (visit[i][j]) continue;
                    int cnt = 1;
                    q.offer(new int[]{i, j});
                    visit[i][j] = true;
                    while (!q.isEmpty()) {
                        int[] tmp = q.poll();
                        for (int k = 0; k < 4; k++) {
                            int r = tmp[0] + dRow[k];
                            int c = tmp[1] + dCol[k];
                            if (r < 0 || r >= N || c < 0 || c >= M) continue;
                            if (visit[r][c]) continue;
                            if (board[r][c] == 0) continue;
                            q.offer(new int[]{r, c});
                            visit[r][c] = true;
                            cnt++;
                        }
                    }
                    max = Math.max(max, cnt);
                }
            }
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
