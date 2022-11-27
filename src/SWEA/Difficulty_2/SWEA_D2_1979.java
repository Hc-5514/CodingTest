/**
 * 문제 : 어디에 단어가 들어갈 수 있을까
 *
 * @author Hc-5514
 */

package SWEA.Difficulty_2;

import java.util.Scanner;

public class SWEA_D2_1979 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {

            // N x N 퍼즐 arr, K: 단어의 길이
            int N = sc.nextInt();
            int[][] arr = new int[N][N];
            int K = sc.nextInt();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            int answer = 0;
            // 가로 탐색
            for (int i = 0; i < N; i++) {
                int cnt = 0;
                for (int j = 0; j < N; j++) {

                    // 현재 칸이 흰색이라면
                    if (arr[i][j] == 1) {
                        cnt++;
                        // 현재 칸이 마지막 칸이라면,
                        if (j == N - 1 && cnt == K) {
                            answer++;
                        }
                    }
                    // 현재 칸이 검은색이라면
                    else {
                        // 앞의 연속된 흰색 칸이 K개 일 때
                        if (cnt == K) {
                            answer++;
                        }
                        cnt = 0;
                    }
                }
            }
            // 세로 탐색
            for (int i = 0; i < N; i++) {
                int cnt = 0;
                for (int j = 0; j < N; j++) {

                    // 현재 칸이 흰색이라면
                    if (arr[j][i] == 1) {
                        cnt++;
                        // 현재 칸이 마지막 칸이라면,
                        if (j == N - 1 && cnt == K) {
                            answer++;
                        }
                    }
                    // 현재 칸이 검은색이라면
                    else {
                        // 앞의 연속된 흰색 칸이 K개 일 때
                        if (cnt == K) {
                            answer++;
                        }
                        cnt = 0;
                    }
                }
            }

            System.out.println("#" + tc + " " + answer);
        }
    }

}
