/**
 * 문제 : 집합
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_3;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_11723 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int M = Integer.parseInt(br.readLine().trim());

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            int n;
            switch (cmd) {
                case "add":
                    n = Integer.parseInt(st.nextToken());
                    set.add(n);
                    break;
                case "remove":
                    n = Integer.parseInt(st.nextToken());
                    set.remove(n);
                    break;
                case "check":
                    n = Integer.parseInt(st.nextToken());
                    if (set.contains(n)) {
                        bw.write(1 + "\n");
                    } else bw.write(0 + "\n");
                    break;
                case "toggle":
                    n = Integer.parseInt(st.nextToken());
                    if (set.contains(n)) {
                        set.remove(n);
                    } else set.add(n);
                    break;
                case "all":
                    set.clear();
                    for (int j = 1; j <= 20; j++) {
                        set.add(j);
                    }
                    break;
                case "empty":
                    set.clear();
                    break;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}