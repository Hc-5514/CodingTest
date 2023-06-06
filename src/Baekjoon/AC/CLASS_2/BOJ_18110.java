/**
 * 문제 : solved.ac
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_2;

import java.io.*;
import java.util.Arrays;

public class BOJ_18110 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine().trim());
        int[] numArr = new int[n];

        for (int i = 0; i < n; i++) {
            numArr[i] = Integer.parseInt(br.readLine().trim());
        }

        Arrays.sort(numArr);

        int exNum = (int) Math.round(n * 0.15);
        int sum = 0;
        for (int i = exNum; i < n - exNum; i++) {
            sum += numArr[i];
        }

        int avg = (int) Math.round(sum / (n - 2.0 * exNum));
        bw.write(avg + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}