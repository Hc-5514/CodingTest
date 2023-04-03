/**
 * 문제 : 키 순서
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.FloydWarshall;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2458 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] board1 = new int[N][N];
        int[][] board2 = new int[N][N];

        int INF = N * 100 + 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    board1[i][j] = 0;
                    board2[i][j] = 0;
                } else {
                    board1[i][j] = INF;
                    board2[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            board1[a][b] = 1;
            board2[b][a] = 1;
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    board1[i][j] = Math.min(board1[i][j], board1[i][k] + board1[k][j]);
                    board2[i][j] = Math.min(board2[i][j], board2[i][k] + board2[k][j]);
                }
            }
        }

        int cnt = 0;
        f1:
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                if ((board1[i][j] == INF) && (board2[i][j] == INF)) continue f1;
            }
            cnt++;
        }

        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}