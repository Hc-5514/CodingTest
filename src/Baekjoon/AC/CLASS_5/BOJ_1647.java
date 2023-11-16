/**
 * 문제 : 도시 분할 계획
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_5;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1647 {

    private static int total, lastWeight;
    private static int[] house;

    private static int find(int n) {
        if (house[n] == n) {
            return n;
        }

        return house[n] = find(house[n]);
    }

    private static void union(int n1, int n2, int weight) {
        int p1 = find(n1);
        int p2 = find(n2);

        // 부모 노드(집)을 비교하여 같다면, 같은 마을이다.
        if (p1 != p2) {
            house[p1] = p2;
            total += weight;
            lastWeight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 1 <= N <= 100,000
        int M = Integer.parseInt(st.nextToken()); // 1 <= M <= 1,000,000

        // 부모 노드 초기화
        house = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            house[i] = i;
        }

        total = 0;
        lastWeight = 0;

        // 최소 유지비부터 연결을 한다.
        PriorityQueue<Road> pq = new PriorityQueue<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            pq.offer(new Road(A, B, C));
        }

        while (!pq.isEmpty()) {
            Road cur = pq.poll();
            union(cur.from, cur.to, cur.weight);
        }

        // 모든 집 사이에는 하나 이상의 길이 있으므로, 가장 높은 가중치의 길 하나만 삭제하면 된다.
        bw.write(total - lastWeight + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static class Road implements Comparable<Road> {
        int from;
        int to;
        int weight;

        public Road(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Road r) {
            return this.weight - r.weight;
        }
    }
}
