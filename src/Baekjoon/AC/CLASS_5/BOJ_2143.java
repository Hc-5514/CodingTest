/**
 * 문제 : 두 배열의 합
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_5;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_2143 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine().trim()); // -1,000,000,000 ≤ T ≤ 1,000,000,000

        int n = Integer.parseInt(br.readLine().trim()); // 1 ≤ n ≤ 1,000
        Map<Integer, Integer> map1 = new HashMap<>();
        int[] prefixSum1 = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            prefixSum1[i] = prefixSum1[i - 1] + Integer.parseInt(st.nextToken());
            for (int j = 0; j < i; j++) {
                int cur = prefixSum1[i] - prefixSum1[j];
                if (map1.containsKey(cur)) {
                    map1.put(cur, map1.get(cur) + 1);
                } else {
                    map1.put(cur, 1);
                }
            }
        }

        int m = Integer.parseInt(br.readLine().trim()); // 1 ≤ n ≤ 1,000
        Map<Integer, Integer> map2 = new HashMap<>();
        int[] prefixSum2 = new int[m + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= m; i++) {
            prefixSum2[i] = prefixSum2[i - 1] + Integer.parseInt(st.nextToken());
            for (int j = 0; j < i; j++) {
                int cur = prefixSum2[i] - prefixSum2[j];
                if (map2.containsKey(cur)) {
                    map2.put(cur, map2.get(cur) + 1);
                } else {
                    map2.put(cur, 1);
                }
            }
        }

        long cnt = 0;
        for (int n1 : map1.keySet()) {
            int goal = T - n1;
            if (map2.containsKey(goal)) {
                cnt += (long) map1.get(n1) * map2.get(goal);
            }
        }

        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
