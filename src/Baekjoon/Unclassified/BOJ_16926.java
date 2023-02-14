/**
 * 문제 : 배열 돌리기 1
 *
 * @author Hc-5514
 */

package Baekjoon.Unclassified;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16926 {

    static StringBuilder sb = new StringBuilder();
    static int[][] arr1, arr2;
    static int N, M, R;

    private static void rotate(int[][] arr1, int rotateCnt) {

        if (rotateCnt == R) {
            return;
        }

        // 회전
        // 배열의 범위를 벗어나거나, 숫자가 있다면 방향 전환
        int cnt = 0; // 방향전환 숫자 4개가 된다면 내부 회전 반복
        int dx = 0, dy = 0;
        int n = 0;
        arr2 = new int[N][M];
        while (n < N * M) {
            // 아래로 채우기
            if (cnt % 4 == 0) {
                if (cnt != 0 && dx == cnt / 4 - 1)
                    dx = dy = cnt / 4;
                // 다음 칸이 배열 범위 밖이거나 숫자가 있다면 방향 전환
                if (dx + 1 == N || arr2[dx + 1][dy] != 0) {
                    cnt++;
                } else {
                    arr2[dx + 1][dy] = arr1[dx][dy];
                    dx++;
                    n++;
                }
            }
            // 오른쪽으로 채우기
            else if (cnt % 4 == 1) {
                // 다음 칸이 배열 범위 밖이거나 숫자가 있다면 방향 전환
                if (dy + 1 == M || arr2[dx][dy + 1] != 0) {
                    cnt++;
                } else {
                    arr2[dx][dy + 1] = arr1[dx][dy];
                    dy++;
                    n++;
                }
            }
            // 위쪽으로 채우기
            else if (cnt % 4 == 2) {
                // 다음 칸이 배열 범위 밖이거나 숫자가 있다면 방향 전환
                if (dx - 1 == -1 || arr2[dx - 1][dy] != 0) {
                    cnt++;
                } else {
                    arr2[dx - 1][dy] = arr1[dx][dy];
                    dx--;
                    n++;
                }
            }
            // 왼쪽으로 채우기
            else if (cnt % 4 == 3) {
                // 다음 칸이 배열 범위 밖이거나 숫자가 있다면 방향 전환
                if (dy - 1 == -1 || arr2[dx][dy - 1] != 0) {
                    cnt++;
                } else {
                    arr2[dx][dy - 1] = arr1[dx][dy];
                    dy--;
                    n++;
                }
            }
        }

        // 반복
        rotate(arr2, rotateCnt + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        // 배열 초기값 입력 받기
        arr1 = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr1[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 배열 회전 시키기
        rotate(arr1, 0);

        // 출력
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                sb.append(arr2[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
