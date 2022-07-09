/**
 * 문제 : 평균
 * @author Hc-5514
 */

package BAEKJOON.Solved_CLASS.CLASS_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1546 {

    public static void main(String[] args) throws IOException {

//        Scanner sc = new Scanner(System.in);

        // 1. 배열 사용
//        int n = sc.nextInt();
//        int[] ary = new int[n];
//
//        for (int i=0; i< n; i++){
//            ary[i] = sc.nextInt();
//        }
//
//        for (int i=0; i< n; i++){
//            System.out.println(ary[i]);
//        }

        // 2. ArrayList 사용
//        ArrayList<Integer> list = new ArrayList<Integer>();
//        int n = sc.nextInt();
//        for (int i=0; i< n; i++){
//            list.add(sc.nextInt());
//        }
//
//        for (int i=0; i< n; i++){
//            System.out.println(list.get(i));
//        }

        // BufferedReader + 배열 사용
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(bf.readLine());
//
//        int[] ary = new int[n];
//        double[] ary2 = new double[n];
//
//        int max = 0;
//        double sum = 0;
//        double avg = 0;
//
//        StringTokenizer token  = new StringTokenizer(bf.readLine());
//        for(int i=0; i<n; i++){
//            ary[i] = Integer.parseInt(token.nextToken());
////            System.out.println("ary[" + i + "]: " + ary[i]);
//            if(ary[i] > max)
//                max = ary[i];
//        }
//
//        for(int i=0; i<n; i++){
//            ary2[i] = (double)ary[i] / max * 100;
////            System.out.println("ary2[" + i + "]: " + ary2[i]);
//            sum += ary2[i];
//        }
//
//        avg = sum / n;
////        System.out.println("max: " + max + ", sum: " + sum);
//        System.out.println(avg);

        // https://st-lab.tistory.com/47 참고
        // BuffuredReader + 배열 사용
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
////        double[] ary = new double[Integer.parseInt(bf.readLine())];
////
////        StringTokenizer token = new StringTokenizer(bf.readLine(), " ");
////        for (int i=0; i<ary.length; i++){
////            ary[i] = Integer.parseInt(token.nextToken());
////        }
////
////        Arrays.sort(ary);
////        double sum = 0;
////
////        for(int i=0; i<ary.length; i++){
////            sum += (ary[i]/ary[ary.length-1]*100);
////        }
////
////        System.out.println(sum/ary.length);

        // https://st-lab.tistory.com/47 참고
        // BufferedReader 사용 + 배열 사용 X
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int max = 0;
        double sum = 0.0;

        for(int i=0; i<n; i++){
            int val = Integer.parseInt(st.nextToken());
            if (val > max){
                max = val;
            }
            sum += val;
        }

        System.out.println(((sum/max)*100)/n);
    }
}
