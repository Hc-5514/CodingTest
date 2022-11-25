/**
 * 문제 : 단어의 개수
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_1;

import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_1152 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();

        StringTokenizer token = new StringTokenizer(str, " ");
        System.out.println(token.countTokens());
    }
}
