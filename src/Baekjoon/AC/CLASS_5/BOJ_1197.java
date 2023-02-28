/**
 * 문제 : 최소 스패닝 트리
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_1197 {

    static int[] parent;

    private static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot != bRoot)
            parent[bRoot] = aRoot;
    }

    private static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        // 0: from, 1: to, 2: weight
        int[][] graph = new int[E][3];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            graph[i][0] = Integer.parseInt(st.nextToken());
            graph[i][1] = Integer.parseInt(st.nextToken());
            graph[i][2] = Integer.parseInt(st.nextToken());
        }

        // 가중치 정렬
        Arrays.sort(graph, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        // make Set
        parent = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }

        // kruscal 알고리즘
        int minWeight = 0;
        for (int i = 0; i < E; i++) {
            // 사이클이 생성 안 되는 경우에만 간선 선택
            if (find(graph[i][0] - 1) != find(graph[i][1] - 1)) {
                union(graph[i][0] - 1, graph[i][1] - 1);
                minWeight += graph[i][2];
            }
        }

        System.out.println(minWeight);
        br.close();
    }
}
