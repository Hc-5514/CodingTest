/**
 * 문제 : 최소비용 구하기 2
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_4;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 도시 이동할 때 비용이 든다. -> 가중치가 있다.
 * 가중치가 있고, 최단 경로를 구하는 문제이므로 다익스트라 사용
 */

public class BOJ_11779 {

    static class City implements Comparable<City> {
        int val;
        int weight;

        public City(int val, int weight) {
            this.val = val;
            this.weight = weight;
        }

        @Override
        public int compareTo(City o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine().trim());
        ArrayList<ArrayList<City>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        int m = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(from).add(new City(to, weight));
        }

        st = new StringTokenizer(br.readLine());
        int startV = Integer.parseInt(st.nextToken());
        int endV = Integer.parseInt(st.nextToken());

        int[] distance = new int[n + 1];
        int INF = Integer.MAX_VALUE;
        Arrays.fill(distance, INF);
        distance[startV] = 0;

        // 방문 경로를 저장할 visitList
        ArrayList<ArrayList<Integer>> visitList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            visitList.add(new ArrayList<>());
        }

        PriorityQueue<City> pq = new PriorityQueue<>();
        pq.offer(new City(startV, 0));
        visitList.get(startV).add(startV);
        while (!pq.isEmpty()) {
            City cur = pq.poll();
            if (distance[cur.val] < cur.weight) continue;
            for (City city : graph.get(cur.val)) {
                int cost = distance[cur.val] + city.weight;
                if (cost < distance[city.val]) {
                    distance[city.val] = cost;
                    pq.offer(new City(city.val, distance[city.val]));
                    // 최단 방문 경로 갱신
                    visitList.get(city.val).clear();
                    for (int i = 0; i < visitList.get(cur.val).size(); i++) {
                        visitList.get(city.val).add(visitList.get(cur.val).get(i));
                    }
                    visitList.get(city.val).add(city.val);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(distance[endV]).append("\n");
        sb.append(visitList.get(endV).size()).append("\n");
        for (int i = 0; i < visitList.get(endV).size(); i++) {
            sb.append(visitList.get(endV).get(i)).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}