/**
 * 문제 : 윤년
 * @author Hc-5514
 */

package BAEKJOON.Solved_CLASS.CLASS_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2753 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // Case 1: 삼항연산자
        n = (n%400 == 0) ? 1 : ((n%100 == 0) ? 0 : (n%4 == 0 ? 1 : 0));
        System.out.println(n);

        // Case 2: 논리연산
//        if(((n%4==0)&&(n%100!=0))||(n%400==0))
//            System.out.println(1);
//        else
//            System.out.println(0);
    }
}
