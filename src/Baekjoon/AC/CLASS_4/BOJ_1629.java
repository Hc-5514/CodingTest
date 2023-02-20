/**
 * 문제 : 곱셈
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1629 {

    private static long division(long a, long b, long c) {

        if (b == 1) return a % c;

        long tmp = division(a, b / 2, c);

        if (b % 2 == 1) {
            return (tmp * tmp % c) * (a % c) % c;
        }

        return tmp * tmp % c;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        long c = Integer.parseInt(st.nextToken());

        System.out.println(division(a, b, c));

        br.close();
    }
}
