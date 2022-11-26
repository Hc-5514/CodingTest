/**
 * 문제 : 음계
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2920 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        br.close();

        int num, count = 0;
        for (int i = 0; i < 8; i++) {
            num = Integer.parseInt(token.nextToken());
            if (num == (i + 1))
                count++;
            else if (num == (8 - i))
                count--;
        }

        if (count == 8)
            System.out.println("ascending");
        else if (count == -8)
            System.out.println("descending");
        else
            System.out.println("mixed");
    }
}
