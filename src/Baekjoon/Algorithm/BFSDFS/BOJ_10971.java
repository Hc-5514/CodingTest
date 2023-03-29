/**
 * 문제 : 외판원 순회 2
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.BFSDFS;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10971 {

    static int N, min = Integer.MAX_VALUE;
    static int[][] board;

    static boolean[] visit;

    private static void dfs(int depth, int loc, int total) {
        if (depth == N - 1) {
            if (board[loc][0] != 0) {
                min = Math.min(min, total + board[loc][0]);
            }
            return;
        }

        if (total >= min) return;

        for (int i = 0; i < N; i++) {
            if (board[loc][i] != 0 && !visit[i]) {
                visit[i] = true;
                dfs(depth + 1, i, total + board[loc][i]);
                visit[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine().trim());
        visit = new boolean[N];
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visit[0] = true;
        dfs(0, 0, 0);

        bw.write(min + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}