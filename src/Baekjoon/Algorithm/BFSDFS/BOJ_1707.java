/**
 * 문제: 이분 그래프
 * 난이도: 골드 4
 * 메모리: 285708KB, 시간: 956ms
 * 풀이: BFS
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

public class BOJ_1707 {

	private static int v, e;
	// 이분 그래프 판별 (true: 시작 노드와 같은 집합인 노드)
	private static boolean[] checkNode, visit;
	private static List<List<Integer>> nodeList;

	private static boolean bfs(int startNo) {
		Queue<Node> q = new ArrayDeque<>();
		q.offer(new Node(startNo, true));
		visit[startNo] = true;
		checkNode[startNo] = true;

		while (!q.isEmpty()) {
			Node pollNode = q.poll();
			for (int i = 0; i < nodeList.get(pollNode.no).size(); i++) {
				int curNo = nodeList.get(pollNode.no).get(i);
				// 인접 노드가 같은 집합에 속한지 확인
				if (visit[curNo]) {
					if (checkNode[curNo] == pollNode.checkNode) {
						return false;
					}
					continue;
				}
				// 인접 노드는 다른 집합에 분류
				checkNode[curNo] = !pollNode.checkNode;
				q.offer(new Node(curNo, checkNode[curNo]));
				visit[curNo] = true;
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int k = Integer.parseInt(br.readLine().trim()); // 2 <= k <= 5
		for (int tc = 0; tc < k; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			v = Integer.parseInt(st.nextToken()); // 정점 개수
			e = Integer.parseInt(st.nextToken()); // 간선 개수

			checkNode = new boolean[v + 1];

			// 인접한 노드 번호를 저장
			nodeList = new ArrayList<>();
			for (int i = 0; i <= v; i++) {
				nodeList.add(new ArrayList<>());
			}

			// 그래프 양방향 연결
			for (int i = 0; i < e; i++) {
				st = new StringTokenizer(br.readLine().trim());
				int n1 = Integer.parseInt(st.nextToken());
				int n2 = Integer.parseInt(st.nextToken());
				nodeList.get(n1).add(n2);
				nodeList.get(n2).add(n1);
			}

			boolean isBipartiteGraph = true;

			// bfs
			visit = new boolean[v + 1];

			for (int i = 1; i <= v; i++) {
				if (visit[i]) {
					continue;
				}
				if (!bfs(i)) {
					isBipartiteGraph = false;
					break;
				}
			}

			String result = "YES\n";
			if (!isBipartiteGraph) {
				result = "NO\n";
			}

			bw.write(result);
		}

		bw.flush();
		bw.close();
		br.close();
	}

	private static class Node {
		int no;
		boolean checkNode;

		public Node(int no, boolean checkNode) {
			this.no = no;
			this.checkNode = checkNode;
		}
	}
}
