/**
 * 문제 : 2048 (Easy)
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_5;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_12100 {

    private static int ans;

    private static void dfs(int depth, int[][] board, int max) {
        if (depth == 5) {
            ans = Math.max(ans, max);
            return;
        }

        // 블록의 최대 합을 구하는 문제, 이동 한 번에 2배까지 가능
        // 가지치기: 현재 최댓값 * (2^남은 이동 횟수) <= max
        if (max * Math.pow(2, 5 - depth) <= ans) {
            return;
        }

        // 상 이동
        int[][] copyBoard = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            copyBoard[i] = Arrays.copyOf(board[i], board[i].length);
        }
        int curMax = moveTop(copyBoard, max);
        dfs(depth + 1, copyBoard, curMax);

        // 하 이동
        copyBoard = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            copyBoard[i] = Arrays.copyOf(board[i], board[i].length);
        }
        curMax = moveDown(copyBoard, max);
        dfs(depth + 1, copyBoard, curMax);

        // 좌 이동
        copyBoard = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            copyBoard[i] = Arrays.copyOf(board[i], board[i].length);
        }
        curMax = moveLeft(copyBoard, max);
        dfs(depth + 1, copyBoard, curMax);

        // 우 이동
        copyBoard = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            copyBoard[i] = Arrays.copyOf(board[i], board[i].length);
        }
        curMax = moveRight(copyBoard, max);
        dfs(depth + 1, copyBoard, curMax);
    }

    public static int moveTop(int[][] board, int max) {
        // 모든 열에 대하여 이동
        for (int j = 0; j < board[0].length; j++) {
            int idx = 0; // 블록을 이동시킬 위치
            int i = 1;
            while (i < board.length && idx < board.length) {
                // 빈 칸 skip
                if (board[i][j] == 0) {
                    i++;
                    continue;
                }
                // 두 칸의 값 비교
                if (board[idx][j] == board[i][j]) {
                    board[idx][j] *= 2;
                    board[i][j] = 0;
                    max = Math.max(max, board[idx][j]);
                    idx++;
                    i++;
                    continue;
                }
                // 빈 칸이라면
                if (board[idx][j] == 0) {
                    board[idx][j] = board[i][j];
                    board[i][j] = 0;
                    i++;
                } else {
                    idx++;
                    if (idx == i) {
                        i++;
                    }
                }
            }
        }
        return max;
    }

    public static int moveDown(int[][] board, int max) {
        // 모든 열에 대하여 이동
        for (int j = 0; j < board[0].length; j++) {
            int idx = board.length - 1; // 블록을 이동시킬 위치
            int i = board.length - 2;
            while (i >= 0 && idx >= 0) {
                // 빈 칸 skip
                if (board[i][j] == 0) {
                    i--;
                    continue;
                }
                // 두 칸의 값 비교
                if (board[idx][j] == board[i][j]) {
                    board[idx][j] *= 2;
                    board[i][j] = 0;
                    max = Math.max(max, board[idx][j]);
                    idx--;
                    i--;
                    continue;
                }
                // 빈 칸이라면
                if (board[idx][j] == 0) {
                    board[idx][j] = board[i][j];
                    board[i][j] = 0;
                    i--;
                } else {
                    idx--;
                    if (idx == i) {
                        i--;
                    }
                }
            }
        }
        return max;
    }

    public static int moveLeft(int[][] board, int max) {
        // 모든 행에 대하여 이동
        for (int i = 0; i < board.length; i++) {
            int idx = 0; // 블록을 이동시킬 위치
            int j = 1;
            while (j < board.length && idx < board.length) {
                // 빈 칸 skip
                if (board[i][j] == 0) {
                    j++;
                    continue;
                }
                // 두 칸의 값 비교
                if (board[i][idx] == board[i][j]) {
                    board[i][idx] *= 2;
                    board[i][j] = 0;
                    max = Math.max(max, board[i][idx]);
                    idx++;
                    j++;
                    continue;
                }
                // 빈 칸이라면
                if (board[i][idx] == 0) {
                    board[i][idx] = board[i][j];
                    board[i][j] = 0;
                    j++;
                } else {
                    idx++;
                    if (idx == j) {
                        j++;
                    }
                }
            }
        }
        return max;
    }

    public static int moveRight(int[][] board, int max) {
        // 모든 행에 대하여 이동
        for (int i = 0; i < board.length; i++) {
            int idx = board[i].length - 1; // 블록을 이동시킬 위치
            int j = board[i].length - 2;
            while (j >= 0 && idx >= 0) {
                // 빈 칸 skip
                if (board[i][j] == 0) {
                    j--;
                    continue;
                }
                // 두 칸의 값 비교
                if (board[i][idx] == board[i][j]) {
                    board[i][idx] *= 2;
                    board[i][j] = 0;
                    max = Math.max(max, board[i][idx]);
                    idx--;
                    j--;
                    continue;
                }
                // 빈 칸이라면
                if (board[i][idx] == 0) {
                    board[i][idx] = board[i][j];
                    board[i][j] = 0;
                    j--;
                } else {
                    idx--;
                    if (idx == j) {
                        j--;
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // N * N 보드 입력 받기
        int N = Integer.parseInt(br.readLine().trim()); // 1 <= N <= 20
        int[][] board = new int[N][N];
        int max = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, board[i][j]);
            }
        }

        // 4의 5제곱 = 2의 10제곱 = 1024
        dfs(0, board, max);

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
