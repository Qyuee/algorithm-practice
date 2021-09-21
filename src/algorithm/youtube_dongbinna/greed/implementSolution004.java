package algorithm.youtube_dongbinna.greed;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 문자열 재정렬 문제
 * 알파벳 대문자와 숫자(0~9)로만 구성된 문자열이 입력된다.
 * 이 때, 모든 알파벳을 오름차순으로 정렬하고, 그 뒤에 모든 숫자를 더한 값을 이어서 출력한다.
 * ex) K1KA5CB7 -> ABCKK13
 */
public class implementSolution004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        // 구현부
            // 문자열 중, 문자와 숫자를 구분해야한다.
            // 구분된 문자는 sort(오름차순)으로 정렬
            // 구분된 숫자는 모두 +연산하여 계산
        ArrayList<String> onlyStr = new ArrayList<>();
        int numberResult = 0;
        String stringResult = "";

        for (int i = 0; i<s.length(); i++) {
            if ('0' <= s.charAt(i) && s.charAt(i) <= '9') {
                numberResult = numberResult + Integer.parseInt(String.valueOf(s.charAt(i)));
                continue;
            }
            onlyStr.add(String.valueOf(s.charAt(i)));
        }
        onlyStr.sort(String::compareTo);
        for (int i = 0; i < onlyStr.size(); i++) {
            stringResult = stringResult + onlyStr.get(i);
        }

        System.out.println(stringResult+numberResult);
    }
}
