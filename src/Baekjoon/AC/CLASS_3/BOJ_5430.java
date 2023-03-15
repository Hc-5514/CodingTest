/**
 * 문제 : AC
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_3;

import java.io.*;
import java.util.*;

/**
 * list 사용하면 시간초과
 * T = 100, p = 100,000, 모든 명령이 R 일 때
 * 100 * 100000log₂(100000) = 100 * 100000 * 20 = 200,000,000 = 약 2초
 */
public class BOJ_5430 {
    static boolean reverseFlag;
    static ArrayDeque dq = new ArrayDeque();

    private static boolean runCmd(String cmdText) {
        for (int i = 0; i < cmdText.length(); i++) {
            char cmd = cmdText.charAt(i);
            if (cmd == 'R') {
                reverseFlag = !reverseFlag;
            } else {
                if (!dq.isEmpty()) {
                    if (reverseFlag)
                        dq.pollLast();
                    else dq.pollFirst();
                } else return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            reverseFlag = false;
            dq.clear();

            String cmdText = br.readLine();
            int len = Integer.parseInt(br.readLine().trim());
            st = new StringTokenizer(br.readLine(), "[,]");
            for (int i = 0; i < len; i++) {
                dq.offer(Integer.parseInt(st.nextToken()));
            }

            boolean errorFlag = runCmd(cmdText);
            if (errorFlag) {
                if (dq.isEmpty())
                    bw.write("[]\n");
                else if (reverseFlag) {
                    bw.write("[");
                    int size = dq.size();
                    for (int i = 0; i < size - 1; i++) {
                        bw.write(dq.pollLast() + ",");
                    }
                    bw.write(dq.poll() + "]\n");
                } else {
                    bw.write("[");
                    int size = dq.size();
                    for (int i = 0; i < size - 1; i++) {
                        bw.write(dq.poll() + ",");
                    }
                    bw.write(dq.poll() + "]\n");
                }
            } else bw.write("error\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}