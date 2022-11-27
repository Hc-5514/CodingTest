/**
 * 문제 : 달팽이 숫자
 *
 * @author Hc-5514
 */

package SWEA.Difficulty_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_D2_1954 {

    public static int[] dir = {0, 1, 2, 3}; // 오른쪽, 아래쪽, 왼쪽, 위쪽

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            // N x N 배열 생성
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];
            arr[0][0] = 1;

            int idx = 0, count = 2, dx = 0, dy = 0;
            // N x N 배열 껍데기 채우기
            while (count <= N * N) { // N x N 배열을 다 채웠다면 종료

                // 숫자 채우기
                if (dir[idx % 4] == 0) { // dir[] == 0 일 때, dy 증가
                    // 배열 범위를 벗어나거나, 다음 칸의 숫자가 0이 아닐 때 : 방향 전환
                    if (dy + 1 == N || arr[dx][dy + 1] != 0) { // 배열 크기 밖이라면, 방향 전환
                        idx++;
                        continue;
                    }
                    dy++;
                    arr[dx][dy] = count++;
                } else if (dir[idx % 4] == 1) { // dir[] == 1 일 때, dx 증가
                    // 배열 범위를 벗어나거나, 다음 칸의 숫자가 0이 아닐 때 : 방향 전환
                    if (dx + 1 == N || arr[dx + 1][dy] != 0) {
                        idx++;
                        continue;
                    }
                    dx++;
                    arr[dx][dy] = count++;
                } else if (dir[idx % 4] == 2) { // dir[] == 2 일 때, dy 감소
                    // 배열 범위를 벗어나거나, 다음 칸의 숫자가 0이 아닐 때 : 방향 전환
                    if (dy - 1 == -1 || arr[dx][dy - 1] != 0) {
                        idx++;
                        continue;
                    }
                    dy--;
                    arr[dx][dy] = count++;
                } else { // dir[] == 3 일 때, dx 감소
                    // 다음 칸의 숫자가 0이 아닐 때 : 방향 전환
                    if (arr[dx - 1][dy] != 0) {
                        idx++;
                        continue;
                    }
                    dx--;
                    arr[dx][dy] = count++;
                }

            } // end while()

            System.out.printf("#%d\n", tc);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.printf("%d ", arr[i][j]);
                }
                System.out.println();
            }
        }
    }

}
