/**
 * 문제 : 나는야 포켓몬 마스터 이다솜
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_3;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_1620 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            map1.put(String.valueOf(i), name);
            map2.put(name, String.valueOf(i));
        }

        for (int i = 0; i < M; i++) {
            String quiz = br.readLine();
            if (map1.containsKey(quiz)) {
                bw.write(map1.get(quiz) + "\n");
            } else {
                bw.write(map2.get(quiz) + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}