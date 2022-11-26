/**
 * 문제 : 사칙연산
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10869 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        br.close();

        StringTokenizer token = new StringTokenizer(str, " ");
        int a = Integer.parseInt(token.nextToken());
        int b = Integer.parseInt(token.nextToken());

        System.out.println(a + b);
        System.out.println(a - b);
        System.out.println(a * b);
        System.out.println(a / b);
        System.out.println(a % b);
    }
}


