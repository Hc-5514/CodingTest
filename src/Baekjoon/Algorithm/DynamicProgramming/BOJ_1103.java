/**
 * 문제 : 게임
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.DynamicProgramming;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1103 {

    static int N, M, max = 1;

    static boolean isRoop = false;

    static final int[] dRow = {-1, 1, 0, 0}, dCol = {0, 0, -1, 1};

    static int[][] dp;

    static char[][] board;

    static boolean[][] visit;

    private static void dfs(int sR, int sC) {
        if (isRoop) return;

        for (int k = 0; k < 4; k++) {
            int r = sR + dRow[k] * (board[sR][sC] - '0');
            int c = sC + dCol[k] * (board[sR][sC] - '0');

            if (r < 0 || c < 0 || r >= N || c >= M) continue;

            if (board[r][c] == 'H') continue;

            if (visit[r][c]) {
                isRoop = true;
                return;
            }

            if (dp[sR][sC] + 1 <= dp[r][c]) continue;

            dp[r][c] = dp[sR][sC] + 1;
            max = Math.max(max, dp[r][c]);
            visit[r][c] = true;
            dfs(r, c);
            visit[r][c] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        dp = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            board[i] = line.toCharArray();
        }

        dp[0][0] = 1;
        visit[0][0] = true;
        dfs(0, 0);

        if (isRoop) bw.write(-1 + "\n");
        else bw.write(max + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}