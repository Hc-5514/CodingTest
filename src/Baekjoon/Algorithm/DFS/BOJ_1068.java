/**
 * 문제 : 트리
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1068 {

    private static int n, leafCnt = 0;

    private static int[] node;

    private static void removeNode(int removeNum) {
        // n번 노드 제거
        node[removeNum] = -2;
        // n번 노드를 부모로 가지는 자식 노드 제거
        for (int i = 0; i < n; i++) {
            if (node[i] == removeNum) {
                removeNode(i);
            }
        }
    }

    private static void dfs(int head) {
        // 자식 노드가 있을 때, 리프 노드가 아니면 -2로 값을 바꾼다.
        for (int i = 0; i < n; i++) {
            // 자식 노드일 때
            if (node[i] == head) {
                // 리프 노드 확인 (cnt: 자식 노드 개수)
                int cnt = 0;
                for (int j = 0; j < n; j++) {
                    if (node[j] == i)
                        cnt++;
                }
                // 리프 노드가 아니면 -2
                if (cnt != 0) {
                    node[i] = -2;
                    dfs(i);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        node = new int[n];

        st = new StringTokenizer(br.readLine());
        int headNode = 0;
        for (int i = 0; i < n; i++) {
            node[i] = Integer.parseInt(st.nextToken());
            if (node[i] == -1) headNode = i;
        }

        // 노드 제거
        removeNode(Integer.parseInt(br.readLine()));

        // 리프 노드 개수 구하기
        dfs(headNode);

        for (int i = 0; i < n; i++) {
            if (node[i] >= 0) {
                leafCnt++;
            }
        }

        // 루트 노드만 남았다면, +1
        if (leafCnt == 0) {
            if (node[0] == -1) {
                leafCnt = 1;
            }
        }

        System.out.println(leafCnt);
        br.close();
    }
}
