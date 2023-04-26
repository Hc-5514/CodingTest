/**
 * 문제 : 스티커
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_4;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 알고리즘 분류: DP
 * 풀이 방법: DP
 */
public class BOJ_9465 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] board = new int[n][2];
            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    board[j][i] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] d = new int[n][2];
            d[0][0] = board[0][0];
            d[0][1] = board[0][1];

            if (n >= 2) {
                d[1][0] = board[0][1] + board[1][0];
                d[1][1] = board[0][0] + board[1][1];

                for (int i = 2; i < n; i++) {
                    d[i][0] = Math.max(board[i][0] + d[i - 1][1], board[i][0] + d[i - 2][1]);
                    d[i][1] = Math.max(board[i][1] + d[i - 1][0], board[i][1] + d[i - 2][0]);
                }
            }

            bw.write(Math.max(d[n - 1][0], d[n - 1][1]) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}