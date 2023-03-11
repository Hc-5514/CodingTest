/**
 * 문제 : 트리의 지름
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_4;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1967 {

    static int n, maxLen = 0;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    private static void dfs(int from, int to, int len) {
        for (int i = 0; i < graph.get(to).size(); i++) {
            Node tmp = graph.get(to).get(i);
            if (tmp.val != from) {
                dfs(to, tmp.val, len + tmp.weight);
            }
        }
        if (maxLen < len) maxLen = len;
    }

    static class Node {
        int val;
        int weight;

        public Node(int val, int weight) {
            this.val = val;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Node(to, weight));
            graph.get(to).add(new Node(from, weight));
        }

        // 모든 리프 노드 dfs 탐색
        for (int i = 0; i < n; i++) {
            // 리프 노드라면
            if (graph.get(i).size() == 1) {
                Node cur = graph.get(i).get(0);
                dfs(i, cur.val, cur.weight);
            }
        }

        bw.write(maxLen + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}