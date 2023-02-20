/**
 * 문제 : 색종이 만들기
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2630 {

    static int blueCnt, whiteCnt;

    static int[][] board;

    private static void division(int r, int c, int size) {

        int sum = 0;
        for (int i = r, rEnd = r + size; i < rEnd; i++) {
            for (int j = c, cEnd = c + size; j < cEnd; j++) {
                if (board[i][j] == 1)
                    sum++;
            }
        }

        // 영역이 모두 파란색일 때
        if (sum == size * size) {
            blueCnt++;
        }
        // 영역이 모두 하얀색일 때
        else if (sum == 0) {
            whiteCnt++;
        }
        // 섞였다면 4분할
        else {
            int half = size / 2;
            division(r, c, half);
            division(r, c + half, half);
            division(r + half, c, half);
            division(r + half, c + half, half);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // n x n 영역에 색종이 정보 입력
        int n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 분할 정복
        division(0, 0, n);

        System.out.println(whiteCnt + "\n" + blueCnt);
        br.close();
    }
}
