/**
 * 문제 : DSLR
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_9019 {

	private static int goal;

	private static String bfs(Command command) {
		Set<Integer> set = new HashSet<>(); // 중복수 명령어 수행 방지
		Queue<Command> q = new ArrayDeque<>();
		q.offer(command);
		set.add(command.n);

		while (!q.isEmpty()) {
			Command cur = q.poll();
			if (cur.n == goal) {
				return cur.cmdOrder;
			}

			int result = command(cur.n, 'D');
			if (!set.contains(result)) {
				q.offer(new Command(result, cur.cmdOrder + 'D'));
				set.add(result);
			}

			result = command(cur.n, 'S');
			if (!set.contains(result)) {
				q.offer(new Command(result, cur.cmdOrder + 'S'));
				set.add(result);
			}

			result = command(cur.n, 'L');
			if (!set.contains(result)) {
				q.offer(new Command(result, cur.cmdOrder + 'L'));
				set.add(result);
			}

			result = command(cur.n, 'R');
			if (!set.contains(result)) {
				q.offer(new Command(result, cur.cmdOrder + 'R'));
				set.add(result);
			}
		}
		return "";
	}

	private static int command(int n, char cmd) {
		int result = n;
		switch (cmd) {
			case 'D':
				result *= 2;
				result = result > 9999 ? result % 10000 : result;
				break;
			case 'S':
				result -= 1;
				result = result == -1 ? 9999 : result;
				break;
			case 'L':
				int n1 = result / 1000;
				int n2 = result % 1000;
				result = n2 * 10 + n1;
				break;
			case 'R':
				int n3 = result / 10;
				int n4 = result % 10;
				result = n4 * 1000 + n3;
				break;
		}
		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // (0 <= n < 10,000)
			goal = Integer.parseInt(st.nextToken()); // (0 <= goal < 10,000)

			// 최소한의 명령어를 사용해서 A를 B로 바꾸기
			// 명령어 실행 순서 출력 문제
			bw.write(bfs(new Command(n, "")) + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

	private static class Command {
		int n;
		String cmdOrder;

		public Command(int n, String cmdOrder) {
			this.n = n;
			this.cmdOrder = cmdOrder;
		}
	}
}
