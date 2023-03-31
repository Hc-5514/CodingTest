/**
 * 문제 : 치즈
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.BFSDFS;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2636 {

    static int N, M;
    static final int[] dRow = {-1, 1, 0, 0}, dCol = {0, 0, -1, 1};
    static int[][] board;
    static boolean[][] visit;

    private static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            for (int k = 0; k < 4; k++) {
                int r = tmp[0] + dRow[k];
                int c = tmp[1] + dCol[k];
                if (r < 0 || c < 0 || r >= N || c >= M) continue;
                if (visit[r][c]) continue;
                visit[r][c] = true;
                if (board[r][c] == 0) {
                    q.offer(new int[]{r, c});
                } else board[r][c] = 0;
            }
        }
    }

    private static int checkBoard() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 1) {
                    cnt++;
                }
            }
        }
        return cnt;
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
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        int time = 0;
        while (true) {
            int cnt = checkBoard();
            list.add(cnt);
            if (cnt == 0) break;
            time++;
            visit = new boolean[N][M];
            bfs();
        }

        bw.write(time + "\n");
        if (list.size() == 0)
            bw.write(0 + "\n");
        else bw.write(list.get(list.size() - 2) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}