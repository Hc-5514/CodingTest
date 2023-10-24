/**
 * 문제 : 줄 세우기
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_5;

import java.io.*;
import java.util.*;

public class BOJ_2252 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 일부 순서를 통해 전체 순서 구하기: 위상 정렬
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 1 <= N <= 32,000
        int M = Integer.parseInt(st.nextToken()); // 1 <= M <= 100,000

        List<List<Integer>> orders = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            orders.add(new ArrayList<>());
        }

        int[] edgeCnt = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            orders.get(from).add(to);
            edgeCnt[to]++;
        }

        // 전입 차수가 없다면
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (edgeCnt[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int n : orders.get(cur)) {
                edgeCnt[n]--;
                if (edgeCnt[n] == 0) {
                    q.offer(n);
                }
            }
            bw.write(cur + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
