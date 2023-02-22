/**
 * 문제 : 숨바꼭질
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

public class BOJ_1697 {

    static int N, K, time = 0;
    static boolean[] visited = new boolean[100001];

    static private void bfs() {

        Queue<Integer> q = new LinkedList<>();
        q.offer(N);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int current = q.poll();
                if (current == K) return;
                else if (current > K && !visited[current - 1]) {
                    q.offer(current - 1);
                    visited[current - 1] = true;
                } else {
                    // case1: -1
                    if (current - 1 >= 0 && !visited[current - 1]) {
                        q.offer(current - 1);
                        visited[current - 1] = true;
                    }
                    // case2: +1
                    if (!visited[current + 1]) {
                        q.offer(current + 1);
                        visited[current + 1] = true;
                    }
                    // case3: x2
                    if (current * 2 <= 100000 && !visited[current * 2]) {
                        q.offer(current * 2);
                        visited[current * 2] = true;
                    }
                }
            }
            time++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs();

        System.out.println(time);
        br.close();
    }
}
