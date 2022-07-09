/**
 * 문제 : 상수
 * @author Hc-5514
 */

package BAEKJOON.Solved_CLASS.CLASS_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2908 {

//    static String getInverseNum(String s){
//
//        StringBuilder sb = new StringBuilder();
//        for(int i=2; i>=0; i--)
//            sb.append(s.charAt(i));
//        String result = sb.toString();
//
//        return result;
//    }
//
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str = br.readLine();
//        br.close();
//
//        StringTokenizer token = new StringTokenizer(str, " ");
//        str = token.nextToken();
//
//        // Case 1: 함수 사용 X
////        StringBuilder sb = new StringBuilder();
////        for(int i=2; i>=0; i--)
////            sb.append(str.charAt(i));
////        String result1 = sb.toString();
////
////        sb.setLength(0);
////
////        str = token.nextToken();
////        for(int i=2; i>=0; i--)
////            sb.append(str.charAt(i));
////        String result2 = sb.toString();
//
//        // Case 2: 함수 사용
//        String result1 = getInverseNum(str);
//        str = token.nextToken();
//        String result2 = getInverseNum(str);
//
//        if(Integer.parseInt(result1) > Integer.parseInt(result2))
//            System.out.println(Integer.parseInt(result1));
//        else
//            System.out.println(Integer.parseInt(result2));
//
//    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        br.close();

        StringTokenizer token = new StringTokenizer(str, " ");
        int a = Integer.parseInt(token.nextToken());
        int b = Integer.parseInt(token.nextToken());

        a = Integer.parseInt(new StringBuilder().append(a).reverse().toString());
        b = Integer.parseInt(new StringBuilder().append(b).reverse().toString());

        System.out.println(a > b ? a : b);
    }
}
