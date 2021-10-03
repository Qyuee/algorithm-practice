package algorithm.T1003;

import java.util.stream.Stream;

public class Solution004 {
    public static void main(String[] args) {
        // P: 현재시간 -> 12시간 단위 ex) PM 01:00:00
        // N: 초

        String P = "PM 11:59:50";
        String APM = P.substring(0, 2);
        int n = 10;
        int[] time = Stream.of(P.substring(3).split(":")).mapToInt(Integer::parseInt).toArray();
        String result = "";

        time[0] = time[0] + n/60/60;
        time[1] = time[1] + n/60;
        time[2] = time[2] + n%60;

        if (APM.contains("PM")) {
            time[0] = time[0]+12;
        }

        for (int i = time.length-1; i >= 0; i--) {
            if (time[i]/60 > 0) {
                time[i-1] = time[i-1]+1;
                time[i] = time[i]%10;
            }

            if (i == 0 && time[i] == 24) {
                time[i] = 0;
            }
        }

        /*System.out.println("h:"+time[0]);
        System.out.println("m:"+time[1]);
        System.out.println("s:"+time[2]);*/

        result = (time[0]/10 == 0 ? "0"+time[0] : time[0])+":"+(time[1]/10 == 0 ? "0"+time[1] : time[1])+":"+(time[2]/10 == 0 ? "0"+time[2] : time[2]);
        System.out.println(result);
    }
}
