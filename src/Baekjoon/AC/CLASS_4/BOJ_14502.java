/**
 * 문제 : 연구소
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_4;

import java.io.*;
import java.util.*;

public class BOJ_14502 {

    static int N, M, maxArea = Integer.MIN_VALUE;
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, 1, -1};
    static int[][] board;

    static ArrayList<int[]> list = new ArrayList<>();

    private static void combination(int depth, int r, int c) {
        if (depth == 3) {
            bfs();
            return;
        }

        if (r >= N) {
            return;
        }

        if (c >= M) {
            combination(depth, r + 1, 0);
            return;
        }

        if (board[r][c] != 0)
            combination(depth, r, c + 1);

        if (board[r][c] == 0) {
            board[r][c] = 3;
            combination(depth + 1, r, c + 1);
            board[r][c] = 0;
            combination(depth, r, c + 1);
        }
    }

    private static void bfs() {
        int[][] copyBoard = new int[N][M];
        for (int i = 0; i < N; i++) {
            copyBoard[i] = Arrays.copyOf(board[i], board[0].length);
        }

        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < list.size(); i++) {
            q.offer(new int[]{list.get(i)[0], list.get(i)[1]});
        }
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            for (int k = 0; k < 4; k++) {
                int r = tmp[0] + dRow[k];
                int c = tmp[1] + dCol[k];
                if (r < 0 || c < 0 || r >= N || c >= M) continue;
                if (copyBoard[r][c] == 0) {
                    q.offer(new int[]{r, c});
                    copyBoard[r][c] = 2;
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyBoard[i][j] == 0) cnt++;
            }
        }

        maxArea = Math.max(maxArea, cnt);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 2)
                    list.add(new int[]{i, j});
            }
        }

        combination(0, 0, 0);

        bw.write(maxArea + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}