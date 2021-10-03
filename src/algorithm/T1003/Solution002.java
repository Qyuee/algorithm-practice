package algorithm.T1003;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution002 {
    public static void main(String[] args) {
        // n일 동안 휴가를 갈 것이다.
        // 여행기간에 포함되는 유일의 숫자는 무슨요일부터 여행을 시작하는지에 따라서 달라진다.
        /*
        ex) 6일동안 여행을 간다.
         '월'에 여행시작 -> 월,화,수,목,금,토 -> 휴일 1 -> 최소값
         '화'에 여향시작 -> 화,수,목,금,토,일 -> 휴일 2 -> 최대값
         */
        // 무슨 요일에 여행을 시작하더라도 휴일이 1보다 적게 포함되거나, 2보다 많이 포함될수는 없다.
        // -> 최소 하루의 휴일이 포함되어야 한다?

        // 입력부
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 로직정의
        /*
        여행을 시작 할 수 있는 요일: [0, 1, 2, 3, 4]
        -> [의문]: 주말에도 여행을 시작해도되는가..?

        전체 요일: [월, 화, 수, 목, 금 ,토, 일]
                  [0, 1, 2, 3, 4, 5, 6]

        ex) n=6
        월 시작 -> 0~5 (6개 카운팅)
        화 시작 -> 1~6
        수 시작 -> 2~0
        목 시작 -> 3~1
        금 시작 -> 4~2
        토 시작 -> 5~3
        일 시작 -> 6~4

        결론: "월~일" 요일별로 반복하여 5, 6에 해당되는 개수를 출력한다.
         */

        // 초기화
        int[] dayPerHoliy = new int[7];
        int[] allResult = {0, 0};

        // 구현
        for (int i = 0; i < 7; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                int test = i+j;
                if (test/7 > 0) test = test-7;
                if (test == 5 || test == 6) {
                    count++;
                }
            }
            dayPerHoliy[i] = count;
        }
        allResult[0] = IntStream.of(dayPerHoliy).boxed().min(Integer::compare).orElse(0);
        allResult[1] = IntStream.of(dayPerHoliy).boxed().max(Integer::compare).orElse(0);
        System.out.println(allResult[0]+", "+allResult[1]);
    }
}
