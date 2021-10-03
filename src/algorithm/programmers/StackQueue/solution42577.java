package algorithm.programmers.StackQueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * [전화번호 목록]
 * 전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
 * 전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.
 * - 구조대 : 119
 * - 박준영 : 97 674 223
 * - 지영석 : 11 9552 4421
 * 전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때,
 * 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.
 */
public class solution42577 {
    public static void main(String[] args) {
        //String[] phone_book = {"97674223", "1195524421", "123123", "119"};
        //String[] phone_book = {"1234", "123421", "1235"};
        String[] phone_book = {"1", "2225", "2223", "33333", "199999"};
        //System.out.println(phone_book[2].indexOf(phone_book[0])); // 0이면 prefix에 해당되는 것.

        // 문자열 sort시, 사전순으로 먼저인 문자가 근처에 있을 확률이 높다.
        String[] phone_book2 = Arrays.stream(phone_book).sorted().toArray(String[]::new);
        for (int i = 0; i < phone_book2.length; i++) {
            System.out.println(phone_book2[i]);
        }

        int count = 0;
        Boolean result = true;
        for (int i = 0; i < phone_book2.length; i++) {
            for (int j = i+1; j < phone_book2.length; j++) {
                if (phone_book2[j].indexOf(phone_book2[i]) == 0) {
                    result = false;
                    break;
                }
                count++;
            }
            if (!result) break;
        }

        System.out.println(result);
        System.out.println(count);
    }

    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        Map<String, Integer> map = new HashMap<>();
        for (String num : phone_book) map.put(num, 0);
        for (String key : map.keySet()) {
            for (int i = 0; i < key.length(); i++) {
                if (map.containsKey(key.substring(0, i))) answer = false;
            }
            if (! answer) break;
        }
        return answer;
    }

    public static boolean solution002(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length-1; i++) {
            if (phone_book[i+1].startsWith(phone_book[i])) {
                answer = false;
                break;
            }
        }

        return answer;
    }
}
