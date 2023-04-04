package Programmers._2023_KAKAO_BLIND_RECRUITMENT;

// 34분
public class 택배_배달과_수거하기 {

    public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        int idx1 = n - 1, idx2 = n - 1;

        while (idx1 >= 0 || idx2 >= 0) {
            // 인덱스 관리
            while (idx1 >= 0 && deliveries[idx1] == 0) {
                idx1--;
            }
            while (idx2 >= 0 && pickups[idx2] == 0) {
                idx2--;
            }

            answer += (Math.max(idx1, idx2) + 1) * 2;

            int ableDelivery = cap;
            int ablePickup = cap;

            // 배달
            while (ableDelivery > 0 && idx1 >= 0) {
                if (deliveries[idx1] > ableDelivery) {
                    deliveries[idx1] -= ableDelivery;
                    ableDelivery = 0;
                } else if (deliveries[idx1] == ableDelivery) {
                    deliveries[idx1] = 0;
                    ableDelivery = 0;
                    idx1--;
                } else {
                    ableDelivery -= deliveries[idx1];
                    deliveries[idx1] = 0;
                    idx1--;
                }
            }
            // 수거
            while (ablePickup > 0 && idx2 >= 0) {
                if (pickups[idx2] > ablePickup) {
                    pickups[idx2] -= ablePickup;
                    ablePickup = 0;
                } else if (pickups[idx2] == ablePickup) {
                    pickups[idx2] = 0;
                    ablePickup = 0;
                    idx2--;
                } else {
                    ablePickup -= pickups[idx2];
                    pickups[idx2] = 0;
                    idx2--;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        long result1 = solution(4, 5, new int[]{1, 0, 3, 1, 2}, new int[]{0, 3, 0, 4, 0});
        long result2 = solution(2, 7, new int[]{1, 0, 2, 0, 1, 0, 2}, new int[]{0, 2, 0, 1, 0, 2, 0});
        System.out.println(result1);
        System.out.println(result2);
    }
}
