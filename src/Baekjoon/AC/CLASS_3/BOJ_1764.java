/**
 * 문제 : 듣보잡
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_3;

import java.io.*;
import java.util.*;

public class BOJ_1764 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        List<String> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if (set.contains(str)) {
                list.add(str);
            }
        }

        Collections.sort(list);

        int size = list.size();
        bw.write(size + "\n");

        for (int i = 0; i < size; i++) {
            bw.write(list.get(i) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}