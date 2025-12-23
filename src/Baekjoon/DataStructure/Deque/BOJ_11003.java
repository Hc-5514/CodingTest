/**
 * 문제: 최솟값 찾기
 * 난이도: 플래 5
 * 메모리: 732072KB, 시간: 2468ms
 * 풀이: 자료구조 (Deque)
 */

package Baekjoon.DataStructure.Deque;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_11003 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		Deque<int[]> dq = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {
			int curNum = Integer.parseInt(st.nextToken());
			// 최솟값 인덱스가 현재 인덱스와 l 이상 차이나면 버리기
			if (!dq.isEmpty() && dq.peek()[1] < (i - l + 1)) {
				dq.pollFirst();
			}
			// 현재값 보다 큰 값들은 저장할 필요 x
			while (!dq.isEmpty() && curNum < dq.peekLast()[0]) {
				dq.pollLast();
			}
			dq.offerLast(new int[] {curNum, i});
			bw.write(dq.peek()[0] + " ");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}