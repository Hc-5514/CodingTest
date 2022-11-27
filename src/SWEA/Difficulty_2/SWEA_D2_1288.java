/**
 * 문제 : 새로운 불면증 치료법
 *
 * @author Hc-5514
 */

package SWEA.Difficulty_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class SWEA_D2_1288 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        HashSet<Integer> hs = new HashSet<>();
        for (int tc = 1; tc <= T; tc++) {

            hs.clear();
            String N = br.readLine();
            String tmp = "";
            int count = 0;

            while (hs.size() < 10) { // 0~9까지의 숫자를 모두 저장하면 종료

                tmp = String.valueOf((Integer.parseInt(N) * (count + 1)));

                for (int i = 0; i < tmp.length(); i++) {
                    hs.add(Character.getNumericValue(tmp.charAt(i)));
                }

                count++;
            }

            System.out.println("#" + tc + " " + tmp);
        }
    }

}
