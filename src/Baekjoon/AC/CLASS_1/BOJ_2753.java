/**
 * 문제 : 윤년
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2753 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        n = (n % 400 == 0) ? 1 : ((n % 100 == 0) ? 0 : (n % 4 == 0 ? 1 : 0));
        System.out.println(n);
    }
}
