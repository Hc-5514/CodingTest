/**
 * 문제 : Brainf**k 인터프리터
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_3954 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine().trim());
		for (int tc = 0; tc < t; tc++) {
			st = new StringTokenizer(br.readLine());
			int sm = Integer.parseInt(st.nextToken()); // 배열 크기 (0 <= sm <= 100,000)
			int sc = Integer.parseInt(st.nextToken()); // 코드 크기 (0 < sc < 4,096)
			int si = Integer.parseInt(st.nextToken()); // 입력 크기 (0 < si < 4,096)

			int[] arr = new int[sm];
			char[] codes = br.readLine().toCharArray(); // 크기: sc
			char[] inputs = br.readLine().toCharArray(); // 크기: si

			int p = 0; // 배열 포인터
			int ip = 0; // 입력 인덱스

			// '['와 ']'의 위치를 저장
			Stack<Integer> s = new Stack<>();
			int[] sBracket = new int[sc];
			int[] eBracket = new int[sc];
			for (int i = 0; i < sc; i++) {
				if (codes[i] == '[') {
					s.push(i);
				}
				if (codes[i] == ']') {
					int idx = s.pop();
					sBracket[idx] = i;
					eBracket[i] = idx;
				}
			}

			// 명령어 수행
			int cnt = 0;
			int endLoopIdx = 0;
			for (int i = 0; i < sc; i++) {
				switch (codes[i]) {
					case '-':
						arr[p] = (arr[p] + 255) % 256;
						break;
					case '+':
						arr[p] = (arr[p] + 1) % 256;
						break;
					case '<':
						p = (p + sm - 1) % sm;
						break;
					case '>':
						p = (p + 1) % sm;
						break;
					case '[':
						// arr[p] == 0: '['와 짝을 이루는 ']'의 다음 명령으로 점프
						if (arr[p] == 0) {
							i = sBracket[i];
						}
						break;
					case ']':
						// arr[p] !=0: ']'와 짝을 이루는 '['의 다음 명령으로 점프
						if (arr[p] != 0) {
							// 5천만 번 이상 수행 됐을 때, 가장 큰 루프의 범위를 찾는다.
							if (cnt > 50_000_000) {
								endLoopIdx = Math.max(endLoopIdx, i);
							}
							i = eBracket[i];
						}
						break;
					case '.':
						// 포인터가 가리키는 수 출력 (출력 무시)
						break;
					case ',':
						arr[p] = ip < si ? inputs[ip++] : 255;
						break;
					default:
						continue;
				}
				cnt++;
				if (cnt > 100_000_000) {
					break;
				}
			}
			if (cnt > 50_000_000) {
				bw.write("Loops " + eBracket[endLoopIdx] + " " + endLoopIdx + "\n");
			} else {
				bw.write("Terminates\n");
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}
}