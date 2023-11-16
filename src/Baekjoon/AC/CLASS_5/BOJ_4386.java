/**
 * 문제 : 별자리 만들기
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_5;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_4386 {

    private static double total;
    private static int[] parent;
    private static double[][] starInfo;

    private static double getDistance(int a, int b) {
        return Math.sqrt(Math.pow(starInfo[a][0] - starInfo[b][0], 2) + Math.pow(starInfo[a][1] - starInfo[b][1], 2));
    }

    private static int find(int n) {
        if (parent[n] == n) {
            return n;
        }

        return parent[n] = find(parent[n]);
    }

    private static void union(int n1, int n2, double dist) {
        int p1 = find(parent[n1]);
        int p2 = find(parent[n2]);

        if (p1 != p2) {
            parent[p1] = p2;
            total += dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // n개의 좌표 입력
        int n = Integer.parseInt(br.readLine().trim());
        starInfo = new double[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            starInfo[i][0] = Double.parseDouble(st.nextToken());
            starInfo[i][1] = Double.parseDouble(st.nextToken());
        }

        // 부모 노드 저장
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        // 두 좌표간 거리를 모두 저장 후 MST 구하기
        PriorityQueue<Star> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double dist = getDistance(i, j);
                pq.offer(new Star(i, j, dist));
            }
        }

        total = 0;
        while (!pq.isEmpty()) {
            Star cur = pq.poll();
            union(cur.from, cur.to, cur.distance);
        }

        total = (int) (total * 100) / 100.0;
        bw.write(total + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static class Star implements Comparable<Star> {
        int from;
        int to;
        double distance;

        public Star(int from, int to, double distance) {
            this.from = from;
            this.to = to;
            this.distance = distance;
        }

        @Override
        public int compareTo(Star d) {
            return (int) (this.distance - d.distance);
        }
    }
}
