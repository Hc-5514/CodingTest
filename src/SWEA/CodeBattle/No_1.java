/**
 * 문제 : No. 1 새로운 불면증 치료법
 *
 * @author Hc-5514
 */

package SWEA.CodeBattle;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No_1 {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine().trim());
		int total = (1 << 10) - 1; // 모든 숫자가 등장했을 때의 값

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine().trim());
			int visit = 0; // 찾은 숫자들
			int cnt = 0;
			for (cnt = 1; ; cnt++) {
				char[] num = String.valueOf((N * cnt)).toCharArray(); // N * cnt 수를 자릿수 별로 char 배열에 저장
				for (int i = 0; i < num.length; i++) {
					int n = num[i] - '0';
					visit = visit | (1 << n); // 찾은 숫자의 위치를 1로 변경
				}
				if (visit == total) // 모든 숫자를 찾았다면, 종료
					break;
			}
			bw.write("#" + tc + " " + (N * cnt) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
