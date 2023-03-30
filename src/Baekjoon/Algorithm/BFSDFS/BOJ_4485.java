/**
 * 문제 : 녹색 옷 입은 애가 젤다지?
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.BFSDFS;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_4485 {

    static int N;

    static final int[] dRow = {-1, 1, 0, 0,}, dCol = {0, 0, -1, 1};
    static int[][] board;

    static boolean[][] visit;

    private static int bfs() {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        pq.add(new int[]{0, 0, board[0][0]});
        while (!pq.isEmpty()) {
            int[] tmp = pq.poll();
            if (tmp[0] == N - 1 && tmp[1] == N - 1) return tmp[2];

            for (int k = 0; k < 4; k++) {
                int r = tmp[0] + dRow[k];
                int c = tmp[1] + dCol[k];
                if (r < 0 || c < 0 || r >= N || c >= N) continue;
                if (visit[r][c]) continue;
                pq.offer(new int[]{r, c, tmp[2] + board[r][c]});
                visit[r][c] = true;
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = 0;
        while (true) {
            T++;
            N = Integer.parseInt(br.readLine().trim());
            if (N == 0) break;
            board = new int[N][N];
            visit = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int minValue = bfs();
            bw.write("Problem " + T + ": " + minValue + "\n");
        }

        bw.write("");
        bw.flush();
        bw.close();
        br.close();
    }
}