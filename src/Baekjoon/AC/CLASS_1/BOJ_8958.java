/**
 * 문제 : OX퀴즈
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_8958 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            int sum = 0;
            int count = 0;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == 'O') {
                    count++;
                    sum += count;
                } else count = 0;
            }
            System.out.println(sum);
        }
    }
}
