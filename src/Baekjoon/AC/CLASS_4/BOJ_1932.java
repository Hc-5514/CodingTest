/**
 * 문제 : 정수 삼각형
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_4;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 알고리즘 분류: DP
 * 풀이 알고리즘: DP
 * [시간 복잡도]
 * O(N²)
 */
public class BOJ_1932 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine().trim());
        int[][] board = new int[n][n];
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        result[0][0] = board[0][0];
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j <= i; j++) {
                result[i + 1][j] = Math.max(result[i + 1][j], result[i][j] + board[i + 1][j]);
                result[i + 1][j + 1] = Math.max(result[i + 1][j + 1], result[i][j] + board[i + 1][j + 1]);
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, result[n - 1][i]);
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}