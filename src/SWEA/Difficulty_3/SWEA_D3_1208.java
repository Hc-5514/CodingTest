/**
 * 문제 : [S/W 문제해결 기본] 1일차 - Flatten 
 *
 * @author Hc-5514
 */

package SWEA.Difficulty_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SWEA_D3_1208 {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> al = new ArrayList<>();

		for (int tc = 1; tc <= 10; tc++) {

			al.clear();

			// N: 덤프 가능 횟수, height: 평탄화 후 최고점과 최저점의 높이차
			int N = sc.nextInt();
			int sum = 0, avg;

			for (int i = 0; i < 100; i++) {
				int height = sc.nextInt();
				al.add(height);
				sum += height;
			}

			avg = (int) Math.floor(sum / 100);

			// N번 만큼 덤프 시작
			Collections.sort(al);
			for (int i = N; i > 0; i--) {

				// 평탄화가 완료되면 종료
				if (al.get(0) == avg) {
					break;
				}

				al.set(0, al.get(0) + 1);
				al.set(99, al.get(99) - 1);

				Collections.sort(al);
			}

			// 결과 출력
			System.out.println("#" + tc + " " + (al.get(99) - al.get(0)));
		}
	}

}
