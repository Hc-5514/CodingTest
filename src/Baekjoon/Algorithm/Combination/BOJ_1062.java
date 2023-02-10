/**
 * 문제 : 가르침
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class BOJ_1062 {

	static int N, K, maxCnt = 0;
	static String[] arrStr;
	static HashSet<Character> hs = new HashSet<>();
	static char[] arrHashSet;
	static char[] isSelected;

	private static void getAlpa() {

		// 단어의 알파벳 중복 제거 후 저장
		for (int i = 0; i < arrStr.length; i++) {
			for (int j = 0; j < arrStr[i].length(); j++) {
				// a, n, t, i, c는 기본으로 선택되므로 추가 필요 x
				if (arrStr[i].charAt(j) != 'a' && arrStr[i].charAt(j) != 'n' && arrStr[i].charAt(j) != 't'
						&& arrStr[i].charAt(j) != 'i' && arrStr[i].charAt(j) != 'c')
					hs.add(arrStr[i].charAt(j));
			}
		}

		// arrHashSet 배열에 HashSet hs의 값 저장
		arrHashSet = new char[hs.size()];
		Iterator<Character> it = hs.iterator();
		int idx = 0;
		while (it.hasNext())
			arrHashSet[idx++] = it.next();
	}

	// cnt: 현재 알파벳 개수
	private static void checkWord(int cnt, int start) {

		// 만들 수 있는 단어의 개수
		int tmpMaxCount = 0;

		// K개의 알파벳만큼 뽑았다면 만들 수 있는 단어 최대 개수 확인
		if (cnt == K) {
			// 단어 개수만큼 확인
			for (int i = 0; i < arrStr.length; i++) {
				// 단어의 알파벳이 저장된 알파벳에 모두 포함되었다면 count
				int tmpCnt = 0;
				for (int j = 0; j < arrStr[i].length(); j++) {
					for (int k = 0; k < isSelected.length; k++) {
						if (arrStr[i].charAt(j) == isSelected[k]) {
							tmpCnt++;
							break;
						}
					}
				}
				if (tmpCnt == arrStr[i].length())
					tmpMaxCount++;
			}
			maxCnt = Math.max(maxCnt, tmpMaxCount);
			return;
		}

		// K개의 알파벳 배열 만들기
		for (int i = start; i < arrHashSet.length; i++) {

			if (K >= arrHashSet.length + 5) {
				maxCnt = N;
				return;
			}
			isSelected[cnt] = arrHashSet[i];
			checkWord(cnt + 1, i + 1);
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// N: 단어의 개수, K: 알파벳 개수
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		isSelected = new char[K];

		// 단어 저장할 배열 만들기
		// anta, tica 제거 후 단어 반환
		arrStr = new String[N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			arrStr[i] = str.substring(4, str.length() - 4);
		}

		// test code
//		System.out.println(Arrays.toString(arrStr));

		// anta tica의
		// a, n, t, i, c 를 저장하려면 K는 5이상 이어야 한다.
		// 5보다 작다면 단어를 만들 수 없다.
		if (K < 5) {
			maxCnt = 0;
		} else if (K == 5) {
			// antatica의 개수 + a,n,t,i,c만으로 이루어진 단어의 개수 추가 해야됨
			f1: for (int i = 0; i < N; i++) {
				for (int j = 0; j < arrStr[i].length(); j++) {
					if (arrStr[i].charAt(j) != 'a' && arrStr[i].charAt(j) != 'n' && arrStr[i].charAt(j) != 't'
							&& arrStr[i].charAt(j) != 'i' && arrStr[i].charAt(j) != 'c')
						continue f1;
				}
				maxCnt++;
			}
		} else {
			// 입력 받은 단어의 알파벳 확인
			getAlpa();

			// k개의 알파벳으로 만들 수 있는 최대 단어 수 확인
			// a, n, t, i, c 는 기본으로 선택
			isSelected[0] = 'a';
			isSelected[1] = 'n';
			isSelected[2] = 't';
			isSelected[3] = 'i';
			isSelected[4] = 'c';
			checkWord(5, 0);

		}

		// 출력
		System.out.println(maxCnt);
		br.close();
	}

}
