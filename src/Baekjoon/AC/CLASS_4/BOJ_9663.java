/**
 * 문제 : N-Queen
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_4;

import java.io.*;

public class BOJ_9663 {

    static int N, cnt = 0;
    static final int[] dRow = {-1, 0, 1}, dCol = {-1, -1, -1};
    static boolean[][] board;

    private static void dfs(int col) {
        if (col == N) {
            cnt++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (checkBoard(i, col)) {
                board[i][col] = true;
                dfs(col + 1);
                board[i][col] = false;
            }
        }
    }

    private static boolean checkBoard(int startR, int startC) {
        for (int k = 0; k < 3; k++) {
            int r = startR + dRow[k];
            int c = startC + dCol[k];
            while (r >= 0 && c >= 0 && r <= N - 1) {
                if (board[r][c]) return false;
                r += dRow[k];
                c += dCol[k];
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine().trim());
        board = new boolean[N][N];

        dfs(0);

        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}