/**
 * 문제 : 색종이 붙이기
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1720
public class BOJ_17136 {

    static int[][] map;
    static int[] paper = new int[6];
    static int totalCnt = Integer.MAX_VALUE;

    private static void dfs(int r, int c, int cnt) {
        // (0,0) ~ (9,9)
        if (r >= 9 && c > 9) {
            if (cnt < totalCnt) totalCnt = cnt;
            return;
        }

        // 가지치기
        if (cnt >= totalCnt) return;

        // 아래 줄 이동
        if (c > 9) {
            dfs(r + 1, 0, cnt);
            return;
        }

        if (map[r][c] == 1) {
            // 5 x 5부터 1 x 1까지 dfs
            for (int size = 5; size >= 1; size--) {
                // 배열 범위 확인 0 1 2 3 4 5 6 7 8 9
                if (r + size > 10 || c + size > 10) continue;
                // i x i 영역 만큼 색종이를 붙일 수 있는지 확인
                if (paper[size] < 5 && checkPaper(r, c, size)) {
                    setPaper(r, c, size, 0);
                    paper[size]++;
                    dfs(r, c + 1, cnt + 1);
                    setPaper(r, c, size, 1);
                    paper[size]--;
                }
            }
        } else {
            dfs(r, c + 1, cnt);
        }
    }

    private static boolean checkPaper(int r, int c, int size) {
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (map[i][j] == 0) return false;
            }
        }
        return true;
    }

    private static void setPaper(int r, int c, int size, int n) {
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                map[i][j] = n;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 10 x 10 종이 입력
        map = new int[10][10];
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0);

        if (totalCnt == Integer.MAX_VALUE) totalCnt = -1;
        System.out.println(totalCnt);
        br.close();
    }
}