/**
 * 문제 : 이중 우선순위 큐
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_3;

import java.io.*;
import java.util.*;

public class BOJ_7662 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            // pq1: 큰 숫자 우선순위
            PriorityQueue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder());

            // pq2: 낮은 숫자 우선순위
            PriorityQueue<Integer> pq2 = new PriorityQueue<>();

            Map<Integer, Integer> map = new HashMap<>();
            int opCnt = Integer.parseInt(br.readLine().trim());

            for (int i = 0; i < opCnt; i++) {
                st = new StringTokenizer(br.readLine());
                char op = st.nextToken().charAt(0);
                int n = Integer.parseInt(st.nextToken());
                if (op == 'I') {
                    pq1.offer(n);
                    pq2.offer(n);
                    if (map.containsKey(n)) {
                        int cnt = map.get(n);
                        map.put(n, cnt + 1);
                    } else map.put(n, 1);
                } else {
                    if (map.size() == 0) continue;
                    int num = 0;
                    if (n == 1) {
                        num = pq1.poll();
                        while (!map.containsKey(num)) {
                            num = pq1.poll();
                        }
                    } else {
                        num = pq2.poll();
                        while (!map.containsKey(num)) {
                            num = pq2.poll();
                        }
                    }
                    int cnt = map.get(num);
                    if (cnt == 1) map.remove(num);
                    else map.put(num, cnt - 1);
                }
            }
            if (map.size() == 0) bw.write("EMPTY\n");
            else {
                int n = pq1.poll();
                while (!map.containsKey(n)) {
                    n = pq1.poll();
                }
                bw.write(n + " ");
                n = pq2.poll();
                while (!map.containsKey(n)) {
                    n = pq2.poll();
                }
                bw.write(n + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}