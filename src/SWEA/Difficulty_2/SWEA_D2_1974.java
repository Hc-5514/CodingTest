/**
 * 문제 : 스도쿠 검증
 *
 * @author Hc-5514
 */

package SWEA.Difficulty_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class SWEA_D2_1974 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int tc = 1; tc <= T; tc++) {

            // 스도쿠 숫자 받기
            int[][] arr = new int[9][9];
            for (int i = 0; i < 9; i++) {

                String str = br.readLine();
                st = new StringTokenizer(str);
                for (int j = 0; j < 9; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 스도쿠 검사하기
            boolean answer = true;
            HashSet<Integer> hs = new HashSet<>();
            // 가로줄 검사
            for (int i = 0; i < 9; i++) {
                hs.clear();
                for (int j = 0; j < 9; j++) {
                    // 중복되는 숫자가 있다면,
                    if (hs.contains(arr[i][j])) {
                        answer = false;
                        break;
                    } else {
                        hs.add(arr[i][j]);
                    }
                }
                // 잘못된 스도쿠
                if (!answer) break;
            }

            // 잘못된 스도쿠
            if (!answer) {
                System.out.println("#" + tc + " " + 0);
                continue;
            }

            // 세로줄 검사
            for (int i = 0; i < 9; i++) {
                hs.clear();
                for (int j = 0; j < 9; j++) {
                    // 중복되는 숫자가 있다면,
                    if (hs.contains(arr[j][i])) {
                        answer = false;
                        break;
                    } else {
                        hs.add(arr[j][i]);
                    }
                }
                // 잘못된 스도쿠
                if (!answer) break;
            }

            // 잘못된 스도쿠
            if (!answer) {
                System.out.println("#" + tc + " " + 0);
                continue;
            }

            // 3x3 영역 검사
            for (int i = 0; i < 3; i++) {

                for (int j = 0; j < 3; j++) {

                    hs.clear();
                    // 3x3 박스 검사
                    for (int k = 0; k < 3; k++) {
                        for (int l = 0; l < 3; l++) {
                            if (hs.contains(arr[3 * i + k][3 * j + l])) {
                                answer = false;
                                break;
                            } else {
                                hs.add(arr[3 * i + k][3 * j + l]);
                            }
                        }
                        // 잘못된 스도쿠
                        if (!answer) break;
                    }
                    // 잘못된 스도쿠
                    if (!answer) break;

                }
                // 잘못된 스도쿠
                if (!answer) break;
            }

            // 결과 출력
            if (answer) System.out.println("#" + tc + " " + 1);
            else System.out.println("#" + tc + " " + 0);

        }

    }

}
