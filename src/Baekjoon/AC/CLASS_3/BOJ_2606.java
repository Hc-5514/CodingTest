/**
 * 문제 : 바이러스
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2606 {

    static int n;

    static int[][] map;

    static boolean[] visit;

    private static int bfs() {
        int cnt = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visit[1] = true;
        while (!q.isEmpty()) {
            int tmp = q.poll();
            for (int i = 0; i <= n; i++) {
                if (map[tmp][i] == 1 && !visit[i]) {
                    q.offer(i);
                    visit[i] = true;
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // n: 정점 개수, m: 엣지 개수
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];
        visit = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = map[b][a] = 1;
        }

        System.out.println(bfs());

        br.close();
    }
}
