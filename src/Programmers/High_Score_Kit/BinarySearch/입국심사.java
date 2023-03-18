package Programmers.High_Score_Kit.BinarySearch;

import java.util.Arrays;

public class 입국심사 {

    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long s = 1l;
        long e = (long) times[times.length - 1] * n;
        while (s <= e) {
            long m = (s + e) >> 1;
            long sum = 0;
            for (int i = 0; i < times.length; i++) {
                sum += m / times[i];
            }
            if (sum < n) {
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
        return s;
    }
}
