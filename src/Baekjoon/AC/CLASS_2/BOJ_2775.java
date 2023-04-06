/**
 * 문제 : 부녀회장이 될테야
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_2;

import java.io.*;

public class BOJ_2775 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] board;

        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            int k = Integer.parseInt(br.readLine().trim());
            int n = Integer.parseInt(br.readLine().trim());

            board = new int[k + 1][n + 1];
            for (int i = 0; i <= k; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i == 0) {
                        board[i][j] = j;
                    } else {
                        board[i][j] = board[i - 1][j] + board[i][j - 1];
                    }
                }
            }

            bw.write(board[k][n] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}