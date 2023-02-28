/**
 * 문제 : [S/W 문제해결 기본] 10일차 - Contact
 *
 * @author Hc-5514
 */

package SWEA.Difficulty_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA_D4_1238 {
    static ArrayList<Integer>[] list;
    static boolean[] visit;
    static int maxNum;

    private static void bfs(int startV) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(startV);
        visit[startV] = true;
        while (!q.isEmpty()) {
            maxNum = 0;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int qNum = q.poll();
                maxNum = Math.max(maxNum, qNum);
                for (int n : list[qNum]) {
                    if (!visit[n]) {
                        visit[n] = true;
                        q.offer(n);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int tc = 1; tc <= 10; tc++) {
            list = new ArrayList[102]; // 1 ~ 100
            visit = new boolean[101];

            st = new StringTokenizer(br.readLine());
            // E: 간선 개수, startV: 시작 정점
            int E = Integer.parseInt(st.nextToken());
            int startV = Integer.parseInt(st.nextToken());

            for (int i = 1; i < 102; i++) {
                list[i] = new ArrayList<>(); // 1 ~ 101
            }

            // 간선 정보 받기
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < E / 2; i++) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list[a].add(b);
            }

            bfs(startV);

            sb.append("#").append(tc).append(" ").append(maxNum).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
