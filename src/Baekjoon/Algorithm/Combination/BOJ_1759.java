/**
 * 문제 : 암호 만들기
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759 {
    static StringBuilder sb = new StringBuilder();
    static int L, C;
    private static final char[] arrVowel = {'a', 'e', 'i', 'o', 'u'};
    private static char[] arrChar;
    private static boolean[] isSelected;

    private static void combination(int cnt, int start) {
        if (cnt == L) {
            // 모음1개, 자음2개 이상 포함 되는지 확인
            int voCnt = 0, coCnt = 0;
            f1: for (int i = 0; i < isSelected.length; i++) {
                if (isSelected[i]) {
                    for (int j = 0; j < arrVowel.length; j++) {
                        if (arrChar[i] == arrVowel[j]) {
                            voCnt++;
                            continue f1;
                        }
                    }
                    coCnt++;
                }
            }
            if (voCnt >= 1 && coCnt >= 2) {
                for (int i = 0; i < isSelected.length; i++) {
                    if (isSelected[i])
                        sb.append(arrChar[i]);
                }
                sb.append("\n");
            }
            return;
        }

        for (int i = start; i < C; i++) {
            if (isSelected[i]) continue;
            isSelected[i] = true;
            combination(cnt + 1, i + 1);
            isSelected[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arrChar = new char[C];
        isSelected = new boolean[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            arrChar[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arrChar);

        // 암호 찾기
        combination(0, 0);

        System.out.println(sb);
        br.close();
    }
}
