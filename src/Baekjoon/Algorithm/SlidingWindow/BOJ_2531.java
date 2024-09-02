/**
 * 문제 : 회전 초밥
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.SlidingWindow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_2531 {

	// 벨트 위에 같은 종류의 초밥이 둘 이상 있을 수 있다.
	// 연속에서 k개의 초밥을 먹을 경우 쿠폰번호 c초밥 추가 제공
	// 손님이 먹을 수 있는 초밥 가짓수 최댓값 구하기

	private static Map<Integer, Integer> maps;

	private static void putMap(int num) {
		if (maps.containsKey(num)) {
			maps.put(num, maps.get(num) + 1);
		} else {
			maps.put(num, 1);
		}
	}

	private static void removeMap(int num) {
		int cnt = maps.get(num);
		if (cnt == 1) {
			maps.remove(num);
		} else {
			maps.put(num, maps.get(num) - 1);
		}
	}

	private static int getMapSize() {
		return maps.size();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 벨트 위 접시 수
		int d = Integer.parseInt(st.nextToken()); // 초밥 가짓수
		int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시 수
		int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

		int[] dishes = new int[n];
		for (int i = 0; i < n; i++) {
			dishes[i] = Integer.parseInt(br.readLine().trim());
		}

		maps = new HashMap<>();
		putMap(c); // 쿠폰 번호 초밥 제공

		for (int i = 0; i < k; i++) {
			putMap(dishes[i]);
		}

		int maxCnt = getMapSize();
		for (int i = 0; i < n; i++) {
			removeMap(dishes[i]);
			putMap(dishes[(i + k) % n]);
			maxCnt = Math.max(maxCnt, getMapSize());
		}

		bw.write(maxCnt + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
