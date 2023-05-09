/**
 * 문제 : 회의실 배정
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;
public class BOJ_1931 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine().trim());
        ArrayList<Room> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Room(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(list, new Comparator<Room>() {
            @Override
            public int compare(Room o1, Room o2) {
                if(o1.end == o2.end)
                    return o1.start - o2.start;
                return o1.end - o2.end;
            }
        });

        int cnt = 1;
        int lastEnd = list.get(0).end;
        for (int i = 1; i < list.size(); i++) {
            if(list.get(i).start >= lastEnd){
                cnt++;
                lastEnd = list.get(i).end;
            }
        }

        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static class Room {
        int start;
        int end;
        int sub;

        public Room(int start, int end) {
            this.start = start;
            this.end = end;
            this.sub = end - start;
        }
    }
}