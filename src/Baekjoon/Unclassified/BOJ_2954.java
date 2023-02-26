/**
 * 문제 : 창영이의 일기장
 *
 * @author Hc-5514
 */

package Baekjoon.Unclassified;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2954 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(br.readLine());
        StringBuilder sb2 = new StringBuilder();

        char[] vowel = {'a', 'e', 'i', 'o', 'u'};

        w1: while (sb.length() != 0) {
            for(int i=0; i<5; i++){
                if(sb.charAt(0) == vowel[i]){
                    sb2.append(sb.charAt(0));
                    sb.delete(0,3);
                    continue w1;
                }
            }
            sb2.append(sb.charAt(0));
            sb.delete(0,1);
        }

        System.out.println(sb2);
        br.close();
    }
}
