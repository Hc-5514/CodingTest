/**
 * 문제 : 단어의 개수
 * @author Hc-5514
 */

package BAEKJOON.Solved_CLASS.CLASS_1;

import java.util.Scanner;
import java.util.StringTokenizer;

public class _1152 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();

        // 방법1. while문
//        int count = 0;
//        StringTokenizer tokenizer = new StringTokenizer(str);
//
//        while(tokenizer.hasMoreTokens()){
//            count++;
//            tokenizer.nextToken();
//        }
//
//        System.out.println(count);

        // 방법2. countTokens() 사용
        StringTokenizer token = new StringTokenizer(str, " ");

        System.out.println(token.countTokens());
    }
}
