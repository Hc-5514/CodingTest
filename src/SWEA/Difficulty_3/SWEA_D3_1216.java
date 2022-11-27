/**
 * 문제 : [S/W 문제해결 기본] 3일차 - 회문2
 *
 * @author Hc-5514
 */

package SWEA.Difficulty_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_D3_1216 {

    public static boolean isPalindrome(StringBuilder sb) {

        String str1 = sb.toString();
        String str2 = sb.reverse().toString();
        sb.reverse();

        return str1.equals(str2);
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[][] arr;

        for (int tc = 1; tc <= 10; tc++) {

            int T = Integer.parseInt(br.readLine());
            int max = Integer.MIN_VALUE;

            // 100 x 100 글자 판 입력 받기
            arr = new char[100][100];
            for (int i = 0; i < 100; i++) {
                sb.setLength(0);
                sb.append(br.readLine());
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = sb.charAt(j);
                }
            }

            // 회문 찾기 - 가로
            for (int i = 0; i < 100; i++) { // 100행 반복
                for (int j = 0; j < 100; j++) { // 100열 반복
                    sb.setLength(0);
                    for (int k = 0; k < 100 - j; k++) { // 현재 열부터 마지막 열까지

                        sb.append(arr[i][j + k]);
                        if (isPalindrome(sb)) {
                            max = Math.max(max, sb.length());
                        }
                    }
                }
            }

            // 회문 찾기 - 세로
            for (int i = 0; i < 100; i++) { // 100행 반복
                for (int j = 0; j < 100; j++) { // 100열 반복
                    sb.setLength(0);
                    for (int k = 0; k < 100 - j; k++) { // 현재 열부터 마지막 열까지

                        sb.append(arr[j + k][i]);
                        if (isPalindrome(sb)) {
                            max = Math.max(max, sb.length());
                        }
                    }
                }
            }

            System.out.println("#" + T + " " + max);

        }

    }

}
