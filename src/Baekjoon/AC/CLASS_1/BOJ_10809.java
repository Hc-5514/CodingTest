/**
 * 문제 : 알파벳 찾기
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10809 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        br.close();

        int[] ary = new int[26];
        for (int i = 0; i < ary.length; i++) { // 11이상 버전: Arrays.fill(ary, -1);
            ary[i] = -1;
        }

        for (int i = 0; i < str.length(); i++) {
            if (ary[str.charAt(i) - 97] == -1) {
                ary[str.charAt(i) - 97] = i;
            }
        }

        for (int result : ary) {
            System.out.print(result + " ");
        }
    }
}
