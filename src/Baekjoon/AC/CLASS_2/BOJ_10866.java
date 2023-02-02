/**
 * 문제 : 덱
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_10866 {

	public static List<Integer> deque = new ArrayList<>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
			case "push_front":
				push_front(Integer.parseInt(st.nextToken()));
				break;
			case "push_back":
				push_back(Integer.parseInt(st.nextToken()));
				break;
			case "pop_front":
				sb.append(pop_front()).append("\n");
				break;
			case "pop_back":
				sb.append(pop_back()).append("\n");
				break;
			case "size":
				sb.append(size()).append("\n");
				break;
			case "empty":
				sb.append(empty()).append("\n");
				break;
			case "front":
				sb.append(front()).append("\n");
				break;
			case "back":
				sb.append(back()).append("\n");
				break;
			default:
				break;
			}
		}
		System.out.println(sb);
		br.close();
	}

	public static void push_front(int x) {
		deque.add(0, x);
	}

	public static void push_back(int x) {
		deque.add(deque.size(), x);
	}

	public static int pop_front() {
		if (deque.size() == 0) {
			return -1;
		} else {
			int x = deque.get(0);
			deque.remove(0);
			return x;
		}
	}

	public static int pop_back() {
		if (deque.size() == 0) {
			return -1;
		} else {
			int x = deque.get(deque.size() - 1);
			deque.remove(deque.size() - 1);
			return x;
		}
	}

	public static int size() {
		return deque.size();
	}

	public static int empty() {
		if (deque.isEmpty()) {
			return 1;
		} else
			return 0;

	}

	public static int front() {
		if (deque.isEmpty()) {
			return -1;
		} else
			return deque.get(0);

	}

	public static int back() {
		if (deque.isEmpty()) {
			return -1;
		} else
			return deque.get(deque.size() - 1);

	}
}
