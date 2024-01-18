/**
 * 문제 : [2번] 석유 시추
 *
 * @author Hc-5514
 */

package Programmers.PCCP_기출문제;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class _2번_석유_시추 {

	private boolean[][] visit;

	private final int[] dRow = {-1, 1, 0, 0}, dCol = {0, 0, -1, 1};

	public int solution(int[][] land) {
		// land[][] 500 x 500
		// 0: 빈 땅, 1: 석유

		visit = new boolean[land.length][land[0].length];

		Map<Integer, Integer> map = new HashMap<>();
		int idx = 2;

		// 1. land 탐색
		for (int i = 0; i < land.length; i++) {
			for (int j = 0; j < land[0].length; j++) {
				// 석유를 만나면 bfs 진행
				if (land[i][j] == 1 && !visit[i][j]) {
					// 방문처리, idx로 석유 번호 표시, 해당 석유의 크기를 Map에 저장
					int cnt = bfs(land, i, j, idx);
					map.put(idx++, cnt);
				}
			}
		}

		// 2. 최대 석유량 측정
		// Hash Set에 idx를 저장 후 Map 을 통해 석유 크기의 총 합을 구한다.
		Set<Integer> set = new HashSet<>();
		int answer = 0;

		for (int i = 0; i < land[0].length; i++) {
			set.clear();
			for (int j = 0; j < land.length; j++) {
				if (land[j][i] != 0) {
					set.add(land[j][i]);
				}
			}

			int sum = 0;
			for (Integer n : set) {
				sum += map.get(n);
			}

			answer = Math.max(answer, sum);
		}

		return answer;
	}

	private int bfs(int[][] land, int i, int j, int idx) {
		int cnt = 1;
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {i, j});
		visit[i][j] = true;
		land[i][j] = idx;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int k = 0; k < 4; k++) {
				int r = cur[0] + dRow[k];
				int c = cur[1] + dCol[k];

				if (r < 0 || c < 0 || r >= land.length || c >= land[0].length) {
					continue;
				}

				if (land[r][c] != 1) {
					continue;
				}

				if (visit[r][c]) {
					continue;
				}

				q.offer(new int[] {r, c});
				land[r][c] = idx;
				visit[r][c] = true;
				cnt++;
			}
		}

		return cnt;
	}
}
