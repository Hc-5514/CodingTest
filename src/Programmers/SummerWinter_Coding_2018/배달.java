package Programmers.SummerWinter_Coding_2018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class 배달 {

    public int solution(int N, int[][] road, int K) {
        // 모든 마을까지의 최단 거리를 구해야 하므로, 다익스트라 알고리즘 사용
        // 1 ~ N 번 마을 거리 초기화
        int[] dist = new int[N + 1];
        Arrays.fill(dist, 500001);
        dist[1] = 0;

        // list 에 도로 정보 저장
        ArrayList<ArrayList<Node>> list = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<Node>());
        }
        for (int i = 0; i < road.length; i++) {
            // 양방향 연결
            list.get(road[i][0]).add(new Node(road[i][1], road[i][2]));
            list.get(road[i][1]).add(new Node(road[i][0], road[i][2]));
        }

        // 우선순위 큐 활용 n Log n
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0)); // 출발 노드 추가
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            // 이미 처리한 노드라면 continue;
            if (cur.weight > dist[cur.to]) continue;
            // 현재 노드와 인접한 모든 노드 탐색
            for (Node node : list.get(cur.to)) {
                // 1번 마을에서 인접 노드까지 거리 vs 현재 노드를 거쳐서 인접 노드까지 거리
                int cost = dist[cur.to] + node.weight;
                // 거쳐서 가는게 빠르다면, 거리 갱신 및 해당 노드로 재계산
                if (cost < dist[node.to]) {
                    dist[node.to] = cost;
                    pq.offer(new Node(node.to, dist[node.to]));
                }
            }
        }

        int answer = 0;
        for (int i = 1; i < N + 1; i++) {
            if (dist[i] <= K) {
                answer++;
            }
        }
        return answer;
    }

    class Node implements Comparable<Node> {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}
