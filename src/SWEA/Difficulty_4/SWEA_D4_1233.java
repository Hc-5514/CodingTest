/**
 * 문제 : [S/W 문제해결 기본] 9일차 - 사칙연산 유효성 검사
 *
 * @author Hc-5514
 */

package SWEA.Difficulty_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D4_1233 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int tc = 1; tc <= 10; tc++) {
            int n = Integer.parseInt(br.readLine());
            boolean flag = true;
            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken(); // 노드 번호 버리기
                // (연산자 숫자 숫자) or (숫자)
                int ch = st.nextToken().charAt(0);
                if (!(ch == '+' || ch == '-' || ch == '*' || ch == '/')) {
                    if (st.hasMoreTokens()) {
                        flag = false;
                    }
                }
            }

            if (flag) {
                sb.append(String.format("#%d %d", tc, 1)).append("\n");
            } else sb.append(String.format("#%d %d", tc, 0)).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
