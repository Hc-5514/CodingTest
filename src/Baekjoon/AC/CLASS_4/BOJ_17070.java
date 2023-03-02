/**
 * 문제 : 파이프 옮기기 1
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_4;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17070 {

    static int N, totalCnt = 0;
    static int[][] board;
    static Queue<int[]> q = new ArrayDeque<>();

    private static void bfs() {
        // [0]: r, [1]: c, [2]: d(방향)
        // q에는 파이프의 끝 부분 좌표를 저장
        q.offer(new int[]{0, 1, 0});
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            // (N-1,N-1)에 도착했다면 카운트
            if (tmp[0] == N - 1 && tmp[1] == N - 1) {
                totalCnt++;
                continue;
            }

            if (tmp[2] == 0) { // 가로
                isPossible(tmp[0], tmp[1], 0);
                isPossible(tmp[0], tmp[1], 2);
            } else if (tmp[2] == 1) { // 세로
                isPossible(tmp[0], tmp[1], 1);
                isPossible(tmp[0], tmp[1], 2);
            } else { // 대각선
                isPossible(tmp[0], tmp[1], 0);
                isPossible(tmp[0], tmp[1], 1);
                isPossible(tmp[0], tmp[1], 2);
            }
        }
    }

    private static void isPossible(int r, int c, int d) {
        // cmd 0: 가로, cmd 1: 세로, cmd 2: 대각선
        // 배열 범위, 설치된 벽 있는지 확인
        switch (d) {
            case 0:
                if (c + 1 >= N || board[r][c + 1] == 1) return;
                q.offer(new int[]{r, c + 1, d});
                break;
            case 1:
                if (r + 1 >= N || board[r + 1][c] == 1) return;
                q.offer(new int[]{r + 1, c, d});
                break;
            case 2:
                if (c + 1 >= N || r + 1 >= N || board[r][c + 1] == 1 || board[r + 1][c] == 1 || board[r + 1][c + 1] == 1)
                    return;
                q.offer(new int[]{r + 1, c + 1, d});
                break;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();

        bw.write(totalCnt + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}