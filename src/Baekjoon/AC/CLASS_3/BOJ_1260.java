/**
 * 문제 : DFS와 BFS
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260 {

    static StringBuilder sb = new StringBuilder();

    static int n;

    static int[][] map;

    static boolean[] visited;

    private static void dfs(int v) {
        visited[v] = true;
        sb.append(v).append(" ");
        for (int i = 1; i <= n; i++) {
            if (map[v][i] == 1 && visited[i] == false) {
                dfs(i);
            }
        }
    }

    private static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        visited[v] = true;

        while (!q.isEmpty()) {
            int tmp = q.poll();
            sb.append(tmp).append(" ");
            for (int i = 1; i <= n; i++) {
                // 연결됐고, 방문하지 않았다면
                if (map[tmp][i] == 1 && visited[i] == false) {
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }

        sb.append("\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // n: 정점의 개수, m: 간선의 개수, v: 탐색 시작 정점 번호
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        map = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = map[b][a] = 1;
        }

        dfs(v);
        sb.append("\n");
        Arrays.fill(visited, false);
        bfs(v);

        System.out.println(sb);
        br.close();
    }
}
