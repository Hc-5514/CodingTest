/**
 * 문제 : 단어 암기
 * 소요 시간 : 70분
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_18119 {

	// N개의 문자열 (1 <= N <= 10,000, len <= 1,000)
	// M개의 명령어 (1 <= M <= 50,000)
	// 1) 1 a: a를 잊는다.
	// 2) 2 b: b를 기억해낸다.
	// 단어 안에 있는 모든 알파벳을 알 때, 그 단어를 안다고 한다.
	// 초기 상태: 모든 알파벳을 알고 있다.
	// 모음은 절대 잊지 않는다.
	// 완전히 알고 있는 단어 개수 구하기

	// 단어의 개수만 구하면 된다. -> 알파벳 중복 및 모음 (len <= 21)
	// 21 * 10,000 * 50,000 = 10,500,000,000 == 130초 (시간초과)
	// 원본 문자와 현재 문자를 비트마스킹으로 비교

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 원본 문자와 현재 문자를 비트마스킹으로 비교한다.
		int[] oriString = new int[N];
		int[] curString = new int[N];

		for (int i = 0; i < N; i++) {
			// 중복 알파벳 제거, 모음 제거
			Set<Character> set = new HashSet<>();
			String str = br.readLine();
			for (int j = 0; j < str.length(); j++) {
				set.add(str.charAt(j));
			}
			Iterator<Character> iterator = set.iterator();
			while (iterator.hasNext()) {
				char ch = iterator.next();
				if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
					continue;
				}
				oriString[i] += Math.pow(2, (ch - 97));
			}
			curString[i] = oriString[i];
		}

		boolean[] memorise = new boolean[26];
		Arrays.fill(memorise, true);

		int currentCnt = N;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			char ch = st.nextToken().charAt(0);
			int chtoi = ch - 97;
			// 모음은 잊지 않는다.
			if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
				bw.write(currentCnt + "\n");
				continue;
			}
			switch (cmd) {
				case 1:
					// 이미 잊은 알파벳
					if (!memorise[chtoi]) {
						break;
					}
					memorise[chtoi] = false;
					// 해당 알파벳이 포함되어 있다면 삭제
					for (int j = 0; j < N; j++) {
						if ((oriString[j] & (1 << chtoi)) == (1 << chtoi)) {
							curString[j] -= (chtoi);
						}
					}
					break;
				case 2:
					// 이미 기억하고 있는 알파벳
					if (memorise[chtoi]) {
						break;
					}
					memorise[chtoi] = true;
					// 해당 알파벳을 복구한다.
					for (int j = 0; j < N; j++) {
						if ((oriString[j] & (1 << chtoi)) == (1 << chtoi)) {
							curString[j] += (chtoi);
						}
					}
					break;
			}
			// 비트마스킹
			int cnt = 0;
			for (int j = 0; j < N; j++) {
				if (oriString[j] == curString[j]) {
					cnt++;
				}
			}
			currentCnt = cnt;
			bw.write(currentCnt + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
