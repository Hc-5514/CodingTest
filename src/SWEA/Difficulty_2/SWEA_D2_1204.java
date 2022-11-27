/**
 * 문제 : [S/W 문제해결 기본] 1일차 - 최빈수 구하기
 *
 * @author Hc-5514
 */

package SWEA.Difficulty_2;

import java.util.Scanner;

public class SWEA_D2_1204 {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt(); // N이 사실상 tc와 동일

			// 1000 명 점수 입력 받기
			int[] arr = new int[101]; // 0~100점 이므로 101개 점수
			for (int i = 0; i < 1000; i++) {
				arr[sc.nextInt()]++;
			}

			// 최빈값 비교
			int max = -1, idx = -1;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] >= max) {
					max = arr[i];
					idx = i;
				}
			}

			System.out.println("#" + tc + " " + idx);
		}
	}

}
