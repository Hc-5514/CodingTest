/**
 * 문제 : 숫자의 개수
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2577 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine());
        int[] ary = new int[10];

        String str = String.valueOf(num);
        for(int i=0; i<str.length(); i++){
            ary[str.charAt(i) - '0']++;
        }

        for(Integer integer : ary){
            System.out.println(integer);
        }
    }
}
