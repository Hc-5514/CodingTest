/**
 * 문제 : 퍼즐
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.BFSDFS;

import java.io.*;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1525 {

    static final int[] dRow = {-1, 1, 0, 0}, dCol = {0, 0, -1, 1};

    private static int bfs(String ori) {
        HashSet<String> hs = new HashSet<>();
        hs.add(ori);
        Queue<Puzzle> q = new ArrayDeque<>();
        q.offer(new Puzzle(ori, 0));
        while (!q.isEmpty()) {
            Puzzle puzzle = q.poll();
            // 퍼즐 완성 체크
            if (puzzle.puzzleStr.equals("123456780"))
                return puzzle.cnt;
            // 이동 가능한 위치 확인
            StringBuilder sb = new StringBuilder(puzzle.puzzleStr);
            int tIdx = sb.indexOf("0");
            int tR = tIdx / 3;
            int tC = tIdx % 3;
            for (int k = 0; k < 4; k++) {
                int r = tR + dRow[k];
                int c = tC + dCol[k];
                if (r < 0 || c < 0 || r >= 3 || c >= 3) continue;
                int idx = r * 3 + c;
                char ch = sb.charAt(idx);
                // 0 이동
                StringBuilder sb2 = new StringBuilder(sb);
                sb2.setCharAt(tIdx, ch);
                sb2.setCharAt(idx, '0');
                // 이미 확인한 문자열인지 확인
                if (hs.contains(sb2.toString())) continue;
                hs.add(sb2.toString());
                q.add(new Puzzle(sb2.toString(), puzzle.cnt + 1));
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                sb.append(st.nextToken());
            }
        }

        int result = bfs(sb.toString());

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static class Puzzle {
        String puzzleStr;
        int cnt;

        public Puzzle(String puzzleStr, int cnt) {
            this.puzzleStr = puzzleStr;
            this.cnt = cnt;
        }
    }
}