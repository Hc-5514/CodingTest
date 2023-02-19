/**
 * 문제 : 철도 공사
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_23309 {

    private static class Node {
        int no;
        Node prev;
        Node next;

        public Node(int no) {
            this.no = no;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 순환 LinkedList: 기존 역 정보를 각 Node에 저장
        st = new StringTokenizer(br.readLine());
        Node head = new Node(Integer.parseInt(st.nextToken()));
        Node curNode = head;
        Node newNode;
        for (int i = 1; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            newNode = new Node(num);
            head.next = newNode;
            newNode.prev = head;
            newNode.next = curNode;
            curNode.prev = newNode;
            curNode = newNode;
        }

        // M번 공사 시작
        int a, b;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            a = Integer.parseInt(st.nextToken());
            while (curNode.no != a) {
                curNode = curNode.next;
            }
            if (command.equals("BN")) {
                // a 다음 역 번호 출력, a 다음 역에 b역 삽입
                sb.append(curNode.prev.no).append("\n");
                b = Integer.parseInt(st.nextToken());
                newNode = new Node(b);
                newNode.prev = curNode.prev;
                newNode.next = curNode;
                newNode.prev.next = newNode;
                curNode.prev = newNode;
                continue;
            } else if (command.equals("BP")) {
                // a 이전 역 번호 출력, a 이전 역에 b역 삽입
                sb.append(curNode.next.no).append("\n");
                b = Integer.parseInt(st.nextToken());
                newNode = new Node(b);
                newNode.prev = curNode;
                newNode.next = curNode.next;
                newNode.next.prev = newNode;
                curNode.next = newNode;
                continue;
            } else if (command.equals("CN")) {
                // a 다음 역 폐쇄 후 번호 출력
                sb.append(curNode.prev.no).append("\n");
                newNode = curNode.prev;
            } else {
                // a 이전 역 폐쇄 후 번호 출력
                sb.append(curNode.next.no).append("\n");
                newNode = curNode.next;
            }
            newNode.prev.next = newNode.next;
            newNode.next.prev = newNode.prev;
            newNode = null;
        }
        System.out.println(sb);
        br.close();
    }
}

