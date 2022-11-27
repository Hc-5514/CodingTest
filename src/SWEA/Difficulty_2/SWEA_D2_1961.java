/**
 * 문제 : 숫자 배열 회전
 *
 * @author Hc-5514
 */

package SWEA.Difficulty_2;

import java.util.Scanner;

public class SWEA_D2_1961 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {

            // N x N 행렬 입력받기
            int N = sc.nextInt();
            int[][] arr = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            // 90도, 180도, 270도 회전 모양 저장할 배열 생성
            int[][] arr90 = new int[N][N];
            int[][] arr180 = new int[N][N];
            int[][] arr270 = new int[N][N];

            // 회전 값 저장
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr90[i][j] = arr[N - 1 - j][i];
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr180[i][j] = arr90[N - 1 - j][i];
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr270[i][j] = arr180[N - 1 - j][i];
                }
            }

            // 값 출력하기
            System.out.println("#" + tc);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(arr90[i][j]);
                }
                System.out.print(" ");
                for (int j = 0; j < N; j++) {
                    System.out.print(arr180[i][j]);
                }
                System.out.print(" ");
                for (int j = 0; j < N; j++) {
                    System.out.print(arr270[i][j]);
                }
                System.out.println();
            }

        }
    }

}
