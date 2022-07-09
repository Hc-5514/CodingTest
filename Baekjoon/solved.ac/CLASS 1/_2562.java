/**
 * 문제 : 최댓값
 * @author Hc-5514
 */

package BAEKJOON.Solved_CLASS.CLASS_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2562 {

    public static void main(String[] args) throws IOException {

        // 방법1. 배열 사용
//        Scanner sc = new Scanner(System.in);
//
//        int[] arr = new int[9];
//        int max = 0;
//
//        for(int i=0; i<9; i++){
//            arr[i] = sc.nextInt();
//            if (arr[i] > max) max = arr[i];
//        }
//
//        System.out.println(max);
//        for(int i=0; i<9; i++){
//            if(arr[i] == max) System.out.println(i+1);
//        }

        // 방법2. 리스트 사용
//        Scanner sc = new Scanner(System.in);
//        ArrayList<Integer> list = new ArrayList<Integer>();
//        int max = 0;
//
//        for(int i=0; i<9; i++){
//            list.add(sc.nextInt());
//            if(list.get(i) > max) max = list.get(i);
//        }
//
//        System.out.println(max + "\n" + (list.indexOf(max)+1));

        // 방법3. 배열, for-each문
//        Scanner sc = new Scanner(System.in);
//        int[] arr = {
//                sc.nextInt(), sc.nextInt(), sc.nextInt(),
//                sc.nextInt(), sc.nextInt(), sc.nextInt(),
//                sc.nextInt(), sc.nextInt(), sc.nextInt()
//        };
//        sc.close();
//
//        int max = 0;
//        int count = 0;
//        int index = 0;
//
//        for(int value:arr){
//            count++;
//            if(value>max){
//                max = value;
//                index = count;
//            }
//        }
//
//        System.out.println(max + "\n" + index);

        // 방법4. BufferReader 사용
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int[] array = new int[9];
//
//        for(int i=0; i<9; i++){
//            array[i] = Integer.parseInt(br.readLine());
//        }
//
//        int max = 0;
//        int count = 0;
//        int index = 0;
//
//        for(int value:array){
//            count++;
//            if(value > max){
//                max = value;
//                index = count;
//            }
//        }
//
//        System.out.println(max + "\n" + index);

        // 방법5. BufferReader 사용, 배열 사용 X
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = 0;
        int index = 0;

        for(int i=0; i<9; i++){
            int val = Integer.parseInt(br.readLine());
            if (val > max){
                max = val;
                index = i+1;
            }
        }

        System.out.println(max + "\n" + index);
    }
}
