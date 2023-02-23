/**
 * 문제 : 연결 요소의 개수
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_11724 {

    static int N, M, cnt = 0;
    static LinkedList<Integer>[] map;
    static boolean[] visit;

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            boolean flag = false;
            if (!map[i].isEmpty()) {
                Iterator<Integer> iter = map[i].iterator();
                while (iter.hasNext()) {
                    int num = iter.next();
                    if (!visit[num]) {
                        q.offer(num);
                        visit[num] = true;
                        flag = true;
                    }
                    while (!q.isEmpty()) {
                        int tmp = q.poll();
                        Iterator<Integer> iter2 = map[tmp].iterator();
                        while (iter2.hasNext()) {
                            int num2 = iter2.next();
                            if (!visit[num2]) {
                                q.offer(num2);
                                visit[num2] = true;
                            }
                        }
                    }
                    if (flag) cnt++;
                    flag = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new LinkedList[N + 1];
        visit = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            map[i] = new LinkedList<>();
        }
        for (int i = 0; i < M; i++) {
            // 간선의 양 끝점 u,v
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            map[u].add(v);
            map[v].add(u);
        }

        bfs();
        for (int i = 1; i <= N; i++) {
            if (!visit[i]) cnt++;
        }

        System.out.println(cnt);
        br.close();
    }
}
