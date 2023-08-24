/**
 * 문제 : A1번 - SAVE the World (Small)
 *
 * @author Hc-5514
 */

package Baekjoon.Contest.제2회_흐즈로컵;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class A1번_SAVE_the_World_Small {

    static final int CENTER = 15;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine().trim());

        List<Soldier> soldierList = new ArrayList<>(); // 용사 좌표 저장

        StringBuilder[] sbArr = new StringBuilder[n + 1]; // 용사 이동 경로 저장
        for (int i = 0; i < n; i++) {
            sbArr[i] = new StringBuilder();
        }

        // 용사 좌표 정보 받기
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) + 15;
            int y = Integer.parseInt(st.nextToken()) + 15;
            soldierList.add(new Soldier(y, x));
        }

        // 용사 이동: 시계방향 회전
        for (int i = 0; i < soldierList.size(); i++) {
            Soldier cur = soldierList.get(i);
            int r = cur.r;
            int c = cur.c;
            while (true) {
                // (15,16) 에 도달하면 골인
                if (r == CENTER && c == CENTER + 1) {
                    sbArr[i].append('A');
                    break;
                }
                // 상
                if (c < CENTER && r >= c + 1 && r <= 2 * CENTER - c) {
                    r -= 1;
                    sbArr[i].append('X');
                    continue;
                }
                // 하
                if (c > CENTER && r >= 2 * CENTER - c && r <= c - 2) {
                    r += 1;
                    sbArr[i].append('W');
                    continue;
                }
                // 좌
                if (r >= CENTER && c >= 2 * CENTER - r + 1 && c <= r + 1) {
                    c -= 1;
                    sbArr[i].append('A');
                    continue;
                }
                // 우
                if (r < CENTER && c >= r && c <= 2 * CENTER - r - 1) {
                    c += 1;
                    sbArr[i].append('D');
                }
            }
        }

        for (int i = 0; i < n; i++) {
            bw.write(sbArr[i].toString() + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Soldier {
        int r;
        int c;

        public Soldier(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}