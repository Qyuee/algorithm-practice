package algorithm.T1003;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Practice001 {
    public static void main(String[] args) {
        // int[] 다루기
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = (int)(Math.random() * 100);
        }

        /**
         * 배열 스트림은 Arrays.stream()으로 생성 할 수 있다.
         */

        // int[] -> Integer[]로 변환
        Integer[] boxedIntArr = Arrays.stream(arr).boxed().toArray(Integer[]::new); // 배열 스트림
        for (int i = 0; i < boxedIntArr.length; i++) {
            System.out.print(boxedIntArr[i]+" ");
        }

        System.out.println();

        // int[] -> List<Integer>로 변환
        List<Integer> intList = Arrays.stream(arr).boxed().collect(Collectors.toList());
        intList.forEach(integer -> System.out.print(integer+" "));
        /*for (int i = 0; i < intList.size(); i++) {
            System.out.print(intList.get(i)+" ");
        }*/

        // int[] -> Map<Integer, Integer>로 변환
        Map<Integer, Integer> intMap = Arrays.stream(arr).boxed().collect(Collectors.toMap(Integer::new, Integer::new));
        intMap.forEach((key, val) -> {
            System.out.println("key = " + key+" value = "+val);
        });
    }
}
