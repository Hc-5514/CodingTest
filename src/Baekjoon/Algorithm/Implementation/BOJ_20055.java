/**
 * 문제 : 컨베이어 벨트 위의 로봇
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

public class BOJ_20055 {

	// 길이가 2N인 원형 벨트 (1번 ~ 2N번)
	// 로봇은 1번에 올릴 수 있고, N번에서 내린다.
	// 1) 벨트 회전
	// 2) N번에 가까운 로봇부터 이동:
	// - 이동하려는 칸의 내구도 1이상 & 빈 칸
	// 3) 1번 칸의 내구도가 0이 아니라면, 로봇 추가
	// 4) 내구도 0인 칸이 K개 이상이면 종료

	private static int n, zeroCnt;
	private static List<Integer> belts;
	private static List<Integer> robots;

	/**
	 * 벨트 회전
	 */
	private static void moveBelt() {
		// 벨트 내구도 이동
		belts.add(0, belts.remove(2 * n - 1));
		// 로봇 위치 이동
		for (int i = 0; i < robots.size(); i++) {
			robots.set(i, robots.get(i) + 1);
		}

		removeRobot();
	}

	/**
	 * 로봇 이동
	 */
	private static void moveRobot() {
		if (robots.isEmpty()) {
			return;
		}

		if (belts.get(robots.get(0) + 1) != 0) {
			downBelt(robots.get(0) + 1);
			robots.set(0, robots.get(0) + 1);
		}

		for (int i = 1; i < robots.size(); i++) {
			// 내구도 1이상, 빈 벨트인 경우
			if (belts.get(robots.get(i) + 1) != 0 && robots.get(i - 1) != robots.get(i) + 1) {
				downBelt(robots.get(i) + 1);
				robots.set(i, robots.get(i) + 1);
			}
		}

		removeRobot();
	}

	/**
	 * 로봇 제거 (내리는 칸에 로봇이 있을 경우)
	 */
	private static void removeRobot() {
		if (!robots.isEmpty()) {
			if (robots.get(0) == (n - 1)) {
				robots.remove(0);
			}
		}
	}

	/**
	 * 로봇 추가
	 */
	private static void addRobot() {
		if (belts.get(0) != 0) {
			robots.add(0); // 로봇 추가
			downBelt(0);
		}
	}

	/**
	 * 벨트 내구도 감소
	 */
	private static void downBelt(int index) {
		int cur = belts.get(index);
		belts.set(index, cur - 1);
		if (cur - 1 == 0) {
			zeroCnt++;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		zeroCnt = 0; // 내구도가 0인 컨베이어 벨트 개수
		belts = new ArrayList<>(); // 컨베이어 벨트의 내구도를 저장할 리스트
		robots = new ArrayList<>(); // 로봇의 위치를 저장할 리스트

		st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) {
			int num = Integer.parseInt(st.nextToken());
			belts.add(num);
			if (num == 0) {
				zeroCnt++;
			}
		}

		int round = 0;
		while (true) {
			round++;
			moveBelt();
			moveRobot();
			addRobot();
			if (zeroCnt >= k) {
				break;
			}
		}

		bw.write(round + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
