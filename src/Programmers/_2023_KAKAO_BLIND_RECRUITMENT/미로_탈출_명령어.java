package Programmers._2023_KAKAO_BLIND_RECRUITMENT;

import java.util.HashMap;
import java.util.Map;

public class 미로_탈출_명령어 {

    public static String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "";

        // dist: 최단 경로 길이, k: 출발지에서 목적지까지 최단 경로를 제외한 이동 가능 거리
        int dist = Math.abs(x - r) + Math.abs(y - c);
        k -= dist;

        if (k < 0 || k % 2 != 0) return "impossible";

        Map<Character, Integer> map = new HashMap<>();

        map.put('u', 0);
        map.put('d', 0);
        map.put('l', 0);
        map.put('r', 0);

        if (x - r > 0) map.put('u', map.get('u') + (x - r));
        else map.put('d', map.get('d') + (r - x));

        if (y - c > 0) map.put('l', map.get('l') + (y - c));
        else map.put('r', map.get('r') + (c - y));

        for (int i = 0; i < map.get('d'); i++)
            answer += "d";
        int cnt = Math.min(k / 2, n - (x + map.get('d')));
        for (int i = 0; i < cnt; i++)
            answer += "d";
        map.put('u', map.get('u') + cnt);
        k -= 2 * cnt;

        for (int i = 0; i < map.get('l'); i++)
            answer += "l";
        cnt = Math.min(k / 2, (y - map.get('l')) - 1);
        for (int i = 0; i < cnt; i++)
            answer += "l";
        map.put('r', map.get('r') + cnt);
        k -= 2 * cnt;

        // rl < ud
        for (int i = 0; i < k / 2; i++)
            answer += "rl";

        for (int i = 0; i < map.get('r'); i++)
            answer += "r";

        for (int i = 0; i < map.get('u'); i++)
            answer += "u";

        return answer;
    }

    public static void main(String[] args) {
        String result1 = solution(3, 4, 2, 3, 3, 1, 5);
        String result2 = solution(2, 2, 1, 1, 2, 2, 2);
        String result3 = solution(3, 3, 1, 2, 3, 3, 4);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }
}
