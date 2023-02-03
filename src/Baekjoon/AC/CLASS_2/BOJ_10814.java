/**
 * 문제 : 나이순 정렬
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_10814 {

    public static class Info {

        int age;
        String name;

        public Info(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        List<Info> list = new ArrayList<>();
        Info info;

        // 나이, 이름 입력 받기
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            info = new Info(Integer.parseInt(st.nextToken()), st.nextToken());
            list.add(info);
        }

        // 나이 순 정렬, 나이가 같다면 먼저 가입한 순서대로 정렬
        // 나이가 같다면 위치를 바꾸지 않으므로, 가입한 순서대로 정렬이 된다.
        Collections.sort(list, (o1, o2) -> o1.age - o2.age);

        for (Info ob : list) {
            sb.append(ob.age).append(" ").append(ob.name).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
