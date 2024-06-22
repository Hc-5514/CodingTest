/**
 * 문제 : 톱니바퀴
 * 소요 시간 : 42분
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_14891 {

	private static List<List<Integer>> lists;
	private static boolean[] visit;

	private static void rotation(int n, int cmd) {
		// 왼쪽 톱니바퀴 확인
		if (n - 1 >= 0 && !visit[n - 1]) {
			if (lists.get(n - 1).get(2) != lists.get(n).get(6)) {
				visit[n - 1] = true;
				rotation(n - 1, cmd * -1);
			}
		}

		// 오른쪽 톱니바퀴 확인
		if (n + 1 <= 3 && !visit[n + 1]) {
			if (lists.get(n).get(2) != lists.get(n + 1).get(6)) {
				visit[n + 1] = true;
				rotation(n + 1, cmd * -1);
			}
		}

		// n번 톱니바퀴 회전
		int tmp;
		switch (cmd) {
			case 1: // 시계 방향 회전
				tmp = lists.get(n).remove(7);
				lists.get(n).add(0, tmp);
				break;
			case -1: // 반시계 방향 회전
				tmp = lists.get(n).remove(0);
				lists.get(n).add(tmp);
				break;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		// 4개의 톱니바퀴 정보를 List 관리
		lists = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			lists.add(new ArrayList<>());
		}

		for (int i = 0; i < 4; i++) {
			String str = br.readLine();
			for (int j = 0; j < 8; j++) {
				lists.get(i).add(Character.getNumericValue(str.charAt(j)));
			}
		}

		int K = Integer.parseInt(br.readLine().trim());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()) - 1;
			int cmd = Integer.parseInt(st.nextToken());

			visit = new boolean[4];
			visit[n] = true;
			rotation(n, cmd);
		}

		// 점수 합산
		int result = 0;
		for (int i = 0; i < 4; i++) {
			result += lists.get(i).get(0) == 1 ? (int)Math.pow(2, i) : 0;
		}

		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
