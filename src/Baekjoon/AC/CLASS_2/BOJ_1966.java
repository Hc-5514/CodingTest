/**
 * 문제 : 프린터 큐
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1966 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Queue<int[]> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        int[][] arr;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {

            q.clear();
            list.clear();
            st = new StringTokenizer(br.readLine());

            // N: 문서 개수, M: 찾으려는 문서의 인덱스
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            // [][0]: 우선 순위 값, [][1]: 인덱스 번호, priority: 몇 번째 우선순위
            arr = new int[N][2];
            int priority = -1;

            // 문서 개수만큼 입력 받기
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int n = Integer.parseInt(st.nextToken());
                arr[i][0] = n;
                arr[i][1] = i;
                q.add(arr[i]);
                list.add(n);
                if (i == M) {
                    priority = n;
                }
            }

            // cnt: M 문서가 몇 번째 순서로 출력됐는지 카운트
            int cnt = 1;

            Collections.sort(list);

            while (!q.isEmpty()) {
                arr[0] = q.poll();
                // 우선순위가 가장 높은 문서일 때
                if (arr[0][0] == list.get(list.size() - 1)) {
                    // 원하는 문서와 우선순위가 같을 때
                    if (arr[0][0] == priority) {
                        // 원하는 문서와 인덱스가 같다면 출력
                        if (arr[0][1] == M) {
                            break;
                        }
                    }
                    // 원하는 문서가 아니라면 출력
                    cnt++;
                    list.remove(list.size() - 1);
                }
                // 우선순위가 가장 높은 문서가 아니라면 다시 큐에 추가
                else {
                    q.offer(arr[0]);
                }
            }

            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}

