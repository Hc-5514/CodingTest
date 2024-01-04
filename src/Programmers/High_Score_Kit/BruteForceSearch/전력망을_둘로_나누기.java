/**
 * 문제 : 전력망을 둘로 나누기
 *
 * @author Hc-5514
 */

package Programmers.High_Score_Kit.BruteForceSearch;

public class 전력망을_둘로_나누기 {

	private int[] parent;

	private int find(int n) {
		if (parent[n] == n) {
			return n;
		}

		return parent[n] = find(parent[n]);
	}

	private void union(int n1, int n2) {
		int p1 = find(n1);
		int p2 = find(n2);

		if (p1 < p2) {
			parent[p2] = p1;
		} else {
			parent[p1] = p2;
		}
	}

	public int solution(int n, int[][] wires) {
		// 2 <= n <= 100
		// 1 <= v1 < v2 <= n

		int answer = Integer.MAX_VALUE;

		// 하나의 wire를 제외하고 모두 연결한다.
		for (int i = 0; i < wires.length; i++) {
			// 초기화
			parent = new int[n + 1];
			for (int j = 0; j <= n; j++) {
				parent[j] = j;
			}

			// i번째 와이어를 제외하고 union 진행
			for (int j = 0; j < wires.length; j++) {
				if (i == j) {
					continue;
				}

				union(wires[j][0], wires[j][1]);
			}

			// parent 배열은 2개의 수를 가지고 있다.
			// 두 수의 개수 차이 확인
			int cnt1 = 0;
			int cnt2 = 0;
			for (int j = 1; j <= n; j++) {
				if (find(parent[j]) == 1) {
					cnt1++;
				} else {
					cnt2++;
				}
			}

			// 최솟값 갱신
			answer = Math.min(answer, Math.abs(cnt1 - cnt2));
		}

		return answer;
	}

	public static void main(String[] args) {

	}
}
