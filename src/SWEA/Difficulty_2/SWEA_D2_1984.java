/**
 * 문제 : 중간 평균값 구하기
 *
 * @author Hc-5514
 */

package SWEA.Difficulty_2;

import java.util.Scanner;

public class SWEA_D2_1984 {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			int sum = 0;
			int max = 0;
			int min = 10000; // 입력 들어올 수 있는 가장 큰 값

			// 숫자 10개 받기, 최대 최소 값 찾기
			for (int i = 0; i < 10; i++) {

				int n = sc.nextInt();
				max = Math.max(max, n);
				min = Math.min(min, n);
				sum += n;
			}

			// 소수 첫째 자리 반올림
			System.out.println("#" + tc + " " + Math.round((sum - max - min) * 1.0 / 8));
		}
	}

}
