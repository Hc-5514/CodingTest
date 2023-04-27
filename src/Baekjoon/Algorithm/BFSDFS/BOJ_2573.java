/**
 * 문제 : 빙산
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.BFSDFS;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2573 {

    static final int[] dRow = {-1, 1, 0, 0}, dCol = {0, 0, -1, 1};

    static boolean flag = false;

    private static boolean checkDivision(int N, int M, int[][] board) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visit = new boolean[N][M];
        f1:
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] > 0) {
                    q.offer(new int[]{i, j});
                    visit[i][j] = true;
                    break f1;
                }
            }
        }

        if(q.isEmpty()){
            flag = true;
            return true;
        }

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            for (int k = 0; k < 4; k++) {
                int r = tmp[0] + dRow[k];
                int c = tmp[1] + dCol[k];
                if (r < 0 || c < 0 || r >= N || c >= M) continue;
                if (board[r][c] == 0) continue;
                if (visit[r][c]) continue;
                q.offer(new int[]{r, c});
                visit[r][c] = true;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] > 0 && !visit[i][j]) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        while (!checkDivision(N, M, board)) {
            time++;
            // 빙산 녹이기
            int[][] countBoard = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (board[i][j] > 0) {
                        int cnt = 0;
                        for (int k = 0; k < 4; k++) {
                            int r = i + dRow[k];
                            int c = j + dCol[k];
                            if (r < 0 || c < 0 || r >= N || c >= M) continue;
                            if (board[r][c] == 0) cnt++;
                        }
                        countBoard[i][j] = cnt;
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (countBoard[i][j] > 0) {
                        board[i][j] -= Math.min(board[i][j], countBoard[i][j]);
                    }
                }
            }
        }

        if(flag) time = 0;

        bw.write(time + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}