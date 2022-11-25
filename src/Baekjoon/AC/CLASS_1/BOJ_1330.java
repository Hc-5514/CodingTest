/**
 * 문제 : 두 수 비교하기
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_1;

import java.util.Scanner;

public class BOJ_1330 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        String str = (a>b) ? (">") : ((a<b) ? ("<") : ("=="));
        System.out.println(str);
    }
}
