/**
 * 문제 : 패션왕 신해빈
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_3;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_9375 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 0; tc < T; tc++) {
            Map<String, Integer> clothes = new HashMap<>();
            int n = Integer.parseInt(br.readLine().trim());
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                String word = st.nextToken();
                String key = st.nextToken();
                if (clothes.containsKey(key)) {
                    clothes.put(key, clothes.get(key) + 1);
                } else {
                    clothes.put(key, 1);
                }
            }

            int result = 1;
            for (int val : clothes.values()) {
                result *= (val + 1); // 옷을 안 입는 경우도 있다.
            }

            bw.write(result - 1 + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}