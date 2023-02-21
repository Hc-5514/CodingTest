/**
 * 문제 : 쿼드트리
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1992 {
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int[][] board;

    private static void division(int r, int c, int size) {
        int sum = 0;
        for (int i = r, rEnd = r + size; i < rEnd; i++) {
            for (int j = c, cEnd = c + size; j < cEnd; j++) {
                sum += board[i][j];
            }
        }

        if (sum == size * size) {
            sb.append(1);
        } else if (sum == 0) {
            sb.append(0);
        } else {
            int half = size / 2;
            sb.append("(");
            division(r, c, half);
            division(r, c + half, half);
            division(r + half, c, half);
            division(r + half, c + half, half);
            sb.append(")");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = str.charAt(j) - '0';
            }
        }

        division(0, 0, n);

        System.out.println(sb);
        br.close();
    }

}
