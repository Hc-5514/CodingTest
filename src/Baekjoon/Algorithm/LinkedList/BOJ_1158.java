/**
 * 문제 : 요세푸스 문제
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
    int data;
    Node next = null;

    public Node(int data) {
        this.data = data;
    }
}

public class BOJ_1158 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder("<");

        // N명, K번째 사람 제거
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 순환 LinkedList
        Node head = new Node(1);
        Node node = head;
        for (int i = 2; i <= N; i++) {
            node.next = new Node(i);
            node = node.next;
        }
        node.next = head;

        while (N-- > 0) {
            // 삭제할 노드의 직전 노드까지 도착
            for (int i = 0; i < K - 1; i++) {
                node = node.next;
            }
            // 노드 삭제
            sb.append(node.next.data).append(", ");
            node.next = node.next.next;
        }

        // 출력하기
        sb.setLength(sb.length() - 2);
        sb.append(">");
        System.out.println(sb);
        br.close();
    }
}
