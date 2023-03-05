/**
 * 문제 : [모의 SW 역량테스트] 보물상자 비밀번호
 *
 * @author Hc-5514
 */

package SWEA.Mock_SW_Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class SWEA_Mock_5658 {

    static int N;
    static ArrayList<String> strList = new ArrayList<>();
    static ArrayList<Integer> numList = new ArrayList<>();

    private static void saveNum(String str) {
        for (int i = 0; i < 4; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < N / 4; j++) {
                sb.append(str.charAt(i * (N / 4) + j));
            }
            strList.add(sb.toString());
        }
    }

    private static StringBuilder makeNum(StringBuilder sb) {
        char ch = sb.charAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
        sb.insert(0, ch);
        return sb;
    }

    private static void getNumList(String str) {
        int num = 0;
        // str을 10진수로 변환
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int tmpNum = 0;
            switch (ch) {
                case 'A':
                    tmpNum = 10;
                    break;
                case 'B':
                    tmpNum = 11;
                    break;
                case 'C':
                    tmpNum = 12;
                    break;
                case 'D':
                    tmpNum = 13;
                    break;
                case 'E':
                    tmpNum = 14;
                    break;
                case 'F':
                    tmpNum = 15;
                    break;
                default:
                    tmpNum = Character.getNumericValue(ch);
                    break;
            }
            num += tmpNum * (int) Math.pow(16, N / 4 - 1 - i);
        }
        if (numList.contains(num)) return;
        numList.add(num);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder resultSB = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            // 리스트 초기화
            strList.clear();
            numList.clear();
            // 입력 받기
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            // 12개 수 만들기
            StringBuilder sb = new StringBuilder(br.readLine());
            saveNum(sb.toString());
            for (int i = 0; i < N / 4 - 1; i++) {
                saveNum(makeNum(sb).toString());
            }

            // 10진수 변환 후 중복 없는 수 저장
            for (int i = 0; i < strList.size(); i++) {
                getNumList(strList.get(i));
            }
            // 내림차순 정렬 후 K번째 수 출력
            Collections.sort(numList, Collections.reverseOrder());

            resultSB.append("#").append(tc).append(" ").append(numList.get(K - 1)).append("\n");
        }

        bw.write(resultSB.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
