/**
 * 문제 : 테트로미노
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_3;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_14500 {

    static int N, M, maxSum;
    static final int[] dRow = { -1, 1, 0, 0 }, dCol = { 0, 0, -1, 1 };
    static int[][] board;
    static boolean[][] visit;

    private static void dfs(int startR, int startC, int depth, int sum) {
        if (depth == 4) {
            if (maxSum < sum)
                maxSum = sum;
            return;
        }

        for (int k = 0; k < 4; k++) {
            int r = startR + dRow[k];
            int c = startC + dCol[k];
            if (r < 0 || c < 0 || r >= N || c >= M)
                continue;
            if (visit[r][c])
                continue;
            visit[r][c] = true;
            dfs(r, c, depth + 1, sum + board[r][c]);
            visit[r][c] = false;
        }
    }

    private static void edgeCase(int startR, int startC) {
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            sum = board[startR][startC];
            for (int k = 0; k < 4; k++) {
                if (i == k)
                    continue;
                int r = startR + dRow[k];
                int c = startC + dCol[k];
                if (r < 0 || c < 0 || r >= N || c >= M)
                    break;
                sum += board[r][c];
            }
            if (maxSum < sum)
                maxSum = sum;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visit[i][j] = true;
                dfs(i, j, 1, board[i][j]);
                visit[i][j] = false;
                edgeCase(i, j);
            }
        }

        bw.write(maxSum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
