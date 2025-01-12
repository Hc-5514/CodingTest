/**
 * 문제 : 나무 탈출
 * 소요 시간 : 27분
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.BFSDFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_15900 {

	// [문제 정리]
	// 성원이가 게임을 이길 수 있다면 "Yes", 없다면 "No" 출력
	// 게임 시작 시, 모든 리프 노드에 게임말이 하나씩 존재
	// 턴마다 임의의 노드에 존재하는 게임말을 부모 노드로 옮긴다. 한 노드에 여러 게임말이 겹칠 수 있다.
	// 게임말이 루트 노드(1번)에 도착하면 제거
	// 선공: 성원, 후공: 형석

	// [문제 풀이]
	// 루트 노드부터 모든 리프 노드까지 노드 깊이의 총합을 구한다.
	// 홀수: 승리, 짝수: 패배

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine().trim());
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		// 노드 양방향 연결
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		// 탐색 시작 노드: 루트 노드
		Queue<Node> q = new ArrayDeque<>();
		q.offer(new Node(1, 0));
		boolean[] visit = new boolean[n + 1];
		visit[1] = true;

		int cnt = 0;
		while (!q.isEmpty()) {
			Node cur = q.poll();
			boolean isLeaf = true;
			for (int i = 0; i < graph.get(cur.no).size(); i++) {
				int no = graph.get(cur.no).get(i);
				if (visit[no]) {
					continue;
				}
				q.offer(new Node(no, cur.depth + 1));
				visit[no] = true;
				isLeaf = false;
			}
			// 리프 노드일 경우, 깊이 합산
			if (isLeaf) {
				cnt += cur.depth;
			}
		}

		String answer = cnt % 2 == 1 ? "Yes" : "No";

		bw.write(answer + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	private static class Node {
		int no;
		int depth;

		public Node(int no, int depth) {
			this.no = no;
			this.depth = depth;
		}
	}
}
