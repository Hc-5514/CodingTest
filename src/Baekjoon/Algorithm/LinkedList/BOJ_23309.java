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
        int[] prev;
        int[] next;

        public Node() {
            prev = new int[1000001];
            next = new int[1000001];
        }

        public void add(int curStation, int newStation) {
            // 첫 번째 역
            if (curStation == -1) {
                prev[newStation] = next[newStation] = newStation;
            } else {
                prev[newStation] = prev[curStation];
                next[newStation] = curStation;
                next[prev[curStation]] = newStation;
                prev[curStation] = newStation;
            }
        }

        public void remove(int station){
            next[prev[station]] = next[station];
            prev[next[station]] = prev[station];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // Node에 기존 역 정보 저장
        st = new StringTokenizer(br.readLine());
        Node node = new Node();
        int curStation = -1, newStation;
        for (int i = 0; i < n; i++) {
            newStation = Integer.parseInt(st.nextToken());
            node.add(curStation, newStation);
            curStation = newStation;
        }

        // M번 공사 시작
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            curStation = Integer.parseInt(st.nextToken());
            if (command.equals("BN")) {
                // curStation 다음 역 번호 출력, curStation 다음 역에 newStation 역 삽입
                sb.append(node.prev[curStation]).append("\n");
                newStation = Integer.parseInt(st.nextToken());
                node.add(curStation, newStation);
            } else if (command.equals("BP")) {
                // curStation 이전 역 번호 출력, curStation 이전 역에 newStation 역 삽입
                sb.append(node.next[curStation]).append("\n");
                newStation = Integer.parseInt(st.nextToken());
                node.add(node.next[curStation], newStation);
            } else if (command.equals("CN")) {
                // curStation 다음 역 폐쇄 후 번호 출력
                sb.append(node.prev[curStation]).append("\n");
                node.remove(node.prev[curStation]);
            } else {
                // curStation 이전 역 폐쇄 후 번호 출력
                sb.append(node.next[curStation]).append("\n");
                node.remove(node.next[curStation]);
            }
        }
        System.out.println(sb);
        br.close();
    }
}

