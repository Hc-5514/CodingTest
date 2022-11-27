/**
 * 문제 : 간단한 압축 풀기
 *
 * @author Hc-5514
 */

package SWEA.Difficulty_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_D2_1946 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        ArrayList<Character> al = new ArrayList<>();
        for (int tc = 1; tc <= T; tc++) {

            al.clear();

            // 알파벳 종류
            int N = Integer.parseInt(br.readLine());

            // 알파벳 저장
            for (int i = 0; i < N; i++) {

                String str = br.readLine();
                StringTokenizer st = new StringTokenizer(str);
                char ch = st.nextToken().charAt(0);
                int count = Integer.parseInt(st.nextToken());

                for (int j = 0; j < count; j++) {
                    al.add(ch);
                }
            }

            // 알파벳 출력
            System.out.print("#" + tc);
            for (int i = 0; i < al.size(); i++) {
                if (i % 10 == 0) System.out.println();
                System.out.print(al.get(i));
            }
            System.out.println();
        }
    }

}
