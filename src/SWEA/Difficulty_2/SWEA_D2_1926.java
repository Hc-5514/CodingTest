/**
 * 문제 : 간단한 369게임
 *
 * @author Hc-5514
 */

package SWEA.Difficulty_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_D2_1926 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {

            String num = String.valueOf(i);
            if (num.contains("3") || num.contains("6") || num.contains("9")) {

                for (int j = 0; j < num.length(); j++) {

                    if (num.charAt(j) == '3' || num.charAt(j) == '6' || num.charAt(j) == '9') System.out.print("-");
                }

            } else System.out.print(num);

            System.out.print(" ");
        }
    }

}
