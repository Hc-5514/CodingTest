/**
 * 문제 : 검증수
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2475 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        br.close();

        int sum = 0;
        for(int i=0; i<5; i++){
            double var = Double.parseDouble(token.nextToken());
            sum += Math.pow(var, 2);
        }

        System.out.println(sum%10);
    }
}
