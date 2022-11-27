/**
 * 문제 : 수도 요금 경쟁
 *
 * @author Hc-5514
 */

package SWEA.Difficulty_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D2_1284 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {

			// 수도 정보 받기
			String str = br.readLine();
			st = new StringTokenizer(str);

			int P = Integer.parseInt(st.nextToken()); // P: A사 1리터 당 요금
			int Q = Integer.parseInt(st.nextToken()); // Q: B사 R리터 이하 요금
			int R = Integer.parseInt(st.nextToken()); // R: B사 기본 요금 기준
			int S = Integer.parseInt(st.nextToken()); // S: B사 기본 요금 초과 1리터 당 요금
			int W = Integer.parseInt(st.nextToken()); // W: 사용한 수도의 양

			// A: A사 이용료, B: B사 이용료
			int A = P * W; // A사 요금

			int B;
			if (W <= R) { // 사용한 수도 양이 B사 기본료 기준 이하라면,
				B = Q;
			} else { // 사용한 수도 양이 B사 기본료 기준보다 크다면,
				B = Q + (W - R) * S;
			}

			System.out.printf("#%d %d\n", tc, Math.min(A,B));
		}
	}

}
