/**
 * 문제 : 막대기
 * @author Hc-5514
 */

package BAEKJOON.Algorithm.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _17608 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());

        // Case 1: 입력받은 수보다 같거나 작은 수는 스택에서 제거
//        stack.push(Integer.parseInt(br.readLine()));
//        for(int i=1; i<n; i++){
//            int num = Integer.parseInt(br.readLine());
//            while(stack.peek()<=num){
//                if(stack.peek() <= num)
//                    stack.pop();
//                if(stack.size() == 0)
//                    break;
//            }
//            stack.push(num);
//        }
//
//        System.out.println(stack.size());

        // Case 2: 스택에서 숫자를 하나씩 꺼내며 비교
        for(int i=0; i<n; i++){
            stack.push(Integer.parseInt(br.readLine()));
        }

        int temp = 0;
        int count = 0;

        for(int i=0; i<n; i++){
            int height = stack.pop();
            if(temp < height){
                temp = height;
                count++;
            }
        }

        System.out.println(count);
    }
}