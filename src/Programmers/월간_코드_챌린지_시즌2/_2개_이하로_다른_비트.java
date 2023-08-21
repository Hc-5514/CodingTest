package Programmers.월간_코드_챌린지_시즌2;

public class _2개_이하로_다른_비트 {

    class Solution {
        public long[] solution(long[] numbers) {
            // numbers[i] 보다 크고, 비트가 1~2개 다른 수 중 제일 작은 수
            // numbers[] 의 모든 수에 대해 계산을 해야 함.

            // 가장 오른쪽부터 탐색하여 01이 가장 먼저 나온 부분을 10으로 바꿔주면 된다.
            // 01 -> 10 변경 방법
            // +1한 수와 xor 연산 후, >> 연산 2번, +1 의 결과값을 더해주면 된다.
            int size = numbers.length;
            long[] answer = new long[size];
            for (int i = 0; i < size; i++) {
                long sum = ((numbers[i] ^ (numbers[i] + 1)) >> 2) + 1;
                answer[i] = numbers[i] + sum;
            }
            return answer;
        }
    }
}
