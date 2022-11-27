/**
 * 문제 : [S/W 문제해결 기본] 7일차 - 암호생성기
 *
 * @author Hc-5514
 */

package SWEA.Difficulty_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_D3_1225 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		ArrayList<Integer> al = new ArrayList<>();

		for (int tc = 1; tc <= 10; tc++) {

			br.readLine(); // 테스트 케이스 번호 불필요

			// 숫자 8개 입력 받기
			al.clear();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 8; i++)
				al.add(Integer.parseInt(st.nextToken()));

			// 사이클 반복
			int cnt = -1; // 감소할 숫자
			int n; // 감소될 숫자
			while (true) {

				n = al.get(0);
				n -= (++cnt % 5 + 1);

				// 0보다 작아지거나 0일 경우, 종료
				if (n <= 0) {
					n = 0;
					al.add(n);
					al.remove(0);
					break;
				}

				al.add(n);
				al.remove(0);
			}

			System.out.println("#" + tc + " ");
			for (int i = 0; i < 8; i++) {
				System.out.print(al.get(i) + " ");
			}
			System.out.println();
		}

	}

}
