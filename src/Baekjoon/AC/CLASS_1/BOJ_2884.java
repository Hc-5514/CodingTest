/**
 * 문제 : 알람 시계
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2884 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        int H = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());

        if ((M -= 45) < 0) {
            M += 60;
            if ((--H) < 0) {
                H = 23;
            }
        }

        System.out.println(H + " " + M);
    }
}
