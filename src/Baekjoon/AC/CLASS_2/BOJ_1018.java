/**
 * 문제 : 체스판 다시 칠하기
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1018 {

    static boolean[][] arr;
    static int min = 64;

    public static void board(int n, int m) {

        int count = 0;
        boolean color = arr[0][0]; // 첫 번째 칸의 색
        for (int i = n; i < n + 8; i++) { // 8x8 크기 보드
            for (int j = m; j < m + 8; j++) {
                if (arr[i][j] != color) { // 올바른 색이 아니라면, 1증가
                    count++;
                }
                color = !color; // 다음 칸은 색이 바뀌므로, true, false 값 변경
            }
            color = !color;
        }

        count = Math.min(count, 64 - count); // 첫 번째 칸의 색이 흑 or 백이므로 2가지 비교
        min = Math.min(min, count); // 보드 최소값 갱신
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N x M 보드판 생성
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new boolean[N][M];

        // 보드판 값 입력
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j) == 'W';
            }
        }

        // 개수 세리기
        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                board(i, j);
            }
        }

        System.out.println(min);
    }
}
