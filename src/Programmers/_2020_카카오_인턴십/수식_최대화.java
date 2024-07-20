/**
 * 문제 : 수식 최대화
 *
 * @author Hc-5514
 */

package Programmers._2020_카카오_인턴십;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class 수식_최대화 {
	private static List<Long> nums;
	private static List<String> operations;
	private static Set<String> operationSet;
	private static List<String> operationKinds;
	private static int[] selectedOperation;
	private static boolean[] isSelected;
	private static long result;

	private static void makePermutation(int depth) {
		if (depth == operationSet.size()) {
			calcExpression();
			return;
		}

		for (int i = 0; i < operationSet.size(); i++) {
			if (isSelected[i]) {
				continue;
			}
			isSelected[i] = true;
			selectedOperation[depth] = i;
			makePermutation(depth + 1);
			isSelected[i] = false;
		}
	}

	private static void calcExpression() {
		List<Long> copyNums = new ArrayList<>(nums);
		List<String> copyOperations = new ArrayList<>(operations);
		for (int i = 0; i < operationKinds.size(); i++) {
			String operation = operationKinds.get(selectedOperation[i]);
			for (int j = 0; j < copyOperations.size(); j++) {
				if (operation.equals(copyOperations.get(j))) {
					copyNums.set(j, (calcOperation(copyNums.get(j), copyNums.get(j + 1), operation)));
					copyNums.remove(j + 1);
					copyOperations.remove(j);
					j--;
				}
			}
		}
		result = Math.max(result, Math.abs(copyNums.get(0)));
	}

	private static long calcOperation(long n1, long n2, String operation) {
		switch (operation) {
			case "*":
				return n1 * n2;
			case "+":
				return n1 + n2;
			case "-":
				return n1 - n2;
			default:
				return Integer.MAX_VALUE;
		}
	}

	private static void init() {
		nums = new ArrayList<>();
		operations = new ArrayList<>();
		selectedOperation = new int[3];
		isSelected = new boolean[3];
		result = 0;
	}

	public static void main(String[] args) {
		StringTokenizer st;
		// String expression = "100-200*300-500+20";
		// String expression = "50*6-3*2";
		String expression = "2-990-5+2";

		init();

		// expression -> 숫자, 연산자 구분
		operationSet = new HashSet<>();
		st = new StringTokenizer(expression, "*+-", true);
		while (st.hasMoreTokens()) {
			String cur = st.nextToken();
			if (cur.equals("*") || cur.equals("+") || cur.equals("-")) {
				operationSet.add(cur);
				operations.add(cur);
			} else {
				nums.add(Long.parseLong(cur));
			}
		}

		operationKinds = new ArrayList<>(operationSet);
		makePermutation(0);

		System.out.println(result);
	}
}
