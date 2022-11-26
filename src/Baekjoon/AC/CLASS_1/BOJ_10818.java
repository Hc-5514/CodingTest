/**
 * 문제 : 최소, 최대
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10818 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        br.close();

        StringTokenizer token = new StringTokenizer(str, " ");
        int max = Integer.parseInt(token.nextToken());
        int min = max;

        for (int i = 1; i < n; i++) {
            int num = Integer.parseInt(token.nextToken());
            if (num > max)
                max = num;
            else if (min > num)
                min = num;
        }

        System.out.println(min + " " + max);
    }
}
