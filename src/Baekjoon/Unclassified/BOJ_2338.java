/**
 * 문제 : 긴자리 계산
 *
 * @author Hc-5514
 */

package Baekjoon.Unclassified;

import java.io.*;
import java.math.BigInteger;

public class BOJ_2338 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        BigInteger n1 = new BigInteger(br.readLine().trim());
        BigInteger n2 = new BigInteger(br.readLine().trim());

        bw.write(n1.add(n2)+"\n");
        bw.write(n1.subtract(n2)+"\n");
        bw.write(n1.multiply(n2)+"\n");

        bw.flush();
        bw.close();
        br.close();
    }
}