/**
 * 문제 : 강의실 배정
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Queue;

import java.io.*;
import java.util.*;

public class BOJ_11000 {

    static class Lecture {
        int s;
        int e;

        public Lecture(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        ArrayList<Lecture> lectureList = new ArrayList<>();

        int N = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            lectureList.add(new Lecture(s, e));
        }

        Collections.sort(lectureList, new Comparator<Lecture>() {
            @Override
            public int compare(Lecture o1, Lecture o2) {
                if (o1.s == o2.s)
                    return o1.e - o2.e;
                else
                    return o1.s - o2.s;
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            // pq에 강의 종료 시간을 넣는다.
            pq.offer(lectureList.get(i).e);
            if (!pq.isEmpty()) {
                // pq의 첫 번째 강의의 종료시간이 새로운 강의의 시작 시간보다 같거나 작다면, 같은 강의실
                if (pq.peek() <= lectureList.get(i).s)
                    pq.poll();
            }
        }

        bw.write(pq.size() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}