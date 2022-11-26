/**
 * 문제 : A+B - 4
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10951 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;
        while ((str = br.readLine()) != null) {
            StringTokenizer token = new StringTokenizer(str, " ");
            System.out.println(Integer.parseInt(token.nextToken()) + Integer.parseInt(token.nextToken()));
        }
    }
}
