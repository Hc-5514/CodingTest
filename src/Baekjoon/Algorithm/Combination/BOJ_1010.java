/**
 * 문제 : 다리 놓기
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Combination;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * 조합 풀이
 */
public class BOJ_1010 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            BigInteger res1 = BigInteger.ONE;
            BigInteger res2 = BigInteger.ONE;

            for (int i = 1; i <= n; i++) {
                res1 = res1.multiply(new BigInteger(String.valueOf(m-i+1)));
                res2 = res2.multiply(new BigInteger(String.valueOf(i)));
            }

            bw.write(res1.divide(res2).toString() + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}