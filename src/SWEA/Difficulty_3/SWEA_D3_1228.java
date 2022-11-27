/**
 * 문제 : [S/W 문제해결 기본] 8일차 - 암호문1
 *
 * @author Hc-5514
 */

package SWEA.Difficulty_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_D3_1228 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st, st1;

		ArrayList<Integer> al = new ArrayList<>();
		int n, idx, num;

		for (int tc = 1; tc <= 10; tc++) {

			al.clear();

			// n개 만큼 숫자를 al에 저장
			n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				al.add(Integer.parseInt(st.nextToken()));
			}

			// 명령어를 n번 수행
			n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), "I");

			for (int i = 0; i < n; i++) {

				st1 = new StringTokenizer(st.nextToken());
				// idx 자리에 num 만큼 숫자 추가
				idx = Integer.parseInt(st1.nextToken());
				num = Integer.parseInt(st1.nextToken());
				for (int j = 0; j < num; j++) {
					al.add(idx + j, Integer.parseInt(st1.nextToken()));
				}
			}

			// 처음 숫자 10개 저장
			sb.append("#").append(tc).append(" ");
			for (int i = 0; i < 10; i++)
				sb.append(al.get(i)).append(" ");
			sb.append("\n");
		}

		System.out.println(sb);
	}

}
