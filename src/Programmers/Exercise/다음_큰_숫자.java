/**
 * 문제 : 다음 큰 숫
 *
 * @author Hc-5514
 */

package Programmers.Exercise;

public class 다음_큰_숫자 {
    
    public int solution(int n) {
        // n 보다 큰 수
        // 2진수 변환 시 1의 개수 동일
        int cnt = 0; // n 을 2진수 변환 시, 1의 개수
        String sN = Integer.toBinaryString(n);
        for (int i = 0; i < sN.length(); i++) {
            if (sN.charAt(i) == '1') {
                cnt++;
            }
        }

        int answer = 2 * n;
        for (int i = n + 1; i <= 2 * n; i++) {
            sN = Integer.toBinaryString(i);
            int cnt2 = 0;
            for (int j = 0; j < sN.length(); j++) {
                if (sN.charAt(j) == '1') {
                    cnt2++;
                }
                if (cnt2 > cnt) {
                    break;
                }
            }

            if (cnt == cnt2) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}
