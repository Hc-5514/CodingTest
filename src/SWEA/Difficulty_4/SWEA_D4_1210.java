/**
 * 문제 : [S/W 문제해결 기본] 2일차 - Ladder1
 *
 * @author Hc-5514
 */

package SWEA.Difficulty_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D4_1210 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		for (int tc = 1; tc <= 10; tc++) {

			// tc 번호 받기
			br.readLine();

			int[][] arr = new int[100][100];

			// 도착점 x 좌표
			int col = -1;

			// 사다리 정보 입력받기 (100 x 100 배열)
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (arr[i][j] == 2)
						col = j;
				}
			}

			// 도착점부터 출발점까지 탐색
			int row = 99;
			while (row > 0) {

				// 왼쪽 사다리로 이동이 가능하다면 이동
				if (col - 1 >= 0 && arr[row][col - 1] == 1) {
					while (col - 1 >= 0 && arr[row][col - 1] == 1) {
						col--;
					}
				}
				// 오른쪽 사다리로 이동이 가능하다면 이동
				else if (col + 1 < 100 && arr[row][col + 1] == 1) {
					while (col + 1 < 100 && arr[row][col + 1] == 1) {
						col++;
					}
				}

				// 좌, 우 사다리 이동이 끝났다면 한 칸 위로
				row--;
			}

			sb.append(String.format("#%d %d\n", tc, col));
		}
		System.out.println(sb.toString());
	}

}
