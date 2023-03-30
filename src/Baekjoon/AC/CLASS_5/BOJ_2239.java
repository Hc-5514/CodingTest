/**
 * 문제 : 스도쿠
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_5;

import java.io.*;

public class BOJ_2239 {

    static int[][] board;
    static boolean isSuccess;

    static StringBuilder sb = new StringBuilder();

    private static void checkBoard(int r, int c) {
        if (isSuccess) return;

        if (r >= 9) {
            isSuccess = true;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(board[i][j]);
                }
                sb.append("\n");
            }
            return;
        }

        if (c >= 9) {
            checkBoard(r + 1, 0);
            return;
        }

        if (board[r][c] != 0) {
            checkBoard(r, c + 1);
            return;
        }

        // 0이라면 값을 채워야 한다.
        for (int i = 1; i <= 9; i++) {
            if (!checkRow(r, i)) continue;
            if (!checkCol(c, i)) continue;
            if (!checkSquare(r, c, i)) continue;
            board[r][c] = i;
            checkBoard(r, c + 1);
            board[r][c] = 0;
        }
    }

    private static boolean checkRow(int r, int n) {
        for (int i = 0; i < 9; i++) {
            if (board[r][i] == n) return false;
        }
        return true;
    }

    private static boolean checkCol(int c, int n) {
        for (int i = 0; i < 9; i++) {
            if (board[i][c] == n) return false;
        }
        return true;
    }

    private static boolean checkSquare(int row, int col, int n) {
        int r = row / 3;
        int c = col / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[r * 3 + i][c * 3 + j] == n) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        board = new int[9][9];
        for (int i = 0; i < 9; i++) {
            String str = br.readLine();
            for (int j = 0; j < 9; j++) {
                board[i][j] = str.charAt(j) - '0';
            }
        }

        checkBoard(0, 0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}