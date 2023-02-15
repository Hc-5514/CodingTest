/**
 * 문제 : 트리의 부모 찾기
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11725 {

    // 노드 개수, 트리, 부모 노드 번호를 저장할 배열
    private static void BFS(int N, ArrayList<ArrayList<Integer>> tree, int[] arrParentNode) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        boolean[] visited = new boolean[N];
        while (!q.isEmpty()) {
            int parentNode = q.poll();
            for (int node : tree.get(parentNode)) {
                if (!visited[node]) {
                    visited[node] = true;
                    arrParentNode[node] = parentNode;
                    q.offer(node);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        // 트리 구조 생성
        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            tree.add(new ArrayList<>());
        }

        // 노드 정보 입력
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken()) - 1;
            int n2 = Integer.parseInt(st.nextToken()) - 1;
            tree.get(n1).add(n2);
            tree.get(n2).add(n1);
        }

        int[] arrParentNode = new int[N];
        BFS(N, tree, arrParentNode);

        for (int i = 1; i < arrParentNode.length; i++) {
            sb.append(arrParentNode[i] + 1).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
