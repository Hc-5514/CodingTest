/**
 * 문제 : 최대공약수와 최소공배수
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2609 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 최대공약수 구하기
        int gcd = getGCD(N, M);

        // 최소공배수 구하기
        int lcm  = N * M / gcd;

        System.out.println(gcd);
        System.out.println(lcm);
    }

    public static int getGCD(int N, int M) {
        if (M == 0)
            return N;

        return getGCD(M, N % M);
    }

}
