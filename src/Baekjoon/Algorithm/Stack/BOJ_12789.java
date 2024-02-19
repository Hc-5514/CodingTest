/**
 * 문제 : 도키도키 간식드리미
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

public class BOJ_12789 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine().trim());
		int[] numArr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
		}

		Stack<Integer> s = new Stack<>();
		int idx = 0;
		int next = 1;
		while (idx < N) {
			if (numArr[idx] == next) {
				idx++;
				next++;
				continue;
			}
			if (!s.isEmpty() && s.peek() == next) {
				s.pop();
				next++;
				continue;
			}
			s.push(numArr[idx]);
			idx++;
		}

		boolean isPossible = true;
		while (!s.isEmpty()) {
			if (s.peek() != next) {
				isPossible = false;
				break;
			}
			s.pop();
			next++;
		}

		if (isPossible) {
			bw.write("Nice\n");
		} else {
			bw.write("Sad\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
