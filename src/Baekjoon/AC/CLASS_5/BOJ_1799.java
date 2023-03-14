/**
 * 문제 : 비숍
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_5;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1799 {

    static int N, maxCnt1, maxCnt2;
    static final int[] dRow = {-1, -1, 1, 1}, dCol = {-1, 1, -1, 1};
    static int[][] board;
    static boolean[][] visit;

    private static void dfs(int r, int c, int cnt) {
        if (r >= N) {
            if (c % 2 == 0 && maxCnt1 < cnt)
                maxCnt1 = cnt;
            else if (c % 2 == 1 && maxCnt2 < cnt)
                maxCnt2 = cnt;
            return;
        }

        // 열 범위 체크
        if (c >= N) {
            if (c % 2 == 0)
                dfs(r + 1, 1, cnt);
            else
                dfs(r + 1, 0, cnt);
            return;
        }
        // 비숍을 놓을 수 있는지 확인: 대각선 이동
        if (board[r][c] == 1) {
            if (checkBoard(r, c)) {
                visit[r][c] = true;
                dfs(r, c + 2, cnt + 1);
                visit[r][c] = false;
            }
        }
        dfs(r, c + 2, cnt);
    }

    private static boolean checkBoard(int r, int c) {
        for (int k = 0; k < 4; k++) {
            int row = r + dRow[k];
            int col = c + dCol[k];
            // 배열 범위 확인
            while (row >= 0 && col >= 0 && row < N && col < N) {
                if (visit[row][col]) return false;
                row += dRow[k];
                col += dCol[k];
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine().trim());
        board = new int[N][N];
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0);
        dfs(0, 1, 0);

        bw.write(maxCnt1 + maxCnt2 + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}