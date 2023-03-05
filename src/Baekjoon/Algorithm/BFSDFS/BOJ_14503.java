/**
 * 문제 : 로봇 청소기
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.BFSDFS;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14503 {

    static int N, M, d, cleanCnt = 0;

    static final int[] dRow = {-1, 0, 1, 0}, dCol = {0, 1, 0, -1};
    static int[][] board;

    private static void bfs(int startR, int startC) {
        // d(로봇 방향) 0: 북, 1: 동, 2: 남, 3: 서
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{startR, startC});
        w1:
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int tmpR = tmp[0];
            int tmpC = tmp[1];
            // 청소가 안 된 경우
            if (board[tmpR][tmpC] == 0) {
                cleanCnt++;
                board[tmpR][tmpC] = -1;
            }
            // 주변 4칸 중 청소 가능한 칸이 있다면
            for (int k = 1; k < 5; k++) {
                int tmpD = d - k < 0 ? d - k + 4 : d - k;
                int r = tmpR + dRow[tmpD];
                int c = tmpC + dCol[tmpD];
                // 배열 범위 확인
                if (r < 0 || c < 0 || r >= N || c >= M) continue;
                if (board[r][c] == 0) {
                    // 1. 반시계 방향 회전
                    d = tmpD;
                    // 2. 앞쪽 칸이 0이라면 전진
                    if (board[r][c] == 0) {
                        q.offer(new int[]{r, c});
                        continue w1;
                    }
                }
            }
            // 주변 4칸 모두 청소 가능한 빈 칸이 없다면
            int r = tmpR + dRow[(d + 2) % 4];
            int c = tmpC + dCol[(d + 2) % 4];
            // 후진을 못 하면 중지
            // 1. 배열 범위 확인
            if (r < 0 || c < 0 || r >= N || c >= M) return;
            // 2. 후진 가능한지 확인 (벽이 아니면 됨)
            if (board[r][c] != 1) {
                q.offer(new int[]{r, c});
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int startR = Integer.parseInt(st.nextToken());
        int startC = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                // 0: 청소 가능한 칸
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(startR, startC);

        bw.write(cleanCnt + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
