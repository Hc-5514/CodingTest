/**
 * 문제 : 벽 부수고 이동하기
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_4;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206 {

    static int N, M, minLen = Integer.MAX_VALUE;
    static int[] dRow = {-1, 1, 0, 0}, dCol = {0, 0, -1, 1};
    static int[][] board;
    static boolean[][][] visit;

    static class Road {
        int r;
        int c;
        int len;
        int flag;

        public Road(int r, int c, int len, int flag) {
            this.r = r;
            this.c = c;
            this.len = len;
            this.flag = flag;
        }
    }

    private static void bfs() {
        Queue<Road> q = new ArrayDeque<>();
        q.offer(new Road(0, 0, 1, 0));
        visit[0][0][0] = true;
        while (!q.isEmpty()) {
            Road cur = q.poll();
            // 목적지 도착
            if (cur.r == N - 1 && cur.c == M - 1) {
                if (cur.len < minLen) minLen = cur.len;
                return;
            }
            // 최단 경로보다 오래 걸리면 더 이상 탐색 필요 x
            if (cur.len >= minLen) continue;
            for (int k = 0; k < 4; k++) {
                int r = cur.r + dRow[k];
                int c = cur.c + dCol[k];
                // 배열 범위 확인
                if (r < 0 || c < 0 || r >= N || c >= M) continue;
                // 벽 확인
                if (board[r][c] == 0 && !visit[r][c][cur.flag]) {
                    q.offer(new Road(r, c, cur.len + 1, cur.flag));
                    visit[r][c][cur.flag] = true;
                } else {
                    // 벽을 부순 적이 없다면, 부순다.
                    if (cur.flag == 0 && !visit[r][c][1]) {
                        q.offer(new Road(r, c, cur.len + 1, 1));
                        visit[r][c][1] = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visit = new boolean[N][M][2];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j) - '0';
            }
        }

        bfs();

        if (minLen == Integer.MAX_VALUE)
            bw.write(-1 + "\n");
        else bw.write(minLen + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}