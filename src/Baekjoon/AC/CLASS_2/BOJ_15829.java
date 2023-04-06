/**
 * 문제 : Hashing
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_2;

import java.io.*;

public class BOJ_15829 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int L = Integer.parseInt(br.readLine().trim());
        String str = br.readLine();

        long[] d = new long[L];
        for (int i = 0; i < L; i++) {
            if (i == 0) d[0] = 1;
            else d[i] = (d[i - 1] * 31) % 1234567891;
        }

        long sum = 0;
        for (int i = 0; i < L; i++) {
            int n = str.charAt(i) - 96;
            sum += n * d[i];
        }

        bw.write(sum % 1234567891 + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}