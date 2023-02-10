/**
 * 문제 : 트럭
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13335 {

	static Queue<Integer> q = new LinkedList<>();
	static int[] arrWeight;

	private static int getWeight() {

		int weight = 0;

		for (Integer n : q) {
			weight += arrWeight[n];
		}

		return weight;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// n: 트럭의 수, w: 다리의 길이, L: 다리의 최대 하중
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		// 각 트럭의 무게 입력 받기
		arrWeight = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arrWeight[i] = Integer.parseInt(st.nextToken());
		}

		// 모든 트럭이 다리를 건너는 최단 시간 계산
		int time = 1;

		// 트럭이 다리 위에 올라간 시간을 저장할 배열
		int[] arrTime = new int[n];
		int cnt = 0;
		q.add(cnt);
		arrTime[cnt] = time;

		while (!q.isEmpty()) {

			time++;

			// 트럭이 다리 위에 올라간 뒤 w초 후에 지나감
			if ((arrTime[q.peek()] + w) == time) {
				q.poll();
			}

			// 한 번에 w대만 올라갈 수 있음 & 다리 위에 올라간 트럭의 무게 총 합 <= L
			if ((q.size() < w) && cnt + 1 < n && ((getWeight() + arrWeight[cnt + 1]) <= L)) {
				// Queue에 트럭을 추가 후, 들어간 시간 저장
				cnt++;
				q.add(cnt);
				arrTime[cnt] = time;

			}
		}

		// 출력
		System.out.println(time);
		br.close();
	}

}
