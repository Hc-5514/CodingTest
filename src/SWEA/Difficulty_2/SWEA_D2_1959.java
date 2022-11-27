/**
 * 문제 : 두 개의 숫자열
 *
 * @author Hc-5514
 */

package SWEA.Difficulty_2;

import java.util.Scanner;

public class SWEA_D2_1959 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {

            // 두 숫자열 입력 받기
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[] arr1 = new int[N];
            int[] arr2 = new int[M];

            for (int i = 0; i < N; i++) {
                arr1[i] = sc.nextInt();
            }

            for (int i = 0; i < M; i++) {
                arr2[i] = sc.nextInt();
            }

            // 최댓값 구하기
            int max = -100000;
            int tmp;

            if (M > N) {
                for (int i = 0; i <= M - N; i++) {
                    tmp = 0;
                    for (int j = 0; j < N; j++) {
                        tmp += (arr1[j] * arr2[i + j]);
                    }
                    max = Math.max(max, tmp);
                }
            } else {
                for (int i = 0; i <= N - M; i++) {
                    tmp = 0;
                    for (int j = 0; j < M; j++) {
                        tmp += (arr2[j] * arr1[i + j]);
                    }
                    max = Math.max(max, tmp);
                }
            }

            System.out.println("#" + tc + " " + max);
        }

    }

}
