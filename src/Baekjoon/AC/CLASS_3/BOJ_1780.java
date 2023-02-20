/**
 * 문제 : 종이의 개수
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1780 {

    static int[] num = new int[3];

    static int[][] board;

    private static void division(int r, int c, int size) {

        int[] sum = new int[3];
        for (int i = r, rEnd = r + size; i < rEnd; i++) {
            for (int j = c, cEnd = c + size; j < cEnd; j++) {
                if (board[i][j] == -1) sum[0]++;
                else if (board[i][j] == 0) sum[1]++;
                else sum[2]++;
            }
        }

        if (sum[0] == size * size) {
            num[0]++;
        } else if (sum[1] == size * size) {
            num[1]++;
        } else if (sum[2] == size * size) {
            num[2]++;
        } else {
            int divSize = size / 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    division(r + i * divSize, c + j * divSize, divSize);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // n x n 영역 숫자 입력
        int n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        division(0, 0, n);

        sb.append(num[0]).append("\n");
        sb.append(num[1]).append("\n");
        sb.append(num[2]).append("\n");
        System.out.println(sb);
        br.close();
    }
}
