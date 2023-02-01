/**
 * 문제 : 큐
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_10845 {

    public static List<Integer> queue = new ArrayList<>();
    public static int size;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()){
                case "push":
                    push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(pop()).append("\n");
                    break;
                case "size":
                    sb.append(size()).append("\n");
                    break;
                case "empty":
                    sb.append(empty()).append("\n");
                    break;
                case "front":
                    sb.append(front()).append("\n");
                    break;
                case "back":
                    sb.append(back()).append("\n");
                    break;
            }
        }

        System.out.println(sb);
        br.close();
    }

    public static void push(int x) {
        queue.add(x);
    }

    public static int pop() {
        if (queue.isEmpty()) {
            return -1;
        } else {
            int n = queue.get(0);
            queue.remove(0);
            return n;
        }
    }

    public static int size() {
        return queue.size();
    }

    public static int empty() {
        if (queue.isEmpty())
            return 1;
        else return 0;
    }

    public static int front() {
        if (queue.isEmpty()) {
            return -1;
        } else return queue.get(0);
    }

    public static int back() {
        if (queue.isEmpty()) {
            return -1;
        } else return queue.get(queue.size() - 1);
    }
}
