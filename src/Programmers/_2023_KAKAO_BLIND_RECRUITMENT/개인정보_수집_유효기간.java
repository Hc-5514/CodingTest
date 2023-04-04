package Programmers._2023_KAKAO_BLIND_RECRUITMENT;

import java.util.*;

// 37분 08초
public class 개인정보_수집_유효기간 {

    public static int[] solution(String today, String[] terms, String[] privacies) {
        StringTokenizer st;

        st = new StringTokenizer(today, ".");
        int tY = Integer.parseInt(st.nextToken());
        int tM = Integer.parseInt(st.nextToken());
        int tD = Integer.parseInt(st.nextToken());

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < terms.length; i++) {
            st = new StringTokenizer(terms[i], " ");
            map.put(st.nextToken().charAt(0), Integer.parseInt(st.nextToken()));
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            st = new StringTokenizer(privacies[i], ". ");
            int pY = Integer.parseInt(st.nextToken());
            int pM = Integer.parseInt(st.nextToken());
            int pD = Integer.parseInt(st.nextToken());
            char privacy = st.nextToken().charAt(0);

            // 일 계산
            pD -= 1;
            if (pD == 0) {
                pM -= 1;
                pD = 28;
            }

            // 년, 월 계산
            pM += map.get(privacy);
            if (pM > 12) {
                pM -= 12;
                pY += 1;
            }

            // 년도-1 * 12 * 28
            // 월-1 * 28
            // 일
            int pDate = (pY - 1) * 12 * 28 + (pM - 1) * 28 + pD;
            int tDate = (tY - 1) * 12 * 28 + (tM - 1) * 28 + tD;

            if (pDate < tDate)
                list.add(i + 1);
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] result1 = solution("2022.05.19", new String[]{"A 6", "B 12", "C 3"}, new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"});
        int[] result2 = solution("2020.01.01", new String[]{"Z 3", "D 5"}, new String[]{"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"});

        System.out.println(Arrays.toString(result1));
        System.out.println(Arrays.toString(result2));
    }
}
