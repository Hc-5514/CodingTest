/**
 * 문제 : 단어 공부
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_1;

import java.util.Scanner;

public class BOJ_1157 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int[] arr = new int[26];

        // 문자별 개수 카운트
        for(int i=0; i<str.length(); i++){
            // 아스키코드 값 (대문자: 65~90, 소문자: 97~122)
            if(str.charAt(i) >= 65 && str.charAt(i) <= 90)
                arr[str.charAt(i) - 65]++;
            else
                arr[str.charAt(i) - 97]++;
        }

        // 가장 많이 사용된 문자 확인, 두 개 이상이라면 ? 저장
        int max = -1;
        char ch = '?';
        for (int i=0; i<26; i++){
            if(arr[i] > max){
                max = arr[i];
                ch = (char)(i + 65);
            }
            else if(arr[i] == max){
                ch = '?';
            }
        }

        // 문자 출력
        System.out.println(ch);
    }
}
