/**
 * 문제 : 가지 교배
 *
 * @author Hc-5514
 */

package Baekjoon.Contest._2023_가지컵;

import java.io.*;
import java.util.StringTokenizer;

public class A번_가지_교배 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine().trim());
        char[] color = new char[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            color[i] = st.nextToken().charAt(0);
        }

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean flag = false;
        f1:
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < k; j++) {
                int idx = Integer.parseInt(st.nextToken()) - 1;
                if (color[idx] == 'P') continue f1;
            }
            flag = true;
        }

        if (flag)
            bw.write("W" + "\n");
        else bw.write("P" + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}