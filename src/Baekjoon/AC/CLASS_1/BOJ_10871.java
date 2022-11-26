/**
 * 문제 : X보다 작은 수
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10871 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer token = new StringTokenizer(str, " ");
        int n = Integer.parseInt(token.nextToken());
        int max = Integer.parseInt(token.nextToken());

        str = br.readLine();
        token = new StringTokenizer(str, " ");
        int num;
        for (int i = 0; i < n; i++) {
            num = Integer.parseInt(token.nextToken());
            if (num < max)
                System.out.print(num + " ");
        }
    }
}
