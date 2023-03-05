/**
 * 문제 : 최단경로
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_4;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1753 {

    static class Node implements Comparable<Node> {

        int val;
        int weight;

        public Node(int val, int weight) {
            this.val = val;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int startV = Integer.parseInt(br.readLine().trim());

        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Node(to, weight));
        }

        int[] distance = new int[V + 1];
        int INF = V * 10;
        Arrays.fill(distance, INF);
        distance[startV] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(startV, 0));
        while (!pq.isEmpty()) {
            // 가장 최단 거리가 짧은 노드 꺼내기
            Node tmp = pq.poll();
            // 현재 노드가 이미 처리된 노드라면 
            if (tmp.weight > distance[tmp.val]) continue;
            // 현재 노드와 연결된 다른 인접한 노드 확인
            for (Node node : graph.get(tmp.val)) {
                // 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
                int cost = distance[tmp.val] + node.weight;
                if (cost < distance[node.val]) {
                    distance[node.val] = cost;
                    pq.offer(new Node(node.val, distance[node.val]));
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (distance[i] >= INF) bw.write("INF" + "\n");
            else bw.write(distance[i] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
