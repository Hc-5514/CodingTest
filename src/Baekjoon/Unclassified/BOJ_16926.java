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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        // 배열 초기값 입력 받기
        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 배열 회전 시키기
        int cnt = Math.min(N, M) / 2;
        // R번 회전
        for (int i = 0; i < R; i++) {
            // 라인 화전
            for (int j = 0; j < cnt; j++) {
                int tmp = arr[j][j];

                // ←
                for (int k = j + 1; k < M - j; k++) {
                    arr[j][k - 1] = arr[j][k];
                }

                // ↑
                for (int k = j + 1; k < N - j; k++) {
                    arr[k - 1][M - 1 - j] = arr[k][M - 1 - j];
                }

                // →
                for (int k = M - 2 - j; k >= j; k--) {
                    arr[N - 1 - j][k + 1] = arr[N - 1 - j][k];
                }

                // ↓
                for (int k = N - j - 2; k >= j; k--) {
                    arr[k + 1][j] = arr[k][j];
                }

                arr[j + 1][j] = tmp;
            }
        }

        // 출력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
