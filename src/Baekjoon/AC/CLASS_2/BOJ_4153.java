/**
 * 문제 : 직각삼각형
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_4153 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        double[] ary = new double[3];

        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            ary[0] = Double.parseDouble(st.nextToken());
            ary[1] = Double.parseDouble(st.nextToken());
            ary[2] = Double.parseDouble(st.nextToken());

            if (ary[0] == 0 && ary[1] == 0 && ary[2] == 0)
                break;

            Arrays.sort(ary);

            if (Math.pow(ary[2], 2) == Math.pow(ary[0], 2) + Math.pow(ary[1], 2)) {
                bw.write("right");
                bw.newLine();
            } else {
                bw.write("wrong");
                bw.newLine();
            }

            bw.flush();
        }

        br.close();
        bw.close();
    }
}
