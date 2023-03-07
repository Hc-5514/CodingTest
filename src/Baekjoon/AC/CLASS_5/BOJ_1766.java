/**
 * 문제 : 문제집
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_5;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1766 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 진입 차수 저장 배열
        int[] edgeCnt = new int[N + 1];

        // 위상 정렬에 사용할 그래프 정보
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
            edgeCnt[to]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        for (int i = 1; i <= N; i++) {
            if (edgeCnt[i] == 0) pq.add(i);
        }

        while (!pq.isEmpty()) {
            int n = pq.poll();
            sb.append(n + " "); // 꺼낸 문제 번호 저장
            ArrayList<Integer> list = new ArrayList<>(graph.get(n));
            for (int i = 0; i < list.size(); i++) {
                edgeCnt[list.get(i)]--;
                if (edgeCnt[list.get(i)] == 0)
                    pq.offer(list.get(i));
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

