/**
 * 문제 : 평균
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1546 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int max = 0;
        double sum = 0.0;

        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(st.nextToken());
            if (val > max) {
                max = val;
            }
            sum += val;
        }

        System.out.println(((sum / max) * 100) / n);
    }
}
