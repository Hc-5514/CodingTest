/**
 * 문제 : [S/W 문제해결 기본] 5일차 - Magnetic
 *
 * @author Hc-5514
 */

package SWEA.Difficulty_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D3_1220 {

	static int[][] arr = new int[100][100];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int tc = 1; tc <= 10; tc++) {

			br.readLine(); // 불필요한 테케 번호 버리기

			// 100 x 100 테이블 입력 받기
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int count = 0;

			// 교착 상태 개수 구하기
			for (int col = 0; col < 100; col++) {
				for (int row = 0; row < 99; row++) {

					// 1은 결국 내려가므로, 1을 만나더라도 무시하고 내려간다.
					// 2는 결국 올라가므로, 올릴 필요가 없다.
					// 테이블 범위 내에서 1을 내리다가 2를 만나면 count 한다.
					if (arr[row][col] == 1) {
						// row가 테이블 범위를 벗어나거나, 2를 만나면 종료
						while (++row < 100 && arr[row][col] != 2) {
							// row 1씩 증가됨
						}
						// row가 범위를 벗어나지 않았다면, 2를 만나 교착이 된 상태
						if (row != 100) {
							count++;
						}
					}
				}
			}

			System.out.println("#" + tc + " " + count);
		}

	}

}
